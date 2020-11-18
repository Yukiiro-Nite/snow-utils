package me.yukiironite.snowutils.init;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.entities.IronSnowGolemEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
  public static DeferredRegister<EntityType<?>> EntityTypes = DeferredRegister.create(ForgeRegistries.ENTITIES, SnowUtils.MOD_ID);

  public static final RegistryObject<EntityType<IronSnowGolemEntity>> IRON_SNOW_GOLEM = EntityTypes.register(
    "iron_snow_golem",
    () ->
      EntityType.Builder
        .create(IronSnowGolemEntity::new, EntityClassification.CREATURE)
        .size(0.7f, 1.9f)
        .build(new ResourceLocation(SnowUtils.MOD_ID, "iron_snow_golem").toString())
  );
}
