<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello World!</title>
  </head>
 
  <body>
  <img src="${url}"/>
  <p>Your registration information: <s:property value="personBean" /> </p>
    <h2><s:property value="messageStore.message" /></h2>
     <s:textfield name="personBean.firstName" />
  </body>
</html>