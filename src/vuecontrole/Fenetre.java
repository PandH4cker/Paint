package vuecontrole;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    private String title;
    private int width;
    private int height;
    private BarreBasse barreBasse;
    private BarreHaute barreHaute;
    private ZoneGraphique zoneGraphique;
    private EcouteurFenetre ecouteurFenetre = new EcouteurFenetre();

    public Fenetre(final String title, final int width, final int height) {
        super();
        this.title = title;
        this.width = width;
        this.height = height;
        this.setTitle(this.title);
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);

        this.barreHaute = new BarreHaute();
        this.barreBasse = new BarreBasse("Souris", "x", "y");
        this.zoneGraphique = new ZoneGraphique(barreBasse, barreHaute);

        this.add(this.barreHaute, BorderLayout.NORTH);
        this.add(this.barreBasse, BorderLayout.SOUTH);

        this.add(this.zoneGraphique, BorderLayout.CENTER);

        this.addWindowListener(this.ecouteurFenetre);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Fenetre("Jeunoizal", 800, 600);
    }
}
