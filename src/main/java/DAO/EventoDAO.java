package DAO;

import entities.Concerto;
import entities.Enum.GenereMusica;
import entities.Evento;
import entities.PartitaDiCalcio;

import javax.persistence.*;
import java.util.List;


public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em){
        this.em=em;
    }
    public   void save(Evento evento){
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(evento);

            transaction.commit();
            System.out.println("Evento salvato correttamente!");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }}
    public Evento getById(int id){
        return em.find(Evento.class,id);
    }

    public void deleteById(int id){
        Evento found = em.find(Evento.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento cancellato!");}else {
            System.out.println("L'evento con l'id:" + id + "non è stato trovato");
        }
    }
    public void refresh(Evento evento) {
        em.refresh(evento);
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(List<GenereMusica> generi) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere IN :generi", Concerto.class);
        query.setParameter("generi", generi);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

}
