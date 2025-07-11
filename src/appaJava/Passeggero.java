package appaJava;

public class Passeggero extends Utente {
    private String destinazione;
    private boolean haBagaglio;

    public Passeggero(String nome, String cognome, String cf, String destinazione, boolean haBagaglio) {
        super(nome, cognome, cf);
        this.destinazione = destinazione;
        this.haBagaglio = haBagaglio;
    }

    @Override
    public String getTipo() {
        return "Passeggero";
    }
}
