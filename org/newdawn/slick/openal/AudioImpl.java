/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.lwjgl.openal.AL10
 */
package org.newdawn.slick.openal;

import org.lwjgl.openal.AL10;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.SoundStore;

public class AudioImpl
implements Audio {
    private SoundStore store;
    private int buffer;
    private int index = -1;
    private float length;

    AudioImpl(SoundStore store, int buffer) {
        this.store = store;
        this.buffer = buffer;
        int bytes = AL10.alGetBufferi((int)buffer, (int)8196);
        int bits = AL10.alGetBufferi((int)buffer, (int)8194);
        int channels = AL10.alGetBufferi((int)buffer, (int)8195);
        int freq = AL10.alGetBufferi((int)buffer, (int)8193);
        int samples = bytes / (bits / 8);
        this.length = (float)samples / (float)freq / (float)channels;
    }

    public int getBufferID() {
        return this.buffer;
    }

    protected AudioImpl() {
    }

    public void stop() {
        if (this.index != -1) {
            this.store.stopSource(this.index);
            this.index = -1;
        }
    }

    public boolean isPlaying() {
        if (this.index != -1) {
            return this.store.isPlaying(this.index);
        }
        return false;
    }

    public int playAsSoundEffect(float pitch, float gain, boolean loop) {
        this.index = this.store.playAsSound(this.buffer, pitch, gain, loop);
        return this.store.getSource(this.index);
    }

    public int playAsSoundEffect(float pitch, float gain, boolean loop, float x, float y, float z) {
        this.index = this.store.playAsSoundAt(this.buffer, pitch, gain, loop, x, y, z);
        return this.store.getSource(this.index);
    }

    public int playAsMusic(float pitch, float gain, boolean loop) {
        this.store.playAsMusic(this.buffer, pitch, gain, loop);
        this.index = 0;
        return this.store.getSource(0);
    }

    public static void pauseMusic() {
        SoundStore.get().pauseLoop();
    }

    public static void restartMusic() {
        SoundStore.get().restartLoop();
    }

    public boolean setPosition(float position) {
        AL10.alSourcef((int)this.store.getSource(this.index), (int)4132, (float)(position %= this.length));
        return AL10.alGetError() == 0;
    }

    public float getPosition() {
        return AL10.alGetSourcef((int)this.store.getSource(this.index), (int)4132);
    }
}

