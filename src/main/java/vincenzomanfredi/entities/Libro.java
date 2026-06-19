package vincenzomanfredi.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Libro extends Articolo {

    private String autore;
    private String genere;

    protected Libro() {

    }

    public Libro(String codiceIsbn, String titolo, int annoPubblicazione, int nPagine, String autore, String genere) {
        super(codiceIsbn, titolo, annoPubblicazione, nPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro -> " + super.toString() +
                " Autore=" + autore +
                ", Genere=" + genere;
    }

}
