package it.softre.thip.base.firmadigitale.api;

import java.io.ByteArrayOutputStream;
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

import it.softre.thip.base.firmadigitale.AssociazioneTipoDocFirma;
import it.softre.thip.base.firmadigitale.DocumentiAttesaFirma;
import it.softre.thip.base.firmadigitale.DocumentiAttesaFirmaTM;
import it.softre.thip.base.firmadigitale.PsnDatiFirmaDigitale;
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
			DocumentiAttesaFirma documentoAttesaFirma = (DocumentiAttesaFirma) DocumentiAttesaFirma.elementWithKey(DocumentiAttesaFirma.class, keyDocOri, PersistentObject.NO_LOCK);
			DocumentoDigitale docOri = documentoAttesaFirma.getDocumentodigitale();
			if(documentoAttesaFirma != null && docOri != null) {
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

				AssociazioneTipoDocFirma associazione = PsnDatiFirmaDigitale.recuperaAssociazioneTipoDocumento(docOri.getIdTipoDocDgt());
				if(associazione == null) {
					//errore grave
				}

				// Draw the signature image onto the page
				PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, signatureBytes, "signature");
				float x = associazione.getXPosition().floatValue(); // Example coordinates
				float y = associazione.getYPosition().floatValue(); // Example coordinates
				PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
				contentStream.drawImage(pdImage, x, y, associazione.getWidth().floatValue(), associazione.getHeight().floatValue());
				contentStream.close();

				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				document.save(byteArrayOutputStream);
				document.close();

				byte[] signedPdfBytes = byteArrayOutputStream.toByteArray();
				DocumentoDgtOggetto oggNew = DocumentoDigitale.creaDocumentoDgtOggetto(docOri, docOri.getTipoDocDgt(), false);
				String filename = oggetto.getFilename();
				if (filename != null && !filename.equals("")) {
					oggNew.setFilename(getNomeAllegato(oggetto.getNomeFilePdf()));
					oggNew.setSSDMimeType(oggetto.getSSDMimeType());
					String descrizione = oggetto.getDescrizione().getDescrizione();
					descrizione = descrizione + " Firmato";
					if(descrizione.length() > 35) {
						descrizione = descrizione.substring(descrizione.length()-35);
					}
					oggNew.getDescrizione().setDescrizione(descrizione);
					oggNew.getDescrizione().setDescrizioneRidotta(oggetto.getDescrizione().getDescrizioneRidotta());
					if (PersDatiGen.getCurrentPersDatiGen().getMemorizzazioneDocDgt() == PersDatiGen.MEM_DOC_DGT_SU_DATABASE) {
						oggNew.setBlobBytes(signedPdfBytes);
					}
					oggNew.setCompresso(docOri.getTipoDocDgt().isZipAttachment());
					if (PersDatiGen.getCurrentPersDatiGen().getMemorizzazioneDocDgt() == PersDatiGen.MEM_DOC_DGT_SU_FILESYSTEM) {
						oggNew.percorsoSalvataggioFile();
						oggNew.setBlobBytes(signedPdfBytes);
					}
				}
				oggNew.setOnDB(false);
				oggNew.setProgressivo(docOri.getOggetti().size()+1);
				docOri.getOggetti().add(oggNew);
				int rc = docOri.save();

				//flaggare il documento come processato
				documentoAttesaFirma.setProcessato(true);
				rc = documentoAttesaFirma.save();
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
		if (path.lastIndexOf(".") != -1) {
			str = path.substring(0,path.lastIndexOf("."));
			String extension = path.substring(path.lastIndexOf("."));
			str = str+"_Firmato"+extension;
		}
		return str;
	}

	public JSONObject recuperaDocumentoDaFirmare(String idDevice,String idAzienda) {
		JSONObject infoDocumento = new JSONObject();
		DocumentiAttesaFirma documentoAttesaFirma = recuperaChiaveDocumentoDigitale(idDevice,idAzienda);
		if(documentoAttesaFirma != null) {
			String kDocDgt = documentoAttesaFirma.getDocumentodigitaleKey();
			if(kDocDgt != null) {
				try {
					DocumentoDigitale docDgt = (DocumentoDigitale) DocumentoDigitale.elementWithKey(DocumentoDigitale.class, kDocDgt, PersistentObject.NO_LOCK);
					if(docDgt != null) {
						if(docDgt.getOggetti().size() > 0) {
							DocumentoDgtOggetto oggetto = (DocumentoDgtOggetto) docDgt.getOggetti().get(0);
							infoDocumento.put("file",readInputStreamToByteArray(oggetto.getOggettoBlob()));
							infoDocumento.put("chiaveDocumentoDigitale", documentoAttesaFirma.getKey());
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

	public DocumentiAttesaFirma recuperaChiaveDocumentoDigitale(String idDevice, String idAzienda) {
		DocumentiAttesaFirma doc = null;
		String key = null;
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT "+DocumentiAttesaFirmaTM.ID_AZIENDA+","+DocumentiAttesaFirmaTM.ID+" "
				+ "FROM "+DocumentiAttesaFirmaTM.TABLE_NAME+" WHERE "+DocumentiAttesaFirmaTM.ID_AZIENDA+" = '"+idAzienda+"' "
				+ "AND "+DocumentiAttesaFirmaTM.R_DEVICE+" = '"+idDevice+"' "
				+ "AND "+DocumentiAttesaFirmaTM.PROCESSATO+" = '"+Column.FALSE_CHAR+"' ORDER BY ID DESC ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if(rs.next()) {
				key = KeyHelper.buildObjectKey(new String[] {
						rs.getString(DocumentiAttesaFirmaTM.ID_AZIENDA),
						rs.getString(DocumentiAttesaFirmaTM.ID)
				});
				doc = (DocumentiAttesaFirma) DocumentiAttesaFirma.elementWithKey(DocumentiAttesaFirma.class, key, PersistentObject.NO_LOCK);
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
		return doc;
	}
}
