<%-- 
    Document   : liste
    Created on : 6 août 2019, 05:49:31
    Author     : khk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <div class="container spacer">
            <div class="panel panel-info">
                <div class="panel panel-heading">Liste des Services</div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Nom Service</th>
                            <th>Port Service</th>
                            <th>Etat Service</th>
                            <th>Identifiant Serveur</th>
                            <th>Nom Serveur</th>
                            <th>Adress Ip Serveur</th>
                        </tr>
                        <c:forEach items="${services}" var="service">
                            <tr>
                                <td>${service.idS}</td>
                                <td>${service.nomS}</td>
                                <td>${service.portS}</td>
                                <td>${service.etatS}</td>
                                <td>${service.serveur.idServ}</td>
                                <td>${service.serveur.nomServ}</td>
                                <td>${service.serveur.adripServ}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="Services?page=add" class="btn btn-primary">Ajout de Service</a>
                </div>
            </div>
        </div>
    </body>
</html>
