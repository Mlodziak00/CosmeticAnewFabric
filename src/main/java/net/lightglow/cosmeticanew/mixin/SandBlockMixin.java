package net.lightglow.cosmeticanew.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.UUID;

@Mixin(SandBlock.class)
public abstract class SandBlockMixin extends FallingBlock {
    @Unique
    private static final UUID SAND_SPEED_BOOST_ID = UUID.fromString("87f46a96-686f-4796-b035-22e16ee9e125");

    public SandBlockMixin(Settings settings) {
        super(settings);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity player){
            if (entity.isOnGround() && entity.getWorld().getBlockState(pos).isIn(BlockTags.SAND)){
                if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemInit.DESERT_WANDERER)){
                    EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                    if (entityAttributeInstance == null) {
                        return;
                    }

                    entityAttributeInstance.addTemporaryModifier(new EntityAttributeModifier(SAND_SPEED_BOOST_ID, "Sand speed boost", (0.03F * (1.0F + 0.35F)), EntityAttributeModifier.Operation.ADDITION));
                }
            }
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
