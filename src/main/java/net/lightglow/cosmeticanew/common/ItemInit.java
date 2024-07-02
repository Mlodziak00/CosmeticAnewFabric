package net.lightglow.cosmeticanew.common;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.specialclothing.DesertWandererClothing;
import net.lightglow.cosmlib.common.item.ClothingItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {

    public static Item ROYAL_MANTLE = registerItem("royal_mantle", new ClothingItem("cosmeticanew", "royal_mantle", true, new FabricItemSettings().maxCount(1)));
    public static Item NOSTALGIC_CLOTHES = registerItem("nostalgic_clothes", new ClothingItem( "cosmeticanew", "nostalgic_clothes", true, new FabricItemSettings().maxCount(1)));
    public static Item FANCY_SUIT = registerItem("fancy_suit", new ClothingItem("cosmeticanew", "fancy_suit", true, new FabricItemSettings().maxCount(1)));
    public static Item LUMBER_CLOTHES = registerItem("lumber_clothes", new ClothingItem("cosmeticanew", "lumber_clothes", true, new FabricItemSettings().maxCount(1)));
    public static Item CASUAL_CLOTHES = registerItem("casual_clothes", new ClothingItem("cosmeticanew", "casual_clothes", true, new FabricItemSettings().maxCount(1)));
    public static Item DESERT_WANDERER = registerItem("desert_wanderer", new DesertWandererClothing("cosmeticanew", "desert_wanderer", false, new FabricItemSettings().maxCount(1)));
    public static Item ILLAGER_CLOTHING = registerItem("illager_clothes", new ClothingItem("cosmeticanew", "illager_clothing", true, new FabricItemSettings().maxCount(1)));
    public static Item WANDERING_TRADER_CLOTHING = registerItem("wandering_trader_clothing", new ClothingItem("cosmeticanew", "wandering_trader", true, new FabricItemSettings().maxCount(1)));
    public static Item CLOTHIER_SPAWNER = registerItem("clothier_spawner", new ClothierCoinItem(EntityInit.CLOTHIER, new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, CosmeticAnew.id(name), item);
    }
    public static void register(){}
}
