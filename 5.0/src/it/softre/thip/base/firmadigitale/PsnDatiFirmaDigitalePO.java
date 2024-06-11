package it.softre.thip.base.firmadigitale;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class PsnDatiFirmaDigitalePO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static PsnDatiFirmaDigitale cInstance;

  /**
   * Attributo iAbilitata
   */
  protected char iAbilitata = '0';

  /**
   * Attributo iAssociazioneDocumenti
   */
  protected OneToMany iAssociazioneDocumenti = new OneToMany(it.softre.thip.base.firmadigitale.AssociazioneTipoDocFirma.class, this, 1, false);

  
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
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  @SuppressWarnings("rawtypes")
public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (PsnDatiFirmaDigitale)Factory.createObject(PsnDatiFirmaDigitale.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return PsnDatiFirmaDigitale
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static PsnDatiFirmaDigitale elementWithKey(String key, int lockType) throws SQLException {
    return (PsnDatiFirmaDigitale)PersistentObject.elementWithKey(PsnDatiFirmaDigitale.class, key, lockType);
  }

  /**
   * PsnDatiFirmaDigitalePO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public PsnDatiFirmaDigitalePO() {
    setAbilitata('0');
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param abilitata
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setAbilitata(char abilitata) {
    this.iAbilitata = abilitata;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public char getAbilitata() {
    return iAbilitata;
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    iAzienda.setKey(idAzienda);
    setDirty();
    setOnDB(false);
    iAssociazioneDocumenti.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * getAssociazioneDocumenti
   * @return List
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  @SuppressWarnings("rawtypes")
public List getAssociazioneDocumenti() {
    return getAssociazioneDocumentiInternal();
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    PsnDatiFirmaDigitalePO psnDatiFirmaDigitalePO = (PsnDatiFirmaDigitalePO)obj;
    iAssociazioneDocumenti.setEqual(psnDatiFirmaDigitalePO.iAssociazioneDocumenti);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  @SuppressWarnings("rawtypes")
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
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(key);
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    return getIdAzienda();
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * saveOwnedObjects
   * @param rc
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public int saveOwnedObjects(int rc) throws SQLException {
    rc = iAssociazioneDocumenti.save(rc);
    return rc;
  }

  /**
   * deleteOwnedObjects
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public int deleteOwnedObjects() throws SQLException {
    return getAssociazioneDocumentiInternal().delete();
  }

  /**
   * initializeOwnedObjects
   * @param result
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean initializeOwnedObjects(boolean result) {
    result = iAssociazioneDocumenti.initialize(result);
    return result;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
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
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return PsnDatiFirmaDigitaleTM.getInstance();
  }

  /**
   * getAssociazioneDocumentiInternal
   * @return OneToMany
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  protected OneToMany getAssociazioneDocumentiInternal() {
    if (iAssociazioneDocumenti.isNew())
        iAssociazioneDocumenti.retrieve();
    return iAssociazioneDocumenti;
  }

}

