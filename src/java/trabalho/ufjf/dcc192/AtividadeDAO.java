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
            String sql ="DELETE FROM Participante WHERE PARTICIPANTECOD=? "
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
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Participante> listParticipanteParticipantes(int eventoCod) {

          List<Participante> participantes = new ArrayList<>();
        try {
            
            Statement comando = conexao.createStatement();
            
            String sql = "SELECT * from atividade a "
                    + "join participante p on p.participantecod=a.participantecod "
                    + "where a.eventocod=?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, eventoCod);
            ResultSet resultado  = stmt.executeQuery();      
                                    
            while (resultado.next()) {
                Participante participante = new Participante();
               
                participante.setNome(resultado.getString("NOME"));
                participante.setCodigoParticipante(resultado.getInt("participantecod"));
                participante.setEmail(resultado.getString("email"));
                participantes.add(participante);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
    }

    void InsereSorteio(int eventoCod, int participanteCod, int sorteado) {
    try {
                Statement comando = conexao.createStatement();
                String sql = "UPDATE ATIVIDADE SET SORTEADO =? WHERE  PARTICIPANTECOD =? AND EVENTOCOD=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1,  sorteado);
                stmt.setInt(2, participanteCod);
                stmt.setInt(3, eventoCod);
                stmt.executeUpdate();
      
     
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    Participante verAmigoSorteado(int eventoCod, int usuarioLogado) {
        Participante participante = new Participante();
        
        try {
            Statement comando = conexao.createStatement();
            String sql = "SELECT * from atividade a "
                    + "join participante p on p.participantecod=a.participantecod "
                    + "where a.eventocod=?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, eventoCod);
            ResultSet resultado  = stmt.executeQuery();      
                                    
            while (resultado.next()) {
                participante.setNome(resultado.getString("NOME"));
                participante.setCodigoParticipante(resultado.getInt("participantecod"));
                participante.setEmail(resultado.getString("email"));
                participante.setTamanhoCalca(resultado.getString("TAMANHOCALCA"));
                participante.setTamanhoCamisa(resultado.getString("TAMANHOCAMISA"));
                participante.setTamanhoSapato(resultado.getString("TAMANHOSAPATO"));
                participante.setInteresses(resultado.getString("INTERESSES"));
               
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participante;
   
    }
         
 }

   

