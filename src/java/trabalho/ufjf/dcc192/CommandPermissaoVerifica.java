package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandPermissaoVerifica implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flagJuntar = 0;
        try {
            int eventoCod = Integer.parseInt(request.getParameter("eventoCod"));
            int participanteCod = Integer.parseInt(request.getParameter("participanteCod"));
            String eventoSenha = request.getParameter("senhaEvento");
            //Evento evento = EventoDAO.getInstance().listEvento(eventoCod);
            List<Evento> eventos = EventoDAO.getInstance().listEventoVerificado(eventoCod,eventoSenha);
           
            if(eventos.size() == 0){
            
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/Erros/erro-acesso.jsp");
                despachante.forward(request, response);
                
            }else{
            Evento evento = eventos.get(0);
            List<Participante> participantes = AtividadeDAO.getInstance().listParticipanteParticipantes(eventoCod);

            for (int i = 0; i < participantes.size(); i++) {
                evento.getParticipantes().add(participantes.get(i));

            }

            for (int i = 0; i < participantes.size(); i++) {
                if (evento.getParticipantes().get(i).getCodigoParticipante() == participanteCod) {
                    flagJuntar = 1;

                }
            }

            request.setAttribute("eventocod", evento);
            request.setAttribute("participantecod", participanteCod);
            request.setAttribute("flagjuntar", flagJuntar);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/evento-descricao.jsp");
            despachante.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandPermissaoVerifica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
