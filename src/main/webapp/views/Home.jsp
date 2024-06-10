<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomeCss.css">
</head>
<body>
	<%
		HttpSession sess = request.getSession();
	    User u = (User) session.getAttribute("user");
	%>
    <div class="banner">
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
            <h1>Welcome <%=u.getFullName() %></h1>
            <pre>Welcome to the ENSAM Tifinagh application
				The first Tifinagh translation platform in the world
            </pre>


            <div class="button-container">
                <a href="UploadAudioPage.jsp"><button type="button" class="btn">Translate an Audio</button></a>
                <a href="Historique.do"><button type="button" class="btn">History</button></a>
                <a href="Deconnecter.do"><button type="button" class="btn">Disconnect</button></a>
            </div>
        </div>
    </div>
</body>
</html>
