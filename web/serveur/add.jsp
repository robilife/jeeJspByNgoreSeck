<%-- 
    Document   : add
    Created on : 6 août 2019, 05:49:03
    Author     : khk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container spacer col-lg-6 col-md-6 col-sm-12 col-xs-6 col-lg-offset-3 col-md-offset-3">
            <div class="panel panel-info">
                <div class="panel panel-heading">Formulaire d'Ajout des serveur</div>
                <div class="panel-body">
                    <form method="POST" action="Serveur">
                        <div class="form-group">
                            <label class="control-label">Nom du serveur</label>
                            <input class="form-control" type="text" name="nomserv" id="nomserv"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Adress ip du serveur</label>
                            <input class="form-control" type="text" name="adripserv" id="adripserv"/>
                        </div>
                        <div>
                            <input class="btn-success" type="submit" name="valider"  value="envoyer"/>
                            <input class="btn-warning" type="reset" name="annuler"  value="annuler"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
