package vuecontrole;

import modele.EnumCouleur;
import modele.EnumForme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarreHaute extends JPanel implements ActionListener {
    private JComboBox<EnumCouleur> couleurs;
    private JComboBox<EnumForme> formes;

    public BarreHaute() {
        super();
        this.couleurs = new JComboBox<>(EnumCouleur.values());
        this.couleurs.addActionListener(this);
        this.add(this.couleurs);

        this.formes = new JComboBox<>(EnumForme.values());
        this.formes.addActionListener(this);
        this.add(this.formes);
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
