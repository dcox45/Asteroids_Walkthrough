package com.company;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public void init(){                                      // this method sets the initial conditions of the game
        this.setVisible(true);
        this.setSize(900, 600);                 // gives the game window a title
        this.setTitle("Asteroids - by John Doe");           // gives the game window a title
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // freezes the size of the window
    }

    public void paint(Graphics g){
        
    }


}




// freezes the size of the window

// gives the game window a title

// sets the game window to 900 pixels wide and 600 in height

// this method sets the initial conditions of the game