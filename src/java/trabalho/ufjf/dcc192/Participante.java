package trabalho.ufjf.dcc192;

public class Participante {
    private int codigoParticipante;
    private String nome;
    private String email;
    private String senha;
    private String interesses;
    private String tamanhoCalca;
    private String tamanhoCamisa;
    private String tamanhoSapato;

    public int getCodigoParticipante() {
        return codigoParticipante;
    }

    public void setCodigoParticipante(int codigoParticipante) {
        this.codigoParticipante = codigoParticipante;
    }

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

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public String getTamanhoCalca() {
        return tamanhoCalca;
    }

    public void setTamanhoCalca(String tamanhoCalca) {
        this.tamanhoCalca = tamanhoCalca;
    }

    public String getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    public void setTamanhoCamisa(String tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
    }

    public String getTamanhoSapato() {
        return tamanhoSapato;
    }

    public void setTamanhoSapato(String tamanhoSapato) {
        this.tamanhoSapato = tamanhoSapato;
    }

}