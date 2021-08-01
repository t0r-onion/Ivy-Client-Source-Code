/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package clientname.mods.impl;

import clientname.Client;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModItemViewer
extends ModDraggable {
    private ScreenPosition pos;

    @Override
    public int getWidth() {
        return 40;
    }

    @Override
    public int getHeight() {
        return 17;
    }

    @Override
    public void render(ScreenPosition pos) {
        if (Client.ModItemViewer) {
            this.renderItemStack(pos, 3, this.mc.thePlayer.getCurrentEquippedItem());
        }
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        if (Client.ModItemViewer) {
            this.renderItemStack(pos, 3, new ItemStack(Items.golden_sword));
        }
    }

    private void renderItemStack(ScreenPosition pos, int i, ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            double damage = (double)(is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, 0xFFFFFF);
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
}

