package it.softre.thip.acquisti.documentoAC.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;

import it.thera.thip.acquisti.documentoAC.web.DocumentoAcquistoGridActionAdapter;

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

public class YDocumentoAcquistoGridActionAdapter extends DocumentoAcquistoGridActionAdapter {

	private static final long serialVersionUID = 1L;

	protected static final String RES_PERS_SOFTRE = "it.softre.thip.base.firmadigitale.resources.DeviceInvioDocumenti";

	public static final String INVIA_DOCUMENTO_A_FIRMARE = "INVIO_DOCUMENTO_FIRMARE";

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton invioDocumento = new WebToolBarButton("InvioDocumentoFirma",
				"action_submit", "new", "infoArea", RES_PERS_SOFTRE, "InvioDocumentoFirma",
				"it/softre/thip/base/firmadigitale/img/firma.png", INVIA_DOCUMENTO_A_FIRMARE, "single", false);
		toolBar.addButton(invioDocumento);
	}

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getAzione(se);
		if(azione.equals(INVIA_DOCUMENTO_A_FIRMARE)) {

		}else {
			super.otherActions(cadc, se);
		}

	}
}
