/*
 * @(#)DeviceInvioDocumentiTM.java
 */

/**
 * DeviceInvioDocumentiTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 03/06/2024 at 14:40:04
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 03/06/2024    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.base.firmadigitale;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class DeviceInvioDocumentiTM extends TableManager {

  
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
   * Attributo NOME_DEVICE
   */
  public static final String NOME_DEVICE = "NOME_DEVICE";

  /**
   * Attributo DESCRIZIONE
   */
  public static final String DESCRIZIONE = "DESCRIZIONE";

  /**
   * Attributo ID_STAMPANTE
   */
  public static final String ID_STAMPANTE = "ID_STAMPANTE";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "DEVICE_INVIO_DOCUMENTI";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.base.firmadigitale.DeviceInvioDocumenti.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(DeviceInvioDocumentiTM.class);
    }
    return cInstance;
  }

  /**
   *  DeviceInvioDocumentiTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public DeviceInvioDocumentiTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
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
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(NOME_DEVICE + ", " + DESCRIZIONE + ", " + ID_AZIENDA + ", " + ID_STAMPANTE
         + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG
         + ", " + TIMESTAMP_AGG);
  }

}

