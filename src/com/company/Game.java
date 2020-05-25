package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener, ActionListener {

    public Window panel;                        // creates an instance of the Window class called "panel"
    Spacecraft ship;                            // creates an instance of VectorSprite called "ship"
    ArrayList<Asteroid> asteroidList;           // A list of asteroid objects
    Timer timer;
    Image offscreen;                            // an image to be loaded offscreen
    Graphics offg;                              // a graphics object to go along with the offscreen image

    boolean upKey, leftKey, rightKey;           //fixes key locking

    public void init() {                                                          // this method sets the initial conditions of the game
        this.setVisible(true);
        this.setSize(900, 600);                                     // gives the game window a title
        this.setTitle("Asteroids - by John Doe");                               // gives the game window a title
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);               // freezes the size of the window
        this.addKeyListener(this);
        add(this.panel = new Window(this), BorderLayout.CENTER);
        offscreen = createImage(this.getWidth(), this.getHeight());
        offg = offscreen.getGraphics();
        ship = new Spacecraft();
        timer = new Timer(20, this);
        asteroidList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            asteroidList.add(new Asteroid());
        }
        pack();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyCheck();
        respawnShip();
        ship.updatePosition();
        for(int i = 0; i < asteroidList.size(); i++) {
            asteroidList.get(i).updatePosition();
        }
        checkCollisions();
    }

    public boolean collision(VectorSprite thing1, VectorSprite thing2) {

        int x, y;

        for(int i = 0; i < thing1.drawShape.npoints; i++) {

            x = thing1.drawShape.xpoints[i];
            y = thing1.drawShape.ypoints[i];

            if(thing2.drawShape.contains(x, y)) {
                return true;
            }
        }

        for(int i = 0; i < thing2.drawShape.npoints; i++) {

            x = thing2.drawShape.xpoints[i];
            y = thing2.drawShape.ypoints[i];

            if(thing1.drawShape.contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void checkCollisions() {

        for(int i = 0; i < asteroidList.size(); i++){
            if(collision(ship, asteroidList.get(i))) {
                ship.hit();
            }
        }

    }

        public void respawnShip() {

            if(ship.active == false && ship.counter > 50 && isRespawnSafe()) {
                ship.reset();
            }

        }

    public boolean isRespawnSafe() {

        int x, y, h;

        for(int i = 0; i < asteroidList.size(); i++){

            x = (int) (asteroidList.get(i).xposition - 450);
            y = (int) (asteroidList.get(i).yposition - 300);
            h = (int) Math.sqrt( (x * x) + (y * y) );

            if(h < 100) {
                return false;
            }

        }

        return true;

    }


    /////KEY EVENTS

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upKey = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKey = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKey = true;
        }

        repaint();
    }

    private void keyCheck() {

        if(upKey) {
            ship.accelerate();
        }

        if(leftKey) {
            ship.rotateLeft();
        }

        if(rightKey) {
            ship.rotateRight();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upKey = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKey = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKey = false;
        }

    }

}






