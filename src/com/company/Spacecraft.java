package com.company;

import java.awt.*;

public class Spacecraft extends VectorSprite {

    int lives;

    public Spacecraft() {
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

        ROTATION = 0.1;
        THRUST = 0.25;

        active = true;
        lives = 3;
    }

    public void accelerate() {
        xspeed += Math.cos(angle) * THRUST;
        yspeed += Math.sin(angle) * THRUST;
    }

    public void rotateLeft(){
        angle -= ROTATION;
    }

    public void rotateRight(){
        angle += ROTATION;
    }

    public void hit() {
        active = false;
        counter = 0;
        lives --;
    }

    public void reset() {
        xposition = 450;
        yposition = 300;
        xspeed = 0;
        yspeed = 0;
        angle = 0;
        active = true;
    }

}
