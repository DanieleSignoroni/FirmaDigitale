package it.softre.thip.base.firmadigitale.web;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.web.WebFormModifier;

import it.softre.thip.base.firmadigitale.InvioDocumentoDevice;

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

public class InvioDocumentoDeviceFormModifier extends WebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormStartElements(JspWriter out) throws IOException {
		try {
			String chiaveSelezionato = (String) getRequest().getAttribute("ChiaveSelezionato");
			String className = (String) getRequest().getAttribute("ClassName");
			getBODataCollector().setOnBORecursive(); //aggiungere per caricare i valori presenti sui componenti settati da parte dell'MDV
			InvioDocumentoDevice bo = (InvioDocumentoDevice) getBODataCollector().getBo();
			bo.setChiaveSelezionato(chiaveSelezionato);
			bo.setClassName(className);
			getBODataCollector().setBo(bo);
			getBODataCollector().setOnBORecursive();
		} catch (Exception var9) {
			var9.printStackTrace(Trace.excStream);
		}
	}


	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {

	}

}
