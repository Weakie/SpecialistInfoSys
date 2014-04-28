<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<script type="text/javascript">
function fileSelected() {
    var file = document.getElementById('fileToUpload').files[0];
    if (file) {
        var fileSize = 0;
        if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

        document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
        document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
        document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
    }
}

function uploadFile(username) {
    var fd = new FormData();
    fd.append("file", document.getElementById('fileToUpload').files[0]);
    var xhr = new XMLHttpRequest();
    xhr.upload.addEventListener("progress", uploadProgress, false);
    xhr.addEventListener("load", uploadComplete, false);
    xhr.addEventListener("error", uploadFailed, false);
    xhr.addEventListener("abort", uploadCanceled, false);
    xhr.open("POST", "/SpecialistInfoSys/uploadImage.action?username="+username);
    xhr.send(fd);
}

function uploadProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
    }
    else {
        document.getElementById('progressNumber').innerHTML = 'unable to compute';
    }
}

function uploadComplete(evt) {
    /* This event is raised when the server send back a response */
    alert(evt.target.responseText);
}

function uploadFailed(evt) {
    alert("There was an error attempting to upload the file.");
}

function uploadCanceled(evt) {
    alert("The upload has been canceled by the user or the browser dropped the connection.");
}
</script>
<body>
<h1>Welcome To Struts 2!</h1>
<p><a href="<s:url action='hello' />">Hello World</a></p>
<s:form action="upload" enctype="multipart/form-data" method="post">

 	   <s:textfield name="age"  label="Age"  />
 	   <s:textfield name="age"  label="Age"  />
 	  <s:file name="file"></s:file>
   	  <s:submit/>
   	
</s:form>	
  <s:form action="upload" enctype="multipart/form-data" method="post">
        <div class="row">
            <label for="file">
                Upload Image:</label>
            <input type="file" name="file" id="fileToUpload" onchange="fileSelected();" />
        </div>
        <div id="fileName">
        </div>
        <div id="fileSize">
        </div>
        <div id="fileType">
        </div> 
        <div class="row">
            <input type="button" onclick="uploadFile(123)" value="Upload Image" />
        </div>
        <div id="progressNumber">
        </div>
</s:form>	
</body>
</html>