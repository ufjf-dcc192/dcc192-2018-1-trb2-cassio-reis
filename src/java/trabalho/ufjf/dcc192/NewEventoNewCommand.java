/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ice
 */
public class NewEventoNewCommand implements Comando {
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
                  
            String nome = request.getParameter("nome");
            Date dataSorteio = formato.parse(request.getParameter("dataSorteio"));
            Date dataEvento = formato.parse(request.getParameter("dataEvento"));
            
            EventoDAO.getInstance().create(nome,dataSorteio,dataEvento);
            
            List<Evento> eventos = EventoDAO.getInstance().listAll();
            request.setAttribute("eventos", eventos);

            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/ver-eventos.jsp");
            despachante.forward(request, response);
            
            //#erro inserir tratametno
        } catch (ParseException ex) {
            Logger.getLogger(NewEventoNewCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
