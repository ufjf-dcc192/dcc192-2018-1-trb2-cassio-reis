package trabalho.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class ParticipanteDAO {
    
    private static Connection conexao;
    private static ParticipanteDAO instancia;

    public static ParticipanteDAO getInstance() {
        if (instancia == null) {
            instancia = new ParticipanteDAO();
        }
        return instancia;
        
    }

    public ParticipanteDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/dcc192-2018-1", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Participantes;
    }

    void create(String nome,String email, String senha ) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO Participante (NOME,EMAIL,SENHA) VALUES('%s','%s','%s')", nome,email,senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Participante WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Participante.setCodigoParticipante(resultado.getInt("participantecod"));
                Participante.setEmail(resultado.getString("nome"));
                Participante.setNome(resultado.getString("email"));
                Participante.setSenha(resultado.getString("senha"));
                Participantes.add(Participante);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Participantes;
    

    }

    Participante selecionarUsuario(int usuarioLogado) {
        Participante participante = new Participante();
        try {
            Statement comando = conexao.createStatement();
            String sql = "SELECT * from participante p "
                  + "where p.participantecod=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioLogado);
            ResultSet resultado  = stmt.executeQuery();      
            while (resultado.next()) {
                participante.setNome(resultado.getString("NOME"));
                participante.setCodigoParticipante(resultado.getInt("participantecod"));
                participante.setEmail(resultado.getString("email"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participante;
   }
}