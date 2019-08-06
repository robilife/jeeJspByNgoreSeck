<%-- 
    Document   : liste
    Created on : 6 août 2019, 05:48:43
    Author     : khk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <div class="container spacer">
            <div class="panel panel-info">
                <div class="panel panel-heading">Liste des Serveurs</div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Nom Serveur</th>
                            <th>Adress IP Serveur</th>
                        </tr>
                        <c:forEach items="${serveurs}" var="serveur">
                            <tr>
                                <td>${serveur.idServ}</td>
                                <td>${serveur.nomServ}</td>
                                <td>${serveur.adripServ}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="Serveur?page=add" class="btn btn-primary">Ajout de Serveur</a>
                </div>
            </div>
        </div>
    </body>
</html>
