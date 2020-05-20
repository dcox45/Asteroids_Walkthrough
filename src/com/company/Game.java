package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener, ActionListener {

    public Window panel;    // creates an instance of the Window class called "panel"
    Spacecraft ship;      // creates an instance of VectorSprite called "ship"
    Asteroid rock;
    Timer timer;
    Image offscreen;        // an image to be loaded offscreen
    Graphics offg;          // a graphics object to go along with the offscreen image

    boolean upKey, leftKey, rightKey;           //fixes key locking

    public void init(){                                                          // this method sets the initial conditions of the game
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
        rock = new Asteroid();
        timer = new Timer(20, this);
        pack();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keyCheck();
        ship.updatePosition();
        rock.updatePosition();
    }

    public boolean collision(){

        int x, y;

        for(int i = 0; i < ship.drawShape.npoints; i++) {

            x = ship.drawShape.xpoints[i];
            y = ship.drawShape.ypoints[i];

            if(rock.drawShape.contains(x, y)) {
                return true;
            }
        }

        for(int i = 0; i < rock.drawShape.npoints; i++) {

            x = rock.drawShape.xpoints[i];
            y = rock.drawShape.ypoints[i];

            if(ship.drawShape.contains(x, y)) {
                return true;
            }
        }

        return false;

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






