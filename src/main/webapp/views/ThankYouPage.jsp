<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ThankYouCss.css">
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
            <h1>Thank you for contacting us!</h1>
            <p>We will get back to you as soon as possible.</p>
        </div>
    </div>
</body>
</html>
