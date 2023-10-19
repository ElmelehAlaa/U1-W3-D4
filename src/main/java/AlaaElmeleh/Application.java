package AlaaElmeleh;

import DAO.EventoDAO;
import entities.Enum.TipoEvento;
import entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;


public class  Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1-w3-d4");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        try {
            ////////////////////////////// Creazione di una partita di calcio
            PartitaDiCalcio partita = new PartitaDiCalcio(
                    "Partita di Calcio", new Date(), "INTER-MILAN", TipoEvento.PUBBLICO, 100,
                    "INTER", "MILAN", "INTER", 2, 1
            );

            PartitaDiCalcio partita2 = new PartitaDiCalcio(
                    "Partita di Calcio ", new Date(), "ROMA-JUVENTUS ", TipoEvento.PUBBLICO, 100,
                    "ROMA", "JUVENTUS", "JUVENTUS", 0, 3
            );


//            eventoDAO.save(partita);
              eventoDAO.save(partita2);
            

            /////////////////////partite vinte in casa
            List<PartitaDiCalcio> partiteVinteInCasa = eventoDAO.getPartiteVinteInCasa();
            for (PartitaDiCalcio partitaCasa : partiteVinteInCasa) {
                System.out.println("Partita vinta in casa: " + partitaCasa);
            }

            ///////////////////partite vinte in trasferta
            List<PartitaDiCalcio> partiteVinteInTrasferta = eventoDAO.getPartiteVinteInTrasferta();
            for (PartitaDiCalcio partitaTrasferta : partiteVinteInTrasferta) {
                System.out.println("Partita vinta in trasferta: " + partitaTrasferta);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}