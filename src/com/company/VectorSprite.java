package com.company;

import java.awt.*;

public class VectorSprite {

    Polygon shape;          // each VectorSprite will have a Polygon

    double xposition;
    double yposition;
    double xspeed;
    double yspeed;
    double angle;

    public VectorSprite() {
        shape = new Polygon();

        shape.addPoint(15, 20);
        shape.addPoint(0, 50);
        shape.addPoint(30, 50);
    }

    public void paint(Graphics g) {
        g.drawPolygon(shape);
    }

}
