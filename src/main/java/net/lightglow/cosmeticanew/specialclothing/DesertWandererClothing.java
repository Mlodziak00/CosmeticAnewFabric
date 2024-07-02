package net.lightglow.cosmeticanew.specialclothing;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import net.lightglow.cosmlib.common.item.ClothingItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.UUID;

public class DesertWandererClothing extends ClothingItem {
    public DesertWandererClothing(String modID, String texture, Boolean hideHatLayer, Settings settings) {
        super(modID, texture, hideHatLayer, settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        boolean isSprinting = entity.isSprinting();
        boolean isGrounded = entity.isOnGround();
        PlayerEntity player = (PlayerEntity) entity;
        Vec3d vec = player.getVelocity();
        if (isGrounded && isSprinting && player.getWorld().getBiome(player.getBlockPos()).isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)){
            player.setVelocity(vec.getX() * 1.15f, vec.getY(), vec.getZ() * 1.15f);
        }
        super.tick(stack, slot, entity);
    }
}
