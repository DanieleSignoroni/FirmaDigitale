package it.softre.thip.base.firmadigitale;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.BusinessObjectAdapter;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.security.Authorizable;

import it.thera.thip.acquisti.documentoAC.DocumentoAcquisto;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.documentoDgt.DocumentoDigitale;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;

public class InvioDocumentoDevice extends BusinessObjectAdapter implements Authorizable {

	protected String iIdAzienda;

	protected String iClassName;

	protected String iChiaveSelezionato;

	protected Proxy iDevice = new Proxy(it.softre.thip.base.firmadigitale.DeviceInvioDocumenti.class);

	public String getIdAzienda() {
		return iIdAzienda;
	}

	public void setIdAzienda(String iIdAzienda) {
		this.iIdAzienda = iIdAzienda;
	}

	public String getClassName() {
		return iClassName;
	}

	public void setClassName(String iClassName) {
		this.iClassName = iClassName;
	}

	public void setDevice(DeviceInvioDocumenti Fornitore)
	{
		this.iDevice.setObject(Fornitore);
	}

	public DeviceInvioDocumenti getDevice()
	{
		return (DeviceInvioDocumenti)iDevice.getObject();
	}

	public void setDeviceKey(String key)
	{
		iDevice.setKey(key);
	}

	public String getDeviceKey()
	{
		return iDevice.getKey();
	}

	public void setIdDevice(String rFornitore)
	{
		String key = iDevice.getKey();
		iDevice.setKey(KeyHelper.replaceTokenObjectKey(key , 2, rFornitore));
	}

	public String getIdDevice(){
		String key = iDevice.getKey();
		String objRFornitore = KeyHelper.getTokenObjectKey(key,2);
		return objRFornitore;
	}

	public String getChiaveSelezionato() {
		return iChiaveSelezionato;
	}

	public void setChiaveSelezionato(String iChiaveSelezionato) {
		this.iChiaveSelezionato = iChiaveSelezionato;
	}

	public InvioDocumentoDevice() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int save(boolean force) throws SQLException {
		int rc = 0;
		DocumentiAttesaFirma attesaFirma = (DocumentiAttesaFirma) Factory.createObject(DocumentiAttesaFirma.class);
		attesaFirma.setIdAzienda(getIdAzienda());
		attesaFirma.setIdDevice(getIdDevice());
		if(getClassName().equals("DocumentoVendita")) {
			DocumentoVendita docVen = (DocumentoVendita) DocumentoVendita.elementWithKey(DocumentoVendita.class,
					getChiaveSelezionato(), PersistentObject.NO_LOCK);
			if(docVen != null) {
				try {
					Vector docs = InvioDocumentiUtils.getDocumentiDigitaliCollegatiDV(docVen, getClassName());
					if(docs.size() > 0) {
						DocumentoDigitale docDgt = (DocumentoDigitale) docs.get(0);
						attesaFirma.setIdDocumentoDgt(docDgt.getIdDocumentoDgt());
						attesaFirma.setRVrsDocDgt(docDgt.getIdVersione());
					}
				} catch (Exception e) {
					e.printStackTrace(Trace.excStream);
				}
			}
		}else if(getClassName().equals("DocumentoAcquisto")){
			DocumentoAcquisto docAcq = (DocumentoAcquisto) DocumentoVendita.elementWithKey(DocumentoAcquisto.class,
					getChiaveSelezionato(), PersistentObject.NO_LOCK);
			if(docAcq != null) {
				try {
					Vector docs = InvioDocumentiUtils.getDocumentiDigitaliCollegatiDA(docAcq, getClassName());
					if(docs.size() > 0) {
						DocumentoDigitale docDgt = (DocumentoDigitale) docs.get(0);
						attesaFirma.setIdDocumentoDgt(docDgt.getIdDocumentoDgt());
						attesaFirma.setRVrsDocDgt(docDgt.getIdVersione());
					}
				} catch (Exception e) {
					e.printStackTrace(Trace.excStream);
				}
			}
		}
		if(attesaFirma.getIdDocumentoDgt() != null)
			rc = attesaFirma.save();
		else
			throw new SQLException("Non e' stato trovato nessun documento da inviare");
		return rc;
	}


}
