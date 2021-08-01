/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods.impl;

import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ModDirection
extends ModDraggable {
    protected static ScaledResolution scaledResolution;
    public static String markerColor;
    public static int compassIndex;

    static {
        markerColor = "c";
        compassIndex = 0;
    }

    @Override
    public int getWidth() {
        return 102;
    }

    @Override
    public int getHeight() {
        return 15;
    }

    @Override
    public void render(ScreenPosition pos) {
        int direction = MathHelper.floor_double((double)(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f) + 0.5) & 0xFF;
        int yBase = ModDirection.getY(1, 12);
        int xBase = ModDirection.getX(65);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
        if (direction < 128) {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
        } else {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
        }
        this.mc.fontRendererObj.drawString("\u00a7" + markerColor.toLowerCase() + "|\u00a7r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 0xFFFFFF);
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        int direction = MathHelper.floor_double((double)(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f) + 0.5) & 0xFF;
        int yBase = ModDirection.getY(1, 12);
        int xBase = ModDirection.getX(65);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
        if (direction < 128) {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
        } else {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
        }
        this.mc.fontRendererObj.drawString("\u00a7" + markerColor.toLowerCase() + "|\u00a7r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 0xFFFFFF);
    }

    private static int getX(int width) {
        return width;
    }

    private static int getY(int rowCount, int height) {
        return height;
    }

    public static enum Direction {
        S,
        SW,
        W,
        NW,
        N,
        NE,
        E,
        SE;

    }
}

