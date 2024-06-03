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
  BODataCollector DocumentiAttesaFirmaBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm DocumentiAttesaFirmaForm =  
     new com.thera.thermfw.web.WebForm(request, response, "DocumentiAttesaFirmaForm", "DocumentiAttesaFirma", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/firmadigitale/DocumentiAttesaFirma.js"); 
  DocumentiAttesaFirmaForm.setServletEnvironment(se); 
  DocumentiAttesaFirmaForm.setJSTypeList(jsList); 
  DocumentiAttesaFirmaForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  DocumentiAttesaFirmaForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  DocumentiAttesaFirmaForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = DocumentiAttesaFirmaForm.getMode(); 
  String key = DocumentiAttesaFirmaForm.getKey(); 
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
        DocumentiAttesaFirmaForm.outTraceInfo(getClass().getName()); 
        String collectorName = DocumentiAttesaFirmaForm.findBODataCollectorName(); 
                DocumentiAttesaFirmaBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (DocumentiAttesaFirmaBODC instanceof WebDataCollector) 
            ((WebDataCollector)DocumentiAttesaFirmaBODC).setServletEnvironment(se); 
        DocumentiAttesaFirmaBODC.initialize("DocumentiAttesaFirma", true, 0); 
        DocumentiAttesaFirmaForm.setBODataCollector(DocumentiAttesaFirmaBODC); 
        int rcBODC = DocumentiAttesaFirmaForm.initSecurityServices(); 
        mode = DocumentiAttesaFirmaForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           DocumentiAttesaFirmaForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = DocumentiAttesaFirmaBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              DocumentiAttesaFirmaForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(DocumentiAttesaFirmaForm); 
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
  myToolBarTB.setParent(DocumentiAttesaFirmaForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=DocumentiAttesaFirmaForm.getBodyOnBeforeUnload()%>" onload="<%=DocumentiAttesaFirmaForm.getBodyOnLoad()%>" onunload="<%=DocumentiAttesaFirmaForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   DocumentiAttesaFirmaForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = DocumentiAttesaFirmaForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", DocumentiAttesaFirmaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=DocumentiAttesaFirmaForm.getServlet()%>" method="post" name="DocumentiAttesaFirmaForm" style="height:100%"><%
  DocumentiAttesaFirmaForm.writeFormStartElements(out); 
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
  WebTextInput DocumentiAttesaFirmaIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("DocumentiAttesaFirma", "IdAzienda"); 
  DocumentiAttesaFirmaIdAzienda.setParent(DocumentiAttesaFirmaForm); 
%>
<input class="<%=DocumentiAttesaFirmaIdAzienda.getClassType()%>" id="<%=DocumentiAttesaFirmaIdAzienda.getId()%>" maxlength="<%=DocumentiAttesaFirmaIdAzienda.getMaxLength()%>" name="<%=DocumentiAttesaFirmaIdAzienda.getName()%>" size="<%=DocumentiAttesaFirmaIdAzienda.getSize()%>" type="hidden"><% 
  DocumentiAttesaFirmaIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput DocumentiAttesaFirmaId =  
     new com.thera.thermfw.web.WebTextInput("DocumentiAttesaFirma", "Id"); 
  DocumentiAttesaFirmaId.setParent(DocumentiAttesaFirmaForm); 
%>
<input class="<%=DocumentiAttesaFirmaId.getClassType()%>" id="<%=DocumentiAttesaFirmaId.getId()%>" maxlength="<%=DocumentiAttesaFirmaId.getMaxLength()%>" name="<%=DocumentiAttesaFirmaId.getName()%>" size="<%=DocumentiAttesaFirmaId.getSize()%>" type="hidden"><% 
  DocumentiAttesaFirmaId.write(out); 
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
  mytabbed.setParent(DocumentiAttesaFirmaForm); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
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
  errorList.setParent(DocumentiAttesaFirmaForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  DocumentiAttesaFirmaForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = DocumentiAttesaFirmaForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", DocumentiAttesaFirmaBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              DocumentiAttesaFirmaForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, DocumentiAttesaFirmaBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, DocumentiAttesaFirmaBODC.getErrorList().getErrors()); 
           if(DocumentiAttesaFirmaBODC.getConflict() != null) 
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
     if(DocumentiAttesaFirmaBODC != null && !DocumentiAttesaFirmaBODC.close(false)) 
        errors.addAll(0, DocumentiAttesaFirmaBODC.getErrorList().getErrors()); 
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
     String errorPage = DocumentiAttesaFirmaForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", DocumentiAttesaFirmaBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = DocumentiAttesaFirmaForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
