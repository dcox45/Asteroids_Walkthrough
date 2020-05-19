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
    double THRUST;                  // represents the acceleration

    public VectorSprite() {

    }

    public void paint(Graphics g) {

        g.drawPolygon(drawShape);

    }


    public void updatePosition() {
        xposition += xspeed;
        yposition += yspeed;

        wraparound();

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

    private void wraparound() {

        if (xposition > 900) {
            xposition = 0;
        }

        if (xposition < 0) {
            xposition = 900;
        }

        if (yposition > 600) {
            yposition = 0;
        }

        if (yposition < 0) {
            yposition = 600;
        }

    }

}















