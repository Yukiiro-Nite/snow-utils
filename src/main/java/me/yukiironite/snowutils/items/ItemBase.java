package me.yukiironite.snowutils.items;

import me.yukiironite.snowutils.SnowUtils;
import net.minecraft.item.Item;

public class ItemBase extends Item {
  public ItemBase() {
    super(new Item.Properties().group(SnowUtils.TAB));
  }
}