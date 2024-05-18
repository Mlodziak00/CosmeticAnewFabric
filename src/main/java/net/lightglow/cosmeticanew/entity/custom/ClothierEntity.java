package net.lightglow.cosmeticanew.entity.custom;

import net.lightglow.cosmeticanew.common.TagInit;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ClothierEntity extends PassiveEntity {

    public final AnimationState idleAnimState = new AnimationState();
    private int idleAnimTimeout = 0;

    public ClothierEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }
    private void setupAnimStates(){
        if (this.idleAnimTimeout <=0){
            this.idleAnimTimeout = this.random.nextInt(40) + 80;
            this.idleAnimState.start(this.age);
        } else {
            --this.idleAnimTimeout;
        }
    }
    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient){
            setupAnimStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new FleeEntityGoal(this, HostileEntity.class, 8.0F, 0.7, 0.9));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 0.5));
        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 0.35));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.35));
        this.goalSelector.add(9, new StopAndLookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
    }

    public static DefaultAttributeContainer.Builder createClothierAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7f);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!stack.isOf(Items.GOLD_INGOT)) {
            if (player.isSneaking()) {
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.NEUTRAL, 1, 1, true);
                this.getWorld().addParticle(ParticleTypes.HEART, this.getX(), this.getY() + 0.95f, this.getZ(), 0, 0.05d, 0);
                return ActionResult.success(true);
            }
        } else {
            stack.decrement(1);
            this.dropItem(Registries.ITEM.getOrCreateEntryList(TagInit.Items.CLOTHIER_SELLABLE).getRandom(random).get().value());
            for (int i = 0; i < 360 ; i++) {
                if (i % 20 == 0) {
                    this.getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY() + 0.45, this.getZ(), Math.cos(i) * 0.02d, 0.05d, Math.sin(i) * 0.02d);
                }
            }
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_CAT_PURREOW, SoundCategory.NEUTRAL, 1, 1, true);
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.NEUTRAL, 1, 1, true);
            this.remove(RemovalReason.DISCARDED);
            return ActionResult.success(true);
        }
        return super.interactMob(player, hand);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
