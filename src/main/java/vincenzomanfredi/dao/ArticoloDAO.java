package vincenzomanfredi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vincenzomanfredi.entities.Articolo;
import vincenzomanfredi.entities.Libro;
import vincenzomanfredi.exceptions.NotFoundException;
import vincenzomanfredi.exceptions.NotFoundIsbnException;

import java.util.List;
import java.util.UUID;

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

    public Articolo findById(UUID id) {
        Articolo found = em.find(Articolo.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Articolo findByIsbn(String isbn) {

        TypedQuery<Articolo> query = em.createQuery("SELECT a FROM Articolo a WHERE a.codiceIsbn = :isbn", Articolo.class);
        query.setParameter("isbn", isbn);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundIsbnException(isbn);
        }
    }

    public List<Articolo> findByAnnoDiPubblicazione(int anno) {
        TypedQuery<Articolo> query = em.createQuery("SELECT a FROM Articolo a WHERE a.annoPubblicazione = :anno", Articolo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Articolo> findByTitolo(String titolo) {
        TypedQuery<Articolo> query = em.createQuery("SELECT a FROM Articolo a WHERE LOWER(a.titolo) LIKE LOWER(:titolo)", Articolo.class);
        query.setParameter("titolo", "%" + titolo.toLowerCase() + "%");
        return query.getResultList();
    }

}
