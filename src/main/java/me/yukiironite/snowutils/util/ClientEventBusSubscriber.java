package me.yukiironite.snowutils.util;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.client.render.GoldSnowGolemRenderer;
import me.yukiironite.snowutils.client.render.IronSnowGolemRenderer;
import me.yukiironite.snowutils.client.render.DiamondSnowGolemRenderer;
import me.yukiironite.snowutils.client.render.NetheriteSnowGolemRenderer;
import me.yukiironite.snowutils.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
  modid = SnowUtils.MOD_ID,
  bus = Mod.EventBusSubscriber.Bus.MOD,
  value = Dist.CLIENT
)
public class ClientEventBusSubscriber {
  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GOLD_SNOW_GOLEM.get(), GoldSnowGolemRenderer::new);
    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IRON_SNOW_GOLEM.get(), IronSnowGolemRenderer::new);
    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DIAMOND_SNOW_GOLEM.get(), DiamondSnowGolemRenderer::new);
    RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NETHERITE_SNOW_GOLEM.get(), NetheriteSnowGolemRenderer::new);
  }
}
