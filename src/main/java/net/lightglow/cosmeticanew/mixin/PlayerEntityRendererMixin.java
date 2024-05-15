package net.lightglow.cosmeticanew.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.lightglow.cosmeticanew.client.renderer.feature.ClothingFeature;
import net.lightglow.cosmeticanew.common.reg.TagsInit;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {


	public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
		super(ctx, model, shadowRadius);
	}

	@Inject(at = @At("TAIL"), method = "<init>")
	private void init(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo ci) {
		this.addFeature(new ClothingFeature(this, ctx.getModelLoader(), slim));
	}

	@Inject(method = "render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
	at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"), cancellable = true)
	private void hideUnNeededParts$render(AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci){
		setVisible(abstractClientPlayerEntity);
	}
	@Unique
	protected void setVisible(LivingEntity entity) {
			TrinketsApi.getTrinketComponent(entity).ifPresent(trinketComponent -> {
				List<Pair<SlotReference, ItemStack>> res = trinketComponent.getEquipped(itemStack -> itemStack.isIn(TagsInit.Items.COSMETICS));
				if (res.size() == 0){
					this.model.jacket.visible = true;
					this.model.rightSleeve.visible = true;
					this.model.leftSleeve.visible = true;
					this.model.rightPants.visible = true;
					this.model.leftPants.visible = true;
				} else {
					this.model.jacket.visible = false;
					this.model.rightSleeve.visible = false;
					this.model.leftSleeve.visible = false;
					this.model.rightPants.visible = false;
					this.model.leftPants.visible = false;
				}
			});

	}
}