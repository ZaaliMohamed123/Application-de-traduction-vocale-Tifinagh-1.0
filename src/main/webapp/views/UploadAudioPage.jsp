<!DOCTYPE html>
<%@page import="beans.User"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Audio</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/UploadAudioPageStyleSheet.css">
</head>
<body>
	<%
	User u = (User)session.getAttribute("user");
	%>
    <div class="container">
        <div class="user">
            Welcome <%=u.getFullName() %>
        </div>
        <form action="Upload.do" method="post" enctype="multipart/form-data">
        	
            <label for="audioFile">Select Audio File:</label>
            <input type="file" id="audioFile" name="audioFile" accept="audio/*" required>
            
            <div class="language-selection">
                <label for="language">Select Language:</label>
                <select id="language" name="language">
                    <option value="Anglais">Anglais</option>
                    <option value="Français">Français</option>
                    <option value="Arabic">Arabe</option>
                </select>
            </div>
            
            <input type="submit" value="Upload Audio">
        </form>
    </div>
</body>
</html>
