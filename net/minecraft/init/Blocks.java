/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockMycelium;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockTripWireHook;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.ResourceLocation;

public class Blocks {
    public static final Block air;
    public static final Block stone;
    public static final BlockGrass grass;
    public static final Block dirt;
    public static final Block cobblestone;
    public static final Block planks;
    public static final Block sapling;
    public static final Block bedrock;
    public static final BlockDynamicLiquid flowing_water;
    public static final BlockStaticLiquid water;
    public static final BlockDynamicLiquid flowing_lava;
    public static final BlockStaticLiquid lava;
    public static final BlockSand sand;
    public static final Block gravel;
    public static final Block gold_ore;
    public static final Block iron_ore;
    public static final Block coal_ore;
    public static final Block log;
    public static final Block log2;
    public static final BlockLeaves leaves;
    public static final BlockLeaves leaves2;
    public static final Block sponge;
    public static final Block glass;
    public static final Block lapis_ore;
    public static final Block lapis_block;
    public static final Block dispenser;
    public static final Block sandstone;
    public static final Block noteblock;
    public static final Block bed;
    public static final Block golden_rail;
    public static final Block detector_rail;
    public static final BlockPistonBase sticky_piston;
    public static final Block web;
    public static final BlockTallGrass tallgrass;
    public static final BlockDeadBush deadbush;
    public static final BlockPistonBase piston;
    public static final BlockPistonExtension piston_head;
    public static final Block wool;
    public static final BlockPistonMoving piston_extension;
    public static final BlockFlower yellow_flower;
    public static final BlockFlower red_flower;
    public static final BlockBush brown_mushroom;
    public static final BlockBush red_mushroom;
    public static final Block gold_block;
    public static final Block iron_block;
    public static final BlockSlab double_stone_slab;
    public static final BlockSlab stone_slab;
    public static final Block brick_block;
    public static final Block tnt;
    public static final Block bookshelf;
    public static final Block mossy_cobblestone;
    public static final Block obsidian;
    public static final Block torch;
    public static final BlockFire fire;
    public static final Block mob_spawner;
    public static final Block oak_stairs;
    public static final BlockChest chest;
    public static final BlockRedstoneWire redstone_wire;
    public static final Block diamond_ore;
    public static final Block diamond_block;
    public static final Block crafting_table;
    public static final Block wheat;
    public static final Block farmland;
    public static final Block furnace;
    public static final Block lit_furnace;
    public static final Block standing_sign;
    public static final Block oak_door;
    public static final Block spruce_door;
    public static final Block birch_door;
    public static final Block jungle_door;
    public static final Block acacia_door;
    public static final Block dark_oak_door;
    public static final Block ladder;
    public static final Block rail;
    public static final Block stone_stairs;
    public static final Block wall_sign;
    public static final Block lever;
    public static final Block stone_pressure_plate;
    public static final Block iron_door;
    public static final Block wooden_pressure_plate;
    public static final Block redstone_ore;
    public static final Block lit_redstone_ore;
    public static final Block unlit_redstone_torch;
    public static final Block redstone_torch;
    public static final Block stone_button;
    public static final Block snow_layer;
    public static final Block ice;
    public static final Block snow;
    public static final BlockCactus cactus;
    public static final Block clay;
    public static final BlockReed reeds;
    public static final Block jukebox;
    public static final Block oak_fence;
    public static final Block spruce_fence;
    public static final Block birch_fence;
    public static final Block jungle_fence;
    public static final Block dark_oak_fence;
    public static final Block acacia_fence;
    public static final Block pumpkin;
    public static final Block netherrack;
    public static final Block soul_sand;
    public static final Block glowstone;
    public static final BlockPortal portal;
    public static final Block lit_pumpkin;
    public static final Block cake;
    public static final BlockRedstoneRepeater unpowered_repeater;
    public static final BlockRedstoneRepeater powered_repeater;
    public static final Block trapdoor;
    public static final Block monster_egg;
    public static final Block stonebrick;
    public static final Block brown_mushroom_block;
    public static final Block red_mushroom_block;
    public static final Block iron_bars;
    public static final Block glass_pane;
    public static final Block melon_block;
    public static final Block pumpkin_stem;
    public static final Block melon_stem;
    public static final Block vine;
    public static final Block oak_fence_gate;
    public static final Block spruce_fence_gate;
    public static final Block birch_fence_gate;
    public static final Block jungle_fence_gate;
    public static final Block dark_oak_fence_gate;
    public static final Block acacia_fence_gate;
    public static final Block brick_stairs;
    public static final Block stone_brick_stairs;
    public static final BlockMycelium mycelium;
    public static final Block waterlily;
    public static final Block nether_brick;
    public static final Block nether_brick_fence;
    public static final Block nether_brick_stairs;
    public static final Block nether_wart;
    public static final Block enchanting_table;
    public static final Block brewing_stand;
    public static final BlockCauldron cauldron;
    public static final Block end_portal;
    public static final Block end_portal_frame;
    public static final Block end_stone;
    public static final Block dragon_egg;
    public static final Block redstone_lamp;
    public static final Block lit_redstone_lamp;
    public static final BlockSlab double_wooden_slab;
    public static final BlockSlab wooden_slab;
    public static final Block cocoa;
    public static final Block sandstone_stairs;
    public static final Block emerald_ore;
    public static final Block ender_chest;
    public static final BlockTripWireHook tripwire_hook;
    public static final Block tripwire;
    public static final Block emerald_block;
    public static final Block spruce_stairs;
    public static final Block birch_stairs;
    public static final Block jungle_stairs;
    public static final Block command_block;
    public static final BlockBeacon beacon;
    public static final Block cobblestone_wall;
    public static final Block flower_pot;
    public static final Block carrots;
    public static final Block potatoes;
    public static final Block wooden_button;
    public static final BlockSkull skull;
    public static final Block anvil;
    public static final Block trapped_chest;
    public static final Block light_weighted_pressure_plate;
    public static final Block heavy_weighted_pressure_plate;
    public static final BlockRedstoneComparator unpowered_comparator;
    public static final BlockRedstoneComparator powered_comparator;
    public static final BlockDaylightDetector daylight_detector;
    public static final BlockDaylightDetector daylight_detector_inverted;
    public static final Block redstone_block;
    public static final Block quartz_ore;
    public static final BlockHopper hopper;
    public static final Block quartz_block;
    public static final Block quartz_stairs;
    public static final Block activator_rail;
    public static final Block dropper;
    public static final Block stained_hardened_clay;
    public static final Block barrier;
    public static final Block iron_trapdoor;
    public static final Block hay_block;
    public static final Block carpet;
    public static final Block hardened_clay;
    public static final Block coal_block;
    public static final Block packed_ice;
    public static final Block acacia_stairs;
    public static final Block dark_oak_stairs;
    public static final Block slime_block;
    public static final BlockDoublePlant double_plant;
    public static final BlockStainedGlass stained_glass;
    public static final BlockStainedGlassPane stained_glass_pane;
    public static final Block prismarine;
    public static final Block sea_lantern;
    public static final Block standing_banner;
    public static final Block wall_banner;
    public static final Block red_sandstone;
    public static final Block red_sandstone_stairs;
    public static final BlockSlab double_stone_slab2;
    public static final BlockSlab stone_slab2;

    static {
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed Blocks before Bootstrap!");
        }
        air = Blocks.getRegisteredBlock("air");
        stone = Blocks.getRegisteredBlock("stone");
        grass = (BlockGrass)Blocks.getRegisteredBlock("grass");
        dirt = Blocks.getRegisteredBlock("dirt");
        cobblestone = Blocks.getRegisteredBlock("cobblestone");
        planks = Blocks.getRegisteredBlock("planks");
        sapling = Blocks.getRegisteredBlock("sapling");
        bedrock = Blocks.getRegisteredBlock("bedrock");
        flowing_water = (BlockDynamicLiquid)Blocks.getRegisteredBlock("flowing_water");
        water = (BlockStaticLiquid)Blocks.getRegisteredBlock("water");
        flowing_lava = (BlockDynamicLiquid)Blocks.getRegisteredBlock("flowing_lava");
        lava = (BlockStaticLiquid)Blocks.getRegisteredBlock("lava");
        sand = (BlockSand)Blocks.getRegisteredBlock("sand");
        gravel = Blocks.getRegisteredBlock("gravel");
        gold_ore = Blocks.getRegisteredBlock("gold_ore");
        iron_ore = Blocks.getRegisteredBlock("iron_ore");
        coal_ore = Blocks.getRegisteredBlock("coal_ore");
        log = Blocks.getRegisteredBlock("log");
        log2 = Blocks.getRegisteredBlock("log2");
        leaves = (BlockLeaves)Blocks.getRegisteredBlock("leaves");
        leaves2 = (BlockLeaves)Blocks.getRegisteredBlock("leaves2");
        sponge = Blocks.getRegisteredBlock("sponge");
        glass = Blocks.getRegisteredBlock("glass");
        lapis_ore = Blocks.getRegisteredBlock("lapis_ore");
        lapis_block = Blocks.getRegisteredBlock("lapis_block");
        dispenser = Blocks.getRegisteredBlock("dispenser");
        sandstone = Blocks.getRegisteredBlock("sandstone");
        noteblock = Blocks.getRegisteredBlock("noteblock");
        bed = Blocks.getRegisteredBlock("bed");
        golden_rail = Blocks.getRegisteredBlock("golden_rail");
        detector_rail = Blocks.getRegisteredBlock("detector_rail");
        sticky_piston = (BlockPistonBase)Blocks.getRegisteredBlock("sticky_piston");
        web = Blocks.getRegisteredBlock("web");
        tallgrass = (BlockTallGrass)Blocks.getRegisteredBlock("tallgrass");
        deadbush = (BlockDeadBush)Blocks.getRegisteredBlock("deadbush");
        piston = (BlockPistonBase)Blocks.getRegisteredBlock("piston");
        piston_head = (BlockPistonExtension)Blocks.getRegisteredBlock("piston_head");
        wool = Blocks.getRegisteredBlock("wool");
        piston_extension = (BlockPistonMoving)Blocks.getRegisteredBlock("piston_extension");
        yellow_flower = (BlockFlower)Blocks.getRegisteredBlock("yellow_flower");
        red_flower = (BlockFlower)Blocks.getRegisteredBlock("red_flower");
        brown_mushroom = (BlockBush)Blocks.getRegisteredBlock("brown_mushroom");
        red_mushroom = (BlockBush)Blocks.getRegisteredBlock("red_mushroom");
        gold_block = Blocks.getRegisteredBlock("gold_block");
        iron_block = Blocks.getRegisteredBlock("iron_block");
        double_stone_slab = (BlockSlab)Blocks.getRegisteredBlock("double_stone_slab");
        stone_slab = (BlockSlab)Blocks.getRegisteredBlock("stone_slab");
        brick_block = Blocks.getRegisteredBlock("brick_block");
        tnt = Blocks.getRegisteredBlock("tnt");
        bookshelf = Blocks.getRegisteredBlock("bookshelf");
        mossy_cobblestone = Blocks.getRegisteredBlock("mossy_cobblestone");
        obsidian = Blocks.getRegisteredBlock("obsidian");
        torch = Blocks.getRegisteredBlock("torch");
        fire = (BlockFire)Blocks.getRegisteredBlock("fire");
        mob_spawner = Blocks.getRegisteredBlock("mob_spawner");
        oak_stairs = Blocks.getRegisteredBlock("oak_stairs");
        chest = (BlockChest)Blocks.getRegisteredBlock("chest");
        redstone_wire = (BlockRedstoneWire)Blocks.getRegisteredBlock("redstone_wire");
        diamond_ore = Blocks.getRegisteredBlock("diamond_ore");
        diamond_block = Blocks.getRegisteredBlock("diamond_block");
        crafting_table = Blocks.getRegisteredBlock("crafting_table");
        wheat = Blocks.getRegisteredBlock("wheat");
        farmland = Blocks.getRegisteredBlock("farmland");
        furnace = Blocks.getRegisteredBlock("furnace");
        lit_furnace = Blocks.getRegisteredBlock("lit_furnace");
        standing_sign = Blocks.getRegisteredBlock("standing_sign");
        oak_door = Blocks.getRegisteredBlock("wooden_door");
        spruce_door = Blocks.getRegisteredBlock("spruce_door");
        birch_door = Blocks.getRegisteredBlock("birch_door");
        jungle_door = Blocks.getRegisteredBlock("jungle_door");
        acacia_door = Blocks.getRegisteredBlock("acacia_door");
        dark_oak_door = Blocks.getRegisteredBlock("dark_oak_door");
        ladder = Blocks.getRegisteredBlock("ladder");
        rail = Blocks.getRegisteredBlock("rail");
        stone_stairs = Blocks.getRegisteredBlock("stone_stairs");
        wall_sign = Blocks.getRegisteredBlock("wall_sign");
        lever = Blocks.getRegisteredBlock("lever");
        stone_pressure_plate = Blocks.getRegisteredBlock("stone_pressure_plate");
        iron_door = Blocks.getRegisteredBlock("iron_door");
        wooden_pressure_plate = Blocks.getRegisteredBlock("wooden_pressure_plate");
        redstone_ore = Blocks.getRegisteredBlock("redstone_ore");
        lit_redstone_ore = Blocks.getRegisteredBlock("lit_redstone_ore");
        unlit_redstone_torch = Blocks.getRegisteredBlock("unlit_redstone_torch");
        redstone_torch = Blocks.getRegisteredBlock("redstone_torch");
        stone_button = Blocks.getRegisteredBlock("stone_button");
        snow_layer = Blocks.getRegisteredBlock("snow_layer");
        ice = Blocks.getRegisteredBlock("ice");
        snow = Blocks.getRegisteredBlock("snow");
        cactus = (BlockCactus)Blocks.getRegisteredBlock("cactus");
        clay = Blocks.getRegisteredBlock("clay");
        reeds = (BlockReed)Blocks.getRegisteredBlock("reeds");
        jukebox = Blocks.getRegisteredBlock("jukebox");
        oak_fence = Blocks.getRegisteredBlock("fence");
        spruce_fence = Blocks.getRegisteredBlock("spruce_fence");
        birch_fence = Blocks.getRegisteredBlock("birch_fence");
        jungle_fence = Blocks.getRegisteredBlock("jungle_fence");
        dark_oak_fence = Blocks.getRegisteredBlock("dark_oak_fence");
        acacia_fence = Blocks.getRegisteredBlock("acacia_fence");
        pumpkin = Blocks.getRegisteredBlock("pumpkin");
        netherrack = Blocks.getRegisteredBlock("netherrack");
        soul_sand = Blocks.getRegisteredBlock("soul_sand");
        glowstone = Blocks.getRegisteredBlock("glowstone");
        portal = (BlockPortal)Blocks.getRegisteredBlock("portal");
        lit_pumpkin = Blocks.getRegisteredBlock("lit_pumpkin");
        cake = Blocks.getRegisteredBlock("cake");
        unpowered_repeater = (BlockRedstoneRepeater)Blocks.getRegisteredBlock("unpowered_repeater");
        powered_repeater = (BlockRedstoneRepeater)Blocks.getRegisteredBlock("powered_repeater");
        trapdoor = Blocks.getRegisteredBlock("trapdoor");
        monster_egg = Blocks.getRegisteredBlock("monster_egg");
        stonebrick = Blocks.getRegisteredBlock("stonebrick");
        brown_mushroom_block = Blocks.getRegisteredBlock("brown_mushroom_block");
        red_mushroom_block = Blocks.getRegisteredBlock("red_mushroom_block");
        iron_bars = Blocks.getRegisteredBlock("iron_bars");
        glass_pane = Blocks.getRegisteredBlock("glass_pane");
        melon_block = Blocks.getRegisteredBlock("melon_block");
        pumpkin_stem = Blocks.getRegisteredBlock("pumpkin_stem");
        melon_stem = Blocks.getRegisteredBlock("melon_stem");
        vine = Blocks.getRegisteredBlock("vine");
        oak_fence_gate = Blocks.getRegisteredBlock("fence_gate");
        spruce_fence_gate = Blocks.getRegisteredBlock("spruce_fence_gate");
        birch_fence_gate = Blocks.getRegisteredBlock("birch_fence_gate");
        jungle_fence_gate = Blocks.getRegisteredBlock("jungle_fence_gate");
        dark_oak_fence_gate = Blocks.getRegisteredBlock("dark_oak_fence_gate");
        acacia_fence_gate = Blocks.getRegisteredBlock("acacia_fence_gate");
        brick_stairs = Blocks.getRegisteredBlock("brick_stairs");
        stone_brick_stairs = Blocks.getRegisteredBlock("stone_brick_stairs");
        mycelium = (BlockMycelium)Blocks.getRegisteredBlock("mycelium");
        waterlily = Blocks.getRegisteredBlock("waterlily");
        nether_brick = Blocks.getRegisteredBlock("nether_brick");
        nether_brick_fence = Blocks.getRegisteredBlock("nether_brick_fence");
        nether_brick_stairs = Blocks.getRegisteredBlock("nether_brick_stairs");
        nether_wart = Blocks.getRegisteredBlock("nether_wart");
        enchanting_table = Blocks.getRegisteredBlock("enchanting_table");
        brewing_stand = Blocks.getRegisteredBlock("brewing_stand");
        cauldron = (BlockCauldron)Blocks.getRegisteredBlock("cauldron");
        end_portal = Blocks.getRegisteredBlock("end_portal");
        end_portal_frame = Blocks.getRegisteredBlock("end_portal_frame");
        end_stone = Blocks.getRegisteredBlock("end_stone");
        dragon_egg = Blocks.getRegisteredBlock("dragon_egg");
        redstone_lamp = Blocks.getRegisteredBlock("redstone_lamp");
        lit_redstone_lamp = Blocks.getRegisteredBlock("lit_redstone_lamp");
        double_wooden_slab = (BlockSlab)Blocks.getRegisteredBlock("double_wooden_slab");
        wooden_slab = (BlockSlab)Blocks.getRegisteredBlock("wooden_slab");
        cocoa = Blocks.getRegisteredBlock("cocoa");
        sandstone_stairs = Blocks.getRegisteredBlock("sandstone_stairs");
        emerald_ore = Blocks.getRegisteredBlock("emerald_ore");
        ender_chest = Blocks.getRegisteredBlock("ender_chest");
        tripwire_hook = (BlockTripWireHook)Blocks.getRegisteredBlock("tripwire_hook");
        tripwire = Blocks.getRegisteredBlock("tripwire");
        emerald_block = Blocks.getRegisteredBlock("emerald_block");
        spruce_stairs = Blocks.getRegisteredBlock("spruce_stairs");
        birch_stairs = Blocks.getRegisteredBlock("birch_stairs");
        jungle_stairs = Blocks.getRegisteredBlock("jungle_stairs");
        command_block = Blocks.getRegisteredBlock("command_block");
        beacon = (BlockBeacon)Blocks.getRegisteredBlock("beacon");
        cobblestone_wall = Blocks.getRegisteredBlock("cobblestone_wall");
        flower_pot = Blocks.getRegisteredBlock("flower_pot");
        carrots = Blocks.getRegisteredBlock("carrots");
        potatoes = Blocks.getRegisteredBlock("potatoes");
        wooden_button = Blocks.getRegisteredBlock("wooden_button");
        skull = (BlockSkull)Blocks.getRegisteredBlock("skull");
        anvil = Blocks.getRegisteredBlock("anvil");
        trapped_chest = Blocks.getRegisteredBlock("trapped_chest");
        light_weighted_pressure_plate = Blocks.getRegisteredBlock("light_weighted_pressure_plate");
        heavy_weighted_pressure_plate = Blocks.getRegisteredBlock("heavy_weighted_pressure_plate");
        unpowered_comparator = (BlockRedstoneComparator)Blocks.getRegisteredBlock("unpowered_comparator");
        powered_comparator = (BlockRedstoneComparator)Blocks.getRegisteredBlock("powered_comparator");
        daylight_detector = (BlockDaylightDetector)Blocks.getRegisteredBlock("daylight_detector");
        daylight_detector_inverted = (BlockDaylightDetector)Blocks.getRegisteredBlock("daylight_detector_inverted");
        redstone_block = Blocks.getRegisteredBlock("redstone_block");
        quartz_ore = Blocks.getRegisteredBlock("quartz_ore");
        hopper = (BlockHopper)Blocks.getRegisteredBlock("hopper");
        quartz_block = Blocks.getRegisteredBlock("quartz_block");
        quartz_stairs = Blocks.getRegisteredBlock("quartz_stairs");
        activator_rail = Blocks.getRegisteredBlock("activator_rail");
        dropper = Blocks.getRegisteredBlock("dropper");
        stained_hardened_clay = Blocks.getRegisteredBlock("stained_hardened_clay");
        barrier = Blocks.getRegisteredBlock("barrier");
        iron_trapdoor = Blocks.getRegisteredBlock("iron_trapdoor");
        hay_block = Blocks.getRegisteredBlock("hay_block");
        carpet = Blocks.getRegisteredBlock("carpet");
        hardened_clay = Blocks.getRegisteredBlock("hardened_clay");
        coal_block = Blocks.getRegisteredBlock("coal_block");
        packed_ice = Blocks.getRegisteredBlock("packed_ice");
        acacia_stairs = Blocks.getRegisteredBlock("acacia_stairs");
        dark_oak_stairs = Blocks.getRegisteredBlock("dark_oak_stairs");
        slime_block = Blocks.getRegisteredBlock("slime");
        double_plant = (BlockDoublePlant)Blocks.getRegisteredBlock("double_plant");
        stained_glass = (BlockStainedGlass)Blocks.getRegisteredBlock("stained_glass");
        stained_glass_pane = (BlockStainedGlassPane)Blocks.getRegisteredBlock("stained_glass_pane");
        prismarine = Blocks.getRegisteredBlock("prismarine");
        sea_lantern = Blocks.getRegisteredBlock("sea_lantern");
        standing_banner = Blocks.getRegisteredBlock("standing_banner");
        wall_banner = Blocks.getRegisteredBlock("wall_banner");
        red_sandstone = Blocks.getRegisteredBlock("red_sandstone");
        red_sandstone_stairs = Blocks.getRegisteredBlock("red_sandstone_stairs");
        double_stone_slab2 = (BlockSlab)Blocks.getRegisteredBlock("double_stone_slab2");
        stone_slab2 = (BlockSlab)Blocks.getRegisteredBlock("stone_slab2");
    }

    private static Block getRegisteredBlock(String p_180383_0_) {
        return Block.blockRegistry.getObject(new ResourceLocation(p_180383_0_));
    }
}

