/*
 * @(#)DocumentiAttesaFirmaTM.java
 */

/**
 * DocumentiAttesaFirmaTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 03/06/2024 at 16:24:49
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

public class DocumentiAttesaFirmaTM extends TableManager {

  
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
   * Attributo ID
   */
  public static final String ID = "ID";

  /**
   * Attributo R_DOC_DGT
   */
  public static final String R_DOC_DGT = "R_DOC_DGT";

  /**
   * Attributo R_VRS_DOC_DGT
   */
  public static final String R_VRS_DOC_DGT = "R_VRS_DOC_DGT";

  /**
   * Attributo PROCESSATO
   */
  public static final String PROCESSATO = "PROCESSATO";

  /**
   * Attributo ERRORS
   */
  public static final String ERRORS = "ERRORS";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "DOCUMENTI_ATTESA_FIRMA";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.base.firmadigitale.DocumentiAttesaFirma.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(DocumentiAttesaFirmaTM.class);
    }
    return cInstance;
  }

  /**
   *  DocumentiAttesaFirmaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public DocumentiAttesaFirmaTM() throws SQLException {
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
    addAttribute("Id", ID, "getIntegerObject");
    addAttribute("Processato", PROCESSATO);
    addAttribute("Errors", ERRORS);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdDocumentoDgt", R_DOC_DGT, "getLongObject");
    addAttribute("RVrsDocDgt", R_VRS_DOC_DGT, "getShortObject");
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID);

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
    configure(ID + ", " + PROCESSATO + ", " + ERRORS + ", " + ID_AZIENDA
         + ", " + R_DOC_DGT + ", " + R_VRS_DOC_DGT + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

