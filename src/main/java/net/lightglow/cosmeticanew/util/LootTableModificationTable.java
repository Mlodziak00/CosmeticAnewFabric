package net.lightglow.cosmeticanew.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.lightglow.cosmeticanew.common.ItemInit;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableModificationTable {
    private static final Identifier BASTION_TREASURE_LOOT =
            new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier VILLAGE_PLAINS_LOOT =
            new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier MINESHAFT_LOOT =
            new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier RUINED_PORTAL_LOOT =
            new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier DESERT_PYRAMID_LOOT =
            new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier SIMPLE_DUNGEON_LOOT =
            new Identifier("minecraft", "chests/simple_dungeon");


    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (BASTION_TREASURE_LOOT.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ItemInit.ROYAL_MANTLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (VILLAGE_PLAINS_LOOT.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ItemInit.NOSTALGIC_CLOTHES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (MINESHAFT_LOOT.equals(id) || RUINED_PORTAL_LOOT.equals(id) || DESERT_PYRAMID_LOOT.equals(id) || SIMPLE_DUNGEON_LOOT.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ItemInit.CLOTHIER_SPAWNER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
