package net.lightglow.cosmeticanew.common.reg;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.common.item.ClothingItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
    // CLOTHING
    public static Item CLOTHING_TEST = registerItem("testclothing", new ClothingItem(new FabricItemSettings().maxCount(1), "test_clothing"));
    public static Item CLOTHING_TEST2 = registerItem("testclothing2", new ClothingItem(new FabricItemSettings().maxCount(1), "test_clothing2"));


    // TOOLS/WEAPONS

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, CosmeticAnew.id(name), item);
    }
    public static void register(){}
}
