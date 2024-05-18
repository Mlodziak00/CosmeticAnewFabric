package net.lightglow.cosmeticanew.common;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.lightglow.cosmeticanew.CosmeticAnew;
import net.lightglow.cosmeticanew.entity.custom.ClothierEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EntityInit {
    public static final EntityType<ClothierEntity> CLOTHIER = Registry.register(Registries.ENTITY_TYPE,
            CosmeticAnew.id("clothier"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ClothierEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.9f)).build());
}
