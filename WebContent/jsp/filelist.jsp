<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	File[] files = (File[])request.getAttribute("files");
	File parent = (File)request.getAttribute("file");
	File superParent = (parent.getParentFile()==null ? parent : parent.getParentFile());
%>
	<%=parent.getAbsolutePath() %><br>
	<a href="./FileListServlet?baseDir=<%=URLEncoder.encode(parent.getAbsolutePath(),"UTF-8")%>">.</a><br>
	<a href="./FileListServlet?baseDir=<%=URLEncoder.encode(superParent.getAbsolutePath(),"UTF-8")%>">..</a><br>
<%
	if(files != null){
		for(File file : files){
			if(file.isHidden()){
				continue;
			}
			if(file.isDirectory()){
%>
<a href="./FileListServlet?baseDir=<%=file.getAbsolutePath()%>"><%=file.getName()%><%=(file.isDirectory()?File.separator:"")%></a><br>
				<!-- <a href="./FileListServlet?baseDir=<%=URLEncoder.encode(file.getAbsolutePath(),"UTF-8")%>"><%=file.getName()%><%=(file.isDirectory()?File.separator:"")%></a><br>-->
<%
			}else{
%>
<a href="./FileReaderServlet?fileName=<%=file.getAbsolutePath()%>"><%=file.getName()%></a><br>
				<!-- <a href="./FileReaderServlet?fileName=<%=URLEncoder.encode(file.getAbsolutePath(),"UTF-8")%>"><%=file.getName()%></a><br>-->	
<%
			}
		}
	}
%>
</body>
</html>
