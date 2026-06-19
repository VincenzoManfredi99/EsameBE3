package vincenzomanfredi.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends Articolo {

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicita")
    Periodicita periodicita;

    protected Rivista() {
    }

    public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, int nPagine, Periodicita periodicita) {
        super(codiceIsbn, titolo, annoPubblicazione, nPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista -> " + super.toString() +
                " Periodicità=" + periodicita;
    }

}
