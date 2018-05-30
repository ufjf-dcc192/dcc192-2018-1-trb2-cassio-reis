package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandPermissaoSorteio implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
            int usuarioLogado = Integer.parseInt(request.getParameter("participantecod"));
            
            Evento evento = EventoDAO.getInstance().listEvento(eventoCod);
            Participante participante = ParticipanteDAO.getInstance().selecionarUsuario(usuarioLogado);
            
            request.setAttribute("evento", evento);
            request.setAttribute("participante", participante);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/permissao-eventos.jsp");
            despachante.forward(request, response);

            
        } catch (SQLException ex) {
            Logger.getLogger(CommandPermissaoSorteio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
