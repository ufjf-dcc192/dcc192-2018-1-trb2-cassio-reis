package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParticipantesLoginCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("email");
        String senha = request.getParameter("senha");
        List<Participante> participantes = ParticipanteDAO.getInstance().select(nome, senha);
        if (participantes.size() > 0) {
            request.setAttribute("usuarioEmail", participantes.get(0).getEmail());
            request.setAttribute("usuarioNome", participantes.get(0).getNome());
            request.setAttribute("usuarioSenha", participantes.get(0).getSenha());
            request.setAttribute("participantecod", participantes.get(0).getCodigoParticipante());
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/inicial.jsp");
            dispacher.forward(request, response);
            
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/Erros/erro-login.jsp");
            dispacher.forward(request, response);
                
        }
    }
}
