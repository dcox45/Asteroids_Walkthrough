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

        shape.addPoint(15, 0);
        shape.addPoint(0, 30);
        shape.addPoint(30, 30);
    }

    public void paint(Graphics g) {
        g.drawPolygon(shape);
    }

}
