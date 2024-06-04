package it.softre.thip.base.firmadigitale.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.ws.rs.core.Response.Status;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.softre.thip.base.firmadigitale.DocumentiAttesaFirmaTM;
import it.thera.thip.base.documentoDgt.DocumentoDgtOggetto;
import it.thera.thip.base.documentoDgt.DocumentoDigitale;
import it.thera.thip.base.generale.PersDatiGen;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 04/06/2024
 * <br><br>
 * <b>71XXX	DSSOF3	04/06/2024</b>
 * <p>Prima stesura.<br>
 *  
 * </p>
 */

public class DocumentiAttesaFirmaService {

	private static DocumentiAttesaFirmaService instance;

	public static DocumentiAttesaFirmaService getInstance() {
		if(instance == null) {
			instance = (DocumentiAttesaFirmaService) Factory.createObject(DocumentiAttesaFirmaService.class);
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public JSONObject firmaDocumento(String jsonString) {
		JSONObject response = new JSONObject();
		Status status = Status.INTERNAL_SERVER_ERROR;
		String keyDocOri = null;
		try {
			JSONObject body = new JSONObject(jsonString);
			keyDocOri = (String) body.get("documentId");
			DocumentoDigitale docOri = (DocumentoDigitale) DocumentoDigitale.elementWithKey(DocumentoDigitale.class, keyDocOri, PersistentObject.NO_LOCK);
			if(docOri != null) {
				DocumentoDgtOggetto oggetto = (DocumentoDgtOggetto) docOri.getOggetti().get(0);
				String signatureDataUrl = (String) body.get("signature");
				String base64Signature = signatureDataUrl.split(",")[1];
				byte[] signatureBytes = Base64.getDecoder().decode(base64Signature);
				InputStream inputstream = null;
				inputstream = oggetto.getOggettoBlob();
				if (inputstream == null) {
					inputstream = oggetto.getOggettoFile();
				}
				PDDocument document = PDDocument.load(inputstream);

		        // Remove security from the document
		        document.setAllSecurityToBeRemoved(true);

		        PDPage page = document.getPage(document.getNumberOfPages() - 1); // Get the last page

		        // Draw the signature image onto the page
		        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, signatureBytes, "signature");
		        float x = 200; // Example coordinates
		        float y = 500; // Example coordinates
		        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
		        contentStream.drawImage(pdImage, x, y, pdImage.getWidth(), pdImage.getHeight());
		        contentStream.close();

		        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		        document.save(byteArrayOutputStream);
		        document.close();

				byte[] signedPdfBytes = byteArrayOutputStream.toByteArray();
				DocumentoDgtOggetto oggNew = DocumentoDigitale.creaDocumentoDgtOggetto(docOri, docOri.getTipoDocDgt(), false);
				String filename = oggetto.getFilename();
				if (filename != null && !filename.equals("")) {
					oggNew.setFilename(getNomeAllegato("firmato"));
					oggNew.setSSDMimeType(oggetto.getSSDMimeType());
					if (!oggNew.onDB) {
						oggNew.getDescrizione().setDescrizione(oggetto.getDescrizione().getDescrizione());
						oggNew.getDescrizione().setDescrizioneRidotta(oggetto.getDescrizione().getDescrizioneRidotta());
					}
					if (PersDatiGen.getCurrentPersDatiGen().getMemorizzazioneDocDgt() == PersDatiGen.MEM_DOC_DGT_SU_DATABASE) {
						oggNew.getOggettoDigitale().setBytes(signedPdfBytes);
						oggNew.doAttach();
					}
					oggNew.setCompresso(docOri.getTipoDocDgt().isZipAttachment());
					if (PersDatiGen.getCurrentPersDatiGen().getMemorizzazioneDocDgt() == PersDatiGen.MEM_DOC_DGT_SU_FILESYSTEM) {
						oggNew.percorsoSalvataggioFile();
						oggNew.getOggettoDigitale().setBytes(signedPdfBytes);
						oggNew.doAttach();
					}
				}
				oggNew.setProgressivo(docOri.getOggetti().size()+1);
				docOri.getOggetti().add(oggNew);
				int rc = docOri.save();
				if(rc > 0) {
					status = Status.OK;
					ConnectionManager.commit();
				}else {
					ConnectionManager.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.put("status",status);
		return response;
	}

	public String getNomeAllegato(String path) {
		String str = path;
		if (path.lastIndexOf(File.separator) != -1)
			str = path.substring(path.lastIndexOf(File.separator)+1);
		return str;
	}

	public JSONObject recuperaDocumentoDaFirmare(String idDevice) {
		JSONObject infoDocumento = new JSONObject();
		String kDocDgt = recuperaChiaveDocumentoDigitale(idDevice);
		if(kDocDgt != null) {
			try {
				DocumentoDigitale docDgt = (DocumentoDigitale) DocumentoDigitale.elementWithKey(DocumentoDigitale.class, kDocDgt, PersistentObject.NO_LOCK);
				if(docDgt != null) {
					if(docDgt.getOggetti().size() > 0) {
						DocumentoDgtOggetto oggetto = (DocumentoDgtOggetto) docDgt.getOggetti().get(0);
						infoDocumento.put("file",readInputStreamToByteArray(oggetto.getOggettoBlob()));
						infoDocumento.put("chiaveDocumentoDigitale", docDgt.getKey());
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			} catch (IOException e) {
				e.printStackTrace(Trace.excStream);
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return infoDocumento;
	}

	private byte[] readInputStreamToByteArray(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int numRead;
		try {
			while ((numRead = inputStream.read(buffer)) != -1) {
				byteBuffer.write(buffer, 0, numRead);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return byteBuffer.toByteArray();
	}

	public String recuperaChiaveDocumentoDigitale(String idDevice) {
		idDevice = "TABLEZ";
		String idAzienda = "001";
		String key = null;
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT "+DocumentiAttesaFirmaTM.ID_AZIENDA+","+DocumentiAttesaFirmaTM.R_DOC_DGT+","+DocumentiAttesaFirmaTM.R_VRS_DOC_DGT+" "
				+ "FROM "+DocumentiAttesaFirmaTM.TABLE_NAME+" WHERE "+DocumentiAttesaFirmaTM.ID_AZIENDA+" = '"+idAzienda+"' "
				+ "AND "+DocumentiAttesaFirmaTM.R_DEVICE+" = '"+idDevice+"' "
				+ "AND "+DocumentiAttesaFirmaTM.PROCESSATO+" = '"+Column.FALSE_CHAR+"' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if(rs.next()) {
				key = KeyHelper.buildObjectKey(new String[] {
						rs.getString(DocumentiAttesaFirmaTM.ID_AZIENDA),
						rs.getString(DocumentiAttesaFirmaTM.R_DOC_DGT),
						rs.getString(DocumentiAttesaFirmaTM.R_VRS_DOC_DGT)
				});
			}
		}catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(cs != null) {
					cs.free();
				}
			}catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return key;
	}
}
