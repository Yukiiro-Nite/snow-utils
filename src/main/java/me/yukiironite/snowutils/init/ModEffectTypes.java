package me.yukiironite.snowutils.init;

import me.yukiironite.snowutils.SnowUtils;
import me.yukiironite.snowutils.effects.FreezeEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffectTypes {
  public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, SnowUtils.MOD_ID);
  public static final DeferredRegister<Potion> POTION_TYPES = DeferredRegister.create(ForgeRegistries.POTION_TYPES, SnowUtils.MOD_ID);

  public static final RegistryObject<Effect> FREEZE_EFFECT = EFFECTS.register("freeze", FreezeEffect::new);

  public static final RegistryObject<Potion> FREEZE_POTION = POTION_TYPES.register("freeze", () ->
    new Potion(new EffectInstance(FREEZE_EFFECT.get(), 8 * 20, 0))
  );
  public static final RegistryObject<Potion> LONG_FREEZE_POTION = POTION_TYPES.register("long_freeze", () ->
    new Potion(new EffectInstance(FREEZE_EFFECT.get(), 16 * 20, 0))
  );

  public static void addPotionRecipes() {
    BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.ICE, FREEZE_POTION.get()));
    BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(FREEZE_POTION.get(), Items.REDSTONE, LONG_FREEZE_POTION.get()));
  }

  private static class ModBrewingRecipe implements IBrewingRecipe {
    private final Potion bottleInput;
    private final Item itemInput;
    private final ItemStack output;

    public ModBrewingRecipe(Potion bottleInput, Item itemInput, Potion output) {
      this.bottleInput = bottleInput;
      this.itemInput = itemInput;
      this.output = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), output);
    }

    @Override
    public boolean isInput(ItemStack input) {
      return PotionUtils.getPotionFromItem(input).equals(this.bottleInput);
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
      return ingredient.getItem().equals(this.itemInput);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
      if(isInput(input) && isIngredient(ingredient)) {
        return this.output.copy();
      } else {
        return ItemStack.EMPTY;
      }
    }
  }
}