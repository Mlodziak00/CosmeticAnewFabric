package net.lightglow.cosmeticanew;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.lightglow.cosmeticanew.client.model.ClothingModel;
import net.lightglow.cosmeticanew.client.model.SlimClothingModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class CosmeticAnewClient implements ClientModInitializer {
    public static final EntityModelLayer CLOTHING_MODEL_LAYER = new EntityModelLayer(CosmeticAnew.id("clothing"), "main");
    public static final EntityModelLayer SLIM_CLOTHING_MODEL_LAYER = new EntityModelLayer(CosmeticAnew.id("slim_clothing"), "main");

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CLOTHING_MODEL_LAYER, ClothingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SLIM_CLOTHING_MODEL_LAYER, SlimClothingModel::getTexturedModelData);
    }
}
