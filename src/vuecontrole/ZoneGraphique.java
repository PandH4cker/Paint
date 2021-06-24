package vuecontrole;

import modele.Droite;
import modele.Forme;
import modele.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

public class ZoneGraphique extends JPanel implements MouseListener, MouseMotionListener {
    private BarreBasse barreBasse;
    private BarreHaute barreHaute;
    private Point pInit, pFin;
    private boolean isPainting;
    private List<Forme> formes;

    public ZoneGraphique(final BarreBasse barreBasse,
                         final BarreHaute barreHaute) {
        super();
        this.setBackground(Color.WHITE);
        this.barreHaute = barreHaute;
        this.barreBasse = barreBasse;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.isPainting = false;
        this.formes = new LinkedList<>();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Forme f : formes)
            f.seDessiner(g);
    }

    private void dessin() {
        Forme f = null;
        Color color = this.barreHaute.getCouleurSelectionnee().getColor();
        switch (this.barreHaute.getFormeSelectionnee()) {
            case DROITE -> f = new Droite(color, this.pInit, this.pFin);
            case CERCLE -> {

            }
            case TRIANGLE -> {

            }
            case RECTANGLE -> {

            }
            default -> f = new Droite(color, this.pInit, this.pFin);
        }
        f.seDessiner(this.getGraphics());
        if (isPainting && this.formes.size() > 0)
            this.formes.remove(this.formes.size() - 1);
        this.formes.add(f);
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.pInit = new Point(e.getX(), e.getY());
        this.barreBasse.setMessage("Relâchez pour voir la forme");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.pFin = new Point(e.getX(), e.getY());
        this.isPainting = false;
        this.barreBasse.setMessage("Cliquez pour initier une forme");
        this.dessin();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        barreBasse.deplacementSouris(e);
        this.pFin = new Point(e.getX(), e.getY());
        isPainting = true;
        this.dessin();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.barreBasse.deplacementSouris(e);
    }
}
