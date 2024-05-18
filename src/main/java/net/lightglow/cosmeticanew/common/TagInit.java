package net.lightglow.cosmeticanew.common;

import net.lightglow.cosmeticanew.CosmeticAnew;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class TagInit {
    public static class Items {
        public static final TagKey<Item> CLOTHIER_SELLABLE = createTag("clothier_sellable");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, CosmeticAnew.id(name));
        }
    }
}
