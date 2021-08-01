/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package net.minecraft.client.multiplayer;

import clientname.Client;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiConnecting
extends GuiScreen {
    private static final AtomicInteger CONNECTION_ID = new AtomicInteger(0);
    private static final Logger logger = LogManager.getLogger();
    private NetworkManager networkManager;
    private boolean cancel;
    private final GuiScreen previousGuiScreen;

    public GuiConnecting(GuiScreen p_i1181_1_, Minecraft mcIn, ServerData p_i1181_3_) {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1181_1_;
        ServerAddress serveraddress = ServerAddress.func_78860_a(p_i1181_3_.serverIP);
        mcIn.loadWorld(null);
        mcIn.setServerData(p_i1181_3_);
        this.connect(serveraddress.getIP(), serveraddress.getPort());
    }

    public GuiConnecting(GuiScreen p_i1182_1_, Minecraft mcIn, String hostName, int port) {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1182_1_;
        mcIn.loadWorld(null);
        this.connect(hostName, port);
    }

    private void connect(final String ip, final int port) {
        logger.info("Connecting to " + ip + ", " + port);
        new Thread("Server Connector #" + CONNECTION_ID.incrementAndGet()){

            @Override
            public void run() {
                InetAddress inetaddress = null;
                try {
                    int i;
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    inetaddress = InetAddress.getByName(ip);
                    GuiConnecting.this.networkManager = NetworkManager.func_181124_a(inetaddress, port, ((GuiConnecting)GuiConnecting.this).mc.gameSettings.func_181148_f());
                    GuiConnecting.this.networkManager.setNetHandler(new NetHandlerLoginClient(GuiConnecting.this.networkManager, GuiConnecting.this.mc, GuiConnecting.this.previousGuiScreen));
                    GuiConnecting.this.networkManager.sendPacket(new C00Handshake(47, ip, port, EnumConnectionState.LOGIN));
                    GuiConnecting.this.networkManager.sendPacket(new C00PacketLoginStart(GuiConnecting.this.mc.getSession().getProfile()));
                    String ip1 = ip.substring(0, ip.length() - 1);
                    int index = ip1.indexOf(".");
                    ip1 = ip1.substring(index + 1);
                    char[] cha = ip1.toCharArray();
                    String[] numbersSTRING = new String[cha.length];
                    for (i = 0; i < cha.length; ++i) {
                        numbersSTRING[i] = String.valueOf(cha[i]);
                    }
                    numbersSTRING[0] = numbersSTRING[0].toUpperCase();
                    for (i = 0; i < numbersSTRING.length; ++i) {
                        if (numbersSTRING[i].toLowerCase().contains("h".toLowerCase()) && numbersSTRING.length > i + 1 && numbersSTRING[i + 1].toLowerCase().contains("d".toLowerCase())) {
                            numbersSTRING[i] = numbersSTRING[i].toUpperCase();
                            numbersSTRING[i + 1] = numbersSTRING[i + 1].toUpperCase();
                        }
                        if (!numbersSTRING[i].toLowerCase().contains("m".toLowerCase()) || numbersSTRING.length <= i + 1 || !numbersSTRING[i + 1].toLowerCase().contains("c".toLowerCase())) continue;
                        numbersSTRING[i] = numbersSTRING[i].toUpperCase();
                        numbersSTRING[i + 1] = numbersSTRING[i + 1].toUpperCase();
                    }
                    for (i = 0; i < numbersSTRING.length; ++i) {
                        if (!numbersSTRING[i].toLowerCase().contains(".".toLowerCase()) || numbersSTRING.length <= i + 3 || !numbersSTRING[i + 1].toLowerCase().contains("c".toLowerCase()) || !numbersSTRING[i + 2].toLowerCase().contains("o".toLowerCase()) || !numbersSTRING[i + 3].toLowerCase().contains("m".toLowerCase())) continue;
                        numbersSTRING[i + 0] = numbersSTRING[i + 0].replace(".", ".");
                        numbersSTRING[i + 1] = numbersSTRING[i + 1].replace("c", "n");
                        numbersSTRING[i + 2] = numbersSTRING[i + 2].replace("o", "e");
                        numbersSTRING[i + 3] = numbersSTRING[i + 3].replace("m", "t");
                    }
                    String newip = "";
                    for (int i2 = 0; i2 < numbersSTRING.length; ++i2) {
                        newip = String.valueOf(newip) + numbersSTRING[i2];
                    }
                    Client.getInstance().getDiscordRP().update("Play's " + newip, "In Game");
                }
                catch (UnknownHostException unknownhostexception) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    logger.error("Couldn't connect to server", (Throwable)unknownhostexception);
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", "Unknown host")));
                }
                catch (Exception exception) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    logger.error("Couldn't connect to server", (Throwable)exception);
                    String s = exception.toString();
                    if (inetaddress != null) {
                        String s1 = String.valueOf(inetaddress.toString()) + ":" + port;
                        s = s.replaceAll(s1, "");
                    }
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", s)));
                }
            }
        }.start();
    }

    @Override
    public void updateScreen() {
        if (this.networkManager != null) {
            if (this.networkManager.isChannelOpen()) {
                this.networkManager.processReceivedPackets();
            } else {
                this.networkManager.checkDisconnected();
            }
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.cancel = true;
            if (this.networkManager != null) {
                this.networkManager.closeChannel(new ChatComponentText("Aborted"));
            }
            this.mc.displayGuiScreen(this.previousGuiScreen);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        if (this.networkManager == null) {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting", new Object[0]), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing", new Object[0]), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

