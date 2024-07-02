package net.lightglow.cosmeticanew.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {
    public static void register(){
        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ItemInit.WANDERING_TRADER_CLOTHING, 1),
                            1, 12, 0.075f));
                });
    }
}
