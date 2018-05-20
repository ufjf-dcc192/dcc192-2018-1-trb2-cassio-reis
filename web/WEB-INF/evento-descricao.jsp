<%@page import="trabalho.ufjf.dcc192.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    Evento evento = (Evento) request.getAttribute("eventocod");
    int participanteCod = (Integer) request.getAttribute("participantecod");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle da Mesa</title>
        <%@include file ="jspf/cabecalho.jspf"%>
    </head>
    <body>
        <div class="container">
            <h1>Evento <%=evento.getEventoNome() %></h1>


          
            <br/>
         
            <div class="container">
                <table class="table table-bordered">
                    <tbody>
                
                        <td>
                            <%=evento.getEventoNome()%>
                        </td>
                       
                        
                        
                        <td>
                            <%=evento.getDataSorteio() %>
                        </td>
                        
                        
                        <td>
                            <%=evento.getDataEvento() %>
                        </td>
                        
                        
                    </tbody>
                </table>
             
                <br/>
              
              
            </div>
            <div class="container">
                <p><a href ="juntar-ao-sorteio.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>"  class="btn btn-primary btn-lg"> Juntar ao sorteio </a></p>
            </div>
                        <hr/>

            <div class="container">
                <br/>
                <p>  
                    <a href ="eventos.html" class="btn btn-danger btn-lg"> Realizar Sorteio </a>
                </p>
          
            </div>
        </div>
        <%@include file ="jspf/rodape.jspf"%>
    </body>

</html>