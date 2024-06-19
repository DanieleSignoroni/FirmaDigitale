package it.softre.thip.base.firmadigitale;

import com.thera.thermfw.persist.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class AssociazioneTipoDocFirmaTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String R_TIPO_DOC = "R_TIPO_DOC";

	public static final String X_POSITION = "X_POSITION";

	public static final String Y_POSITION = "Y_POSITION";

	public static final String WIDTH = "WIDTH";

	public static final String HEIGHT = "HEIGHT";

	public static final String TIPO_DOC_VEN = "TIPO_DOC_VEN";

	public static final String TIPO_DOC_ACQ = "TIPO_DOC_ACQ";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "ASSOCIAZIONE_TIPO_DOC_FIRMA";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.firmadigitale.AssociazioneTipoDocFirma.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(AssociazioneTipoDocFirmaTM.class);
		}
		return cInstance;
	}

	public AssociazioneTipoDocFirmaTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("XPosition", X_POSITION);
		addAttribute("YPosition", Y_POSITION);
		addAttribute("Width", WIDTH);
		addAttribute("Height", HEIGHT);
		addAttribute("TipoDocVen", TIPO_DOC_VEN);
		addAttribute("TipoDocAcq", TIPO_DOC_ACQ);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdTipoDocumento", R_TIPO_DOC);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + R_TIPO_DOC);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}

