package com.company;

import java.awt.*;

public class Asteroid extends VectorSprite{

    public Asteroid() {
        shape = new Polygon();
        shape.addPoint(30, 3);
        shape.addPoint(5, 35);
        shape.addPoint(-25, 10);
        shape.addPoint(-17, -15);
        shape.addPoint(20, -35);

        drawShape = new Polygon();
        drawShape.addPoint(30, 3);
        drawShape.addPoint(5, 35);
        drawShape.addPoint(-25, 10);
        drawShape.addPoint(-17, -15);
        drawShape.addPoint(20, -35);

        xposition = 450;
        yposition = 300;

        ROTATION = Math.random() / 4;
        THRUST = 0.25;

        double h, a;
        h = Math.random() + 1;
        a = Math.random() * (2 * Math.PI);
        xspeed = Math.cos(a) * h;
        yspeed = Math.sin(a) * h;

        h = Math.random() * 400 + 100;
        a = Math.random() * (2   * Math.PI);
        xposition = Math.cos(a) * h + 450;
        yposition = Math.sin(a) * h + 300;

        active = true;
    }

    public void updatePosition() {
        angle += ROTATION;
        super.updatePosition();
    }

}
