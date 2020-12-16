<%-- 
    Document   : linea1
    Created on : 5/12/2020, 05:28:39 PM
    Author     : Jose
--%>

<%@page import="DAO.Usuario"%>
<%@page import="Negocio.graficaConsumo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="">
        <title>Ladrillera CasaBlanca</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/ceramica.svg" />

        <link href="${pageContext.request.contextPath}/css/style4.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <%
            graficaConsumo g = new graficaConsumo();
            String a = g.graficaDia("1");
            String b = g.graficaSemana("1");
            String c = g.graficaMes("1");

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            String datos = usuario.getNombre();
        %>

        <!-- JS -->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            <%=a%>
            <%=b%>
            <%=c%>
        </script>

        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css" >
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style3.css" type="text/css">
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
                    Graficas
                </div>


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>CONSUMO</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="conectarLinea1">
                                <span>Linea 1</span></a>
                            <a class="collapse-item" href="conectarLinea2">
                                <span>Linea 2</span></a>
                            <a class="collapse-item" href="conectarLinea3">
                                <span>Linea 3</span></a>
                            <a class="collapse-item" href="conectarLinea4">
                                <span>Linea 4</span></a>
                                                   
                            <!-- Barra -->
                            <hr class="sidebar-divider">

                            <a class="collapse-item" href="conectarConsumoTabla">
                                <span>Tablas</span></a>
                        </div>
                    </div>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <img src="${pageContext.request.contextPath}/img/ico9.png" alt="">
                        <span>PRODUCCION</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="conectarProduccion">
                                <span>Lineas</span></a>

                            <!-- Barra -->
                            <hr class="sidebar-divider">

                            <a class="collapse-item" href="conectarProduccionTabla">
                                <span>Tablas</span></a>
                        </div>
                    </div>
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
                        <h3>Datos Linea 1</h3>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=datos%></span>
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

                    <!-- Tablas -->
                    <div class="container-fluid">    
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Ultimo Dia</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <div id="chart_div" style="height: 300px"></div>
                                </div>
                            </div>
                        </div>

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Ultimos 7 Dias</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <div id="chart_div2" style="height: 300px"></div>
                                </div>
                            </div>
                        </div>

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Ultimos 30 Dias</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <div id="chart_div3" style="height: 300px"></div>
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
        
        <!-- JavaScript Tablas -->
        <script src="${pageContext.request.contextPath}/js/jsTablas.js"></script>
        <script src="${pageContext.request.contextPath}/js/jsTablas2.js"></script>
        <script src="${pageContext.request.contextPath}/js/jsTablas3.js"></script>

    </body>
</html>
