package me.yukiironite.snowutils.client.render;

import me.yukiironite.snowutils.SnowUtils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SnowManRenderer;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.ResourceLocation;

public class NetheriteSnowGolemRenderer extends SnowManRenderer {
  protected static final ResourceLocation TEXTURE = new ResourceLocation(SnowUtils.MOD_ID, "textures/entity/netherite_snow_golem.png");
  public NetheriteSnowGolemRenderer(EntityRendererManager renderManagerIn) {
    super(renderManagerIn);
  }

  @Override
  public ResourceLocation getEntityTexture(SnowGolemEntity entity) {
    return TEXTURE;
  }  
}
