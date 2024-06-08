<%@page import="beans.Audio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Historique</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/HistoriqueCss.css">
</head>
<body>
    <div class="historique-banner">
        <header class="header">
            <div class="logo-container">
                <img id="ENSAM" src="${pageContext.request.contextPath}/images/ensam logo.jpg" alt="ENSAM Rabat Logo">
                <p>ENSAM TIFINAGH</p>
            </div>
            <div class="navbar">
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="Services.jsp">Services</a></li>
                    <li><a href="AboutUs.jsp">About Us</a></li>
                    <li><a href="ContactUs.jsp">Contact Us</a></li>
                </ul>
            </div>
        </header>
        <div class="content">
        	<%
        		List<Audio> AudioTif = (List<Audio>)request.getAttribute("AudioTifinagh");
        	%>
            <h1>Votre Historique</h1>
            <div class="table-container">
                <table class="audio-table">
                    <tbody>
                    <%
                    	for(Audio a : AudioTif){
                    %>
                        <tr>
                            <td class="audio-name"><%=a.getAudioName() %></td>
                            <td class="actions">
                                <a href="DisplayAudio.do?audioName=<%=a.getAudioName() %>"><button type="button" class="btn">Consulter</button></a>
                                <a href="DeleteAudio.do?audioId=<%=a.getAudioId() %>"><button type="button" class="btn">Supprimer</button></a>
                            </td>
                        </tr>
                     <%
                    	}
                     %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
