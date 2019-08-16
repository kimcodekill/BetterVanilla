package chokemonster.bettervanilla.registry;

import chokemonster.bettervanilla.BetterVanilla;
import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.biomes.BetterNetherBiome;
import chokemonster.bettervanilla.recipes.BlastingRecipe;
import chokemonster.bettervanilla.recipes.BlastingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscInit {

    @SubscribeEvent
    public static void onRecipeSerializerRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> registryEvent) {
        registryEvent.getRegistry().registerAll(
                new BlastingRecipeSerializer<>(BlastingRecipe::new, 200).setRegistryName(Reference.MODID, "blasting")
        );
    }

    @SubscribeEvent
    public static void onBiomeRegistry(final RegistryEvent.Register<Biome> registryEvent) {
        registryEvent.getRegistry().registerAll(
                new BetterNetherBiome().setRegistryName("minecraft", "nether")
        );
        BetterVanilla.BETTERVANILLALOGGER.warn("Registered custom Nether biome");
    }
}