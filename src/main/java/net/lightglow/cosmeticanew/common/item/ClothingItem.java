package net.lightglow.cosmeticanew.common.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ClothingItem extends TrinketItem {
    public final String texture;
    public ClothingItem(Settings settings, String texture) {
        super(settings);
        this.texture = texture;
    }

    public String getClothTexture() {
        return this.texture;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "cosmeticanew:generic_armor", 1.0, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }
}
