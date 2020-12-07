<%-- 
    Document   : datosUsuario
    Created on : 6/12/2020, 06:02:01 PM
    Author     : Jose
--%>

<%@page import="DAO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="">
        <title>Ladrillera CasaBlanca</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/ceramica.svg" />

        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <%
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            String email = usuario.getEmail();
            String contra = usuario.getContra();
            String nombre = usuario.getNombre();
            String cargo = usuario.getCargo();
            String tipo = usuario.getTipo(); 
        %>

        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/css/style2.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style3.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <div id="wrapper">
            <!-- Logo y Menu -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="">
                    <div class="sidebar-brand-icon">
                        <img src="${pageContext.request.contextPath}/img/ico1.png" alt="">
                    </div>
                    <div class="sidebar-brand-text mx-3">Shin Impact</div>
                </a>

                <!-- Barra -->
                <hr class="sidebar-divider">

                <!-- Menu de tablas -->
                <div class="sidebar-heading">
                    CONSUMO
                </div>

                <li class="nav-item active">
                    <a class="nav-link" href="conectarLinea1">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>Linea 1</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="conectarLinea2">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>Linea 2</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="conectarLinea3">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>Linea 3</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="conectarLinea4">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>Linea 4</span></a>
                </li>

                <!-- Barra -->
                <hr class="sidebar-divider">

                <!-- Menu de tablas -->
                <div class="sidebar-heading">
                    PRODUCCIÓN
                </div>
                <li class="nav-item active">
                    <a class="nav-link" href="">
                        <img src="${pageContext.request.contextPath}/img/ico8.png" alt="">
                        <span>Lineas</span></a>
                </li>

                <!-- Barra -->
                <hr class="sidebar-divider">

                <!-- Menu de archivos -->
                <div class="sidebar-heading">
                    Archivos
                </div>
                <li class="nav-item active">
                    <a class="nav-link" href="conectarExcel">
                        <img src="${pageContext.request.contextPath}/img/ico4.png" alt="">
                        <span>Excel</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="conectarAlertas">
                        <img src="${pageContext.request.contextPath}/img/ico3.png" alt="">
                        <span>Alertas</span></a>
                </li>

                <!-- Barra -->
                <hr class="sidebar-divider">

                <!-- Menu de info -->
                <div class="sidebar-heading">
                    Info
                </div>
                <li class="nav-item active">
                    <a class="nav-link" href="conectarInfo">
                        <img src="${pageContext.request.contextPath}/img/ico2.png" alt="">
                        <span>Creadores</span></a>
                </li>

                <!-- Barra -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Boton -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"><img src="${pageContext.request.contextPath}/img/ico6.png" alt=""></button>
                </div>
            </ul>

            <!-- Contenido -->
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">

                    <!-- Barra y Perfil -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <h3>Datos del Usuario</h3>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=nombre%></span>
                                    <img class="img-profile rounded-circle" src="${pageContext.request.contextPath}/img/usuario.svg">
                                </a>
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="conectarDatosUsuario" >
                                        Usuario
                                    </a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp" >
                                        Cerrar Sesión
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </nav>

                    <!-- Datos Usuario -->
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card position-relative">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Datos de Usuario</h6>
                                    </div>
                                    <div class="card-body">
                                        <form class="user">
                                            <div class="form-group">
                                                <input type="email" value="<%=email%>" class="form-control form-control-user" name="email" aria-describedby="emailHelp" placeholder="Email" maxlength="50" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" value="<%=contra%>" class="form-control form-control-user" name="contrasenia" placeholder="Contraseña" maxlength="8" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" value="<%=nombre%>" class="form-control form-control-user" name="nombre" placeholder="Nombre" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" value="<%=cargo%>" class="form-control form-control-user" name="cargo" placeholder="Cargo" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" value="<%=tipo%>" class="form-control form-control-user" name="tipo" placeholder="Tipo" readonly required>
                                            </div>
                                            <div class="form-group">
                                                <input type="number" class="form-control form-control-user" value="525" placeholder="Codigo de la Empresa" readonly required>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>

                            <!-- Modificar Usuario -->
                            <div class="col-lg-6">
                                <div class="card position-relative">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Cambiar Datos</h6>
                                    </div>
                                    <div class="card-body">
                                        <form action="modificar" class="user">
                                            <div class="form-group">
                                                <input type="email" class="form-control form-control-user" name="datoEmail" aria-describedby="emailHelp" placeholder="Email" maxlength="50" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" name="datoContra" placeholder="Contraseña" maxlength="8" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user" name="datoNombre" placeholder="Nombre" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user" name="datoCargo" placeholder="Cargo" required>
                                            </div>
                                            <hr>
                                            <input type="submit" value="Modificar Datos" class="btn btn-primary btn-user btn-block">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap JavaScript-->
        <script src="${pageContext.request.contextPath}/js/js1.js"></script>
        <script src="${pageContext.request.contextPath}/js/js2.js"></script>
        <script src="${pageContext.request.contextPath}/js/js3.js"></script>

        <!-- JavaScript -->
        <script src="${pageContext.request.contextPath}/js/js4.js"></script>
        <script src="${pageContext.request.contextPath}/js/js5.js"></script>
        <script src="${pageContext.request.contextPath}/js/js6.js"></script>
        <script src="${pageContext.request.contextPath}/js/js7.js"></script>
    </body>
</html>
