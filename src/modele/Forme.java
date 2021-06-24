package modele;

import java.awt.*;

public abstract class Forme {
    protected Color color;

    protected Forme(final Color color) {
        this.color = color;
    }

    public void seDessiner(Graphics g) {
        g.setColor(this.color);
    }
}
