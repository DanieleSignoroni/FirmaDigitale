<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\FirmaDigitale\WebContent\dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>
  <head>
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
  BODataCollector DeviceInvioDocumentiBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm DeviceInvioDocumentiForm =  
     new com.thera.thermfw.web.WebForm(request, response, "DeviceInvioDocumentiForm", "DeviceInvioDocumenti", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/firmadigitale/DeviceInvioDocumenti.js"); 
  DeviceInvioDocumentiForm.setServletEnvironment(se); 
  DeviceInvioDocumentiForm.setJSTypeList(jsList); 
  DeviceInvioDocumentiForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  DeviceInvioDocumentiForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  DeviceInvioDocumentiForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = DeviceInvioDocumentiForm.getMode(); 
  String key = DeviceInvioDocumentiForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        DeviceInvioDocumentiForm.outTraceInfo(getClass().getName()); 
        String collectorName = DeviceInvioDocumentiForm.findBODataCollectorName(); 
                DeviceInvioDocumentiBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (DeviceInvioDocumentiBODC instanceof WebDataCollector) 
            ((WebDataCollector)DeviceInvioDocumentiBODC).setServletEnvironment(se); 
        DeviceInvioDocumentiBODC.initialize("DeviceInvioDocumenti", true, 0); 
        DeviceInvioDocumentiForm.setBODataCollector(DeviceInvioDocumentiBODC); 
        int rcBODC = DeviceInvioDocumentiForm.initSecurityServices(); 
        mode = DeviceInvioDocumentiForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           DeviceInvioDocumentiForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = DeviceInvioDocumentiBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              DeviceInvioDocumentiForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(DeviceInvioDocumentiForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(DeviceInvioDocumentiForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=DeviceInvioDocumentiForm.getBodyOnBeforeUnload()%>" onload="<%=DeviceInvioDocumentiForm.getBodyOnLoad()%>" onunload="<%=DeviceInvioDocumentiForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   DeviceInvioDocumentiForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = DeviceInvioDocumentiForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", DeviceInvioDocumentiBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=DeviceInvioDocumentiForm.getServlet()%>" method="post" name="DeviceInvioDocumentiForm" style="height:100%"><%
  DeviceInvioDocumentiForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput DeviceInvioDocumentiIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("DeviceInvioDocumenti", "IdAzienda"); 
  DeviceInvioDocumentiIdAzienda.setParent(DeviceInvioDocumentiForm); 
%>
<input class="<%=DeviceInvioDocumentiIdAzienda.getClassType()%>" id="<%=DeviceInvioDocumentiIdAzienda.getId()%>" maxlength="<%=DeviceInvioDocumentiIdAzienda.getMaxLength()%>" name="<%=DeviceInvioDocumentiIdAzienda.getName()%>" size="<%=DeviceInvioDocumentiIdAzienda.getSize()%>" type="hidden"><% 
  DeviceInvioDocumentiIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(DeviceInvioDocumentiForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.firmadigitale.resources.DeviceInvioDocumenti", "tab1", "DeviceInvioDocumenti", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "DeviceInvioDocumenti", "NomeDevice", null); 
   label.setParent(DeviceInvioDocumentiForm); 
%><label class="<%=label.getClassType()%>" for="NomeDevice"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput DeviceInvioDocumentiNomeDevice =  
     new com.thera.thermfw.web.WebTextInput("DeviceInvioDocumenti", "NomeDevice"); 
  DeviceInvioDocumentiNomeDevice.setParent(DeviceInvioDocumentiForm); 
%>
<input class="<%=DeviceInvioDocumentiNomeDevice.getClassType()%>" id="<%=DeviceInvioDocumentiNomeDevice.getId()%>" maxlength="<%=DeviceInvioDocumentiNomeDevice.getMaxLength()%>" name="<%=DeviceInvioDocumentiNomeDevice.getName()%>" size="<%=DeviceInvioDocumentiNomeDevice.getSize()%>"><% 
  DeviceInvioDocumentiNomeDevice.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "DeviceInvioDocumenti", "Descrizione", null); 
   label.setParent(DeviceInvioDocumentiForm); 
%><label class="<%=label.getClassType()%>" for="Descrizione"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput DeviceInvioDocumentiDescrizione =  
     new com.thera.thermfw.web.WebTextArea("DeviceInvioDocumenti", "Descrizione"); 
  DeviceInvioDocumentiDescrizione.setParent(DeviceInvioDocumentiForm); 
%>
<textarea class="<%=DeviceInvioDocumentiDescrizione.getClassType()%>" cols="60" id="<%=DeviceInvioDocumentiDescrizione.getId()%>" maxlength="<%=DeviceInvioDocumentiDescrizione.getMaxLength()%>" name="<%=DeviceInvioDocumentiDescrizione.getName()%>" rows="5" size="<%=DeviceInvioDocumentiDescrizione.getSize()%>"></textarea><% 
  DeviceInvioDocumentiDescrizione.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                    </td>
                    <td valign="top">
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "DeviceInvioDocumenti", "IdStampante", null); 
   label.setParent(DeviceInvioDocumentiForm); 
%><label class="<%=label.getClassType()%>" for="Stampante"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm DeviceInvioDocumentiStampante =  
     new com.thera.thermfw.web.WebMultiSearchForm("DeviceInvioDocumenti", "Stampante", false, false, true, 1, null, null); 
  DeviceInvioDocumentiStampante.setParent(DeviceInvioDocumentiForm); 
  DeviceInvioDocumentiStampante.write(out); 
%>
<!--<span class="multisearchform" id="Stampante"></span>-->
                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(DeviceInvioDocumentiForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  DeviceInvioDocumentiForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = DeviceInvioDocumentiForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", DeviceInvioDocumentiBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              DeviceInvioDocumentiForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, DeviceInvioDocumentiBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, DeviceInvioDocumentiBODC.getErrorList().getErrors()); 
           if(DeviceInvioDocumentiBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(DeviceInvioDocumentiBODC != null && !DeviceInvioDocumentiBODC.close(false)) 
        errors.addAll(0, DeviceInvioDocumentiBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = DeviceInvioDocumentiForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", DeviceInvioDocumentiBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = DeviceInvioDocumentiForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
