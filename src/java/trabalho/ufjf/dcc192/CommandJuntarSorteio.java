package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandJuntarSorteio implements Comando {

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flagJuntar = 0;

        try {
            int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
            int usuarioLogado = Integer.parseInt(request.getParameter("participantecod"));
            AtividadeDAO.getInstance().juntarSorteio(eventoCod, usuarioLogado);

            Evento evento = EventoDAO.getInstance().listEvento(eventoCod);
            List<Participante> participantes = AtividadeDAO.getInstance().listParticipanteParticipantes(eventoCod);

            for (int i = 0; i < participantes.size(); i++) {
                evento.getParticipantes().add(participantes.get(i));
            }
            for (int i = 0; i < participantes.size(); i++) {
                flagJuntar = 0;
                if (evento.getParticipantes().get(i).getCodigoParticipante() == usuarioLogado) {
                    flagJuntar = 1;

                }
            }

            Date dataAtual = new Date();
            if (evento.getDataSorteio().getTime() < dataAtual.getTime()) {

                int i = 0;
                int participanteCod = Integer.parseInt(request.getParameter("participantecod"));
                Collections.shuffle(participantes);

                for (i = 0; i < participantes.size() - 1; i++) {

                    AtividadeDAO.getInstance().InsereSorteio(eventoCod, participantes.get(i).getCodigoParticipante(), participantes.get(i + 1).getCodigoParticipante());

                }

                AtividadeDAO.getInstance().InsereSorteio(eventoCod, participantes.get(i).getCodigoParticipante(), participantes.get(0).getCodigoParticipante());
                EventoDAO.getInstance().atualizaEvento(eventoCod);
                String redirect = "amigo-sorteado.html?participantecod=" + participanteCod + "&eventocod=" + eventoCod;
                response.sendRedirect(redirect);

            } else {

                request.setAttribute("eventocod", evento);
                request.setAttribute("participantecod", usuarioLogado);
                request.setAttribute("flagjuntar", flagJuntar);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/evento-descricao.jsp");
                despachante.forward(request, response);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandJuntarSorteio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
