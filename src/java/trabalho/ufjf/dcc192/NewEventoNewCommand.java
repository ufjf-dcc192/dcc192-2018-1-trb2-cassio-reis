/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
public class NewEventoNewCommand implements Comando {
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       String nome = request.getParameter("nome");
       String email = request.getParameter("dataSorteio");
       String senha = request.getParameter("dataEvento");
       
       EventoDAO.getInstance().create(nome,email,senha);
       response.sendRedirect("index.html");
       
    }
    
}
