package com.company;

import java.awt.*;

public class Asteroid extends VectorSprite{

    int size;

    public Asteroid() {
        size = 3;
        initializeAsteroid();
    }

    public Asteroid(double x, double y, int s) {
        size = s;
        initializeAsteroid();
        xposition = x;
        yposition = y;
    }

    public void initializeAsteroid() {
        shape = new Polygon();
        shape.addPoint(15 * size, 3 * size);
        shape.addPoint(5 * size, 17 * size);
        shape.addPoint(-12 * size, 5 * size);
        shape.addPoint(-8 * size, -8 * size);
        shape.addPoint(10 * size, -17 * size);

        drawShape = new Polygon();
        drawShape.addPoint(15 * size, 3 * size);
        drawShape.addPoint(5 * size, 17 * size);
        drawShape.addPoint(-12 * size, 5 * size);
        drawShape.addPoint(-8 * size, -8 * size);
        drawShape.addPoint(10 * size, -17 * size);

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
