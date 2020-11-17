package me.yukiironite.snowutils.items;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.entities.LoadedSnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class LoadedSnowball extends SnowballItem {
  private float baseDamage;

  public LoadedSnowball(float damage) {
    super(
      new Item.Properties()
        .group(SnowUtils.TAB)
    );
    baseDamage = damage;
  }
  
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    ItemStack itemstack = playerIn.getHeldItem(handIn);
    worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
    if (!worldIn.isRemote) {
       SnowballEntity snowballentity = new LoadedSnowballEntity(worldIn, playerIn, baseDamage);
       snowballentity.setItem(itemstack);
       snowballentity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
       worldIn.addEntity(snowballentity);
    }

    playerIn.addStat(Stats.ITEM_USED.get(this));
    if (!playerIn.abilities.isCreativeMode) {
       itemstack.shrink(1);
    }

    return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
 }
}
