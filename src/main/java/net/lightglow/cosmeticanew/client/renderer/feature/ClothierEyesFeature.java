package net.lightglow.cosmeticanew.client.renderer.feature;

import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.client.model.ClothierModel;
import net.lightglow.cosmeticanew.entity.custom.ClothierEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;

public class ClothierEyesFeature extends EyesFeatureRenderer<ClothierEntity, ClothierModel<ClothierEntity>> {
    private static final RenderLayer EYES = RenderLayer.getEyes(CosmeticAnew.id("textures/entity/clothier_g.png"));
    public ClothierEyesFeature(FeatureRendererContext<ClothierEntity, ClothierModel<ClothierEntity>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return EYES;
    }
}
