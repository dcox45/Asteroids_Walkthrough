package com.company;

import java.awt.*;

public class VectorSprite {

    Polygon shape, drawShape;          // each VectorSprite will have 2 Polygons, for rotation and drawing

    double xposition;
    double yposition;
    double xspeed;
    double yspeed;
    double angle;
    double ROTATION;                // a constant that represents the amount of change in angle

    public VectorSprite() {
        shape = new Polygon();
        shape.addPoint(15, 0);
        shape.addPoint(-10, 10);
        shape.addPoint(-10, -10);

        drawShape = new Polygon();
        drawShape.addPoint(15, 0);
        drawShape.addPoint(-10, 10);
        drawShape.addPoint(-10, -10);

        xposition = 450;
        yposition = 300;
    }

    public void paint(Graphics g) {

        g.drawPolygon(drawShape);

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

            drawShape.xpoints[i] = x;
            drawShape.ypoints[i] = y;
        }
        drawShape.translate((int)Math.round(xposition), (int)Math.round(yposition));

    }

}















