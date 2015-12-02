package net.scratchforfun;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Frame {

    public static String TITLE = "Advent Calendar Game";
    public static int WIDTH = 640, HEIGHT = 480;

    private JFrame frame;

    public Frame() {
        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = new Dimension(WIDTH, HEIGHT);
        frame.getContentPane().setPreferredSize(dim);

        Screen screen = new Screen();
        frame.getContentPane().add(screen);

        frame.setResizable(false);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        screen.start();
    }

}
