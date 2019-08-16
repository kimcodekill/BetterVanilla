package chokemonster.bettervanilla.misc;

import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.biomes.BetterNetherBiome;
import chokemonster.bettervanilla.recipes.BlastingRecipe;
import chokemonster.bettervanilla.recipes.BlastingRecipeSerializer;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Reference.MODID)
public class MiscObjects {

    @ObjectHolder("blasting")
    public static final BlastingRecipeSerializer<BlastingRecipe> blasting = null;

    @ObjectHolder("minecraft:nether")
    public static final BetterNetherBiome nether = null;
}
