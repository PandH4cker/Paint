package vuecontrole;

import modele.EnumCouleur;
import modele.EnumForme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarreHaute extends JPanel implements ActionListener {
    private JComboBox<EnumCouleur> couleurs;
    private JComboBox<EnumForme> formes;
    private JButton effacer, defaire, gomme;
    private Fenetre fenetre;
    private boolean isErasing = false;

    public BarreHaute(final Fenetre fenetre) {
        super();
        this.fenetre = fenetre;
        this.couleurs = new JComboBox<>(EnumCouleur.values());
        this.couleurs.addActionListener(this);
        this.add(this.couleurs);

        this.formes = new JComboBox<>(EnumForme.values());
        this.formes.addActionListener(this);
        this.add(this.formes);

        this.effacer = new JButton("Effacer");
        this.effacer.addActionListener(new EcouteurEffacer());
        this.add(this.effacer);

        this.defaire = new JButton("Défaire");
        class EcouteurDefaire implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.defaire();
            }
        }
        this.defaire.addActionListener(new EcouteurDefaire());
        this.add(this.defaire);

        this.gomme = new JButton("Activer gomme");
        this.gomme.addActionListener(e -> {
            this.isErasing = !this.isErasing;
            if (isErasing) {
                fenetre.activerGomme();
                this.gomme.setText("Désactiver gomme");
            }
            else {
                fenetre.desactiverGomme();
                this.gomme.setText("Activer gomme");
            }
        });
        this.add(this.gomme);
    }

    class EcouteurEffacer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fenetre.effacer();
        }
    }

    public EnumCouleur getCouleurSelectionnee() {
        return (EnumCouleur) this.couleurs.getSelectedItem();
    }

    public EnumForme getFormeSelectionnee() {
        return (EnumForme) this.formes.getSelectedItem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.formes))
            System.out.println(getFormeSelectionnee());
        if (e.getSource().equals(this.couleurs))
            System.out.println(getCouleurSelectionnee());
    }
}
