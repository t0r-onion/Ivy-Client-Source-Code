/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.opengl.Display
 */
package clientname.mods.impl;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class ModFullscreen
extends ModDraggable {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void render(ScreenPosition pos) {
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
        Display.setLocation((int)0, (int)0);
        try {
            Display.setFullscreen((boolean)false);
        }
        catch (LWJGLException e) {
            e.printStackTrace();
        }
        Display.setResizable((boolean)false);
    }
}

