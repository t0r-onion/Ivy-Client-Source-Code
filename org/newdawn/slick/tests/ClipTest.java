/*
 * Decompiled with CFR 0.150.
 */
package org.newdawn.slick.tests;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class ClipTest
extends BasicGame {
    private float ang = 0.0f;
    private boolean world;
    private boolean clip;

    public ClipTest() {
        super("Clip Test");
    }

    public void init(GameContainer container) throws SlickException {
    }

    public void update(GameContainer container, int delta) throws SlickException {
        this.ang += (float)delta * 0.01f;
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("1 - No Clipping", 100.0f, 10.0f);
        g.drawString("2 - Screen Clipping", 100.0f, 30.0f);
        g.drawString("3 - World Clipping", 100.0f, 50.0f);
        if (this.world) {
            g.drawString("WORLD CLIPPING ENABLED", 200.0f, 80.0f);
        }
        if (this.clip) {
            g.drawString("SCREEN CLIPPING ENABLED", 200.0f, 80.0f);
        }
        g.rotate(400.0f, 400.0f, this.ang);
        if (this.world) {
            g.setWorldClip(350.0f, 302.0f, 100.0f, 196.0f);
        }
        if (this.clip) {
            g.setClip(350, 302, 100, 196);
        }
        g.setColor(Color.red);
        g.fillOval(300.0f, 300.0f, 200.0f, 200.0f);
        g.setColor(Color.blue);
        g.fillRect(390.0f, 200.0f, 20.0f, 400.0f);
        g.clearClip();
        g.clearWorldClip();
    }

    public void keyPressed(int key, char c) {
        if (key == 2) {
            this.world = false;
            this.clip = false;
        }
        if (key == 3) {
            this.world = false;
            this.clip = true;
        }
        if (key == 4) {
            this.world = true;
            this.clip = false;
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ClipTest());
            container.setDisplayMode(800, 600, false);
            container.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

