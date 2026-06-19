package vincenzomanfredi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "articolo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_articolo")
public abstract class Articolo {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "codice_isbn", unique = true)
    private String codiceIsbn;

    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "numero_pagine")
    private int nPagine;

    protected Articolo() {
    }

    public Articolo(String codiceIsbn, String titolo, int annoPubblicazione, int nPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.nPagine = nPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(String codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNpagine() {
        return nPagine;
    }

    public void setNpagine(int nPagine) {
        this.nPagine = nPagine;
    }
}
