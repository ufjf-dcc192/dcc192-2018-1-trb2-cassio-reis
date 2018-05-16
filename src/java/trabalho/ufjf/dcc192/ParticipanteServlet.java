/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.ufjf.dcc192;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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


@WebServlet(name = "ParticipanteServlet", urlPatterns = {"/index.html","/cadastro-pessoas.html"})
public class ParticipanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "trabalho.ufjf.dcc192.IndexCommand");
        rotas.put("/cadastro-pessoas.html", "trabalho.ufjf.dcc192.ParticipantesNewCommand");
    
    
    String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/cadastro-pessoas.html", "trabalho.ufjf.dcc192.NewParticipantesNewCommand");
        rotas.put("/index.html", "trabalho.ufjf.dcc192.ParticipantesLoginCommand");
    
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}