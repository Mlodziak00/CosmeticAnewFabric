package net.lightglow.cosmeticanew.client.renderer;

import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.client.CosmeticAnewClient;
import net.lightglow.cosmeticanew.client.model.ClothierModel;
import net.lightglow.cosmeticanew.client.renderer.feature.ClothierEyesFeature;
import net.lightglow.cosmeticanew.entity.custom.ClothierEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ClothierRenderer extends MobEntityRenderer<ClothierEntity, ClothierModel<ClothierEntity>> {

    public ClothierRenderer(EntityRendererFactory.Context context) {
        super(context, new ClothierModel<>(context.getPart(CosmeticAnewClient.CLOTHIER)), 0.2f);
        this.addFeature(new ClothierEyesFeature(this));
    }

    @Override
    public Identifier getTexture(ClothierEntity entity) {
        return CosmeticAnew.id("textures/entity/clothier.png");
    }

    @Override
    public void render(ClothierEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
