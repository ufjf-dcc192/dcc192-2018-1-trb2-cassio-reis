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
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><a href="cadastrar-evento.html?participantecod=<%=participanteLogado.getCodigoParticipante()%>">Cadastrar evento</a></li>
                    <li><a href="ver-eventos.html?participantecod=<%=participanteLogado.getCodigoParticipante()%>">Ver evento</a></li>
                    <li><a href="index.html">Sair</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h1>Seu amigo-secreto é: <%=amigoSorteado.getNome()%> </h1>
            <p>Atenção <%=participanteLogado.getNome()%>, o evento acontecerá no dia <%=evento.getDataEvento()%></p>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Tamanho de camisa</th>
                        <th>Tamanho de sapatos</th>
                        <th>Tamanho de calças</th>
                        <th>Lista de interesses</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <%= amigoSorteado.getNome()%></td>
                        <td> <%= amigoSorteado.getEmail()%></td>
                        <td> <%= amigoSorteado.getTamanhoCamisa()%></td>
                        <td> <%= amigoSorteado.getTamanhoCalca()%></td>
                        <td> <%= amigoSorteado.getTamanhoSapato()%></td>
                        <td> <%= amigoSorteado.getInteresses()%></td>
                    </tr>
                </tbody>
            </table>
            <a href="ver-eventos.html?participantecod=<%=participanteLogado.getCodigoParticipante()%>" class="btn btn-primary btn-lg">Voltar aos eventos </a>
        </div>
        <br/>
    </body>
    <%@include file ="jspf/rodape.jspf"%>
</html>