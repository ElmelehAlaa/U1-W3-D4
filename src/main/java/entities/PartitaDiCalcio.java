package entities;

import entities.Enum.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;


@Entity
        @NamedQuery(
                name = "PartitaDiCalcio.getPartiteVinteInCasa",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa"
        )
        @NamedQuery(
                name = "PartitaDiCalcio.getPartiteVinteInTrasferta",
                query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"
        )

    public class PartitaDiCalcio extends Evento {
        private String squadraCasa;
        private String squadraOspite;
        private String squadraVincente; // Null se pareggio
        private int numeroGolSquadraCasa;
        private int numeroGolSquadraOspite;


    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public PartitaDiCalcio(){}
}
