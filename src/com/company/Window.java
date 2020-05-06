package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    private Game game;

    public Window(Game game){
        this.game = game;

        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.fillRect(0, 0, 900, 600);
        g.setColor(Color.GREEN);
        game.ship.paint(g);
        repaint();

    }

}
