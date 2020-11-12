package me.yukiironite.snowutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SnowBrickBlock extends Block {
  public SnowBrickBlock() {
    super(
      Block.Properties.create(Material.SNOW_BLOCK)
        .hardnessAndResistance(1.0f, 5.0f)
        .sound(SoundType.SNOW)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
        .setRequiresTool()
    );
  }
}
