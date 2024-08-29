<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="prenom" type="java.lang.String" scope="request"/>
<jsp:useBean id="nom" type="java.lang.String" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Affichage de mes variables</h1>

<h2>Bonjour ${prenom} ${nom}</h2>

</body>
</html>