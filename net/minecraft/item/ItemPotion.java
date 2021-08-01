/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 */
package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotion
extends Item {
    private Map<Integer, List<PotionEffect>> effectCache = Maps.newHashMap();
    private static final Map<List<PotionEffect>, Integer> SUB_ITEMS_CACHE = Maps.newLinkedHashMap();

    public ItemPotion() {
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    public List<PotionEffect> getEffects(ItemStack stack) {
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("CustomPotionEffects", 9)) {
            ArrayList list1 = Lists.newArrayList();
            NBTTagList nbttaglist = stack.getTagCompound().getTagList("CustomPotionEffects", 10);
            for (int i = 0; i < nbttaglist.tagCount(); ++i) {
                NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
                PotionEffect potioneffect = PotionEffect.readCustomPotionEffectFromNBT(nbttagcompound);
                if (potioneffect == null) continue;
                list1.add(potioneffect);
            }
            return list1;
        }
        List<PotionEffect> list = this.effectCache.get(stack.getMetadata());
        if (list == null) {
            list = PotionHelper.getPotionEffects(stack.getMetadata(), false);
            this.effectCache.put(stack.getMetadata(), list);
        }
        return list;
    }

    public List<PotionEffect> getEffects(int meta) {
        List<PotionEffect> list = this.effectCache.get(meta);
        if (list == null) {
            list = PotionHelper.getPotionEffects(meta, false);
            this.effectCache.put(meta, list);
        }
        return list;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        List<PotionEffect> list;
        if (!playerIn.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        if (!worldIn.isRemote && (list = this.getEffects(stack)) != null) {
            for (PotionEffect potioneffect : list) {
                playerIn.addPotionEffect(new PotionEffect(potioneffect));
            }
        }
        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        if (!playerIn.capabilities.isCreativeMode) {
            if (stack.stackSize <= 0) {
                return new ItemStack(Items.glass_bottle);
            }
            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        return stack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (ItemPotion.isSplash(itemStackIn.getMetadata())) {
            if (!playerIn.capabilities.isCreativeMode) {
                --itemStackIn.stackSize;
            }
            worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!worldIn.isRemote) {
                worldIn.spawnEntityInWorld(new EntityPotion(worldIn, (EntityLivingBase)playerIn, itemStackIn));
            }
            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
            return itemStackIn;
        }
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }

    public static boolean isSplash(int meta) {
        return (meta & 0x4000) != 0;
    }

    public int getColorFromDamage(int meta) {
        return PotionHelper.getLiquidColor(meta, false);
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int renderPass) {
        return renderPass > 0 ? 0xFFFFFF : this.getColorFromDamage(stack.getMetadata());
    }

    public boolean isEffectInstant(int meta) {
        List<PotionEffect> list = this.getEffects(meta);
        if (list != null && !list.isEmpty()) {
            for (PotionEffect potioneffect : list) {
                if (!Potion.potionTypes[potioneffect.getPotionID()].isInstant()) continue;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        List<PotionEffect> list;
        if (stack.getMetadata() == 0) {
            return StatCollector.translateToLocal("item.emptyPotion.name").trim();
        }
        String s = "";
        if (ItemPotion.isSplash(stack.getMetadata())) {
            s = String.valueOf(StatCollector.translateToLocal("potion.prefix.grenade").trim()) + " ";
        }
        if ((list = Items.potionitem.getEffects(stack)) != null && !list.isEmpty()) {
            String s2 = list.get(0).getEffectName();
            s2 = String.valueOf(s2) + ".postfix";
            return String.valueOf(s) + StatCollector.translateToLocal(s2).trim();
        }
        String s1 = PotionHelper.getPotionPrefix(stack.getMetadata());
        return String.valueOf(StatCollector.translateToLocal(s1).trim()) + " " + super.getItemStackDisplayName(stack);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        if (stack.getMetadata() != 0) {
            List<PotionEffect> list = Items.potionitem.getEffects(stack);
            HashMultimap multimap = HashMultimap.create();
            if (list != null && !list.isEmpty()) {
                for (PotionEffect potioneffect : list) {
                    String s1 = StatCollector.translateToLocal(potioneffect.getEffectName()).trim();
                    Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                    Map<IAttribute, AttributeModifier> map = potion.getAttributeModifierMap();
                    if (map != null && map.size() > 0) {
                        for (Map.Entry<IAttribute, AttributeModifier> entry : map.entrySet()) {
                            AttributeModifier attributemodifier = entry.getValue();
                            AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(), potion.getAttributeModifierAmount(potioneffect.getAmplifier(), attributemodifier), attributemodifier.getOperation());
                            multimap.put((Object)entry.getKey().getAttributeUnlocalizedName(), (Object)attributemodifier1);
                        }
                    }
                    if (potioneffect.getAmplifier() > 0) {
                        s1 = String.valueOf(s1) + " " + StatCollector.translateToLocal("potion.potency." + potioneffect.getAmplifier()).trim();
                    }
                    if (potioneffect.getDuration() > 20) {
                        s1 = String.valueOf(s1) + " (" + Potion.getDurationString(potioneffect) + ")";
                    }
                    if (potion.isBadEffect()) {
                        tooltip.add((Object)((Object)EnumChatFormatting.RED) + s1);
                        continue;
                    }
                    tooltip.add((Object)((Object)EnumChatFormatting.GRAY) + s1);
                }
            } else {
                String s = StatCollector.translateToLocal("potion.empty").trim();
                tooltip.add((Object)((Object)EnumChatFormatting.GRAY) + s);
            }
            if (!multimap.isEmpty()) {
                tooltip.add("");
                tooltip.add((Object)((Object)EnumChatFormatting.DARK_PURPLE) + StatCollector.translateToLocal("potion.effects.whenDrank"));
                for (Map.Entry entry1 : multimap.entries()) {
                    AttributeModifier attributemodifier2 = (AttributeModifier)entry1.getValue();
                    double d0 = attributemodifier2.getAmount();
                    double d1 = attributemodifier2.getOperation() != 1 && attributemodifier2.getOperation() != 2 ? attributemodifier2.getAmount() : attributemodifier2.getAmount() * 100.0;
                    if (d0 > 0.0) {
                        tooltip.add((Object)((Object)EnumChatFormatting.BLUE) + StatCollector.translateToLocalFormatted("attribute.modifier.plus." + attributemodifier2.getOperation(), ItemStack.DECIMALFORMAT.format(d1), StatCollector.translateToLocal("attribute.name." + (String)entry1.getKey())));
                        continue;
                    }
                    if (!(d0 < 0.0)) continue;
                    tooltip.add((Object)((Object)EnumChatFormatting.RED) + StatCollector.translateToLocalFormatted("attribute.modifier.take." + attributemodifier2.getOperation(), ItemStack.DECIMALFORMAT.format(d1 *= -1.0), StatCollector.translateToLocal("attribute.name." + (String)entry1.getKey())));
                }
            }
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        List<PotionEffect> list = this.getEffects(stack);
        return list != null && !list.isEmpty();
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        super.getSubItems(itemIn, tab, subItems);
        if (SUB_ITEMS_CACHE.isEmpty()) {
            for (int i = 0; i <= 15; ++i) {
                for (int j = 0; j <= 1; ++j) {
                    int lvt_6_1_ = j == 0 ? i | 0x2000 : i | 0x4000;
                    for (int l = 0; l <= 2; ++l) {
                        List<PotionEffect> list;
                        int i1 = lvt_6_1_;
                        if (l != 0) {
                            if (l == 1) {
                                i1 = lvt_6_1_ | 0x20;
                            } else if (l == 2) {
                                i1 = lvt_6_1_ | 0x40;
                            }
                        }
                        if ((list = PotionHelper.getPotionEffects(i1, false)) == null || list.isEmpty()) continue;
                        SUB_ITEMS_CACHE.put(list, i1);
                    }
                }
            }
        }
        for (int j1 : SUB_ITEMS_CACHE.values()) {
            subItems.add(new ItemStack(itemIn, 1, j1));
        }
    }
}

