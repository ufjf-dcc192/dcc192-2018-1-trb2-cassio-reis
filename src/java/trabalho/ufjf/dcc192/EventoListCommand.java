package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoListCommand implements Comando {

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int participanteCod = Integer.parseInt(request.getParameter("participantecod"));
       
        
        List<Evento> eventos = EventoDAO.getInstance().listAll();
        request.setAttribute("eventos", eventos);
        request.setAttribute("participantecod", participanteCod);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-eventos.jsp");
        despachante.forward(request, response);

    }
}
