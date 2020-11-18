package me.yukiironite.snowutils.init;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.entities.GoldSnowGolemEntity;
import me.yukiironite.snowutils.entities.IronSnowGolemEntity;
import me.yukiironite.snowutils.entities.DiamondSnowGolemEntity;
import me.yukiironite.snowutils.entities.NetheriteSnowGolemEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
  public static DeferredRegister<EntityType<?>> EntityTypes = DeferredRegister.create(ForgeRegistries.ENTITIES, SnowUtils.MOD_ID);

  public static final RegistryObject<EntityType<GoldSnowGolemEntity>> GOLD_SNOW_GOLEM = EntityTypes.register(
    "gold_snow_golem",
    () ->
      EntityType.Builder
        .create(GoldSnowGolemEntity::new, EntityClassification.CREATURE)
        .size(0.7f, 1.9f)
        .build(new ResourceLocation(SnowUtils.MOD_ID, "gold_snow_golem").toString())
  );

  public static final RegistryObject<EntityType<IronSnowGolemEntity>> IRON_SNOW_GOLEM = EntityTypes.register(
    "iron_snow_golem",
    () ->
      EntityType.Builder
        .create(IronSnowGolemEntity::new, EntityClassification.CREATURE)
        .size(0.7f, 1.9f)
        .build(new ResourceLocation(SnowUtils.MOD_ID, "iron_snow_golem").toString())
  );

  public static final RegistryObject<EntityType<DiamondSnowGolemEntity>> DIAMOND_SNOW_GOLEM = EntityTypes.register(
    "diamond_snow_golem",
    () ->
      EntityType.Builder
        .create(DiamondSnowGolemEntity::new, EntityClassification.CREATURE)
        .size(0.7f, 1.9f)
        .build(new ResourceLocation(SnowUtils.MOD_ID, "diamond_snow_golem").toString())
  );

  public static final RegistryObject<EntityType<NetheriteSnowGolemEntity>> NETHERITE_SNOW_GOLEM = EntityTypes.register(
    "netherite_snow_golem",
    () ->
      EntityType.Builder
        .create(NetheriteSnowGolemEntity::new, EntityClassification.CREATURE)
        .size(0.7f, 1.9f)
        .build(new ResourceLocation(SnowUtils.MOD_ID, "netherite_snow_golem").toString())
  );
}
