<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AboutUsCss.css">
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
            <h1>About Us</h1>
            <div class="team-container">
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/images/Mohamed pic.jpeg" alt="Mohamed Zaali">
                    <div class="member-info">
                        <h2>Mohamed Zaali</h2>
                        <p>first-year student studying Data Science, AI, and Digital Health Engineering.
                             My passion for technology has been ingrained in me since early childhood. 
                             Now, I am channeling that lifelong curiosity into crafting code, developing
                              algorithms for a better future. </p>
                        <div class="social-links">
                            <a href="https://www.linkedin.com/in/m-zaali/" target="_blank">LinkedIn</a>
                        </div>
                    </div>
                    
                </div>
                
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/images/bilalpic.jpeg" alt="Bilal Lahfari">
                    <div class="member-info">
                        <h2>Bilal Lahfari</h2>
                        <p>first-year Data Science and AI Engineering student at ENSAM Rabat. Passionate about bringing innovation to life by revealing insights from data. Let's connect and dive into the realm of data-driven possibilities!</p>
                        <div class="social-links">
                            <a href="https://www.linkedin.com/in/bilal-lahfari-107854290/" target="_blank">LinkedIn</a>
                        </div>
                    </div>
                    
                </div>
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/images/ayoubpic.jpeg" alt="Ayoub Khazaz">
                    <div class="member-info">
                        <h2>Ayoub Khazaz</h2>
                        <p>Computer Science student interested in AI and web technologies.</p>
                        <div class="social-links">
                            <a href="https://www.linkedin.com/in/ayoub-khezzaz-2a64a4291/" target="_blank">LinkedIn</a>
                        </div>
                    </div>
                </div>
                <div class="team-member">
                    <img src="${pageContext.request.contextPath}/images/douaa image.jpeg" alt="Douaa Sekal">
                    <div class="member-info">
                        <h2>Douaa Sekal</h2>
                        <p>Data Science, AI and Digital Health Engineering Student</p>
                        <div class="social-links">
                            <a href="https://www.linkedin.com/in/douaa-sekal/" target="_blank">LinkedIn</a>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>
