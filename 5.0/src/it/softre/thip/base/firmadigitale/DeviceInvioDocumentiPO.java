package it.softre.thip.base.firmadigitale;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import com.thera.thermfw.batch.Printer;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class DeviceInvioDocumentiPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static DeviceInvioDocumenti cInstance;

	protected String iNomeDevice;

	protected String iDescrizione;

	protected Proxy iStampante = new Proxy(com.thera.thermfw.batch.Printer.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (DeviceInvioDocumenti)Factory.createObject(DeviceInvioDocumenti.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static DeviceInvioDocumenti elementWithKey(String key, int lockType) throws SQLException {
		return (DeviceInvioDocumenti)PersistentObject.elementWithKey(DeviceInvioDocumenti.class, key, lockType);
	}

	public DeviceInvioDocumentiPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setNomeDevice(String nomeDevice) {
		this.iNomeDevice = nomeDevice;
		setDirty();
		setOnDB(false);
	}

	public String getNomeDevice() {
		return iNomeDevice;
	}

	public void setDescrizione(String descrizione) {
		this.iDescrizione = descrizione;
		setDirty();
	}

	public String getDescrizione() {
		return iDescrizione;
	}

	public void setIdAzienda(String idAzienda) {
		iAzienda.setKey(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setStampante(Printer stampante) {
		this.iStampante.setObject(stampante);
		setDirty();
	}

	public Printer getStampante() {
		return (Printer)iStampante.getObject();
	}

	public void setStampanteKey(String key) {
		iStampante.setKey(key);
		setDirty();
	}

	public String getStampanteKey() {
		return iStampante.getKey();
	}

	public void setIdStampante(String idStampante) {
		iStampante.setKey(idStampante);
		setDirty();
	}

	public String getIdStampante() {
		String key = iStampante.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		DeviceInvioDocumentiPO deviceInvioDocumentiPO = (DeviceInvioDocumentiPO)obj;
		iStampante.setEqual(deviceInvioDocumentiPO.iStampante);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setNomeDevice(KeyHelper.getTokenObjectKey(key, 2));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String nomeDevice = getNomeDevice();
		Object[] keyParts = {idAzienda, nomeDevice};
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return DeviceInvioDocumentiTM.getInstance();
	}

}

