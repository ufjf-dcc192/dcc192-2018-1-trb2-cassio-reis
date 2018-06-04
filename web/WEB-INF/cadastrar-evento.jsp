<%

    int participanteCod = Integer.parseInt( request.getParameter("participantecod"));

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Pedido</title>
        <%@include file ="jspf/cabecalho.jspf"%>
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
        <div class="container">
            <h1> Bem-vindo </h1>
            <h3>Cadastre seu evento </h3>
        </div>
        <div class="container">
            <form method="post">
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input name="nome" class="form-control" required>     
                </div>
              
                <div class="form-group">
                    <label for="usr">Data do Sorteio</label>
                    <input type="date" name="dataSorteio" class="form-control" required>     
                </div>

                <div class="form-group">
                    <label for="usr">Data do Evento</label>
                    <input type="date" name="dataEvento" class="form-control" required>     
                </div>
                
                 <div class="form-group">
                    <label for="usr">Senha do evento:</label>
                    <input type="password" name="senhaEvento" class="form-control" required>     
                </div>
                
                
                <input class="btn btn-primary btn" type ="Submit" /> 
                <input class="btn btn-primary btn" type ="Reset" /> 
            </form>
        </div>
    </body>
     
    <%@include file ="jspf/rodape.jspf"%>
   
</html>