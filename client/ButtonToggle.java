/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package client;

import client.FileManagerButton;
import java.awt.Color;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class ButtonToggle
extends GuiButton {
    Color off = new Color(-4342339);
    Color on = new Color(-16711936);
    Color c = new Color(-1);

    public ButtonToggle(int i, int j, int k, String s) {
        this(i, j, k, 120, 20, s);
    }

    public ButtonToggle(int i, int j, int k, int l, int i1, String s) {
        super(i, j, k, l, i1, s);
        this.enabled = true;
        this.visible = true;
    }

    @Override
    protected int getHoverState(boolean flag) {
        int byte0 = 1;
        if (!this.enabled) {
            byte0 = 0;
        } else if (flag) {
            byte0 = 2;
        }
        return byte0;
    }

    @Override
    public void drawButton(Minecraft mc, int mx, int my) {
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        if (ButtonToggle.load(this.displayString).booleanValue()) {
            this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.on);
            this.drawCircle(this.xPosition + this.width - this.height + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
        } else {
            this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.off);
            this.drawCircle(this.xPosition + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
        }
    }

    public static File getFolder(String toggle) {
        File file = new File(FileManagerButton.TOGGLE_DIR, toggle);
        file.mkdirs();
        return file;
    }

    public static void save(String toggle, Boolean b) {
        FileManagerButton.writeJsonToFile(new File(ButtonToggle.getFolder(toggle), "Toggle.json"), b);
    }

    public static Boolean load(String toggle) {
        Boolean b = FileManagerButton.readFromJson(new File(ButtonToggle.getFolder(toggle), "Toggle.json"), Boolean.class);
        if (b == null) {
            b = false;
            ButtonToggle.save(toggle, b);
        }
        return b;
    }

    private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
        ButtonToggle.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        ButtonToggle.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        ButtonToggle.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }

    private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0.0).endVertex();
        for (int i = (int)((double)startAngle / 360.0 * 100.0); i <= (int)((double)endAngle / 360.0 * 100.0); ++i) {
            double angle = Math.PI * 2 * (double)i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos((double)x + Math.sin(angle) * (double)radius, (double)y + Math.cos(angle) * (double)radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    private void drawCircle(int x, int y, int width, int height, Color color) {
        this.drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
    }
}

