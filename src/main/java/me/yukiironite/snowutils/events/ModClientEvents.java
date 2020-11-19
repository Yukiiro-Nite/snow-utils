package me.yukiironite.snowutils.events;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.entities.GoldSnowGolemEntity;
import me.yukiironite.snowutils.entities.IronSnowGolemEntity;
import me.yukiironite.snowutils.entities.DiamondSnowGolemEntity;
import me.yukiironite.snowutils.entities.NetheriteSnowGolemEntity;
import me.yukiironite.snowutils.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
  modid = SnowUtils.MOD_ID,
  bus = Mod.EventBusSubscriber.Bus.FORGE,
  value = Dist.CLIENT
)
public class ModClientEvents {
  public static final HashMap<UUID, Item> entitiesToUpgrade = new HashMap<>();
  public static final List<Item> upgradeItems = Arrays.asList(
    Items.GOLD_BLOCK,
    Items.IRON_BLOCK,
    Items.DIAMOND_BLOCK,
    Items.NETHERITE_BRICKS // not sure why this is bricks, should be block.
  );

  @SubscribeEvent
  public static void onPlayerUpgradeSnowman(EntityInteract event) {
    PlayerEntity player = event.getPlayer();
    Item heldItem = player.getHeldItemMainhand().getItem();
    Entity target = event.getTarget();
    boolean shouldUpgradeSnowman = target.getType() == EntityType.SNOW_GOLEM
      && upgradeItems.contains(heldItem)
      && !entitiesToUpgrade.containsKey(target.getUniqueID())
      && !player.getEntityWorld().isRemote;

    if(shouldUpgradeSnowman) {
      entitiesToUpgrade.put(target.getUniqueID(), heldItem);
      target.remove();
      player.getHeldItemMainhand().shrink(1);
    }
  }

  @SubscribeEvent
  public static void onSnowmanRemove(EntityLeaveWorldEvent event) {
    Entity target = event.getEntity();
    UUID targetId = target.getUniqueID();
    boolean upgradeTarget = entitiesToUpgrade.containsKey(targetId)
      && !target.getEntityWorld().isRemote;

    if(upgradeTarget) {
      Item upgradeItem = entitiesToUpgrade.get(targetId);
      World world = target.getEntityWorld();
      Entity upgradedGolem;

      if(upgradeItem == Items.GOLD_BLOCK) {
        upgradedGolem = new GoldSnowGolemEntity(ModEntityTypes.GOLD_SNOW_GOLEM.get(), world);
      } else if(upgradeItem == Items.IRON_BLOCK) {
        upgradedGolem = new IronSnowGolemEntity(ModEntityTypes.IRON_SNOW_GOLEM.get(), world);
      } else if(upgradeItem == Items.DIAMOND_BLOCK) {
        upgradedGolem = new DiamondSnowGolemEntity(ModEntityTypes.DIAMOND_SNOW_GOLEM.get(), world);
      } else if(upgradeItem == Items.NETHERITE_BRICKS) {
        upgradedGolem = new NetheriteSnowGolemEntity(ModEntityTypes.NETHERITE_SNOW_GOLEM.get(), world);
      } else {
        upgradedGolem = new SnowGolemEntity(EntityType.SNOW_GOLEM, world);
      }
      
      upgradedGolem.setPose(target.getPose());
      upgradedGolem.setLocationAndAngles(
        target.getPosX(), target.getPosY(), target.getPosZ(),
        target.rotationPitch, target.rotationYaw
      );
      upgradedGolem.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.5f, 0.5f + (float)Math.random() * 0.25f);
      
      upgradedGolem.getEntityWorld().addEntity(upgradedGolem);
      
      entitiesToUpgrade.remove(targetId);
    }
  }
}
