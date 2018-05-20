
<%
    
    int participanteCod = (Integer) request.getAttribute("participantecod");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicial</title>
        <%@include file ="jspf/cabecalho.jspf"%>
    </head>

    <body style="background-color:black;">
        
        <div class="container text-center">
            <div class="container-fluid">
                <h1 style="color:white">AMigoculto dos amigos</h1>
                <img src="http://www.theatrocentral.com.br/wp-content/uploads/2016/07/logo_ufjf_v7.png" alt="Logo">
                <h3 style="color:gray">Laboratório de Desenvolvimento JavaWeb</h3>
                <a href="cadastrar-evento.html?participantecod=<%=participanteCod%>" class="btn btn-danger btn-lg"> Cadastrar eventos </a>
                <a href="ver-eventos.html?participantecod=<%=participanteCod%>" class="btn btn-danger btn-lg"> Ver eventos </a>
            </div>
        </div>
             <footer style="color: #c1c1c3; text-align: center;"  class="footer navbar-fixed-bottom">
            <p> © 2018 Copyright:Cássio Reis</p>
        </footer>
    </body>
</html>