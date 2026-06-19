package vincenzomanfredi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vincenzomanfredi.dao.ArticoloDAO;
import vincenzomanfredi.entities.Articolo;
import vincenzomanfredi.exceptions.NotFoundException;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ArticoloDAO articoloDAO = new ArticoloDAO(em);
        try {
            /*Utente utente = new Utente("Pippo", "Bianchi", LocalDate.of(1999, 3, 1), 56789);
            em.getTransaction().begin();
            em.persist(utente);
            em.getTransaction().commit();
            System.out.println("Utente salvato con successo!");

            Libro libro = new Libro("000-222", "Noi", 1980, 303, "Zamjatin", "Distopia");
            articoloDAO.save(libro);

            Rivista rivista = new Rivista("000-333", "Focus Storico", 2019, 40, Periodicita.SETTIMANALE);
            articoloDAO.save(rivista);

            Prestito prestito = new Prestito(utente, libro, LocalDate.now());
            em.getTransaction().begin();
            em.persist(prestito);
            em.getTransaction().commit();
            System.out.println("Prestito registrato con successo!");

            Articolo articoloCercato = articoloDAO.findById(UUID.fromString("1bd25eb8-70c9-4f75-b5df-cf97674d7991"));
            System.out.println(articoloCercato);*/

            Articolo articoloCercatoIsbn = articoloDAO.findByIsbn("000-333");
            System.out.println(articoloCercatoIsbn);


        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
