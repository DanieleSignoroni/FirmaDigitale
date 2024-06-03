/*
 * @(#)DocumentiAttesaFirmaPO.java
 */

/**
 * null
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
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.base.documentoDgt.DocumentoDigitale;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class DocumentiAttesaFirmaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static DocumentiAttesaFirma cInstance;

  /**
   * Attributo iId
   */
  protected Integer iId;

  /**
   * Attributo iProcessato
   */
  protected boolean iProcessato = false;

  /**
   * Attributo iErrors
   */
  protected String iErrors;

  /**
   * Attributo iDocumentodigitale
   */
  protected Proxy iDocumentodigitale = new Proxy(it.thera.thip.base.documentoDgt.DocumentoDigitale.class);

  
  /**
   *  retrieveList
   * @param where
   * @param orderBy
   * @param optimistic
   * @return Vector
   * @throws SQLException
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (DocumentiAttesaFirma)Factory.createObject(DocumentiAttesaFirma.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return DocumentiAttesaFirma
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static DocumentiAttesaFirma elementWithKey(String key, int lockType) throws SQLException {
    return (DocumentiAttesaFirma)PersistentObject.elementWithKey(DocumentiAttesaFirma.class, key, lockType);
  }

  /**
   * DocumentiAttesaFirmaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public DocumentiAttesaFirmaPO() {
    setProcessato(false);
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param id
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setId(Integer id) {
    this.iId = id;
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return Integer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public Integer getId() {
    return iId;
  }

  /**
   * Valorizza l'attributo. 
   * @param processato
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setProcessato(boolean processato) {
    this.iProcessato = processato;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean getProcessato() {
    return iProcessato;
  }

  /**
   * Valorizza l'attributo. 
   * @param errors
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setErrors(String errors) {
    this.iErrors = errors;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getErrors() {
    return iErrors;
  }

  /**
   * Valorizza l'attributo. 
   * @param documentodigitale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setDocumentodigitale(DocumentoDigitale documentodigitale) {
    String oldObjectKey = getKey();
    String idAzienda = getIdAzienda();
    if (documentodigitale != null) {
      idAzienda = KeyHelper.getTokenObjectKey(documentodigitale.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iDocumentodigitale.setObject(documentodigitale);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
    }
  }

  /**
   * Restituisce l'attributo. 
   * @return DocumentoDigitale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public DocumentoDigitale getDocumentodigitale() {
    return (DocumentoDigitale)iDocumentodigitale.getObject();
  }

  /**
   * setDocumentodigitaleKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setDocumentodigitaleKey(String key) {
    String oldObjectKey = getKey();
    iDocumentodigitale.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
    }
  }

  /**
   * getDocumentodigitaleKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getDocumentodigitaleKey() {
    return iDocumentodigitale.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param idDocumentoDgt
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdDocumentoDgt(Long idDocumentoDgt) {
    String key = iDocumentodigitale.getKey();
    iDocumentodigitale.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idDocumentoDgt));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Long
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public Long getIdDocumentoDgt() {
    String key = iDocumentodigitale.getKey();
    String objIdDocumentoDgt = KeyHelper.getTokenObjectKey(key,2);
    return KeyHelper.stringToLongObj(objIdDocumentoDgt);
    
  }

  /**
   * Valorizza l'attributo. 
   * @param rVrsDocDgt
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setRVrsDocDgt(Short rVrsDocDgt) {
    String key = iDocumentodigitale.getKey();
    iDocumentodigitale.setKey(KeyHelper.replaceTokenObjectKey(key , 3, rVrsDocDgt));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Short
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public Short getRVrsDocDgt() {
    String key = iDocumentodigitale.getKey();
    String objRVrsDocDgt = KeyHelper.getTokenObjectKey(key,3);
    return KeyHelper.stringToShortObj(objRVrsDocDgt);
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    DocumentiAttesaFirmaPO documentiAttesaFirmaPO = (DocumentiAttesaFirmaPO)obj;
    iDocumentodigitale.setEqual(documentiAttesaFirmaPO.iDocumentodigitale);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public Vector checkAll(BaseComponentsCollection components) {
    Vector errors = new Vector();
    components.runAllChecks(errors);
    return errors;
  }

  /**
   *  setKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setId(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    Integer id = getId();
    Object[] keyParts = {idAzienda, id};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String toString() {
    return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
  }

  /**
   *  getTableManager
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return DocumentiAttesaFirmaTM.getInstance();
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iDocumentodigitale.getKey();
    iDocumentodigitale.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
  }

}

