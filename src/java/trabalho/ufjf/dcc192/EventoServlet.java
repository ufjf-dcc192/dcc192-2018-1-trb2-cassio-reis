package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventoServlet", urlPatterns = {"/cadastrar-evento.html", "/ver-eventos.html", "/juntar-ao-sorteio.html", "/descricao-evento.html", "/amigo-sorteado.html", "/sortear.html", "/permissao-sorteio.html"})
public class EventoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String> rotas = new HashMap<>();
        rotas.put("/cadastrar-evento.html", "trabalho.ufjf.dcc192.EventoNewCommand");
        rotas.put("/ver-eventos.html", "trabalho.ufjf.dcc192.EventoListCommand");
        rotas.put("/descricao-evento.html", "trabalho.ufjf.dcc192.EventoDescricaoListCommand");
        rotas.put("/juntar-ao-sorteio.html", "trabalho.ufjf.dcc192.CommandJuntarSorteio");
        rotas.put("/sortear.html", "trabalho.ufjf.dcc192.CommandSorteio");
        rotas.put("/amigo-sorteado.html", "trabalho.ufjf.dcc192.CommandAmigoSorteado");
        rotas.put("/permissao-sorteio.html", "trabalho.ufjf.dcc192.CommandPermissaoSorteio");

        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String> rotas = new HashMap<>();
        rotas.put("/cadastrar-evento.html", "trabalho.ufjf.dcc192.NewEventoNewCommand");
        rotas.put("/ver-eventos.html", "trabalho.ufjf.dcc192.EventoListCommand");
        rotas.put("/permissao-sorteio.html", "trabalho.ufjf.dcc192.CommandPermissaoVerifica");

        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
