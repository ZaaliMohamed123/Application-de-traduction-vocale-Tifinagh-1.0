<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Services</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ServicesCss.css">
</head>
<body>
	<%
		HttpSession sess = request.getSession();
	    User u = (User) session.getAttribute("user");
	    String homePageLink = "" ;
	    if(u!=null){
	    	homePageLink = "Home.jsp";
	    }else{
	    	homePageLink = "index.html";
	    }
	%>
    <div class="banner">
        <header class="header">
            <div class="logo-container">
                <img id="ENSAM" src="${pageContext.request.contextPath}/images/ensam logo.jpg" alt="ENSAM Rabat Logo">
                <p>ENSAM TIFINAGH</p>
            </div>
            <div class="navbar">
                <ul>
                    <li><a href="<%=homePageLink %>">Home</a></li>
                    <li><a href="Services.jsp">Services</a></li>
                    <li><a href="AboutUs.jsp">About Us</a></li>
                    <li><a href="ContactUs.jsp">Contact Us</a></li>
                </ul>
            </div>
        </header>
        <div class="content">
            <h1>Our Services</h1>
            <div class="services-container">
                <div class="service">
                    <h2>Audio Translation</h2>
                    <p>We offer translation services for Tifinagh audio to English, French, and Arabic. Our service ensures accurate and efficient translations to help you understand and communicate in multiple languages.</p>
                </div>
                <div class="service">
                    <h2>Audio Database Management</h2>
                    <p>Store your Tifinagh audio files in our secure application database. Each user can upload and manage their own collection of audio files, making it easy to access and organize your translations.</p>
                </div>
            </div>
            <div class="button-container">
                <a href="LoginPage.html"><button type="button" class="btn">Login</button></a>
                <a href="SignUpPage.html"><button type="button" class="btn">Sign Up</button></a>
            </div>
        </div>
    </div>
</body>
</html>