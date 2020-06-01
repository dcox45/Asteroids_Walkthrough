package com.company;

import com.sun.media.sound.SoftFilter;

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.offg.setColor(Color.BLACK);
        game.offg.fillRect(0, 0, 900, 600);
        game.offg.setColor(Color.GREEN);
        game.offg.drawString("Lives: " + game.ship.lives, 20, 580);
        if(game.ship.active) {
            game.ship.paint(game.offg);
        }
        for(int i = 0; i < game.asteroidList.size(); i++) {
            game.asteroidList.get(i).paint(game.offg);
        }
        for(int i = 0; i < game.bulletList.size(); i++) {
            game.bulletList.get(i).paint(game.offg);
        }
        if(game.asteroidList.isEmpty()) {
            game.offg.drawString("Game Over - You Win!", 400, 300);
        }
        g.drawImage(game.offscreen, 0, 0, this);
        repaint();
    }

}
