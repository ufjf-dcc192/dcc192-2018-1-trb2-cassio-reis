
package trabalho.ufjf.dcc192;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class EventoDAO {
      
    private static Connection conexao;
    private static EventoDAO instancia;

    public static EventoDAO getInstance() {
        if (instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
        
    }

    public EventoDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192-2018-1", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Participante> listAll() {
        List<Participante> Participantes = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id,titulo from Participante");
            while (resultado.next()) {
                Participante Participante = new Participante();
              //  Participante.setId(resultado.getLong("id"));
        //        Participante.setTitulo(resultado.getString("titulo"));
                Participantes.add(Participante);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Participantes;
    }

    void create(String nome,Date dataSorteio, Date dataEvento ) {
        try {
         
            java.sql.Date d = new java.sql.Date (dataSorteio.getTime());
            java.sql.Date dt = new java.sql.Date (dataEvento.getTime());
            
            Statement comando = conexao.createStatement();
            String sql = "INSERT INTO EVENTO (EVENTONOME,DATASORTEIO,DATAEVENTO) VALUES(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDate(2,  d);
            stmt.setDate(3,  dt);

            stmt.executeUpdate();
                                    
   
               
  
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Participante WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Participante> select(String email, String senha) {
        
     List<Participante> Participantes = new ArrayList<>();
        try {
            
            String sql = "select * from Participante where email=? and senha=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
                                    
            Statement comando = conexao.createStatement();
            ResultSet resultado  = stmt.executeQuery();
            
            while (resultado.next()) {
                Participante Participante = new Participante();
              //  Participante.setId(resultado.getLong("id"));
        //        Participante.setTitulo(resultado.getString("titulo"));
                Participantes.add(Participante);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Participantes;
    

    }
}
