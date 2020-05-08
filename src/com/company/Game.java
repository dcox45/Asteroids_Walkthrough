package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener, ActionListener {

    public Window panel;    // creates an instance of the Window class called "panel"
    VectorSprite ship;      // creates an instance of VectorSprite called "ship"
    Timer timer;
    Image offscreen;        // an image to be loaded offscreen
    Graphics offg;          // a graphics object to go along with the offscreen image

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
        ship = new VectorSprite();
        timer = new Timer(20, this);
        pack();
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship.angle += 1;
            ship.xspeed += 1;
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ship.angle -= 1;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ship.updatePosition();
    }

}






