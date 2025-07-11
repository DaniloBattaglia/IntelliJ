package appaJava;

public abstract class Utente implements UtenteAutobus {
    protected String nome;
    protected String cognome;
    protected String codiceFiscale;

    public Utente(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String getNomeCompleto() {
        return nome + " " + cognome;
    }
}
