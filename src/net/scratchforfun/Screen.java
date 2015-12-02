package net.scratchforfun;

import java.awt.*;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Screen extends Canvas implements Runnable {

    public static final int TARGET_UPS = 60;

    private Thread thread;

    public Screen() {
        this.thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    private void preRender() {}
    private void render() {}
    private void tick() {}
    private void load() {}

    @Override
    public void run() {
        load();

        int frames = 0, ticks = 0;
        double lastSecondMs = System.currentTimeMillis();

        double periodNs = 1000000000D / TARGET_UPS;
    }
}
