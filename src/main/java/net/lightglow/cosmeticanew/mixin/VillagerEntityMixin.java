package net.lightglow.cosmeticanew.mixin;

import dev.emi.trinkets.api.TrinketsApi;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InteractionObserver;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerDataContainer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;

@Mixin(VillagerEntity.class)
public abstract class VillagerEntityMixin extends MerchantEntity implements InteractionObserver, VillagerDataContainer {

    public VillagerEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "prepareOffersFor", at = @At("TAIL"))
    private void prepTrades(PlayerEntity player, CallbackInfo ci){
        if (TrinketsApi.getTrinketComponent(player).get().isEquipped(ItemInit.WANDERING_TRADER_CLOTHING)) {
            Iterator var5 = this.getOffers().iterator();
            while(var5.hasNext()) {
                TradeOffer tradeOffer2 = (TradeOffer)var5.next();
                double d = 0.3 + 0.0625 * 2;
                int k = (int)Math.floor(d * (double)tradeOffer2.getOriginalFirstBuyItem().getCount());
                tradeOffer2.increaseSpecialPrice(-Math.max(k, 1));
            }
        }
    }
}
