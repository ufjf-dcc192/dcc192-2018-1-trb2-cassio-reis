package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
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
        List<Evento> evento = EventoDAO.getInstance().listUnicEvent(eventoCod);
        request.setAttribute("evento", evento.get(0));
        request.setAttribute("participanteLogado", participanteLogado);
        request.setAttribute("amigoSorteado", amigoSorteado);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/amigo-sorteado.jsp");
        despachante.forward (request, response);
     }
}
