<%

    int participanteCod = (Integer) request.getAttribute("participantecod");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicial</title>
        <%@include file ="../jspf/cabecalho.jspf"%>

    </head>

    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><a href="cadastrar-evento.html?participantecod=<%=participanteCod%>">Cadastrar evento</a></li>
                    <li><a href="ver-eventos.html?participantecod=<%=participanteCod%>">Ver evento</a></li>
                    <li><a href="index.html">Sair</a></li>
                </ul>
            </div>
        </nav>
        <div class="container text-center">
            <div class="container-fluid">
                <h1 style="color:white">Erro de data</h1>
                <h3 style="color:gray">A data do evento deve ser posterior a data do sorteio</h3>
                <a href="cadastrar-evento.html?participantecod=<%=participanteCod%>" class="btn btn-danger btn-lg"> Cadastrar eventos </a>
                <a href="ver-eventos.html?participantecod=<%=participanteCod%>" class="btn btn-danger btn-lg"> Ver eventos </a>
            </div>
        </div>
        <footer style="color: #c1c1c3; text-align: center;"  class="footer navbar-fixed-bottom">
            <p> © 2018 Copyright:Cássio Reis</p>
        </footer>
    </body>
</html>