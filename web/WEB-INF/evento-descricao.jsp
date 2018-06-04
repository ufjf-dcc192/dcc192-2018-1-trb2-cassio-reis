<%@page import="trabalho.ufjf.dcc192.Participante"%>
<%@page import="java.util.List"%>
<%@page import="trabalho.ufjf.dcc192.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    Evento evento = (Evento) request.getAttribute("eventocod");
    int participanteCod = (Integer) request.getAttribute("participantecod");
    int flagJuntar = (Integer) request.getAttribute("flagjuntar");

    //List<Participante> participantes = (List<Participante>) request.getAttribute("participantes");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle da Mesa</title>
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
            <h1>Evento <%=evento.getEventoNome()%></h1>



            <br/>

            <div class="container">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th> Nome do evento:  <%=evento.getEventoNome()%></th>
                            <th> Data do sorteio:  <%=evento.getDataSorteio()%></th>
                            <th> Data do evento:   <%=evento.getDataEvento()%></th>

                        </tr>
                    </thead>
                    <tbody>


                        <% if (evento.getParticipantes().size() > 0) {
                                for (int i = 0; i < evento.getParticipantes().size(); i++) {
                        %>
                        <tr>
                            <td colspan = 3>        
                                <%=evento.getParticipantes().get(i).getNome()%>
                            </td>
                        </tr>
                        <%}
                            }%>
                    </tbody>
                </table>
                <br/>


            </div>
            <% if (flagJuntar == 0) {%>
            <div class="container">
                <p><a href ="juntar-ao-sorteio.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>"  class="btn btn-primary btn-lg"> Juntar ao sorteio </a></p>
            </div>
            <% }%>
            <hr/>


            <% if (evento.getSituacao() == 0) {%>
            <div class="container">
                <br/>
                <p>  
                    <a href ="sortear.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>" class="btn btn-danger btn-lg"> Realizar Sorteio </a>
                </p>

            </div>
            <% } else {%> 
            <div class="container">
                <br/>
                <p>  
                    <a href ="amigo-sorteado.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>" class="btn btn-danger btn-lg"> Meu amigo secreto </a>
                </p>

            </div>

            <% }%>
        </div>
        <%@include file ="jspf/rodape.jspf"%>
    </body>

</html>