<%@ page import="Exercice_02.Chat" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

    <h1>Liste de chats</h1>

    <%List<Chat> chats = (List<Chat>) request.getAttribute("chats");
    if (chats == null || chats.isEmpty()) {%>
        <p>Aucun chat dans la liste</p>
    <%}else{%>
        <table>
            <tr><th>Nom</th><th>Race</th><th>Repas favoris</th><th>Date de naissance</th></tr>
            <%for(Chat chat : chats){%>
                <tr><td><%=chat.getNom()%></td><td><%=chat.getRace()%></td><td><%=chat.getRepasFavoris()%></td><td><%=chat.getNaissance()%></td></tr>
            <%}%>
        </table>
    <%}%>

    <form action="${pageContext.request.contextPath}/servlet" method="post">
        <ul>
            <li><label for="nom">Nom</label><input type="text" id="nom" name="nom"></li>
            <li><label for="race">Race</label><input type="text" id="race" name="race"></li>
            <li><label for="repasFavoris">Repas favoris</label><input type="text" id="repasFavoris" name="repasFavoris"></li>
            <li><label for="naissance">Date de naissance</label><input type="date" id="naissance" name="naissance"></li>
            <li><button type="submit">Ajouter</button></li>
        </ul>
    </form>

</body>
</html>