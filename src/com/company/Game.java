package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    int x1, y1, x2, y2;     // these are the x and y coordinates of our line
    int[] x;                // declaring an array of x coordinates for our Polygon
    int[] y;                // and an array of y coordinates

    public void init(){                                                          // this method sets the initial conditions of the game
        this.setVisible(true);
        this.setSize(900, 600);                                     // gives the game window a title
        this.setTitle("Asteroids - by John Doe");                               // gives the game window a title
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);               // freezes the size of the window
        this.addKeyListener(this);
        x = new int[3];
        x[0] = 15;
        x[1] = 0;
        x[2] = 30;
        y = new int[] {20, 50, 50};
    }

    public void paint(Graphics g){
        g.fillRect(0, 0, 900, 600);
        g.setColor(Color.GREEN);
        g.drawPolygon(x, y, x.length);
    }

    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x1 = x1 + 10;
            x2 = x2 + 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}






