/*
 * @(#)AssociazioneTipoDocFirmaTM.java
 */

/**
 * AssociazioneTipoDocFirmaTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 11/06/2024 at 11:47:49
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 11/06/2024    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.base.firmadigitale;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class AssociazioneTipoDocFirmaTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo STATO
   */
  public static final String STATO = "STATO";

  /**
   * Attributo R_UTENTE_CRZ
   */
  public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

  /**
   * Attributo TIMESTAMP_CRZ
   */
  public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

  /**
   * Attributo R_UTENTE_AGG
   */
  public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

  /**
   * Attributo TIMESTAMP_AGG
   */
  public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

  /**
   * Attributo R_TIPO_DOC
   */
  public static final String R_TIPO_DOC = "R_TIPO_DOC";

  /**
   * Attributo X_POSITION
   */
  public static final String X_POSITION = "X_POSITION";

  /**
   * Attributo Y_POSITION
   */
  public static final String Y_POSITION = "Y_POSITION";

  /**
   * Attributo WIDTH
   */
  public static final String WIDTH = "WIDTH";

  /**
   * Attributo HEIGHT
   */
  public static final String HEIGHT = "HEIGHT";

  /**
   * Attributo TIPO_DOC_VEN
   */
  public static final String TIPO_DOC_VEN = "TIPO_DOC_VEN";

  /**
   * Attributo TIPO_DOC_ACQ
   */
  public static final String TIPO_DOC_ACQ = "TIPO_DOC_ACQ";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "ASSOCIAZIONE_TIPO_DOC_FIRMA";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.base.firmadigitale.AssociazioneTipoDocFirma.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(AssociazioneTipoDocFirmaTM.class);
    }
    return cInstance;
  }

  /**
   *  AssociazioneTipoDocFirmaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public AssociazioneTipoDocFirmaTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    setTableName(TABLE_NAME);
    setObjClassName(CLASS_NAME);
    init();
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(X_POSITION + ", " + Y_POSITION + ", " + WIDTH + ", " + HEIGHT
         + ", " + TIPO_DOC_VEN + ", " + TIPO_DOC_ACQ + ", " + ID_AZIENDA + ", " + R_TIPO_DOC
         + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG
         + ", " + TIMESTAMP_AGG);
  }

}

