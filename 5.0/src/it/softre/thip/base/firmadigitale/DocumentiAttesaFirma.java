package it.softre.thip.base.firmadigitale;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.KeyHelper;

/**
 * Rappresenta un documento digitale in attesa di firma, se {@link #getProcessato()} <code>false</code>.<br>
 * Questo viene usato dai dispositivi per firmare il documento digitale e salvare il pdf firmato.<br>
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 04/06/2024
 * <br><br>
 * <b>71XXX	DSSOF3	04/06/2024</b>
 * <p>Prima stesura.<br>
 *  
 * </p>
 */

public class DocumentiAttesaFirma extends DocumentiAttesaFirmaPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	public int save() throws SQLException {
		if (!isOnDB()) {
			try {
				setId(new Integer(Numerator.getNextInt("DocAttsFirma")));
			} catch (NumeratorException e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return super.save();
	}

	@SuppressWarnings("rawtypes")
	public static DocumentiAttesaFirma recuperaDocumentoInAttesaDiFirma(String keyDocDigitale) {
		DocumentiAttesaFirma documento = null;
		String[] keyValues = KeyHelper.unpackObjectKey(keyDocDigitale);
		if(keyValues.length < 2) {
			return documento;
		}
		String where = " "+DocumentiAttesaFirmaTM.ID_AZIENDA+" = '"+keyValues[0]+"' AND "+DocumentiAttesaFirmaTM.R_DOC_DGT+" = '"+keyValues[1]+"' "
				+ "AND "+DocumentiAttesaFirmaTM.R_VRS_DOC_DGT+" = '"+keyValues[2]+"' ";
		try {
			Vector documenti = DocumentiAttesaFirma.retrieveList(DocumentiAttesaFirma.class, where, "", false);
			if(documenti.size() > 0) {
				documento = (DocumentiAttesaFirma) documenti.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documento;
	}

}

