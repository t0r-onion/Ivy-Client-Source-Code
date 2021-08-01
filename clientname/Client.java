/*
 * Decompiled with CFR 0.150.
 */
package clientname;

import clientname.DiscordRP;
import clientname.FileManager;
import clientname.event.EventManager;
import clientname.event.EventTarget;
import clientname.event.impl.ClientTickEvent;
import clientname.gui.SplashProgress;
import clientname.gui.gui.GUIToggle;
import clientname.gui.hud.HUDManager;
import clientname.mods.ModInstances;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class Client {
    private static final Client INSTANCE = new Client();
    public static boolean ChromaText = false;
    public static boolean LeftHand = false;
    public static boolean WidePlayer = false;
    public static boolean DynamicFOV = false;
    public static boolean CosmeticGhostWings = false;
    public static boolean CosmeticCap = false;
    public static String ClientName = "Ivy Client";
    public static String mainColor = "green";
    public static String DiscordID = "869217822956453988";
    public static int FPSBoost = 2;
    public static boolean LogoButtons = true;
    public static int guiToggleClientName = 55;
    public static int ConfigScreenColor = Client.getConfigScreenColor();
    public static Color SplashColor = Client.getSplashColor();
    public static String ModFarbe = Client.getModFarbe();
    public static int ButtonHover = Client.getButtonHover();
    public static String KlammerFarbe = "\u00a7f";
    public static boolean CosmeticHat;
    public static boolean CosmeticWitchHat;
    public static boolean DiamondHead;
    public static boolean ChatBackground;
    public static boolean BetterAnimations;
    public static boolean ItemPhysics;
    public static boolean ToggleSprint;
    public static boolean CosmeticWings;
    public static boolean CosmeticHalo;
    public static boolean CosmeticCape;
    public static boolean CosmeticCape2;
    public static boolean CosmeticCape3;
    public static boolean CosmeticCape4;
    public static boolean ModBiom;
    public static boolean ModFPS;
    public static boolean ModPing;
    public static boolean ModPotionstatus;
    public static boolean ModTimeShow;
    public static boolean ModPosition;
    public static boolean ModArmorStatus;
    public static boolean ModKeystrokes;
    public static boolean ModItemViewer;
    public static String Background;
    public static String Cape;
    public static String SplashScreen;
    public static String Logo;
    private DiscordRP discordRP = new DiscordRP();
    private HUDManager hudManager;
    int scrollTotal = 4;
    private static boolean prevIsKeyDown;
    private static float savedFOV;

    static {
        ModBiom = true;
        ModFPS = true;
        ModPing = true;
        ModPotionstatus = true;
        ModTimeShow = true;
        ModPosition = true;
        ModArmorStatus = true;
        ModKeystrokes = true;
        ModItemViewer = true;
        Background = "background.png";
        Cape = "cape.png";
        SplashScreen = "splash.png";
        Logo = "tollerzitronens-01.jpeg";
        prevIsKeyDown = false;
        savedFOV = 0.0f;
    }

    public static final Client getInstance() {
        return INSTANCE;
    }

    public HUDManager getHudManager() {
        return this.hudManager;
    }

    public static Color getSplashColor() {
        if (mainColor == "pink") {
            return new Color(255, 85, 255);
        }
        if (mainColor == "blue") {
            return new Color(85, 85, 255);
        }
        if (mainColor == "red") {
            return new Color(255, 85, 85);
        }
        if (mainColor == "pink") {
            return new Color(255, 85, 255);
        }
        if (mainColor == "green") {
            return new Color(85, 255, 85);
        }
        if (mainColor == "cyan") {
            return new Color(85, 255, 255);
        }
        if (mainColor == "orange") {
            return new Color(255, 170, 0);
        }
        if (mainColor == "gold") {
            return new Color(255, 170, 0);
        }
        if (mainColor == "brown") {
            return new Color(255, 170, 0);
        }
        if (mainColor == "white") {
            return new Color(255, 255, 255);
        }
        if (mainColor == "yellow") {
            return new Color(255, 255, 85);
        }
        return new Color(0);
    }

    public static int getConfigScreenColor() {
        if (mainColor == "pink") {
            return -43521;
        }
        if (mainColor == "blue") {
            return -11184641;
        }
        if (mainColor == "red") {
            return -43691;
        }
        if (mainColor == "pink") {
            return -43521;
        }
        if (mainColor == "green") {
            return -11141291;
        }
        if (mainColor == "cyan") {
            return -11141121;
        }
        if (mainColor == "orange") {
            return -22016;
        }
        if (mainColor == "gold") {
            return -22016;
        }
        if (mainColor == "brown") {
            return -22016;
        }
        if (mainColor == "white") {
            return -1;
        }
        if (mainColor == "yellow") {
            return -171;
        }
        return 0;
    }

    public static String getModFarbe() {
        if (mainColor == "pink") {
            return "\u00a7d";
        }
        if (mainColor == "blue") {
            return "\u00a79";
        }
        if (mainColor == "red") {
            return "\u00a7c";
        }
        if (mainColor == "pink") {
            return "\u00a7d";
        }
        if (mainColor == "green") {
            return "\u00a7a";
        }
        if (mainColor == "cyan") {
            return "\u00a7b";
        }
        if (mainColor == "orange") {
            return "\u00a76";
        }
        if (mainColor == "gold") {
            return "\u00a76";
        }
        if (mainColor == "brown") {
            return "\u00a76";
        }
        if (mainColor == "white") {
            return "\u00a7f";
        }
        if (mainColor == "yellow") {
            return "\u00a7e";
        }
        return "0000000000";
    }

    public static int getButtonHover() {
        if (mainColor == "pink") {
            return 0xFF55FF;
        }
        if (mainColor == "blue") {
            return 0x5555FF;
        }
        if (mainColor == "red") {
            return 0xFF5555;
        }
        if (mainColor == "pink") {
            return 0xFF55FF;
        }
        if (mainColor == "green") {
            return 0x55FF55;
        }
        if (mainColor == "cyan") {
            return 0x55FFFF;
        }
        if (mainColor == "orange") {
            return 0xFFAA00;
        }
        if (mainColor == "gold") {
            return 0xFFAA00;
        }
        if (mainColor == "brown") {
            return 0xFFAA00;
        }
        if (mainColor == "white") {
            return 0xFFFFFF;
        }
        if (mainColor == "yellow") {
            return 0xFFFF55;
        }
        return 0;
    }

    public void init() {
        SplashProgress.setProgress(1, String.valueOf(ClientName) + " - Discord Initialisation");
        FileManager.init();
        this.discordRP.start();
        EventManager.register(this);
    }

    public void start() {
        this.hudManager = HUDManager.getInstance();
        ModInstances.register(this.hudManager);
    }

    public void shutdown() {
        this.discordRP.shutdown();
    }

    public DiscordRP getDiscordRP() {
        return this.discordRP;
    }

    @EventTarget
    public void onTick(ClientTickEvent e) {
        boolean isKeyDown;
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
            this.hudManager.openConfigScreen();
        }
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_SETTINGS.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GUIToggle(null));
        }
        if (prevIsKeyDown != (isKeyDown = Minecraft.getMinecraft().gameSettings.ZOOM.isKeyDown())) {
            if (isKeyDown) {
                savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
                Minecraft.getMinecraft().gameSettings.fovSetting = 30.0f;
                Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            } else {
                Minecraft.getMinecraft().gameSettings.fovSetting = savedFOV;
                Minecraft.getMinecraft().gameSettings.smoothCamera = false;
            }
        }
        prevIsKeyDown = isKeyDown;
    }
}

