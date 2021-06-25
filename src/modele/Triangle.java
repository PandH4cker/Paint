package modele;

import java.awt.*;

public class Triangle extends Forme{
    private Point top, left, right;

    public Triangle(final Color color,
                    final Point pInit,
                    final Point pFin) {
        super(color);
        this.left = pInit;
        this.right = pFin;
        this.top = new Point((pInit.getX() + pFin.getX())/2, pInit.getY());
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawLine(
                this.left.getX(),
                this.left.getY(),
                this.right.getX(),
                this.right.getY()
        );
        g.drawLine(
                this.right.getX(),
                this.right.getY(),
                this.top.getX(),
                this.top.getY()
        );
        g.drawLine(
                this.top.getX(),
                this.top.getY(),
                this.left.getX(),
                this.left.getY()
        );
    }
}
