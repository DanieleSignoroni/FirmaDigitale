<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/5.0.0/websrcsvil/dtd/xhtml1-transitional.dtd">
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
  BODataCollector InvioDocumentoDeviceBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm InvioDocumentoDeviceForm =  
     new com.thera.thermfw.web.WebForm(request, response, "InvioDocumentoDeviceForm", "InvioDocumentoDevice", null, "it.softre.thip.base.firmadigitale.web.InvioDocumentoDeviceFormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/firmadigitale/InvioDocumentoDevice.js"); 
  InvioDocumentoDeviceForm.setServletEnvironment(se); 
  InvioDocumentoDeviceForm.setJSTypeList(jsList); 
  InvioDocumentoDeviceForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  InvioDocumentoDeviceForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  InvioDocumentoDeviceForm.setWebFormModifierClass("it.softre.thip.base.firmadigitale.web.InvioDocumentoDeviceFormModifier"); 
  InvioDocumentoDeviceForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = InvioDocumentoDeviceForm.getMode(); 
  String key = InvioDocumentoDeviceForm.getKey(); 
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
        InvioDocumentoDeviceForm.outTraceInfo(getClass().getName()); 
        String collectorName = InvioDocumentoDeviceForm.findBODataCollectorName(); 
                InvioDocumentoDeviceBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (InvioDocumentoDeviceBODC instanceof WebDataCollector) 
            ((WebDataCollector)InvioDocumentoDeviceBODC).setServletEnvironment(se); 
        InvioDocumentoDeviceBODC.initialize("InvioDocumentoDevice", true, 0); 
        InvioDocumentoDeviceForm.setBODataCollector(InvioDocumentoDeviceBODC); 
        int rcBODC = InvioDocumentoDeviceForm.initSecurityServices(); 
        mode = InvioDocumentoDeviceForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           InvioDocumentoDeviceForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = InvioDocumentoDeviceBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              InvioDocumentoDeviceForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(InvioDocumentoDeviceForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=InvioDocumentoDeviceForm.getBodyOnBeforeUnload()%>" onload="<%=InvioDocumentoDeviceForm.getBodyOnLoad()%>" onunload="<%=InvioDocumentoDeviceForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   InvioDocumentoDeviceForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = InvioDocumentoDeviceForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", InvioDocumentoDeviceBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=InvioDocumentoDeviceForm.getServlet()%>" method="post" name="InvioDocumentoDeviceForm" style="height:100%"><%
  InvioDocumentoDeviceForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput InvioDocumentoDeviceIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("InvioDocumentoDevice", "IdAzienda"); 
  InvioDocumentoDeviceIdAzienda.setParent(InvioDocumentoDeviceForm); 
%>
<input class="<%=InvioDocumentoDeviceIdAzienda.getClassType()%>" id="<%=InvioDocumentoDeviceIdAzienda.getId()%>" maxlength="<%=InvioDocumentoDeviceIdAzienda.getMaxLength()%>" name="<%=InvioDocumentoDeviceIdAzienda.getName()%>" size="<%=InvioDocumentoDeviceIdAzienda.getSize()%>" type="hidden"><% 
  InvioDocumentoDeviceIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
                <table>
                  <tr style="display:none;">
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "InvioDocumentoDevice", "ClassName", null); 
   label.setParent(InvioDocumentoDeviceForm); 
%><label class="<%=label.getClassType()%>" for="ClassName"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput InvioDocumentoDeviceClassName =  
     new com.thera.thermfw.web.WebTextInput("InvioDocumentoDevice", "ClassName"); 
  InvioDocumentoDeviceClassName.setParent(InvioDocumentoDeviceForm); 
%>
<input class="<%=InvioDocumentoDeviceClassName.getClassType()%>" id="<%=InvioDocumentoDeviceClassName.getId()%>" maxlength="<%=InvioDocumentoDeviceClassName.getMaxLength()%>" name="<%=InvioDocumentoDeviceClassName.getName()%>" size="<%=InvioDocumentoDeviceClassName.getSize()%>"><% 
  InvioDocumentoDeviceClassName.write(out); 
%>

                    </td>
                     <td valign="top">
                      <% 
  WebTextInput InvioDocumentoDeviceChiaveSelezionato =  
     new com.thera.thermfw.web.WebTextInput("InvioDocumentoDevice", "ChiaveSelezionato"); 
  InvioDocumentoDeviceChiaveSelezionato.setParent(InvioDocumentoDeviceForm); 
%>
<input class="<%=InvioDocumentoDeviceChiaveSelezionato.getClassType()%>" id="<%=InvioDocumentoDeviceChiaveSelezionato.getId()%>" maxlength="<%=InvioDocumentoDeviceChiaveSelezionato.getMaxLength()%>" name="<%=InvioDocumentoDeviceChiaveSelezionato.getName()%>" size="<%=InvioDocumentoDeviceChiaveSelezionato.getSize()%>"><% 
  InvioDocumentoDeviceChiaveSelezionato.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "InvioDocumentoDevice", "IdDevice", null); 
   label.setParent(InvioDocumentoDeviceForm); 
%><label class="<%=label.getClassType()%>" for="Device"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm InvioDocumentoDeviceDevice =  
     new com.thera.thermfw.web.WebMultiSearchForm("InvioDocumentoDevice", "Device", false, false, true, 1, null, null); 
  InvioDocumentoDeviceDevice.setParent(InvioDocumentoDeviceForm); 
  InvioDocumentoDeviceDevice.write(out); 
%>
<!--<span class="multisearchform" id="Device"></span>-->
                    </td>
                  </tr>
                </table>
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(InvioDocumentoDeviceForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  InvioDocumentoDeviceForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = InvioDocumentoDeviceForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", InvioDocumentoDeviceBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              InvioDocumentoDeviceForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, InvioDocumentoDeviceBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, InvioDocumentoDeviceBODC.getErrorList().getErrors()); 
           if(InvioDocumentoDeviceBODC.getConflict() != null) 
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
     if(InvioDocumentoDeviceBODC != null && !InvioDocumentoDeviceBODC.close(false)) 
        errors.addAll(0, InvioDocumentoDeviceBODC.getErrorList().getErrors()); 
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
     String errorPage = InvioDocumentoDeviceForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", InvioDocumentoDeviceBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = InvioDocumentoDeviceForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
