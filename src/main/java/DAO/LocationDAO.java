package DAO;

import entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em){
        this.em=em;
    }
    public void save(Location location){
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.persist(location);

            transaction.commit();
            System.out.println("location salvata correttamente!");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }}
    public Location getById(int id){
        return em.find(Location.class,id);
    }

    public void deleteById(int id){
        Location found = em.find(Location.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Location cancellato!");}else {
            System.out.println("La Location con l'id:" + id + "non è stato trovato");
        }
    }
}
