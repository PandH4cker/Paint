package modele;

import java.awt.*;

public class Camion extends Forme{
    private static final int GAP = 3;
    private static final int SQUARE_RIGHT_WIDTH = 35;

    private Point squareLeftTopLeftCorner,
                  squareLeftBottomRightCorner;

    private Point circleLeftTopLeftCorner,
                  circleLeftBottomRightCorner;

    private Point circleRightTopLeftCorner,
                  circleRightBottomRightCorner;

    private Point squareRightTopLeftCorner,
                  squareRightBottomRightCorner;

    private Point squareInsideTopLeftCorner,
                  squareInsideBottomRightCorner;

    public Camion(final Color color,
                     final Point pInit,
                     final Point pFin) {
        super(color);
        this.squareLeftTopLeftCorner = pInit;
        this.squareLeftBottomRightCorner = new Point(Math.abs(pFin.getX() - SQUARE_RIGHT_WIDTH), pFin.getY());

        this.squareRightTopLeftCorner = new Point(Math.abs(pFin.getX() - SQUARE_RIGHT_WIDTH) + GAP, Math.abs(pFin.getY() - 4 * (pFin.getY() - pInit.getY())/5));
        this.squareRightBottomRightCorner = pFin;

        this.squareInsideTopLeftCorner = new Point(
                this.squareRightTopLeftCorner.getX() + GAP,
                this.squareRightTopLeftCorner.getY() + GAP
        );
        this.squareInsideBottomRightCorner = new Point(
                squareInsideTopLeftCorner.getX() + Math.abs(this.squareInsideTopLeftCorner.getX() - this.squareRightBottomRightCorner.getX()) - GAP,
                squareInsideTopLeftCorner.getY() + Math.abs(this.squareInsideTopLeftCorner.getY() - this.squareRightBottomRightCorner.getY())/3
        );

        this.circleRightTopLeftCorner = new Point(
            this.squareLeftBottomRightCorner.getX(),
            Math.abs(this.squareLeftBottomRightCorner.getY() - GAP)
        );

        this.circleRightBottomRightCorner = new Point(
                Math.abs(this.squareLeftBottomRightCorner.getX() - Math.abs(this.squareLeftTopLeftCorner.getX() - this.squareLeftBottomRightCorner.getX())/8),
                Math.abs(this.squareLeftBottomRightCorner.getY() - GAP) +
                        Math.abs(this.squareLeftTopLeftCorner.getY() - this.squareLeftBottomRightCorner.getY())/8
        );

        this.circleLeftTopLeftCorner = new Point(
                this.squareLeftTopLeftCorner.getX() + GAP,
                Math.abs(this.squareLeftBottomRightCorner.getY() - GAP)
        );

        this.circleLeftBottomRightCorner = new Point(
                Math.abs(this.squareLeftTopLeftCorner.getX() + GAP + Math.abs(this.squareLeftTopLeftCorner.getX() - this.squareLeftBottomRightCorner.getX())/8),
                Math.abs(this.squareLeftBottomRightCorner.getY() - GAP) +
                        Math.abs(this.squareLeftTopLeftCorner.getY() - this.squareLeftBottomRightCorner.getY())/8
        );
    }

    @Override
    public void seDessiner(Graphics g) {
        super.seDessiner(g);
        Rectangle squareLeft =
                new Rectangle(g.getColor(), this.squareLeftTopLeftCorner, this.squareLeftBottomRightCorner);
        Rectangle squareRight =
                new Rectangle(g.getColor(), this.squareRightTopLeftCorner, this.squareRightBottomRightCorner);
        Rectangle squareInside =
                new Rectangle(g.getColor(), this.squareInsideTopLeftCorner, this.squareInsideBottomRightCorner);
        Cercle circleRight =
                new Cercle(g.getColor(), this.circleRightTopLeftCorner, this.circleRightBottomRightCorner);
        Cercle circleLeft =
                new Cercle(g.getColor(), this.circleLeftTopLeftCorner, this.circleLeftBottomRightCorner);

        squareLeft.seDessiner(g);
        squareRight.seDessiner(g);
        squareInside.seDessiner(g);
        circleRight.seDessiner(g);
        circleLeft.seDessiner(g);
    }
}
