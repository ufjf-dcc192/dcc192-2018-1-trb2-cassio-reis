package trabalho.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class AtividadeDAO {
      
    private static Connection conexao;
    private static AtividadeDAO instancia;

    public static AtividadeDAO getInstance() {
        if (instancia == null) {
            instancia = new AtividadeDAO();
        }
        return instancia;
        
    }

    public AtividadeDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192-2018-1", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
    void delete(int eventoCod, int participanteCod){
       try {
            Statement comando = conexao.createStatement();
            String sql ="DELETE FROM Evento WHERE PARTICIPANTECOD=? "
                    + "AND EVENTOCOD=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, eventoCod);
            stmt.setInt(2, participanteCod);
            stmt.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   

    void juntarSorteio(int eventoCod, int participanteCod) throws SQLException {
         try {
                Statement comando = conexao.createStatement();
                String sql = "INSERT INTO ATIVIDADE (PARTICIPANTECOD,EVENTOCOD) VALUES(?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1,  participanteCod);
                stmt.setInt(2, eventoCod);
                stmt.executeUpdate();
      
     
      } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
         
    }
   

