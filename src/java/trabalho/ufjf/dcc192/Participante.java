package trabalho.ufjf.dcc192;

public class Participante {
    private int codigoParticipante;
    private String nome;
    private String email;
    private String senha;

    public Participante(int codigoParticipante, String nome, String email, String senha) {
        this.codigoParticipante = codigoParticipante;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Participante() {
    }
    
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}