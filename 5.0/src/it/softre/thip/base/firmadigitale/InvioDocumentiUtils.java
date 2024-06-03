package it.softre.thip.base.firmadigitale;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.ad.ClassADCollectionManager;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.security.Entity;
import com.thera.thermfw.security.EntityNotFoundException;

import it.thera.thip.acquisti.documentoAC.DocumentoAcquisto;
import it.thera.thip.acquisti.generaleAC.CausaleDocumentoTestataAcq;
import it.thera.thip.acquisti.generaleAC.TipoBollaAcq;
import it.thera.thip.base.comuniVenAcq.AzioneMagazzino;
import it.thera.thip.base.comuniVenAcq.DocumentoTestata;
import it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgt;
import it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgtTM;
import it.thera.thip.base.documentoDgt.DocDgtEntita;
import it.thera.thip.base.documentoDgt.DocDgtEntitaTM;
import it.thera.thip.base.documentoDgt.DocumentoDigitale;
import it.thera.thip.base.documentoDgt.DocumentoDigitaleTM;
import it.thera.thip.base.documentoDgt.FunzioneTipoDocDgt;
import it.thera.thip.base.documentoDgt.FunzioneTipoDocDgtTM;
import it.thera.thip.base.documentoDgt.web.ApriDocumentoDigitale;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;
import it.thera.thip.vendite.generaleVE.TipoBolla;

public class InvioDocumentiUtils {

	/**
	 * Serve per capire se un documento e' abilitato all'invio per la firma.<br>
	 * @author Daniele Signoroni 03/06/2024
	 * <p>
	 * Prima stesura.<br>
	 * Nel caso di documenti acquisto dobbiamo verificare che sia di uscita (eg. uscita C/Lav, uscita reso fornitore).
	 * </p>
	 * @param documento
	 * @return un booleano che indica l'abilitazione
	 */
	public static boolean isDocumentoAbilitatoInvio(DocumentoTestata documento) {
		if(documento != null && documento.isOnDB()) {
			if(documento instanceof DocumentoAcquisto) {
				CausaleDocumentoTestataAcq causale = ((DocumentoAcquisto) documento).getCausale();
				if(causale.getAzioneMagazzino() != AzioneMagazzino.USCITA) {
					return false;
				}
			}
		}
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public static Vector getDocumentiDigitaliCollegatiDV(DocumentoVendita dv, String className) throws Exception {
		String idEntita = getEntitaFromClassHdr(className);
		if (dv != null) {
			String idAzienda = dv.getIdAzienda();
			String idFunzione = null;
			if (dv.getTipoBolla() == TipoBolla.DDT) {
				idFunzione = ApriDocumentoDigitale.DDT_VENDITE;
			}
			else if (dv.getTipoBolla() == TipoBolla.FATTURA_ACCOMPAGNATORIA) {
				idFunzione = ApriDocumentoDigitale.FATT_ACCOM;
			}
			else if ((dv.getTipoBolla() == TipoBolla.ALTRO && dv.getCausale().getAzioneMagazzino() == AzioneMagazzino.ENTRATA)){
				idFunzione = ApriDocumentoDigitale.BEM_VENDITE;
			}
			else if (dv.getTipoBolla() == TipoBolla.BEM){
				idFunzione = ApriDocumentoDigitale.BEM_VE_SCA;
			}
			else return null;

			String idTipoDoc = findTipoDocumentoDgt(idAzienda, idFunzione);
			if (idTipoDoc == null) {
				if (idEntita != null && !idEntita.equals(""))
					idTipoDoc = findTipoDocumentoDgtFromAssocia(idAzienda, idEntita);
			}
			if (idTipoDoc != null && !idTipoDoc.equals(""))
				return findDocumentoDigitale(idAzienda, idTipoDoc, dv.getAnnoDocumento(), dv.getNumeroDocumento());
			else
				return null;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Vector getDocumentiDigitaliCollegatiDA(DocumentoAcquisto dv, String className) throws Exception {
		String idEntita = getEntitaFromClassHdr(className);
		if (dv != null) {
			String idAzienda = dv.getIdAzienda();
			String idFunzione = null;
			if (dv.getTipoBolla() == TipoBolla.DDT) {
				idFunzione = ApriDocumentoDigitale.DDT_ACQUISTI;

			} else if (dv.getTipoBolla() == TipoBollaAcq.BEM) {
				idFunzione = ApriDocumentoDigitale.BEM_ACQUISTI;
			}
			else if (dv.getTipoBolla() == TipoBollaAcq.ALTRO) {
				idFunzione = ApriDocumentoDigitale.BEM_AC_SCA;
			}
			else return null;

			String idTipoDoc = findTipoDocumentoDgt(idAzienda, idFunzione);
			if (idTipoDoc == null) {
				if (idEntita != null && !idEntita.equals(""))
					idTipoDoc = findTipoDocumentoDgtFromAssocia(idAzienda, idEntita);
			}
			if (idTipoDoc != null && !idTipoDoc.equals(""))
				return findDocumentoDigitale(idAzienda, idTipoDoc, dv.getAnnoDocumento(), dv.getNumeroDocumento());
			else
				return null;
		}
		return null;
	}

	public static boolean documentoAcquistoHasDocumentiDigitali(DocumentoAcquisto da,String className) throws Exception {
		String idEntita = getEntitaFromClassHdr(className);
		if (da != null) {
			String idAzienda = da.getIdAzienda();
			String idFunzione = null;
			if (da.getTipoBolla() == TipoBolla.DDT) {
				idFunzione = ApriDocumentoDigitale.DDT_ACQUISTI;

			} else if (da.getTipoBolla() == TipoBollaAcq.BEM) {
				idFunzione = ApriDocumentoDigitale.BEM_ACQUISTI;
			}
			else if (da.getTipoBolla() == TipoBollaAcq.ALTRO) {
				idFunzione = ApriDocumentoDigitale.BEM_AC_SCA;
			}
			else return false;

			String idTipoDoc = findTipoDocumentoDgt(idAzienda, idFunzione);
			if (idTipoDoc == null) {
				if (idEntita != null && !idEntita.equals(""))
					idTipoDoc = findTipoDocumentoDgtFromAssocia(idAzienda, idEntita);
			}
			if (idTipoDoc != null && !idTipoDoc.equals(""))
				return findDocumentoDigitale(idAzienda, idTipoDoc, da.getAnnoDocumento(), da.getNumeroDocumento()).size() > 0 ? true : false;
			else
				return false;
		}
		return false;
	}

	public static boolean documentoVenditaHasDocumentiDigitali(DocumentoVendita dv,String className) throws Exception {
		String idEntita = getEntitaFromClassHdr(className);
		if (dv != null) {
			String idAzienda = dv.getIdAzienda();
			String idFunzione = null;
			if (dv.getTipoBolla() == TipoBolla.DDT) {
				idFunzione = ApriDocumentoDigitale.DDT_VENDITE;
			}
			else if (dv.getTipoBolla() == TipoBolla.FATTURA_ACCOMPAGNATORIA) {
				idFunzione = ApriDocumentoDigitale.FATT_ACCOM;
			}
			else if ((dv.getTipoBolla() == TipoBolla.ALTRO && dv.getCausale().getAzioneMagazzino() == AzioneMagazzino.ENTRATA)){
				idFunzione = ApriDocumentoDigitale.BEM_VENDITE;
			}
			else if (dv.getTipoBolla() == TipoBolla.BEM){
				idFunzione = ApriDocumentoDigitale.BEM_VE_SCA;
			}
			else
				return false;

			String idTipoDoc = findTipoDocumentoDgt(idAzienda, idFunzione);
			if (idTipoDoc == null) {
				if (idEntita != null && !idEntita.equals(""))
					idTipoDoc = findTipoDocumentoDgtFromAssocia(idAzienda, idEntita);
			}
			if (idTipoDoc != null && !idTipoDoc.equals(""))
				return findDocumentoDigitale(idAzienda, idTipoDoc, dv.getAnnoDocumento(), dv.getNumeroDocumento()).size() > 0 ? true : false;
			else
				return false;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	protected static String getEntitaFromClassHdr(String classHdr) {
		String idEntita = null;
		try {
			ClassADCollection cadc = ClassADCollectionManager.collectionWithName(classHdr);
			Class c = Class.forName(cadc.getBOClassName());
			if(classHdr != null && cadc != null && c != null){
				idEntita = Entity.findEntityId(c);
			}
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace(Trace.excStream);
		} 
		catch (EntityNotFoundException e1) {
			e1.printStackTrace(Trace.excStream);
		} 
		catch (SQLException e1) {
			e1.printStackTrace(Trace.excStream);
		} 
		catch (NoSuchElementException e) {
			e.printStackTrace(Trace.excStream);
		} 
		catch (NoSuchFieldException e) {
			e.printStackTrace(Trace.excStream);
		}
		return idEntita;
	}

	@SuppressWarnings("rawtypes")
	public static String findTipoDocumentoDgtFromAssocia(String idAzienda, String idEntita) throws Exception {
		String where = AssociazioneEntitaTpDgtTM.ID_AZIENDA + " = '" + idAzienda + "' AND " +
				AssociazioneEntitaTpDgtTM.ID_ENTITA + " = '" + idEntita + "' AND " +
				AssociazioneEntitaTpDgtTM.STATO + " = '" + DatiComuniEstesi.VALIDO + "'";
		Vector v = AssociazioneEntitaTpDgt.retrieveList(where, "", false);
		if (v.size() >= 1) {
			AssociazioneEntitaTpDgt fnz = (AssociazioneEntitaTpDgt)v.elementAt(0);
			return fnz.getIdTipoDocDgt();
		}
		return null;
	}



	@SuppressWarnings("rawtypes")
	public static String findTipoDocumentoDgt(String idAzienda, String idFunzione) throws Exception {
		String where = FunzioneTipoDocDgtTM.ID_AZIENDA + " = '" + idAzienda + "' AND " +
				FunzioneTipoDocDgtTM.ID_FUNZIONE + " = '" + idFunzione + "' AND " +
				FunzioneTipoDocDgtTM.STATO + " = '" + DatiComuniEstesi.VALIDO + "'";
		Vector v = FunzioneTipoDocDgt.retrieveList(where, "", false);
		if (v.size() >= 1) {
			FunzioneTipoDocDgt fnz = (FunzioneTipoDocDgt)v.elementAt(0);
			return fnz.getIdTipoDocDgt();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static Vector findDocumentoDigitale(String IdAzienda, String tipoDoc, String annoDoc, String numeroDoc) throws Exception {
		return findDocumentoDigitale(IdAzienda, tipoDoc, annoDoc, numeroDoc, true, true); //21156 DZ
	}

	@SuppressWarnings("rawtypes")
	public static Vector findDocumentoDigitale(String IdAzienda, String tipoDoc, String annoDoc, String numeroDoc, boolean ricercaSuClassificazioneDoc, boolean ricercaSuEntitaAssociate) throws Exception {
		StringBuffer where = new StringBuffer();
		where.append(DocumentoDigitaleTM.ID_AZIENDA + " = '" + IdAzienda + "' AND ");
		where.append(DocumentoDigitaleTM.R_TIPO_DOC_DGT + " = '" + tipoDoc + "' AND ");
		where.append(DocumentoDigitaleTM.R_ANNO_DOC + " = '" + annoDoc + "' AND ");
		where.append(DocumentoDigitaleTM.R_NUMERO_DOC + " = '" + numeroDoc + "' AND ");
		where.append(DocumentoDigitaleTM.VISIBILE_GRIGLIA + " = 'Y'");
		Vector docDgt = new Vector();
		if (ricercaSuClassificazioneDoc)
			docDgt = DocumentoDigitale.retrieveList(where.toString(), "", false);
		String[] key = {IdAzienda, annoDoc, numeroDoc};
		if (ricercaSuEntitaAssociate)
			addDocDgtFromAssoc(docDgt, IdAzienda, tipoDoc, KeyHelper.buildObjectKey(key));
		return docDgt;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addDocDgtFromAssoc(Vector docDgt, String idAzienda, String tipoDoc, String key) {
		String where = DocDgtEntitaTM.ID_AZIENDA + "='" + idAzienda +
				"' AND " + DocDgtEntitaTM.KEY_ENTITA + "='" + key +
				"' AND " + DocDgtEntitaTM.ID_TIPO_DOC_DGT + "='" + tipoDoc + "'";

		try {
			List entita = DocDgtEntita.retrieveList(where, "", false);
			for(int i=0; i<entita.size(); i++){
				DocDgtEntita docDgtEnt = (DocDgtEntita)entita.get(i);
				if(! docDgt.contains(docDgtEnt.getDocumentoDgt()))
					docDgt.add(docDgtEnt.getDocumentoDgt());
			}
		}
		catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
	}
}
