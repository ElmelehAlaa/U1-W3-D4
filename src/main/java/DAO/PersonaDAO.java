package DAO;

import entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;
    public PersonaDAO(EntityManager em){this.em=em;}
    public void save(Persona persona){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(persona);
            transaction.commit();
            System.out.println("Persona salvata correttamente");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public Persona getById(int id){return em.find(Persona.class,id);}

    public void deleteById(int id){
        Persona found = em.find(Persona.class,id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Persona Cancellata!");
        }else {
            System.out.println("La persona con l'id:"+ id + "non é stata trovata");
        }
    }
    public void refresh(Persona persona){
        em.refresh(persona);
    }
}
