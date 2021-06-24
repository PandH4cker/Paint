package modele;

import java.awt.*;

public enum EnumCouleur {
    VERT("Vert", Color.GREEN),
    MAGENTA("Magenta", Color.MAGENTA),
    CYAN("Cyan", Color.CYAN),
    ORANGE("Orange", Color.ORANGE),
    BLANC("Blanc", Color.WHITE);

    private String name;
    private Color color;
    EnumCouleur(final String name, final Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
