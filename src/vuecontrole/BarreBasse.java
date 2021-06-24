package vuecontrole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class BarreBasse extends JPanel {
    private JLabel message;
    private JLabel x;
    private JLabel y;

    public BarreBasse(final String message, final String x, final String y) {
        super();
        this.message = new JLabel(message);
        this.message.setForeground(Color.GREEN);
        this.x = new JLabel(x);
        this.x.setForeground(Color.CYAN);
        this.y = new JLabel(y);
        this.y.setForeground(Color.ORANGE);
        this.add(this.message);
        this.add(this.x);
        this.add(this.y);
        this.setBackground(Color.MAGENTA);
    }

    public void deplacementSouris(MouseEvent event) {
        if (event == null) return;
        this.x.setText(String.valueOf(event.getX()));
        this.y.setText(String.valueOf(event.getY()));
    }

    public JLabel getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public JLabel getXtkt() {
        return x;
    }

    public void setX(JLabel x) {
        this.x = x;
    }

    public JLabel getYtkt() {
        return y;
    }

    public void setY(JLabel y) {
        this.y = y;
    }
}
