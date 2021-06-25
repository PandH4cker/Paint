package modele;

import java.awt.*;

public class Rectangle extends Forme{
    private Point topLeftCorner,
                  topRightCorner,
                  bottomLeftCorner,
                  bottomRightCorner;

    public Rectangle(final Color color,
                        final Point pInit,
                        final Point pFin) {
        super(color);
        this.topLeftCorner = pInit;
        this.bottomRightCorner = pFin;
        this.topRightCorner = new Point(pFin.getX(), pInit.getY());
        this.bottomLeftCorner = new Point(pInit.getX(), pFin.getY());
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawLine(
                this.topLeftCorner.getX(),
                this.topLeftCorner.getY(),
                this.topRightCorner.getX(),
                this.topRightCorner.getY()
        );
        g.drawLine(
                this.topRightCorner.getX(),
                this.topRightCorner.getY(),
                this.bottomRightCorner.getX(),
                this.bottomRightCorner.getY()
        );
        g.drawLine(
                this.bottomRightCorner.getX(),
                this.bottomRightCorner.getY(),
                this.bottomLeftCorner.getX(),
                this.bottomLeftCorner.getY()
        );
        g.drawLine(
                this.bottomLeftCorner.getX(),
                this.bottomLeftCorner.getY(),
                this.topLeftCorner.getX(),
                this.topLeftCorner.getY()
        );
    }
}
