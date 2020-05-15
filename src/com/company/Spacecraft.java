package com.company;

public class Spacecraft extends VectorSprite {

    public void accelerate() {
        xspeed += Math.cos(angle) / 5;
        yspeed += Math.sin(angle) / 5;
    }

    public void rotateLeft(){
        angle -= 0.1;
    }

    public void rotateRight(){
        angle += 0.1;
    }

}
