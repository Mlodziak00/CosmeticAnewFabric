package net.lightglow.cosmeticanew;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lightglow.cosmeticanew.common.EntityInit;
import net.lightglow.cosmeticanew.common.ItemGroupInit;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.lightglow.cosmeticanew.entity.custom.ClothierEntity;
import net.lightglow.cosmeticanew.util.LootTableModificationTable;
import net.lightglow.cosmeticanew.util.ModCustomTrades;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CosmeticAnew implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("cosmeticanew");
	public static String MOD_ID = "cosmeticanew";


	@Override
	public void onInitialize() {
		ItemInit.register();
		ItemGroupInit.register();
		ModCustomTrades.register();
		FabricDefaultAttributeRegistry.register(EntityInit.CLOTHIER, ClothierEntity.createClothierAttributes());
		LootTableModificationTable.modifyLootTables();
	}
	public static Identifier id(String name){
		return new Identifier(MOD_ID, name);
	}

}