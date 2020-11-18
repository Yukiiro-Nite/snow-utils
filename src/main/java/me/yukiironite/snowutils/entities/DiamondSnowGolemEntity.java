package me.yukiironite.snowutils.entities;

import me.yukiironite.snowutils.util.RegistryHandler;
import me.yukiironite.snowutils.util.SnowballDamage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DiamondSnowGolemEntity extends SnowGolemEntity {
  protected static final ItemStack snowballType = new ItemStack(RegistryHandler.DIAMOND_SNOWBALL.get());

  public DiamondSnowGolemEntity(EntityType<? extends SnowGolemEntity> type, World worldIn) {
    super(type, worldIn);
  }

  public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
    SnowballEntity snowballEntity = new LoadedSnowballEntity(this.world, this, SnowballDamage.DIAMOND);
    snowballEntity.setItem(snowballType);
    double d0 = target.getPosYEye() - (double)1.1F;
    double d1 = target.getPosX() - this.getPosX();
    double d2 = d0 - snowballEntity.getPosY();
    double d3 = target.getPosZ() - this.getPosZ();
    float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
    snowballEntity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
    this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
    this.world.addEntity(snowballEntity);
 }
  
}
