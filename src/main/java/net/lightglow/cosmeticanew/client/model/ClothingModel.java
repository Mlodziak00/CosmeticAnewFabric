// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.lightglow.cosmeticanew.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

import java.util.NoSuchElementException;

public class ClothingModel extends BipedEntityModel<AbstractClientPlayerEntity> {
	private ModelPart clothed_l_arm, clothed_r_arm;
	private final boolean thinArms;
	public ClothingModel(ModelPart root, boolean thinArms) {
		super(root, RenderLayer::getArmorCutoutNoCull);
		this.thinArms = thinArms;
		try {
			clothed_l_arm = leftArm.getChild("clothed_l_arm");
			clothed_r_arm = rightArm.getChild("clothed_r_arm");
		} catch (NoSuchElementException ignored){

		}
	}
	private static ModelData getBaseData() {
		ModelData data = new ModelData();
		ModelPartData root = data.getRoot();
		root.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		root.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		root.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		root.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
		root.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
		root.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
		root.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create(), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
		return data;
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData data = getBaseData();
		ModelPartData root = data.getRoot();
		ModelPartData right_leg = root.getChild(EntityModelPartNames.RIGHT_LEG);
		ModelPartData right_legCloth = right_leg.addChild("right_leg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F))
				.uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = root.getChild(EntityModelPartNames.LEFT_LEG);
		ModelPartData left_legCloth = left_leg.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.01F))
				.uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = root.getChild(EntityModelPartNames.RIGHT_ARM);
		ModelPartData right_armCloth = right_arm.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.01F))
				.uv(40, 32).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData left_arm = root.getChild(EntityModelPartNames.LEFT_ARM);
		ModelPartData left_armCloth = left_arm.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.01F))
				.uv(48, 48).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData body = root.getChild(EntityModelPartNames.BODY);
		ModelPartData bodyCloth = body.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.01F))
		.uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = root.getChild(EntityModelPartNames.HEAD);
		ModelPartData headCloth = head.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.01F))
		.uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(data, 64, 64);
	}
	@Override
	public void setAngles(AbstractClientPlayerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		super.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	public void adjustArmPivots(boolean slim) {
		if (clothed_r_arm != null) {
			clothed_r_arm.pivotX = slim ? 1.0F : -0.5F;
		}
		if (clothed_l_arm != null) {
			clothed_l_arm.pivotX = slim ? 0.0F : 1.5F;
		}
	}
}