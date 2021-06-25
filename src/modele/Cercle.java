package modele;

import java.awt.*;

public class Cercle extends Forme{
    private Point topLeftCorner;
    private Point bottomRightCorner;

    public Cercle(final Color color,
                  final Point pInit,
                  final Point pFin) {
        super(color);
        int x1 = pInit.getX();
        int y1 = pInit.getY();
        int x2 = pFin.getX();
        int y2 = pFin.getY();


        if(x1 <= x2) {
            if(y1 >= y2) { //Si pInit en haut à gauche (cas de base)
                this.topLeftCorner = new Point(x1, y2);
                this.bottomRightCorner = new Point(x2, y1);
            } else { //Si pInit en bas à gauche
                this.topLeftCorner = pInit;
                this.bottomRightCorner = pFin;
            }
        } else {
            if(y1 >= y2) { //Si pInit en bas à droite
                this.topLeftCorner = pFin;
                this.bottomRightCorner = pInit;
            } else { // Si pInit en haut à droite
                this.topLeftCorner = new Point(x2, y1);
                this.bottomRightCorner = new Point(x1, y2);
            }
        }
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawOval(
                this.topLeftCorner.getX(),
                this.topLeftCorner.getY(),
                Math.abs(this.bottomRightCorner.getX() - this.topLeftCorner.getX()),
                Math.abs(this.bottomRightCorner.getY() - this.topLeftCorner.getY())
        );
    }
}
