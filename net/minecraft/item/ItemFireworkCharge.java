/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.StatCollector;

public class ItemFireworkCharge
extends Item {
    @Override
    public int getColorFromItemStack(ItemStack stack, int renderPass) {
        if (renderPass != 1) {
            return super.getColorFromItemStack(stack, renderPass);
        }
        NBTBase nbtbase = ItemFireworkCharge.getExplosionTag(stack, "Colors");
        if (!(nbtbase instanceof NBTTagIntArray)) {
            return 0x8A8A8A;
        }
        NBTTagIntArray nbttagintarray = (NBTTagIntArray)nbtbase;
        int[] aint = nbttagintarray.getIntArray();
        if (aint.length == 1) {
            return aint[0];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arrn = aint;
        int n = aint.length;
        for (int i2 = 0; i2 < n; ++i2) {
            int l = arrn[i2];
            i += (l & 0xFF0000) >> 16;
            j += (l & 0xFF00) >> 8;
            k += (l & 0xFF) >> 0;
        }
        return (i /= aint.length) << 16 | (j /= aint.length) << 8 | (k /= aint.length);
    }

    public static NBTBase getExplosionTag(ItemStack stack, String key) {
        NBTTagCompound nbttagcompound;
        if (stack.hasTagCompound() && (nbttagcompound = stack.getTagCompound().getCompoundTag("Explosion")) != null) {
            return nbttagcompound.getTag(key);
        }
        return null;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        NBTTagCompound nbttagcompound;
        if (stack.hasTagCompound() && (nbttagcompound = stack.getTagCompound().getCompoundTag("Explosion")) != null) {
            ItemFireworkCharge.addExplosionInfo(nbttagcompound, tooltip);
        }
    }

    public static void addExplosionInfo(NBTTagCompound nbt, List<String> tooltip) {
        boolean flag4;
        boolean flag3;
        int[] aint1;
        int n;
        byte b0 = nbt.getByte("Type");
        if (b0 >= 0 && b0 <= 4) {
            tooltip.add(StatCollector.translateToLocal("item.fireworksCharge.type." + b0).trim());
        } else {
            tooltip.add(StatCollector.translateToLocal("item.fireworksCharge.type").trim());
        }
        int[] aint = nbt.getIntArray("Colors");
        if (aint.length > 0) {
            boolean flag = true;
            String s = "";
            int[] arrn = aint;
            n = aint.length;
            for (int i = 0; i < n; ++i) {
                int i2 = arrn[i];
                if (!flag) {
                    s = String.valueOf(s) + ", ";
                }
                flag = false;
                boolean flag1 = false;
                for (int j = 0; j < ItemDye.dyeColors.length; ++j) {
                    if (i2 != ItemDye.dyeColors[j]) continue;
                    flag1 = true;
                    s = String.valueOf(s) + StatCollector.translateToLocal("item.fireworksCharge." + EnumDyeColor.byDyeDamage(j).getUnlocalizedName());
                    break;
                }
                if (flag1) continue;
                s = String.valueOf(s) + StatCollector.translateToLocal("item.fireworksCharge.customColor");
            }
            tooltip.add(s);
        }
        if ((aint1 = nbt.getIntArray("FadeColors")).length > 0) {
            boolean flag2 = true;
            String s1 = String.valueOf(StatCollector.translateToLocal("item.fireworksCharge.fadeTo")) + " ";
            int[] arrn = aint1;
            int n2 = aint1.length;
            for (n = 0; n < n2; ++n) {
                int l = arrn[n];
                if (!flag2) {
                    s1 = String.valueOf(s1) + ", ";
                }
                flag2 = false;
                boolean flag5 = false;
                for (int k = 0; k < 16; ++k) {
                    if (l != ItemDye.dyeColors[k]) continue;
                    flag5 = true;
                    s1 = String.valueOf(s1) + StatCollector.translateToLocal("item.fireworksCharge." + EnumDyeColor.byDyeDamage(k).getUnlocalizedName());
                    break;
                }
                if (flag5) continue;
                s1 = String.valueOf(s1) + StatCollector.translateToLocal("item.fireworksCharge.customColor");
            }
            tooltip.add(s1);
        }
        if (flag3 = nbt.getBoolean("Trail")) {
            tooltip.add(StatCollector.translateToLocal("item.fireworksCharge.trail"));
        }
        if (flag4 = nbt.getBoolean("Flicker")) {
            tooltip.add(StatCollector.translateToLocal("item.fireworksCharge.flicker"));
        }
    }
}

