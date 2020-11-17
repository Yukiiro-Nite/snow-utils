package me.yukiironite.snowutils.entities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;

public class LoadedSnowballEntity extends SnowballEntity {
  private float baseDamage;

  public LoadedSnowballEntity(World worldIn, LivingEntity throwerIn, float baseDamage) {
    super(worldIn, throwerIn);
    this.baseDamage = baseDamage;
  }
  
  @Override
  protected void onEntityHit(EntityRayTraceResult traceResult) {
    super.onEntityHit(traceResult);
    Entity entity = traceResult.getEntity();
    float blazeMultiplier = entity instanceof BlazeEntity ? 1.5f : 1f;
    float damage = baseDamage * blazeMultiplier;
    entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), damage);
 }
}
