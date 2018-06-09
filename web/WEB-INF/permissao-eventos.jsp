<%@page import="trabalho.ufjf.dcc192.Evento"%>
<%@page import="trabalho.ufjf.dcc192.Participante"%>
<%
    Participante participante = (Participante) request.getAttribute("participante");
    Evento evento = (Evento) request.getAttribute("evento");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permissão para eventos</title>
        <%@include file ="jspf/cabecalho.jspf"%>
    </head>
    <body>
        <div class="container">
            <h1>Credenciais de acesso do <%=evento.getEventoNome() %></h1>
            <p>Verifique com o administrador do evento a senha de acesso</p>

            <form method="post">
                <div class="form-group">
                    <label for="usr">Codigo do usuário logado</label>
                    <input  class="form-control" name="participanteCod" value="<%=participante.getCodigoParticipante()%>" readonly>     
                </div>
                <div class="form-group">
                    <label for="usr">Código do evento</label>
                    <input  class="form-control" name="eventoCod" value="<%=evento.getEventoCod()%>" readonly>   
                </div>

                <div class="form-group">
                    <label for="usr">Senha do evento</label>
                    <input type="password" name="senhaEvento" class="form-control" required>     
                </div>

                <input class="btn btn-primary btn" type ="Submit"  value="Enviar"/> 
                <input class="btn btn-primary btn" type ="Reset" /> 
            </form>
    
        </div>
        </body>
    
    <%@include file ="jspf/rodape.jspf"%>

</html>
