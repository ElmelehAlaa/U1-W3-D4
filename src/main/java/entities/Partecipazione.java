package entities;

import entities.Enum.StatoPartecipazione;

import javax.persistence.*;

@Entity

public class Partecipazione {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "gestione_eventi_id")
    private Evento evento;

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", statoPartecipazione=" + statoPartecipazione +
                ", persona=" + persona +
                '}';
    }
}
