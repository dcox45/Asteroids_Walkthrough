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

    public void updatePosition() {
        xposition += xspeed;
        yposition += yspeed;

        int x, y;
        for(int i = 0; i < shape.npoints; i++) {
            //shape.xpoints[i] += xspeed;
            //shape.ypoints[i] += yspeed;

            x = (int)Math.round(shape.xpoints[i]*Math.cos(angle) - shape.ypoints[i] * Math.sin(angle));
            y = (int)Math.round(shape.xpoints[i]*Math.sin(angle) + shape.ypoints[i] * Math.cos(angle));

            shape.xpoints[i] = x;
            shape.ypoints[i] = y;
        }

    }

}















