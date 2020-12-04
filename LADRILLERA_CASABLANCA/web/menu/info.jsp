<%-- 
    Document   : info
    Created on : 2/12/2020, 03:22:03 PM
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="author" content="">
    <title>Ladrillera CasaBlanca</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/ceramica.svg" />
    
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    
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
                Datos
            </div>
            <li class="nav-item active">
                <a class="nav-link" href="dia.jsp">
                    <img src="${pageContext.request.contextPath}/img/ico5.png" alt="">
                    <span>Dia</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="semana.jsp">
                    <img src="${pageContext.request.contextPath}/img/ico5.png" alt="">
                    <span>Semana</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="mes.jsp">
                    <img src="${pageContext.request.contextPath}/img/ico5.png" alt="">
                    <span>Mes</span></a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="alertas.jsp">
                    <img src="${pageContext.request.contextPath}/img/ico3.png" alt="">
                    <span>Alertas</span></a>
            </li>

            <!-- Barra -->
            <hr class="sidebar-divider">

            <!-- Menu de archivos -->
            <div class="sidebar-heading">
                Archivos
            </div>
            <li class="nav-item active">
                <a class="nav-link" href="excel.jsp">
                    <img src="${pageContext.request.contextPath}/img/ico4.png" alt="">
                    <span>Excel</span></a>
            </li>
            
            <!-- Barra -->
            <hr class="sidebar-divider">

            <!-- Menu de info -->
            <div class="sidebar-heading">
                Info
            </div>
            <li class="nav-item active">
                <a class="nav-link" href="info.jsp">
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
                    <h3>Información</h3>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Usuario</span>
                                <img class="img-profile rounded-circle" src="${pageContext.request.contextPath}/img/usuario.svg">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp" >
                                    Cerrar Sesión
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                
                <!-- Info -->
                <div class="container-fluid">
                    <div class="row">
                        
                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <center><h3 class="m-0 font-weight-bold text-primary">UFPS</h3></center>
                                </div>
                                <div class="card-body">
                                    <center><img src="${pageContext.request.contextPath}/img/info3.png" height="250px"></center>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <center><h3 class="m-0 font-weight-bold text-primary">AπNGHOST</h3></center>
                                </div>
                                <div class="card-body">
                                    <center><img src="${pageContext.request.contextPath}/img/info.gif" height="250px"></center>
                                </div>
                            </div>

                        </div>

                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <center><h3 class="m-0 font-weight-bold text-primary">Bootstrap</h3></center>
                                </div>
                                <div class="card-body">
                                    <center><img src="${pageContext.request.contextPath}/img/info2.png" height="250px"></center>
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
