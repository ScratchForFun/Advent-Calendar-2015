package net.scratchforfun;

import javax.swing.*;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }

}
