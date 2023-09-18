<%-- 
    Document   : index
    Created on : Sep 10, 2023, 3:56:18 PM
    Author     : guispiger
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="erro" class="java.lang.String" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questão 1</title>
    </head>
    <body>
        <h1>Questão 1</h1>
        <c:if test="${not empty erro}">
            <c:forEach items="${erro}" var="e">
                <span style="color: red; font-weight: bold">${e}</span>
            </c:forEach>
            
        </c:if>
        <form action="calcular" method="POST">
            Tamanho do Conjunto (N): <input type="text" name="N" size="3"><br/>
            Elementos a combinar (K): <input type="text" name="K" size="3"><br/>
            <input type="submit" value="Enviar"/>
        </form>
        <c:remove var="erro"></c:remove>
    </body>
</html>
