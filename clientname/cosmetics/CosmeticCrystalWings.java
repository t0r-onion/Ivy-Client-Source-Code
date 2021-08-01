/*
 * Decompiled with CFR 0.150.
 */
package clientname.cosmetics;

import clientname.cosmetics.util.CosmeticBase;
import clientname.cosmetics.util.CosmeticModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CosmeticCrystalWings
extends CosmeticBase {
    private CrytsalWingsModel crytsalWingsModel;

    public CosmeticCrystalWings(RenderPlayer playerRenderer) {
        super(playerRenderer);
        this.crytsalWingsModel = new CrytsalWingsModel(playerRenderer);
    }

    @Override
    public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.crytsalWingsModel.render(player, limbSwing, limbSwingAmount, ageInTicks, headPitch, headPitch, scale);
    }

    public class CrytsalWingsModel
    extends CosmeticModelBase {
        private ModelRenderer model;
        ResourceLocation resourceLocation;

        public CrytsalWingsModel(RenderPlayer player) {
            super(player);
            this.resourceLocation = new ResourceLocation("crystalwings.png");
            int i = 30;
            int j = 24;
            this.model = new ModelRenderer(this).setTextureSize(i, j).setTextureOffset(0, 8);
            this.model.setRotationPoint(-0.0f, 1.0f, 0.0f);
            this.model.addBox(0.0f, -3.0f, 0.0f, 14, 7, 1);
            this.model.isHidden = true;
            ModelRenderer modelrenderer = new ModelRenderer(this).setTextureSize(i, j).setTextureOffset(0, 16);
            modelrenderer.setRotationPoint(-0.0f, 0.0f, 0.2f);
            modelrenderer.addBox(0.0f, -3.0f, 0.0f, 14, 7, 1);
            this.model.addChild(modelrenderer);
            ModelRenderer modelrenderer1 = new ModelRenderer(this).setTextureSize(i, j).setTextureOffset(0, 0);
            modelrenderer1.setRotationPoint(-0.0f, 0.0f, 0.2f);
            modelrenderer1.addBox(0.0f, -3.0f, 0.0f, 14, 7, 1);
            modelrenderer.addChild(modelrenderer1);
        }

        @Override
        public void render(Entity entityIn, float p_78088_2_, float walkingSpeed, float tickValue, float p_78088_5_, float p_78088_6_, float scale) {
            float f = (float)Math.cos(tickValue / 10.0f) / 20.0f - 0.03f - walkingSpeed / 20.0f;
            ModelRenderer modelrenderer = this.model.childModels.get(0);
            ModelRenderer modelrenderer1 = modelrenderer.childModels.get(0);
            this.model.rotateAngleZ = f * 3.0f;
            modelrenderer.rotateAngleZ = f / 2.0f;
            modelrenderer1.rotateAngleZ = f / 2.0f;
            this.model.rotateAngleY = -0.3f - walkingSpeed / 3.0f;
            this.model.rotateAngleX = 0.3f;
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.6, 1.6, 1.0);
            GlStateManager.translate(0.0, (double)0.05f, (double)0.05f);
            if (entityIn.isSneaking()) {
                GlStateManager.translate(0.0, (double)0.08f, (double)0.03f);
                GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
                this.model.rotateAngleZ = 0.8f;
                modelrenderer.rotateAngleZ = 0.0f;
                modelrenderer1.rotateAngleZ = 0.0f;
            } else {
                RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
                if (rendermanager != null) {
                    GlStateManager.rotate(rendermanager.playerViewX / 3.0f, 1.0f, 0.0f, 0.0f);
                }
            }
            this.model.isHidden = false;
            for (int i = -1; i <= 1; i += 2) {
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 0.3f);
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.alphaFunc(516, 0.003921569f);
                GlStateManager.disableLighting();
                GlStateManager.color(0.0f, 0.0f, 0.0f);
                Minecraft.getMinecraft().getTextureManager().bindTexture(this.resourceLocation);
                if (i == 1) {
                    GlStateManager.scale(-1.0f, 1.0f, 1.0f);
                }
                GlStateManager.translate(0.05, 0.0, 0.0);
                this.model.render(scale);
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.popMatrix();
                GlStateManager.depthMask(true);
            }
            this.model.isHidden = true;
            GlStateManager.popMatrix();
        }
    }
}

