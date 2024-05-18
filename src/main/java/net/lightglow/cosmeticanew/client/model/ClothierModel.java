// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.lightglow.cosmeticanew.client.model;

import net.lightglow.cosmeticanew.entity.anim.ClothierAnim;
import net.lightglow.cosmeticanew.entity.custom.ClothierEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ClothierModel<T extends ClothierEntity> extends SinglePartEntityModel<T> {
	private final ModelPart clothier;
	private final ModelPart head;
	public ClothierModel(ModelPart root) {
		this.clothier = root.getChild("clothier");
		this.head = clothier.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData clothier = modelPartData.addChild("clothier", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = clothier.addChild("body", ModelPartBuilder.create().uv(0, 10).cuboid(-2.5F, -5.925F, -1.5F, 5.0F, 6.0F, 3.0F, new Dilation(0.1F))
		.uv(16, 10).cuboid(-2.5F, -6.0F, -1.5F, 5.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -2.75F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(10, 19).cuboid(1.0F, -6.0F, 0.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(17, 3).cuboid(-3.0F, -6.0F, 0.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

		ModelPartData taild1 = body.addChild("taild1", ModelPartBuilder.create().uv(6, 19).cuboid(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -1.5F, 1.5F));

		ModelPartData taild2 = taild1.addChild("TailD2", ModelPartBuilder.create().uv(0, 19).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 2.0F));

		ModelPartData tailu1 = body.addChild("tailu1", ModelPartBuilder.create().uv(17, 0).cuboid(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.5F, 1.3F, 0.3491F, 0.0F, 0.0F));

		ModelPartData tailu2 = tailu1.addChild("TailU2", ModelPartBuilder.create().uv(13, 10).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 2.0F));

		ModelPartData lleg = body.addChild("LLeg", ModelPartBuilder.create().uv(16, 19).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.75F, 0.0F, 0.0F));

		ModelPartData rleg = body.addChild("RLeg", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.75F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		clothier.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return clothier;
	}


	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngle(headYaw, headPitch);

		this.animateMovement(ClothierAnim.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimState, ClothierAnim.IDLE, animationProgress, 1f);
	}

	private void setHeadAngle(float headYaw, float headPitch) {
		this.head.pitch = headPitch * 0.017453292F;
		this.head.yaw = headYaw * 0.017453292F;
	}
}