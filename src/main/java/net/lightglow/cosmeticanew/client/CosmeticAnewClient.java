package net.lightglow.cosmeticanew.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.client.model.ClothierModel;
import net.lightglow.cosmeticanew.client.renderer.ClothierRenderer;
import net.lightglow.cosmeticanew.common.EntityInit;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class CosmeticAnewClient implements ClientModInitializer {
    public static final EntityModelLayer CLOTHIER = new EntityModelLayer(CosmeticAnew.id("clothier"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityInit.CLOTHIER, ClothierRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CLOTHIER, ClothierModel::getTexturedModelData);
    }
}
