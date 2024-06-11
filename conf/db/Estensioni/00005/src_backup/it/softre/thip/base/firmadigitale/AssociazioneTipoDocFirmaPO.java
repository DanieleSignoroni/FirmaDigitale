/*
 * @(#)AssociazioneTipoDocFirmaPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 11/06/2024 at 11:28:43
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 11/06/2024    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.base.firmadigitale;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.base.documentoDgt.TipoDocumentoDigitale;
import java.math.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class AssociazioneTipoDocFirmaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

  
  /**
   *  instance
   */
  private static AssociazioneTipoDocFirma cInstance;

  /**
   * Attributo iTipoBolla
   */
  protected char iTipoBolla = '0';

  /**
   * Attributo iXPosition
   */
  protected BigDecimal iXPosition;

  /**
   * Attributo iYPosition
   */
  protected BigDecimal iYPosition;

  /**
   * Attributo iWidth
   */
  protected BigDecimal iWidth;

  /**
   * Attributo iHeight
   */
  protected BigDecimal iHeight;

  /**
   * Attributo iTipodocumento
   */
  protected Proxy iTipodocumento = new Proxy(it.thera.thip.base.documentoDgt.TipoDocumentoDigitale.class);

  /**
   * Attributo iParent
   */
  protected Proxy iParent = new Proxy(it.softre.thip.base.firmadigitale.PsnDatiFirmaDigitale.class);

  
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
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (AssociazioneTipoDocFirma)Factory.createObject(AssociazioneTipoDocFirma.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return AssociazioneTipoDocFirma
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static AssociazioneTipoDocFirma elementWithKey(String key, int lockType) throws SQLException {
    return (AssociazioneTipoDocFirma)PersistentObject.elementWithKey(AssociazioneTipoDocFirma.class, key, lockType);
  }

  /**
   * AssociazioneTipoDocFirmaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public AssociazioneTipoDocFirmaPO() {
    setTipoBolla('0');
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param tipoBolla
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setTipoBolla(char tipoBolla) {
    this.iTipoBolla = tipoBolla;
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
  public char getTipoBolla() {
    return iTipoBolla;
  }

  /**
   * Valorizza l'attributo. 
   * @param xPosition
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setXPosition(BigDecimal xPosition) {
    this.iXPosition = xPosition;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getXPosition() {
    return iXPosition;
  }

  /**
   * Valorizza l'attributo. 
   * @param yPosition
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setYPosition(BigDecimal yPosition) {
    this.iYPosition = yPosition;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getYPosition() {
    return iYPosition;
  }

  /**
   * Valorizza l'attributo. 
   * @param width
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setWidth(BigDecimal width) {
    this.iWidth = width;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getWidth() {
    return iWidth;
  }

  /**
   * Valorizza l'attributo. 
   * @param height
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setHeight(BigDecimal height) {
    this.iHeight = height;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getHeight() {
    return iHeight;
  }

  /**
   * Valorizza l'attributo. 
   * @param tipodocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setTipodocumento(TipoDocumentoDigitale tipodocumento) {
    String idAzienda = getIdAzienda();
    if (tipodocumento != null) {
      idAzienda = KeyHelper.getTokenObjectKey(tipodocumento.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iTipodocumento.setObject(tipodocumento);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return TipoDocumentoDigitale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public TipoDocumentoDigitale getTipodocumento() {
    return (TipoDocumentoDigitale)iTipodocumento.getObject();
  }

  /**
   * setTipodocumentoKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setTipodocumentoKey(String key) {
    iTipodocumento.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * getTipodocumentoKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getTipodocumentoKey() {
    return iTipodocumento.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idTipoDocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdTipoDocumento(String idTipoDocumento) {
    String key = iTipodocumento.getKey();
    iTipodocumento.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idTipoDocumento));
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
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdTipoDocumento() {
    String key = iTipodocumento.getKey();
    String objIdTipoDocumento = KeyHelper.getTokenObjectKey(key,2);
    return objIdTipoDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param parent
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setParent(PsnDatiFirmaDigitale parent) {
    setIdAziendaInternal(parent.getKey());
    this.iParent.setObject(parent);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return PsnDatiFirmaDigitale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public PsnDatiFirmaDigitale getParent() {
    return (PsnDatiFirmaDigitale)iParent.getObject();
  }

  /**
   * setParentKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setParentKey(String key) {
    iParent.setKey(key);
    setIdAziendaInternal(key);
    setDirty();
    setOnDB(false);
  }

  /**
   * getParentKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getParentKey() {
    return iParent.getKey();
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
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
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
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    AssociazioneTipoDocFirmaPO associazioneTipoDocFirmaPO = (AssociazioneTipoDocFirmaPO)obj;
    iTipodocumento.setEqual(associazioneTipoDocFirmaPO.iTipodocumento);
    iParent.setEqual(associazioneTipoDocFirmaPO.iParent);
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
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setIdTipoDocumento(KeyHelper.getTokenObjectKey(key, 2));
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
    String idAzienda = getIdAzienda();
    String idTipoDocumento = getIdTipoDocumento();
    Object[] keyParts = {idAzienda, idTipoDocumento};
    return KeyHelper.buildObjectKey(keyParts);
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
   * getFatherKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getFatherKey() {
    return getParentKey();
  }

  /**
   * setFatherKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setFatherKey(String key) {
    setParentKey(key);
  }

  /**
   * setFather
   * @param father
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setFather(PersistentObject father) {
    iParent.setObject(father);
  }

  /**
   * getOrderByClause
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getOrderByClause() {
    return "";
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
    return AssociazioneTipoDocFirmaTM.getInstance();
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 11/06/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iTipodocumento.getKey();
    iTipodocumento.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    iParent.setKey(idAzienda);
  }

}

