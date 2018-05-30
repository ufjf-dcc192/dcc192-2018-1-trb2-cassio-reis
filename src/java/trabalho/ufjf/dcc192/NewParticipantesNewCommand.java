
package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewParticipantesNewCommand implements Comando {
   
    
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       String nome = request.getParameter("nome");
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
       int tamanhoCalca = Integer.parseInt(request.getParameter("tamanhoCalca"));
       int tamanhoCamisa = Integer.parseInt(request.getParameter("tamanhoCamisa"));
       int tamanhoSapato = Integer.parseInt(request.getParameter("tamanhoSapato"));
       String interesses = request.getParameter("interesses");
       
       ParticipanteDAO.getInstance().create(nome,email,senha,tamanhoCalca,tamanhoSapato,tamanhoCamisa, interesses);
       response.sendRedirect("index.html");
       
    }
    
}
