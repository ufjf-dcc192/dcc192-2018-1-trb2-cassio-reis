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

public class CommandAmigoSorteado implements Comando{
     
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
        int usuarioLogado = Integer.parseInt(request.getParameter("participantecod"));
        Participante amigoSorteado = AtividadeDAO.getInstance().verAmigoSorteado(eventoCod,usuarioLogado);
        Participante participanteLogado = ParticipanteDAO.getInstance().selecionarUsuario(usuarioLogado);
        request.setAttribute("eventocod", eventoCod);
        request.setAttribute("participantecod", usuarioLogado);
        request.setAttribute("participanteLogado", participanteLogado);
        request.setAttribute("amigoSorteado", amigoSorteado);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/amigo-sorteado.jsp");
        despachante.forward (request, response);

     }
    
}
