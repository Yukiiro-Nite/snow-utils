package me.yukiironite.snowutils.client.render;

import me.yukiironite.snowutils.SnowUtils;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SnowManRenderer;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.ResourceLocation;

public class DiamondSnowGolemRenderer extends SnowManRenderer {
  protected static final ResourceLocation TEXTURE = new ResourceLocation(SnowUtils.MOD_ID, "textures/entity/diamond_snow_golem.png");
  public DiamondSnowGolemRenderer(EntityRendererManager renderManagerIn) {
    super(renderManagerIn);
  }

  @Override
  public ResourceLocation getEntityTexture(SnowGolemEntity entity) {
    return TEXTURE;
  }  
}
