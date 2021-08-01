/*
 * Decompiled with CFR 0.150.
 */
package org.newdawn.slick.openal;

import org.newdawn.slick.openal.Audio;

public class NullAudio
implements Audio {
    public int getBufferID() {
        return 0;
    }

    public float getPosition() {
        return 0.0f;
    }

    public boolean isPlaying() {
        return false;
    }

    public int playAsMusic(float pitch, float gain, boolean loop) {
        return 0;
    }

    public int playAsSoundEffect(float pitch, float gain, boolean loop) {
        return 0;
    }

    public int playAsSoundEffect(float pitch, float gain, boolean loop, float x, float y, float z) {
        return 0;
    }

    public boolean setPosition(float position) {
        return false;
    }

    public void stop() {
    }
}

