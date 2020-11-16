package me.yukiironite.snowutils.items;

import me.yukiironite.snowutils.SnowUtils;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class SnowCone extends Item {
  public SnowCone() {
    super(
      new Item.Properties()
        .group(SnowUtils.TAB)
        .food(
          new Food.Builder()
            .hunger(5)
            .saturation(1.5f)
            .build()
        )
    );
  }
}