<%@page import="trabalho.ufjf.dcc192.Participante"%>
<%@page import="trabalho.ufjf.dcc192.Evento"%>
<%@page import="java.util.List"%>
<%
    Participante participanteLogado = (Participante) request.getAttribute("participanteLogado");
    Participante amigoSorteado = (Participante) request.getAttribute("amigoSorteado");
    Evento evento = (Evento) request.getAttribute("evento");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amigo Sorteado</title>
        <%@include file ="jspf/cabecalho.jspf"%>
    </head>
    <body>
    <div class="container">
        <h1>Seu amigo-secreto é: <%=amigoSorteado.getNome()%> </h1>
        <p>Atenção <%=participanteLogado.getNome()%>, o evento acontecerá no dia <%=evento.getDataEvento()%></p>
    
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Idade</th>
                        <th>Tamanho de camisa</th>
                        <th>Tamanho de sapatos</th>
                        <th>Tamanho de calças</th>
                        <th>Lista de interesses</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= participanteLogado.getNome() %></td>
                        <td> <%= participanteLogado.getEmail() %></td>
                    </tr>
                </tbody>
            </table>
                    <a href="inicial.html?participantecod=<%=participanteLogado.getCodigoParticipante()%>" class="btn btn-primary btn-lg">Voltar a página inicial </a>
        </div>
        <br/>
    </body>
        <%@include file ="jspf/rodape.jspf"%>
</html>