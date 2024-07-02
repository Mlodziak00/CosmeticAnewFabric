package net.lightglow.cosmeticanew.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.function.Predicate;

@Mixin(ActiveTargetGoal.class)
public class ActiveTargetGoalMixin {
    @ModifyVariable(method = "<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;IZZLjava/util/function/Predicate;)V", at= @At("HEAD"), argsOnly = true)
    private static Predicate<LivingEntity> clothingMobNeutrality(Predicate<LivingEntity> value, MobEntity mob){
        Predicate<LivingEntity> neutralityPredicate = target -> {
            if (mob instanceof IllagerEntity) {
                if (TrinketsApi.getTrinketComponent(target).get().isEquipped(ItemInit.ILLAGER_CLOTHING)) {
                    return false;
                }
            }
            if (mob instanceof IronGolemEntity) {
                if (TrinketsApi.getTrinketComponent(target).get().isEquipped(ItemInit.ILLAGER_CLOTHING)) {
                    return true;
                }
            }
            return true;
        };
        if (value == null){
            return neutralityPredicate;
        }
        return value.and(neutralityPredicate);
    }
}
