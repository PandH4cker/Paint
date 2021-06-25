package vuecontrole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{
    private String title;
    private int width;
    private int height;
    private BarreBasse barreBasse;
    private BarreHaute barreHaute;
    private ZoneGraphique zoneGraphique;
    private EcouteurFenetre ecouteurFenetre = new EcouteurFenetre();
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem closeItem;

    public Fenetre(final String title, final int width, final int height) {
        super();
        this.title = title;
        this.width = width;
        this.height = height;
        this.setTitle(this.title);
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);

        this.barreHaute = new BarreHaute(this);
        this.barreBasse = new BarreBasse("Souris", "x", "y");
        this.zoneGraphique = new ZoneGraphique(barreBasse, barreHaute);

        this.add(this.barreHaute, BorderLayout.NORTH);
        this.add(this.barreBasse, BorderLayout.SOUTH);

        this.add(this.zoneGraphique, BorderLayout.CENTER);

        this.addWindowListener(this.ecouteurFenetre);

        this.menuBar = new JMenuBar();

        this.fileMenu = new JMenu("Fichier");

        this.closeItem = new JMenuItem("Fermer");
        this.closeItem.addActionListener(e -> {
            System.exit(0);
        });
        this.fileMenu.add(this.closeItem);

        this.menuBar.add(this.fileMenu);

        this.setJMenuBar(this.menuBar);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void effacer() {
        this.zoneGraphique.effacer();
    }

    public void defaire() {
        this.zoneGraphique.defaire();
    }

    public void activerGomme() {
        this.zoneGraphique.activerGomme();
    }

    public void desactiverGomme() {
        this.zoneGraphique.desactiverGomme();
    }

    public static void main(String[] args) {
        new Fenetre("Jeunoizal", 800, 600);
    }
}
