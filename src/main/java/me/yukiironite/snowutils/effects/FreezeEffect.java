package me.yukiironite.snowutils.effects;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class FreezeEffect extends Effect {
  private static final String movementEffectUUID = UUID.randomUUID().toString();

  public FreezeEffect() {
    super(EffectType.HARMFUL, 7761091);
    this.addAttributesModifier(Attributes.MOVEMENT_SPEED, movementEffectUUID, -1, Operation.MULTIPLY_TOTAL);
  }
}
