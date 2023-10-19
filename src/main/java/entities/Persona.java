package entities;

import entities.Enum.Sesso;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataNascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany
    private Set<Partecipazione> listaPartecipazioni ;



    public Persona() {
        // Costruttore senza argomenti
    }

    public Persona(String nome, String cognome, String email, Date dataNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                ", listaPartecipazione=" +
//                listaPartecipazione
                +
                        '}';
    }
}