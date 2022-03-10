/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book.thinkjava;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Attila Molnar
 */
public class CardTable extends Canvas {

    private Image[][] images;
    private int cardWidth, cardHeight;

    public CardTable() {
        setBackground(new Color(0x088A4B));

        images = new Image[14][4];
        String cardset = "cardset";
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif", cardset, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }

        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);

        setTableSize(14, 4);
    }

    private void setTableSize(int x, int y) {
        setSize((x * cardWidth), (y * cardHeight));
    }

    public void drawCard(Graphics g, int rank, int suit, int x, int y) {
        Image image = images[rank][suit];
        g.drawImage(image, x, y, null);
    }

    @Override
    public void paint(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, (int) x, (int) y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new CardTable();
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}
