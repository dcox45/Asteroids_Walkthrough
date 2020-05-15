package com.company;

public class Spacecraft extends VectorSprite {

    public Spacecraft() {
        ROTATION = 0.1;
        THRUST = 5;
    }

    public void accelerate() {
        xspeed += Math.cos(angle) / THRUST;
        yspeed += Math.sin(angle) / THRUST;
    }

    public void rotateLeft(){
        angle -= ROTATION;
    }

    public void rotateRight(){
        angle += ROTATION;
    }

}
