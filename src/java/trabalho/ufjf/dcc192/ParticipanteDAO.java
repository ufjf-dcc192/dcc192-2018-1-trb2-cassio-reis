package trabalho.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
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

    void create(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO Participante(titulo) VALUES('%s')", titulo));
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

}