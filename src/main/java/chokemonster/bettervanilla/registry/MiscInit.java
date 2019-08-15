package chokemonster.bettervanilla.registry;

import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.recipes.BlastingRecipe;
import chokemonster.bettervanilla.recipes.BlastingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
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
}