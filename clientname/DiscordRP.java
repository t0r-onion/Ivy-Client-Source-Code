/*
 * Decompiled with CFR 0.150.
 */
package clientname;

import clientname.Client;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.minecraft.client.Minecraft;

public class DiscordRP {
    private boolean running = true;
    private long created = 0L;
    private Minecraft mc;

    public void start() {
        this.created = System.currentTimeMillis();
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback(){

            @Override
            public void apply(DiscordUser user) {
                System.out.println("Willkommen" + user.username + "#" + user.discriminator);
                DiscordRP.this.update("", "");
            }
        }).build();
        DiscordRPC.discordInitialize(Client.DiscordID, handlers, true);
        new Thread("Discord RPC Callback"){

            @Override
            public void run() {
                while (DiscordRP.this.running) {
                    DiscordRPC.discordRunCallbacks();
                }
            }
        }.start();
        if (!this.running) {
            this.mc.shutdown();
        }
    }

    public void shutdown() {
        this.running = false;
        DiscordRPC.discordShutdown();
    }

    public void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        if (b != null) {
            b.setBigImage("large", "");
            b.setDetails(firstLine);
            b.setStartTimestamps(this.created);
            DiscordRPC.discordUpdatePresence(b.build());
        } else {
            System.exit(0);
        }
    }
}

