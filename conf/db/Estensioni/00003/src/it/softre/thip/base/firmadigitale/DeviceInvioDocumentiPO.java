/*
 * @(#)DeviceInvioDocumentiPO.java
 */

/**
 * null
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
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import com.thera.thermfw.batch.Printer;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class DeviceInvioDocumentiPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static DeviceInvioDocumenti cInstance;

  /**
   * Attributo iNomeDevice
   */
  protected String iNomeDevice;

  /**
   * Attributo iDescrizione
   */
  protected String iDescrizione;

  /**
   * Attributo iStampante
   */
  protected Proxy iStampante = new Proxy(com.thera.thermfw.batch.Printer.class);

  
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
      cInstance = (DeviceInvioDocumenti)Factory.createObject(DeviceInvioDocumenti.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return DeviceInvioDocumenti
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static DeviceInvioDocumenti elementWithKey(String key, int lockType) throws SQLException {
    return (DeviceInvioDocumenti)PersistentObject.elementWithKey(DeviceInvioDocumenti.class, key, lockType);
  }

  /**
   * DeviceInvioDocumentiPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public DeviceInvioDocumentiPO() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param nomeDevice
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setNomeDevice(String nomeDevice) {
    this.iNomeDevice = nomeDevice;
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
  public String getNomeDevice() {
    return iNomeDevice;
  }

  /**
   * Valorizza l'attributo. 
   * @param descrizione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setDescrizione(String descrizione) {
    this.iDescrizione = descrizione;
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
  public String getDescrizione() {
    return iDescrizione;
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
    iAzienda.setKey(idAzienda);
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
   * @param stampante
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setStampante(Printer stampante) {
    this.iStampante.setObject(stampante);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Printer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public Printer getStampante() {
    return (Printer)iStampante.getObject();
  }

  /**
   * setStampanteKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setStampanteKey(String key) {
    iStampante.setKey(key);
    setDirty();
  }

  /**
   * getStampanteKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getStampanteKey() {
    return iStampante.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idStampante
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdStampante(String idStampante) {
    iStampante.setKey(idStampante);
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
  public String getIdStampante() {
    String key = iStampante.getKey();
    return key;
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
    DeviceInvioDocumentiPO deviceInvioDocumentiPO = (DeviceInvioDocumentiPO)obj;
    iStampante.setEqual(deviceInvioDocumentiPO.iStampante);
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
    setNomeDevice(KeyHelper.getTokenObjectKey(key, 2));
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
    String nomeDevice = getNomeDevice();
    Object[] keyParts = {idAzienda, nomeDevice};
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
    return DeviceInvioDocumentiTM.getInstance();
  }

}

