package net.lightglow.cosmeticanew;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.SlotType;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.util.TriState;
import net.lightglow.cosmeticanew.common.reg.ItemInit;
import net.lightglow.cosmeticanew.common.reg.TagsInit;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CosmeticAnew implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "cosmeticanew";
	public static final Logger LOGGER = LoggerFactory.getLogger("cosmeticanew");



	@Override
	public void onInitialize() {
		ItemInit.register();
		EquipmentSlot slot = EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, 2);
		TrinketsApi.registerTrinketPredicate(id(slot.getName()), ((itemStack, slotReference, livingEntity) -> {
			if (itemStack.isIn(TagsInit.Items.COSMETICS)){
				return TriState.TRUE;
			}
			return TriState.DEFAULT;
		}));
	}

	public static ItemStack getCosmeticArmor(LivingEntity entity, EquipmentSlot slot) {
		Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(entity);
		if(component.isPresent()) {
			List<Pair<SlotReference, ItemStack>> list = component.get().getEquipped(stack -> stack.isIn(TagsInit.Items.COSMETICS));
			for(Pair<SlotReference, ItemStack> equipped : list) {
				SlotType slotType = equipped.getLeft().inventory().getSlotType();
				if(!slotType.getName().equals("necklace")) {
					continue;
				}
				if(!slotType.getGroup().equalsIgnoreCase(slot.getName())) {
					continue;
				}
				return equipped.getRight();
			}
		}
		return ItemStack.EMPTY;
	}

	public static Identifier id(String name){
		return new Identifier(MOD_ID, name);
	}
}