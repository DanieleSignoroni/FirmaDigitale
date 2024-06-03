package it.softre.thip.base.firmadigitale.web;

import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;
import com.thera.thermfw.web.servlet.FormActionAdapter;

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

public class InvioDocumentoDeviceFormActionAdapter extends FormActionAdapter {

	private static final long serialVersionUID = 1L;

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton save = (WebToolBarButton) toolBar.getButtons().get(1);
		toolBar.getButtons().clear();
		toolBar.addButton(save);
	}
}
