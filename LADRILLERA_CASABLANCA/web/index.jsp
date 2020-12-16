<%-- 
    Document   : index
    Created on : 12/12/2020, 05:55:58 PM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">

        <title>Ladrillera CasaBlanca</title>

        <link rel="icon" type="image/x-icon" href="img/ceramica.svg"/>

        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="bg-gradient-primary">

        <br><br><br><br><br><br><br>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-10 col-lg-12 col-md-9">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h2 text-gray-900 mb-4">Ladrillera CasaBlanca</h1>
                                        </div>
                                        <form action="login" class="user">
                                            <div class="form-group">
                                                <input type="email" class="form-control form-control-user" name="email" placeholder="Email" maxlength="50" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" name="contrasenia" placeholder="Contraseña" maxlength="20" required>
                                            </div>
                                            <hr>
                                            <input type="submit" value="Iniciar Sesión" class="btn btn-primary btn-user btn-block">
                                            <!-- <a href="menu/dia.jsp" class="btn btn-primary btn-user btn-block">Iniciar Sesión</a> -->
                                        </form>
                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="./inicio/index2.jsp">Crear Cuenta!</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
