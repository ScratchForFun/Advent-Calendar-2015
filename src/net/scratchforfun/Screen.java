package net.scratchforfun;

import java.awt.*;

/**
 * Created by Magnus on 10/15/2015.
 */
public class Screen extends Canvas implements Runnable {

    public static final int TARGET_UPS = 60;

    private boolean isRunning = true;
    private boolean isDebugging = true;
    private boolean throttleFps = false;

    private Thread thread;

    public Screen() {
        this.thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    private void preRender() {}
    private void render() {}
    private void load() {}
    private void tick() {}

    @Override
    public void run() {
        load();

        int frames = 0, ticks = 0;
        double lastSecondMs = System.currentTimeMillis();

        double then = System.nanoTime();
        double periodNs = 1000000000D / TARGET_UPS;
        double unprocessed = 0;

        while(isRunning) {
            boolean canRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then) / periodNs;
            then = now;

            while(unprocessed >= 1) {
                ticks++;
                tick();
                canRender = true;
                --unprocessed;
            }

            if(!throttleFps || canRender) {
                frames++;
                preRender();
            }

            if(System.currentTimeMillis() - 1000 > lastSecondMs) {
                if(isDebugging)
                    System.out.println("Frames: " + frames + ", Ticks: " + ticks);
                frames = 0; ticks = 0;
                lastSecondMs += 1000;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) { }
        }
    }














}
