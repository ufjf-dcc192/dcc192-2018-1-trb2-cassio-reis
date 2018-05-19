
package trabalho.ufjf.dcc192;

import java.util.Date;


public class Evento {
    private int eventoCod;
    private String eventoNome;
    private Date dataSorteio;
    private Date dataEvento;
    private int situacao;

    public Evento(int eventoCod, String eventoNome, Date dataSorteio, Date dataEvento, int situacao) {
        this.eventoCod = eventoCod;
        this.eventoNome = eventoNome;
        this.dataSorteio = dataSorteio;
        this.dataEvento = dataEvento;
        this.situacao = situacao;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    

    public Evento() {
    }

  
    public int getEventoCod() {
        return eventoCod;
    }

    public void setEventoCod(int eventoCod) {
        this.eventoCod = eventoCod;
    }

    public String getEventoNome() {
        return eventoNome;
    }

    public void setEventoNome(String eventoNome) {
        this.eventoNome = eventoNome;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    
}
