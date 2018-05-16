
package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ParticipantesNewCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/cadastrar-participantes.jsp");
        //List<Participante> participantes = ParticipanteDAO.getInstance().listAll();
        //request.setAttribute("participantes", participantes);
        dispacher.forward(request, response);
    }
    
}


