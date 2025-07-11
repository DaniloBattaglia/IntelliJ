package appaJava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestionePrenotazioni extends JFrame {

    private int maxPasseggeri = 20;
    private int maxAutisti = 2;

    private JLabel labelPasseggeri;
    private JLabel labelAutisti;

    private ArrayList<UtenteAutobus> utenti = new ArrayList<>();

    public GestionePrenotazioni() {
        setTitle("Prenotazione Autobus");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnAggiungiPasseggero = new JButton("Aggiungi passeggero");
        JButton btnAggiungiAutista = new JButton("Aggiungi autista");

        labelPasseggeri = new JLabel("Posti passeggeri disponibili: " + maxPasseggeri);
        labelAutisti = new JLabel("Posti autisti disponibili: " + maxAutisti);

        btnAggiungiPasseggero.addActionListener(e -> {
            try {
                aggiungiPasseggero();
            } catch (PostiEsauritiPasseggeroException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnAggiungiAutista.addActionListener(e -> {
            try {
                aggiungiAutista();
            } catch (PostiEsauritiAutistaException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setLayout(new GridLayout(4, 1));
        add(labelPasseggeri);
        add(labelAutisti);
        add(btnAggiungiPasseggero);
        add(btnAggiungiAutista);

        setVisible(true);
    }

    private void aggiungiPasseggero() throws PostiEsauritiPasseggeroException {
        if (maxPasseggeri <= 0) throw new PostiEsauritiPasseggeroException("Posti passeggeri esauriti!");
        Passeggero p = new Passeggero("Mario", "Rossi", "RSSMRA90X01", "Roma", true);
        utenti.add(p);
        maxPasseggeri--;
        labelPasseggeri.setText("Posti passeggeri disponibili: " + maxPasseggeri);
    }

    private void aggiungiAutista() throws PostiEsauritiAutistaException {
        if (maxAutisti <= 0) throw new PostiEsauritiAutistaException("Posti autisti esauriti!");
        Autista a = new Autista("Luigi", "Verdi", "VRDLGU80X01", "D", 10);
        utenti.add(a);
        maxAutisti--;
        labelAutisti.setText("Posti autisti disponibili: " + maxAutisti);
    }
}
