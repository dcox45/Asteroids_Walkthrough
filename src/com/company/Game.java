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
    ArrayList<Asteroid> asteroidList;           // a list of asteroid objects
    ArrayList<Bullet> bulletList;               // a list of bullet objects
    Timer timer;
    Image offscreen;                            // an image to be loaded offscreen
    Graphics offg;                              // a graphics object to go along with the offscreen image

    int score;

    boolean upKey, leftKey, rightKey, spaceKey;           //fixes key locking

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
        bulletList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            asteroidList.add(new Asteroid());
        }
        score = 0;
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
        for(int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).updatePosition();
            if(bulletList.get(i).counter == 90 || bulletList.get(i).active == false) {
                bulletList.remove(i);
            }
        }
        checkCollisions();
        checkAsteroidDestruction();
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
                if(collision(ship, asteroidList.get(i)) && ship.active) {
                    score -= 20;
                    ship.hit();
                }

                for(int j = 0; j < bulletList.size(); j++){

                    if(collision(bulletList.get(j), asteroidList.get(i))){
                        score += 20;
                        bulletList.get(j).active = false;
                        asteroidList.get(i).active = false;
                    }
                }
            }
        }

        public void respawnShip() {

            if(ship.active == false && ship.counter > 50 && isRespawnSafe() && ship.lives > 0) {
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

    public void fireBullet() {
        if(ship.counter > 5 && ship.active) {
            bulletList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle));
            ship.counter = 0;
        }
    }

    public void checkAsteroidDestruction() {

        for(int i = 0; i < asteroidList.size(); i++){

            if(asteroidList.get(i).active == false) {
                if(asteroidList.get(i).size > 1){
                    asteroidList.add(new Asteroid(asteroidList.get(i).xposition, asteroidList.get(i).yposition, asteroidList.get(i).size - 1));
                    asteroidList.add(new Asteroid(asteroidList.get(i).xposition, asteroidList.get(i).yposition, asteroidList.get(i).size - 1));
                }
                asteroidList.remove(i);
            }
        }
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

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceKey = true;
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

        if(spaceKey) {
            fireBullet();
            if(ship.counter > 5 && ship.active) {
                bulletList.add(new Bullet(ship.drawShape.xpoints[0], ship.drawShape.ypoints[0], ship.angle));
                ship.counter = 0;
            }
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

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceKey = false;
        }

    }

}






