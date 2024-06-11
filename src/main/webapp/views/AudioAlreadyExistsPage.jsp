<%@page import="java.util.List"%>
<%@page import="beans.Audio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tifinagh Audio Translation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ResultUploadAudioPageStyleSheet.css">
</head>
<body>
	<% 	
		Audio a0 = (Audio)request.getAttribute("AudioTifinagh");
		Audio a0tr = (Audio)request.getAttribute("AudioTranslated");
		String language = request.getAttribute("language").toString();
		
	%>
	<div class="container">
        <h1>Tifinagh Audio Translation</h1>
        <h2 style="text-align: center;">Audio Already Exists</h2><br>
        <div class="audio-section">
            <h2>Tifinagh <%=a0.getAudioName() %></h2>
            <audio controls>
                <source src="data:audio/<%= a0.getAudioExtension() %>;base64,<%= java.util.Base64.getEncoder().encodeToString(a0.getAudioContent()) %>" type="audio/<%= a0.getAudioExtension() %>">
                Your browser does not support the audio element.
            </audio>
        </div>
        <div class="translations">
            <div class="translation">
                <h3><%=language %> Translation</h3>
                <audio controls>
                    <source src="data:audio/<%= a0tr.getAudioExtension() %>;base64,<%= java.util.Base64.getEncoder().encodeToString(a0tr.getAudioContent()) %>" type="audio/<%= a0tr.getAudioExtension() %>">
                	Your browser does not support the audio element.
                </audio>
            </div>
        </div>
        <div class="button-container">
            <a href="Historique.do"><button type="button" class="btn">Go to Historique</button></a>
            <a href="Home.jsp"><button type="button" class="btn">Go to Home Page</button></a>
        </div>
    </div>
</body>
</html>