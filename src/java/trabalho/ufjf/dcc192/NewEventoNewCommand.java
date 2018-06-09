package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewEventoNewCommand implements Comando {

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int usuarioLogado = Integer.parseInt(request.getParameter("participantecod"));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");

            String nome = request.getParameter("nome");
            String senhaEvento = request.getParameter("senhaEvento");
            Date dataSorteio = formato.parse(request.getParameter("dataSorteio"));
            Date dataEvento = formato.parse(request.getParameter("dataEvento"));

            if (dataSorteio.getTime() > dataEvento.getTime()) {
                request.setAttribute("participantecod", usuarioLogado);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/Erros/erro-data-evento-sorteio.jsp");
                despachante.forward(request, response);
            } else {

                EventoDAO.getInstance().create(nome, dataSorteio, dataEvento, senhaEvento);
                response.sendRedirect("ver-eventos.html?participantecod=" + usuarioLogado);
            }
            //#erro inserir tratametno
        } catch (ParseException ex) {
            Logger.getLogger(NewEventoNewCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
