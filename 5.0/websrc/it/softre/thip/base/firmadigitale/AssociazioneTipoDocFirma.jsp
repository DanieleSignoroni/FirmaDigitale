<!-- WIZGEN Therm 2.0.0 as Form riga interna - multiBrowserGen = true -->

<% 
  if(false) 
  { 
%> 
<head><% 
  } 
%> 

<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector AssociazioneTipoDocFirmaBODC = null; 
  WebFormForInternalRowForm AssociazioneTipoDocFirmaForm =  
     new com.thera.thermfw.web.WebFormForInternalRowForm(request, response, "AssociazioneTipoDocFirmaForm", "AssociazioneTipoDocFirma", "Arial,10", "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, false, false, true, true, null, 1); 
  int mode = AssociazioneTipoDocFirmaForm.getMode(); 
  String key = AssociazioneTipoDocFirmaForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        AssociazioneTipoDocFirmaForm.outTraceInfo(getClass().getName()); 
        ClassADCollection globCadc = AssociazioneTipoDocFirmaForm.getClassADCollection(); 
        requestIsValid = true; 
        AssociazioneTipoDocFirmaForm.write(out); 
        String collectorName = AssociazioneTipoDocFirmaForm.findBODataCollectorName(); 
				 AssociazioneTipoDocFirmaBODC = (BODataCollector)Factory.createObject(collectorName); 
        AssociazioneTipoDocFirmaBODC.initialize("AssociazioneTipoDocFirma", true, 1); 
        AssociazioneTipoDocFirmaForm.setBODataCollector(AssociazioneTipoDocFirmaBODC); 
        WebForm parentForm = (WebForm)request.getAttribute("parentForm"); 
        AssociazioneTipoDocFirmaForm.setJSTypeList(parentForm.getOwnerForm().getJSTypeList()); 
        AssociazioneTipoDocFirmaForm.setParent(parentForm); 
        AssociazioneTipoDocFirmaForm.writeHeadElements(out); 
     }
  }
  catch(NamingException e) { 
    errorMessage = e.getMessage(); 
  } 
  catch(SQLException e) { 
     errorMessage = e.getMessage(); 
  } 
  finally 
  { 
     try 
     { 
        se.end(); 
     } 
     catch(IllegalArgumentException e) { 
        e.printStackTrace(); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(); 
     } 
  } 
%> 

	<title>Associazione Documenti</title>
<% 
  if(false) 
  { 
%> 
</head><% 
  } 
%> 

<% 
  if(false) 
  { 
%> 
<body bottommargin="0" leftmargin="0" rightmargin="0" topmargin="0"><% 
  } 
%> 
<%
   AssociazioneTipoDocFirmaForm.writeBodyStartElements(out); 
%> 

<% 
  if(false) 
  { 
%> 
<form action="submit" name="AssociazioneTipoDocFirmaForm"><% 
  } 
%> 
<%
   AssociazioneTipoDocFirmaForm.writeFormStartElements(out); 
%> 

<table cellpadding="2" cellspacing="0" height="100%" id="emptyborder" width="100%">
  <tr>
    <td>
          <table border="0" style="margin: 2 5 5 5;">
		  	<tr>
		      <td><% 
  WebTextInput AssociazioneTipoDocFirmaIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("AssociazioneTipoDocFirma", "IdAzienda"); 
  AssociazioneTipoDocFirmaIdAzienda.setParent(AssociazioneTipoDocFirmaForm); 
%>
<input class="<%=AssociazioneTipoDocFirmaIdAzienda.getClassType()%>" id="<%=AssociazioneTipoDocFirmaIdAzienda.getId()%>" maxlength="<%=AssociazioneTipoDocFirmaIdAzienda.getMaxLength()%>" name="<%=AssociazioneTipoDocFirmaIdAzienda.getName()%>" size="<%=AssociazioneTipoDocFirmaIdAzienda.getSize()%>" style="display:none" type="text"><% 
  AssociazioneTipoDocFirmaIdAzienda.write(out); 
%>
</td>
			</tr>
			<tr>
			  <td><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "IdTipoDocumento", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="TipoDocumento"><%label.write(out);%></label><%}%></td>
		      <td><% 
  WebMultiSearchForm AssociazioneTipoDocFirmaTipoDocumento =  
     new com.thera.thermfw.web.WebMultiSearchForm("AssociazioneTipoDocFirma", "TipoDocumento", false, false, true, 1, null, null); 
  AssociazioneTipoDocFirmaTipoDocumento.setParent(AssociazioneTipoDocFirmaForm); 
  AssociazioneTipoDocFirmaTipoDocumento.write(out); 
%>
<!--<span class="multisearchform" id="TipoDocumento" name="TipoDocumento"></span>--></td>
		       <td valign="top">
                                  <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "TipoDocVen", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="TipoDocVen"><%label.write(out);%></label><%}%>
                                </td>
                                <td valign="top">
                                  <% 
  WebComboBox AssociazioneTipoDocFirmaTipoDocVen =  
     new com.thera.thermfw.web.WebComboBox("AssociazioneTipoDocFirma", "TipoDocVen", null); 
  AssociazioneTipoDocFirmaTipoDocVen.setParent(AssociazioneTipoDocFirmaForm); 
%>
<select id="<%=AssociazioneTipoDocFirmaTipoDocVen.getId()%>" name="<%=AssociazioneTipoDocFirmaTipoDocVen.getName()%>"><% 
  AssociazioneTipoDocFirmaTipoDocVen.write(out); 
%> 
</select>
                                </td>
                                   <td valign="top">
                                  <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "TipoDocAcq", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="TipoDocAcq"><%label.write(out);%></label><%}%>
                                </td>
                                <td valign="top">
                                  <% 
  WebComboBox AssociazioneTipoDocFirmaTipoDocAcq =  
     new com.thera.thermfw.web.WebComboBox("AssociazioneTipoDocFirma", "TipoDocAcq", null); 
  AssociazioneTipoDocFirmaTipoDocAcq.setParent(AssociazioneTipoDocFirmaForm); 
%>
<select id="<%=AssociazioneTipoDocFirmaTipoDocAcq.getId()%>" name="<%=AssociazioneTipoDocFirmaTipoDocAcq.getName()%>"><% 
  AssociazioneTipoDocFirmaTipoDocAcq.write(out); 
%> 
</select>
                                </td>
			</tr>
			<tr>
			  <td><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "XPosition", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="XPosition"><%label.write(out);%></label><%}%></td>
		      <td><% 
  WebTextInput AssociazioneTipoDocFirmaXPosition =  
     new com.thera.thermfw.web.WebTextInput("AssociazioneTipoDocFirma", "XPosition"); 
  AssociazioneTipoDocFirmaXPosition.setParent(AssociazioneTipoDocFirmaForm); 
%>
<input class="<%=AssociazioneTipoDocFirmaXPosition.getClassType()%>" id="<%=AssociazioneTipoDocFirmaXPosition.getId()%>" maxlength="<%=AssociazioneTipoDocFirmaXPosition.getMaxLength()%>" name="<%=AssociazioneTipoDocFirmaXPosition.getName()%>" size="<%=AssociazioneTipoDocFirmaXPosition.getSize()%>" type="text"><% 
  AssociazioneTipoDocFirmaXPosition.write(out); 
%>
</td>
		      
		      <td><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "YPosition", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="YPosition"><%label.write(out);%></label><%}%></td>
		      <td><% 
  WebTextInput AssociazioneTipoDocFirmaYPosition =  
     new com.thera.thermfw.web.WebTextInput("AssociazioneTipoDocFirma", "YPosition"); 
  AssociazioneTipoDocFirmaYPosition.setParent(AssociazioneTipoDocFirmaForm); 
%>
<input class="<%=AssociazioneTipoDocFirmaYPosition.getClassType()%>" id="<%=AssociazioneTipoDocFirmaYPosition.getId()%>" maxlength="<%=AssociazioneTipoDocFirmaYPosition.getMaxLength()%>" name="<%=AssociazioneTipoDocFirmaYPosition.getName()%>" size="<%=AssociazioneTipoDocFirmaYPosition.getSize()%>" type="text"><% 
  AssociazioneTipoDocFirmaYPosition.write(out); 
%>
</td>
			</tr>
			<tr>
			  <td><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "Width", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="Width"><%label.write(out);%></label><%}%></td>
		      <td><% 
  WebTextInput AssociazioneTipoDocFirmaWidth =  
     new com.thera.thermfw.web.WebTextInput("AssociazioneTipoDocFirma", "Width"); 
  AssociazioneTipoDocFirmaWidth.setParent(AssociazioneTipoDocFirmaForm); 
%>
<input class="<%=AssociazioneTipoDocFirmaWidth.getClassType()%>" id="<%=AssociazioneTipoDocFirmaWidth.getId()%>" maxlength="<%=AssociazioneTipoDocFirmaWidth.getMaxLength()%>" name="<%=AssociazioneTipoDocFirmaWidth.getName()%>" size="<%=AssociazioneTipoDocFirmaWidth.getSize()%>" type="text"><% 
  AssociazioneTipoDocFirmaWidth.write(out); 
%>
</td>
		      
		      <td><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "AssociazioneTipoDocFirma", "Height", null); 
   label.setParent(AssociazioneTipoDocFirmaForm); 
%><label class="<%=label.getClassType()%>" for="Height"><%label.write(out);%></label><%}%></td>
		      <td><% 
  WebTextInput AssociazioneTipoDocFirmaHeight =  
     new com.thera.thermfw.web.WebTextInput("AssociazioneTipoDocFirma", "Height"); 
  AssociazioneTipoDocFirmaHeight.setParent(AssociazioneTipoDocFirmaForm); 
%>
<input class="<%=AssociazioneTipoDocFirmaHeight.getClassType()%>" id="<%=AssociazioneTipoDocFirmaHeight.getId()%>" maxlength="<%=AssociazioneTipoDocFirmaHeight.getMaxLength()%>" name="<%=AssociazioneTipoDocFirmaHeight.getName()%>" size="<%=AssociazioneTipoDocFirmaHeight.getSize()%>" type="text"><% 
  AssociazioneTipoDocFirmaHeight.write(out); 
%>
</td>
			</tr>
	      </table>
    </td>
  </tr>
</table>
<%
  AssociazioneTipoDocFirmaForm.writeFormEndElements(out); 
%>
<% 
  if(false) 
  { 
%> 
</form><% 
  } 
%> 

<%
   AssociazioneTipoDocFirmaForm.writeBodyEndElements(out); 
%> 
<% 
  if(false) 
  { 
%> 
</body><% 
  } 
%> 

