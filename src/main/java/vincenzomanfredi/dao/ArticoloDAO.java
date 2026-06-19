package vincenzomanfredi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vincenzomanfredi.entities.Articolo;

public class ArticoloDAO {
    private final EntityManager em;

    public ArticoloDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Articolo articolo) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(articolo);
        transaction.commit();
        System.out.println("Articolo" + articolo.getTitolo() + " salvata con successo");
    }
}
