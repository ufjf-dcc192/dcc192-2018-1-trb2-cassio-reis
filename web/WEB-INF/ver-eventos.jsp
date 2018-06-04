
<%
    
    int participanteCod = (Integer) request.getAttribute("participantecod");
    
%>

<%@page import="trabalho.ufjf.dcc192.Evento"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Evento</title>
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
        <h1>Gerenciamento de Evento</h1>
        <p>Seja bem-vindo, clique na mesa desejada para adicionar um pedido</p>
    
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Evento</th>
                        <th>Estado</th>
                        <th>Incluir Participantes</th>
                        <th>Data do Sorteio</th>
                        <th>Data do Evento</th>
                        <th>Excluir Evento</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
                        for (int i = 0; i < eventos.size(); i++) {
                    %>
                    <tr>

                        <td> <a href="permissao-sorteio.html?eventocod=<%=eventos.get(i).getEventoCod() %>&participantecod=<%=participanteCod%>"><%= eventos.get(i).getEventoNome() %> </a></td>
                        <% if (eventos.get(i).getSituacao() == 0) {
                        %><td style="color:blue">
                            <b> SORTEAR</b>
                            <%
                            }   else {
                            %> 
                        
                        <td style="color:red"> <b> SORTEADO</b>
                            <%
                                }
                            %> 
                        </td>
                        <td > <a href="excluir-evento.html?eventocod=<%=eventos.get(i).getEventoCod() %>"><i class="fa fa-ban" style="font-size:24px"></i> </a> </td>
                        
                        <td><%= eventos.get(i).getDataEvento() %> </td>
                        <td><%= eventos.get(i).getDataSorteio() %> </td>
                        <td > <a href="excluir-evento.html?eventocod=<%=eventos.get(i).getEventoCod()%>"><i class="fa fa-ban" style="font-size:24px"></i> </a> </td>

                        
                    </tr>
                    
                    <%
                        }
                    %>
                </tbody>
            </table>
        <a href="adicionar.html" class="btn btn-primary btn-lg">Adicionar Mesa </a>
        <a href="inicial.html" class="btn btn-primary btn-lg">Voltar ao Menu </a>
        </div>
        <br/>
    </body>
        <%@include file ="jspf/rodape.jspf"%>

</html>