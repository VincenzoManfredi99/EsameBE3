package vincenzomanfredi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Column(name = "codice_tessera")
    private int codiceTessera;

    public Utente() {

    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, int codiceTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codiceTessera = codiceTessera;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getCodiceTessera() {
        return codiceTessera;
    }

    public void setCodiceTessera(int codiceTessera) {
        this.codiceTessera = codiceTessera;
    }
}


