package me.yukiironite.snowutils.util;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.blocks.BlockItemBase;
import me.yukiironite.snowutils.blocks.SnowBrickBlock;
import me.yukiironite.snowutils.init.ModEntityTypes;
import me.yukiironite.snowutils.items.SnowCone;
import me.yukiironite.snowutils.items.LoadedSnowball;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SnowUtils.MOD_ID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SnowUtils.MOD_ID);

  public static void init() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    ModEntityTypes.EntityTypes.register(FMLJavaModLoadingContext.get().getModEventBus());
  }

  // Items
  public static final RegistryObject<Item> SNOWCONE = ITEMS.register("snow_cone", SnowCone::new);
  public static final RegistryObject<Item> GOLD_SNOWBALL = ITEMS.register("gold_snowball", () -> new LoadedSnowball(2f));
  public static final RegistryObject<Item> IRON_SNOWBALL = ITEMS.register("iron_snowball", () -> new LoadedSnowball(4f));
  public static final RegistryObject<Item> DIAMOND_SNOWBALL = ITEMS.register("diamond_snowball", () -> new LoadedSnowball(5f));
  public static final RegistryObject<Item> NETHERITE_SNOWBALL = ITEMS.register("netherite_snowball", () -> new LoadedSnowball(6f));

  // Blocks
  public static final RegistryObject<Block> SNOW_BRICK_BLOCK = BLOCKS.register("snow_brick_block", SnowBrickBlock::new);

  // Block Items
  public static final RegistryObject<Item> SNOW_BRICK_BLOCK_ITEM = ITEMS.register("snow_brick_block", () -> new BlockItemBase(SNOW_BRICK_BLOCK.get()));

}