<%-- 
    Document   : resultados
    Created on : Sep 10, 2023, 9:01:44 PM
    Author     : guispiger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="permutacoes" class="java.lang.String" scope="session"/>
<jsp:useBean id="combinacoes" class="java.lang.String" scope="session"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
    </head>
    <body>
        <h1>Resultados</h1>
        Permutações: ${permutacoes} <br/>
        Combinações: ${combinacoes}
    </body>
</html>
