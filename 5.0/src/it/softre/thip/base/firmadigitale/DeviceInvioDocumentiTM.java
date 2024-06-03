package it.softre.thip.base.firmadigitale;

import com.thera.thermfw.persist.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class DeviceInvioDocumentiTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String NOME_DEVICE = "NOME_DEVICE";

	public static final String DESCRIZIONE = "DESCRIZIONE";

	public static final String ID_STAMPANTE = "ID_STAMPANTE";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "DEVICE_INVIO_DOCUMENTI";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.firmadigitale.DeviceInvioDocumenti.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(DeviceInvioDocumentiTM.class);
		}
		return cInstance;
	}

	public DeviceInvioDocumentiTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("NomeDevice", NOME_DEVICE);
		addAttribute("Descrizione", DESCRIZIONE);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdStampante", ID_STAMPANTE);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + NOME_DEVICE);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}

