
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

public class CommandJuntarSorteio implements Comando{
     
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
            int participanteCod = Integer.parseInt(request.getParameter("participantecod"));
            AtividadeDAO.getInstance().juntarSorteio(eventoCod,participanteCod);
            

            Evento evento = EventoDAO.getInstance().listEvento(eventoCod);
            request.setAttribute ("eventocod", evento);
            request.setAttribute ("participantecod", participanteCod);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/evento-descricao.jsp");
            despachante.forward (request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CommandJuntarSorteio.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
    
}