package DAO;

import entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em){
        this.em=em;
    }
    public void save(Partecipazione partecipazione){
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(partecipazione);

            transaction.commit();
            System.out.println("Evento salvato correttamente!");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }}
    public Partecipazione getById(int id){
        return em.find(Partecipazione.class,id);
    }

    public void deleteById(int id){
        Partecipazione found = em.find(Partecipazione.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Partecipazione cancellato!");}else {
            System.out.println("La Partecipazione con l'id:" + id + "non è stato trovato");
        }
    }
}
