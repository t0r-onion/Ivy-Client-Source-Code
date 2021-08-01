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
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.opengl.renderer.Renderer;

public class GradientTest
extends BasicGame {
    private GameContainer container;
    private GradientFill gradient;
    private GradientFill gradient2;
    private GradientFill gradient4;
    private Rectangle rect;
    private Rectangle center;
    private RoundedRectangle round;
    private RoundedRectangle round2;
    private Polygon poly;
    private float ang;

    public GradientTest() {
        super("Gradient Test");
    }

    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.rect = new Rectangle(400.0f, 100.0f, 200.0f, 150.0f);
        this.round = new RoundedRectangle(150.0f, 100.0f, 200.0f, 150.0f, 50.0f);
        this.round2 = new RoundedRectangle(150.0f, 300.0f, 200.0f, 150.0f, 50.0f);
        this.center = new Rectangle(350.0f, 250.0f, 100.0f, 100.0f);
        this.poly = new Polygon();
        this.poly.addPoint(400.0f, 350.0f);
        this.poly.addPoint(550.0f, 320.0f);
        this.poly.addPoint(600.0f, 380.0f);
        this.poly.addPoint(620.0f, 450.0f);
        this.poly.addPoint(500.0f, 450.0f);
        this.gradient = new GradientFill(0.0f, -75.0f, Color.red, 0.0f, 75.0f, Color.yellow, true);
        this.gradient2 = new GradientFill(0.0f, -75.0f, Color.blue, 0.0f, 75.0f, Color.white, true);
        this.gradient4 = new GradientFill(-50.0f, -40.0f, Color.green, 50.0f, 40.0f, Color.cyan, true);
    }

    public void render(GameContainer container, Graphics g) {
        g.rotate(400.0f, 300.0f, this.ang);
        g.fill(this.rect, this.gradient);
        g.fill(this.round, this.gradient);
        g.fill(this.poly, this.gradient2);
        g.fill(this.center, this.gradient4);
        g.setAntiAlias(true);
        g.setLineWidth(10.0f);
        g.draw(this.round2, this.gradient2);
        g.setLineWidth(2.0f);
        g.draw(this.poly, this.gradient);
        g.setAntiAlias(false);
        g.fill(this.center, this.gradient4);
        g.setAntiAlias(true);
        g.setColor(Color.black);
        g.draw(this.center);
        g.setAntiAlias(false);
    }

    public void update(GameContainer container, int delta) {
        this.ang += (float)delta * 0.01f;
    }

    public static void main(String[] argv) {
        try {
            Renderer.setRenderer(2);
            AppGameContainer container = new AppGameContainer(new GradientTest());
            container.setDisplayMode(800, 600, false);
            container.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(int key, char c) {
        if (key == 1) {
            this.container.exit();
        }
    }
}

