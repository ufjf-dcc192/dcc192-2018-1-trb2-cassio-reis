<%
    int participanteLogado = (int) request.getAttribute("participantecod");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amigo Sorteado</title>
        <%@include file ="../jspf/cabecalho.jspf"%>
    </head>
    <body>
    <div class="container">
        <h1>Seu amigo-secreto é:  </h1>
    </div>
    </body>
        <%@include file ="../jspf/rodape.jspf"%>
</html>