
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

    public List<Evento> listAll() {
        List<Evento> Eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT EVENTONOME,DATASORTEIO,DATAEVENTO,SITUACAO from Evento");
            while (resultado.next()) {
                Evento Evento = new Evento();
                Evento.setEventoNome(resultado.getString("EVENTONOME"));
                Evento.setDataEvento(resultado.getDate("DATAEVENTO"));
                Evento.setDataSorteio(resultado.getDate("DATASORTEIO"));
                Evento.setSituacao(resultado.getInt("SITUACAO"));
                Eventos.add(Evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Eventos;
    }

    void create(String nome,Date dataSorteio, Date dataEvento ) {
        try {
         
            java.sql.Date d = new java.sql.Date (dataSorteio.getTime());
            java.sql.Date dt = new java.sql.Date (dataEvento.getTime());
            
            Statement comando = conexao.createStatement();
            String sql = "INSERT INTO EVENTO (EVENTONOME,DATASORTEIO,DATAEVENTO,SITUACAO) VALUES(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDate(2,  d);
            stmt.setDate(3,  dt);
            stmt.setInt(4,  0);
            
            stmt.executeUpdate();
                                    
   
               
  
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Evento WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Evento> select(String email, String senha) {
        
     List<Evento> Eventos = new ArrayList<>();
        try {
            
            String sql = "select * from Evento where email=? and senha=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
                                    
            Statement comando = conexao.createStatement();
            ResultSet resultado  = stmt.executeQuery();
            
            while (resultado.next()) {
                Evento Evento = new Evento();
              //  Evento.setId(resultado.getLong("id"));
        //        Evento.setTitulo(resultado.getString("titulo"));
                Eventos.add(Evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Eventos;
    

    }
}
