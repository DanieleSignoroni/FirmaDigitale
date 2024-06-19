package it.softre.thip.vendite.documentoVE.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;
import com.thera.thermfw.web.servlet.GridActionAdapter;

import it.softre.thip.base.firmadigitale.InvioDocumentiUtils;
import it.softre.thip.base.firmadigitale.PsnDatiFirmaDigitale;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;
import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaGridActionAdapter;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 03/06/2024
 * <br><br>
 * <b>71XXX	DSSOF3	03/06/2024</b>
 * <p>Prima stesura.<br>
 *  
 * </p>
 */

public class YDocumentoVenditaGridActionAdapter extends DocumentoVenditaGridActionAdapter {

	private static final long serialVersionUID = 1L;

	protected static final String RES_PERS_SOFTRE = "it.softre.thip.base.firmadigitale.resources.DeviceInvioDocumenti";

	public static final String INVIA_DOCUMENTO_A_FIRMARE = "INVIO_DOCUMENTO_FIRMARE";

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton invioDocumento = new WebToolBarButton("InvioDocumentoFirma",
				"action_submit", "new", "no", RES_PERS_SOFTRE, "InvioDocumentoFirma",
				"it/softre/thip/base/firmadigitale/img/firma.png", INVIA_DOCUMENTO_A_FIRMARE, "single", false);
		toolBar.addButton(invioDocumento);
	}

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getAzione(se);
		if(azione.equals(INVIA_DOCUMENTO_A_FIRMARE)) {
			try {
				DocumentoVendita docVen = (DocumentoVendita) DocumentoVendita.elementWithKey(DocumentoVendita.class, 
						getStringParameter(se.getRequest(), OBJECT_KEY), PersistentObject.NO_LOCK);
				String className = getStringParameter(se.getRequest(), GridActionAdapter.CLASS_NAME);
				if(docVen != null 
						&& InvioDocumentiUtils.isDocumentoAbilitatoInvio(docVen) && PsnDatiFirmaDigitale.getCurrentPersDati().getAbilitata() == '1'
						/*&& InvioDocumentiUtils.documentoVenditaHasDocumentiDigitali(docVen, className)*/) {
					String thKey = getStringParameter(se.getRequest(), OBJECT_KEY);
					se.getRequest().setAttribute("ChiaveSelezionato", thKey);
					se.getRequest().setAttribute("ClassName", className);
					String jsp = "it/softre/thip/base/firmadigitale/InvioDocumentoDevice.jsp";
					se.sendRequest(getServletContext(),jsp+"?MODE=NEW&InitialActionAdapter=com.thera.thermfw.web.servlet.GridActionAdapter", false);
				}else {
					se.addErrorMessage(new ErrorMessage("BAS0000000"));
					se.sendRequest(getServletContext(), "com/thera/thermfw/common/InfoAreaHandler.jsp", false);
				}
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
			}
		}else {
			super.otherActions(cadc, se);
		}

	}
}
