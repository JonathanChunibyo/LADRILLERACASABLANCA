<%-- 
    Document   : index2
    Created on : 4/12/2020, 10:39:09 AM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <title>Ladrillera CasaBlanca</title>
    
    <link rel="icon" type="image/x-icon" href="img/ceramica.svg"/>

    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <link href="css/style1.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">
    
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
                                        <h1 class="h2 text-gray-900 mb-4">Registrar!</h1>
                                    </div>
                                    <form class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" name="email" aria-describedby="emailHelp" placeholder="Email" maxlength="50" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="contraseña" placeholder="Contraseña" maxlength="8" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" name="nombre" placeholder="Nombre" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" name="cargo" placeholder="Cargo" required>
                                        </div>
                                        <div class="form-group" class="dropdown-item">
                                            <select name="cargo" class="form-control">
                                                <option selected value="gerencia">Gerencia</option>
                                                <option selected value="supernumerario">Supernumerario</option>
                                                <option selected value="produccion">Producción</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control form-control-user" value="525" placeholder="Codigo de la Empresa" readonly required>
                                        </div>
                                        <hr>
                                        <a href="index.jsp" class="btn btn-primary btn-user btn-block">Registrar Cuenta</a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="index.jsp">Iniciar Sesión!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>   
        
        
        <!-- JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="js/sb-admin-2.min.js"></script>
</body>
</html>
