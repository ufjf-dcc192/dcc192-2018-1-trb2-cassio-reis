
package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ParticipantesLoginCommand implements Comando{
      @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = request.getParameter("email");
        String senha = request.getParameter("senha");
        List<Participante> participantes = ParticipanteDAO.getInstance().select(nome,senha);
        if(participantes.size()>0){
            response.sendRedirect("dashboard.html");
        }
        else{
            //#erro1 - tratar erro se a pessoa nao conseguir fazer o login.
        }
    }
}