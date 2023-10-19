package entities;

import entities.Enum.GenereMusica;
import entities.Enum.Streaming;
import entities.Enum.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private GenereMusica genere;

    @Enumerated(EnumType.STRING)
    private Streaming inStreaming;

    public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, GenereMusica genere, Streaming inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
     public Concerto(){}

    public GenereMusica getGenere() {
        return genere;
    }

    public void setGenere(GenereMusica genere) {
        this.genere = genere;
    }

    public Streaming getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Streaming inStreaming) {
        this.inStreaming = inStreaming;
    }
}