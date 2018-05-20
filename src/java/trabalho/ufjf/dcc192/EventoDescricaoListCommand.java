package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoDescricaoListCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
            int usuarioLogado = Integer.parseInt(request.getParameter("participantecod"));
            int flagJuntar=0;

            Evento evento = EventoDAO.getInstance().listEvento(eventoCod);

            List<Participante> participantes = AtividadeDAO.getInstance().listParticipanteParticipantes(eventoCod);

            for (int i = 0; i < participantes.size(); i++) {
                evento.getParticipantes().add(participantes.get(i));

            }

            for (int i = 0; i < participantes.size(); i++) {
                if (evento.getParticipantes().get(i).getCodigoParticipante() == usuarioLogado) {
                     flagJuntar = 1;

                }
            }

            request.setAttribute("eventocod", evento);
            request.setAttribute("participantecod", usuarioLogado);
            request.setAttribute("flagjuntar", flagJuntar);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/evento-descricao.jsp");
            despachante.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EventoDescricaoListCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
