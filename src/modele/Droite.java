package modele;

import java.awt.*;

public class Droite extends Forme{
    private Point pInit, pFin;

    public Droite(final Color color,
                  final Point pInit,
                  final Point pFin) {
        super(color);
        this.pInit = pInit;
        this.pFin = pFin;
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        g.drawLine(
                this.pInit.getX(),
                this.pInit.getY(),
                this.pFin.getX(),
                this.pFin.getY()
        );
    }
}
