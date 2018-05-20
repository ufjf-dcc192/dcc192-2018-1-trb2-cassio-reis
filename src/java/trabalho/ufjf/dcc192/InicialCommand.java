
package trabalho.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InicialCommand implements Comando {
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int participanteCod = Integer.parseInt(request.getParameter("participantecod"));
        
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/inicial.jsp");
        
        request.setAttribute("participantecod",participanteCod);
        dispacher.forward(request, response);
    }
}
