package vincenzomanfredi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vincenzomanfredi.dao.ArticoloDAO;
import vincenzomanfredi.entities.*;
import vincenzomanfredi.exceptions.NotFoundException;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ArticoloDAO articoloDAO = new ArticoloDAO(em);
        try {
            Utente utente = new Utente("Giorgio", "Rossi", LocalDate.of(2000, 5, 15), 12345);
            em.getTransaction().begin();
            em.persist(utente);
            em.getTransaction().commit();
            System.out.println("Utente salvato con successo!");

            Libro libro = new Libro("000-000", "Ubik", 1980, 303, "Dick", "Distopia");
            articoloDAO.save(libro);

            Rivista rivista = new Rivista("000-111", "Focus Scientifico", 2026, 84, Periodicita.MENSILE);
            articoloDAO.save(rivista);

            Prestito prestito = new Prestito(utente, libro, LocalDate.now());
            em.getTransaction().begin();
            em.persist(prestito);
            em.getTransaction().commit();
            System.out.println("Prestito registrato con successo!");
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
