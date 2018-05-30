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
        <div class="container">
            <h1>Evento <%=evento.getEventoNome() %></h1>


          
            <br/>
         
            <div class="container">
                <table class="table table-bordered">
                   <thead>
                    <tr>
                        <th> Nome do evento:  <%=evento.getEventoNome()%></th>
                        <th> Data do sorteio:  <%=evento.getDataSorteio() %></th>
                        <th> Data do evento:   <%=evento.getDataEvento() %></th>
              
                    </tr>
                </thead>
                    <tbody>
                
                                        
                        <% if(evento.getParticipantes().size()>0 ) {
                            for (int i = 0; i<evento.getParticipantes().size();i++){
                                 %>
                         <tr>
                        <td colspan = 3>        
                             <%=evento.getParticipantes().get(i).getNome() %>
                        </td>
                         </tr>
                        <%}
}%>
                        
                        
                       
                    </tbody>
                </table>
             
                <br/>
              
              
            </div>
                <% if(flagJuntar==0) {%>
            <div class="container">
                <p><a href ="juntar-ao-sorteio.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>"  class="btn btn-primary btn-lg"> Juntar ao sorteio </a></p>
            </div>
            <% }%>
                        <hr/>

                        
          <% if(evento.getSituacao()==0) {%>
            <div class="container">
                <br/>
                <p>  
                    <a href ="sortear.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>" class="btn btn-danger btn-lg"> Realizar Sorteio </a>
                </p>
          
            </div>
          <% }else{%> 
          <div class="container">
                <br/>
                <p>  
               <a href ="amigo-sorteado.html?eventocod=<%=evento.getEventoCod()%>&participantecod=<%= participanteCod%>" class="btn btn-danger btn-lg"> Meu amigo secreto </a>
                </p>
          
            </div>
          
          <% }%>
          
          
          <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Faça seu login</h4>
                    </div>
                    <form method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="usr">Email:</label>
                                <input type="text" class="form-control" id="usr" name = "email">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" name="senha">
                            </div>         </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default"> Entrar </button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>


            </div>
        </div>

          
          
        </div>
        <%@include file ="jspf/rodape.jspf"%>
    </body>

</html>