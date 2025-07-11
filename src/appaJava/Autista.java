package appaJava;

public class Autista extends Utente {
    private String patente;
    private int anniEsperienza;

    public Autista(String nome, String cognome, String cf, String patente, int anniEsperienza) {
        super(nome, cognome, cf);
        this.patente = patente;
        this.anniEsperienza = anniEsperienza;
    }

    @Override
    public String getTipo() {
        return "Autista";
    }
}

