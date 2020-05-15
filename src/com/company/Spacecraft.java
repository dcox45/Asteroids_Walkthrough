package com.company;

public class Spacecraft extends VectorSprite {

    public void accelerate() {
        xspeed += Math.cos(angle);
        yspeed += Math.sin(angle);
    }

}
