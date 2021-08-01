/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 */
package net.minecraft.client.resources;

import com.google.common.collect.ImmutableSet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class DefaultResourcePack
implements IResourcePack {
    public static final Set<String> defaultResourceDomains = ImmutableSet.of((Object)"minecraft", (Object)"realms");
    private final Map<String, File> mapAssets;

    public DefaultResourcePack(Map<String, File> mapAssetsIn) {
        this.mapAssets = mapAssetsIn;
    }

    @Override
    public InputStream getInputStream(ResourceLocation location) throws IOException {
        InputStream inputstream = this.getResourceStream(location);
        if (inputstream != null) {
            return inputstream;
        }
        InputStream inputstream1 = this.getInputStreamAssets(location);
        if (inputstream1 != null) {
            return inputstream1;
        }
        throw new FileNotFoundException(location.getResourcePath());
    }

    public InputStream getInputStreamAssets(ResourceLocation location) throws IOException, FileNotFoundException {
        File file1 = this.mapAssets.get(location.toString());
        return file1 != null && file1.isFile() ? new FileInputStream(file1) : null;
    }

    private InputStream getResourceStream(ResourceLocation location) {
        return DefaultResourcePack.class.getResourceAsStream("/assets/" + location.getResourceDomain() + "/" + location.getResourcePath());
    }

    @Override
    public boolean resourceExists(ResourceLocation location) {
        return this.getResourceStream(location) != null || this.mapAssets.containsKey(location.toString());
    }

    @Override
    public Set<String> getResourceDomains() {
        return defaultResourceDomains;
    }

    @Override
    public <T extends IMetadataSection> T getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
        try {
            FileInputStream inputstream = new FileInputStream(this.mapAssets.get("pack.mcmeta"));
            return AbstractResourcePack.readMetadata(p_135058_1_, inputstream, p_135058_2_);
        }
        catch (RuntimeException var4) {
            return null;
        }
        catch (FileNotFoundException var5) {
            return null;
        }
    }

    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(DefaultResourcePack.class.getResourceAsStream("/" + new ResourceLocation("pack.png").getResourcePath()));
    }

    @Override
    public String getPackName() {
        return "Default";
    }
}

