package modele;

import java.awt.*;

public class Gomme extends Forme{
    private Point center;
    private int radius;

    public Gomme(final Color color,
                 final Point pInit,
                 final int radius) {
        super(color);
        this.center = pInit;
        this.radius = radius;
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.fillOval(
                this.center.getX()-this.radius/2,
                this.center.getY()-this.radius/2,
                this.radius,
                this.radius
        );
    }
}
