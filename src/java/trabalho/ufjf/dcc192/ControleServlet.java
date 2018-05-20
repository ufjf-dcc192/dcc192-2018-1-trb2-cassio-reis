/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author cassio
 */
@WebServlet(name = "ControleServlet", urlPatterns = {"/inicial.html"})
public class ControleServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String usuarioNome =  request.getParameter("usuarioNome");
        String usuarioSenha =  request.getParameter("usuarioSenha");
        String usuarioEmail =  request.getParameter("usuarioEmail");
    
        //#erro alterar quando for implemntaqr o banco, so tirar a exclamaçao 
        if(!(usuarioNome==null && usuarioSenha == null && usuarioEmail==null)){
            Map<String, String> rotas = new HashMap<>();
            rotas.put("/inicial.html", "trabalho.ufjf.dcc192.IndexCommand"); 
            
            //rotas.put("/cadastro-pessoas.html", "trabalho.ufjf.dcc192.ParticipantesNewCommand");
            String clazzName = rotas.get(request.getServletPath());
        
    
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        
             Map<String, String> rotas = new HashMap<>();
            rotas.put("/inicial.html", "trabalho.ufjf.dcc192.InicialCommand");


            //rotas.put("/cadastro-pessoas.html", "trabalho.ufjf.dcc192.ParticipantesNewCommand");
            String clazzName = rotas.get(request.getServletPath());
        
    
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(ParticipanteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
 }
