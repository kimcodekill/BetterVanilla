package chokemonster.bettervanilla.interfaces;

import chokemonster.bettervanilla.recipes.BlastingRecipe;
import net.minecraft.item.crafting.IRecipeType;

public interface IBetterRecipeType extends IRecipeType {
    IRecipeType<BlastingRecipe> BETTERBLASTING = IRecipeType.register("better_blasting");
}
