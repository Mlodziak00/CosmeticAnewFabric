package net.lightglow.cosmeticanew.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
    @Inject(
            method = {"wearsGoldArmor"},
            at = {@At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"
            )},
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void wearingMantle(LivingEntity entity, CallbackInfoReturnable<Boolean> cir, Iterable iterable, Iterator var2, ItemStack itemStack){
        if (TrinketsApi.getTrinketComponent(entity).get().isEquipped(ItemInit.ROYAL_MANTLE)){
            cir.setReturnValue(true);
        }
    }
}
