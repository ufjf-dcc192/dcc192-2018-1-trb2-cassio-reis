/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
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
public class CommandSorteio  implements Comando{
      
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            int i = 0;
            int eventoCod = Integer.parseInt(request.getParameter("eventocod"));
            List<Participante> participantes = AtividadeDAO.getInstance().listParticipanteParticipantes(eventoCod);
            Collections.shuffle(participantes);
          
            for ( i = 0; i < participantes.size()-1 ; i++) {
                    
                    AtividadeDAO.getInstance().InsereSorteio(eventoCod,participantes.get(i).getCodigoParticipante(),participantes.get(i+1).getCodigoParticipante());

                }
            
            AtividadeDAO.getInstance().InsereSorteio(eventoCod,participantes.get(i).getCodigoParticipante(),participantes.get(0).getCodigoParticipante());
            
     }
}     

