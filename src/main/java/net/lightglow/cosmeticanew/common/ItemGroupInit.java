package net.lightglow.cosmeticanew.common;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ItemGroupInit {
    public static final ItemGroup CLOTHING_GROUP = FabricItemGroup.builder()
            .displayName(Text.literal("Clothing"))
            .icon(() -> new ItemStack(ItemInit.CLOTHIER_SPAWNER))
            .entries((displayContext, entries) ->{
                entries.add(ItemInit.CLOTHIER_SPAWNER);
                entries.add(ItemInit.CASUAL_CLOTHES);
                entries.add(ItemInit.NOSTALGIC_CLOTHES);
                entries.add(ItemInit.LUMBER_CLOTHES);
                entries.add(ItemInit.FANCY_SUIT);
                entries.add(ItemInit.ROYAL_MANTLE);
                entries.add(ItemInit.DESERT_WANDERER);
                entries.add(ItemInit.ILLAGER_CLOTHING);
                entries.add(ItemInit.WANDERING_TRADER_CLOTHING);
            }).build();


    public static void register(){
        Registry.register(Registries.ITEM_GROUP, CosmeticAnew.id("clothing_group"), CLOTHING_GROUP);
    }
}
