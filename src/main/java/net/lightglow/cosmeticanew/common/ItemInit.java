package net.lightglow.cosmeticanew.common;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmlib.common.item.ClothingItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {

    public static Item ROYAL_MANTLE = registerItem("royal_mantle", new ClothingItem(new FabricItemSettings().maxCount(1), "cosmeticanew", "royal_mantle"));
    public static Item NOSTALGIC_CLOTHES = registerItem("nostalgic_clothes", new ClothingItem(new FabricItemSettings().maxCount(1), "cosmeticanew", "nostalgic_clothes"));
    public static Item FANCY_SUIT = registerItem("fancy_suit", new ClothingItem(new FabricItemSettings().maxCount(1), "cosmeticanew", "fancy_suit"));
    public static Item LUMBER_CLOTHES = registerItem("lumber_clothes", new ClothingItem(new FabricItemSettings().maxCount(1), "cosmeticanew", "lumber_clothes"));
    public static Item CASUAL_CLOTHES = registerItem("casual_clothes", new ClothingItem(new FabricItemSettings().maxCount(1), "cosmeticanew", "casual_clothes"));

    public static Item CLOTHIER_SPAWNER = registerItem("clothier_spawner", new ClothierCoinItem(EntityInit.CLOTHIER, new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, CosmeticAnew.id(name), item);
    }
    public static void register(){}
}
