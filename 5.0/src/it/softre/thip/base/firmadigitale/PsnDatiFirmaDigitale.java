package it.softre.thip.base.firmadigitale;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.Vector;

import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.common.*;

public class PsnDatiFirmaDigitale extends PsnDatiFirmaDigitalePO implements Cacheable {

	@SuppressWarnings("rawtypes")
	protected static Hashtable iHistory_PersDatiAcq = new Hashtable();

	public ErrorMessage checkDelete() {
		return null;
	}

	public static PsnDatiFirmaDigitale getCurrentPersDati() {
		return getCurrentPersDati(Azienda.getAziendaCorrente());
	}

	@SuppressWarnings("unchecked")
	public static PsnDatiFirmaDigitale getCurrentPersDati(String iIdAzienda) {
		if (iIdAzienda == null)
			return null;

		PsnDatiFirmaDigitale iPersDatiAcq = null;

		try
		{
			if(PersistentObjectCache.isEnabled())
			{
				return (PsnDatiFirmaDigitale)PersistentObject.readOnlyElementWithKey(PsnDatiFirmaDigitale.class, iIdAzienda);
			}
			else
			{
				if(iHistory_PersDatiAcq.containsKey(iIdAzienda))
					return (PsnDatiFirmaDigitale)iHistory_PersDatiAcq.get(iIdAzienda);
				else
				{
					iPersDatiAcq = PsnDatiFirmaDigitale.elementWithKey(iIdAzienda, PersistentObject.OPTIMISTIC_LOCK);
					if(iPersDatiAcq != null)
						iHistory_PersDatiAcq.put(iIdAzienda,iPersDatiAcq);
				}
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return iPersDatiAcq;
	}

	@SuppressWarnings("rawtypes")
	public static String getIdTipoDocumentoDigitale(char tipoDocumento, boolean isDocumentoVendita) {
		String where = " "+AssociazioneTipoDocFirmaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' ";
		if(isDocumentoVendita) {
			where += " AND "+AssociazioneTipoDocFirmaTM.TIPO_DOC_VEN+" = '"+tipoDocumento+"' ";
		}else {
			where += " AND "+AssociazioneTipoDocFirmaTM.TIPO_DOC_ACQ+" = '"+tipoDocumento+"' ";
		}
		try {
			Vector associazioni = AssociazioneTipoDocFirma.retrieveList(AssociazioneTipoDocFirma.class, where, "", false);
			if(associazioni.size() > 0) {
				AssociazioneTipoDocFirma associazione = (AssociazioneTipoDocFirma) associazioni.get(0);
				return associazione.getIdTipoDocumento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static AssociazioneTipoDocFirma recuperaAssociazioneTipoDocumento(String idTipoDocumento) {
		String where = " "+AssociazioneTipoDocFirmaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' ";
		where += " AND "+AssociazioneTipoDocFirmaTM.R_TIPO_DOC+" = '"+idTipoDocumento+"' ";
		try {
			Vector associazioni = AssociazioneTipoDocFirma.retrieveList(AssociazioneTipoDocFirma.class, where, "", false);
			if(associazioni.size() > 0) {
				AssociazioneTipoDocFirma associazione = (AssociazioneTipoDocFirma) associazioni.get(0);
				return associazione;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public int saveOwnedObjects(int rc) throws SQLException {
		rc += super.saveOwnedObjects(rc);

		if(rc >= 0)
			iHistory_PersDatiAcq.put(this.getIdAzienda(),this);

		return rc;
	}
}

