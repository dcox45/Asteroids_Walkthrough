package com.company;

import java.awt.*;

public class Debris extends VectorSprite{

    public Debris(double x, double y){
        shape = new Polygon();

        shape.addPoint(1, 1);
        shape.addPoint(-1, 1);
        shape.addPoint(-1, -1);
        shape.addPoint(1, -1);

        drawShape = new Polygon();

        drawShape.addPoint(1, 1);
        drawShape.addPoint(-1, 1);
        drawShape.addPoint(-1, -1);
        drawShape.addPoint(1, -1);

        xposition = x;
        yposition = y;

        THRUST = 10;

        double a;
        a = Math.random() * 2 * Math.PI;
        xspeed = Math.cos(a) * a;
        yspeed = Math.sin(a) * a;

        active = true;
    }

}
