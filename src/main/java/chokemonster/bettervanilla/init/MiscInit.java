package chokemonster.bettervanilla.init;

import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.blocks.Blocks;
import chokemonster.bettervanilla.recipes.BlastingRecipe;
import chokemonster.bettervanilla.recipes.BlastingRecipeSerializer;
import chokemonster.bettervanilla.tileentities.BetterBlastFurnaceTileEntity;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static chokemonster.bettervanilla.BetterVanilla.LOGGER;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscInit {

    public static final TileEntityType<?> BETTERBLASTFURNACETE = TileEntityType.Builder.create(BetterBlastFurnaceTileEntity::new, Blocks.BETTERBLASTFURNACEBLOCK)
            .build(null)
            .setRegistryName("bettervanilla", "better_blast_furnace");

    public static final IRecipeSerializer<BlastingRecipe> BETTERBLASTINGRECIPE = new BlastingRecipeSerializer<>(BlastingRecipe::new, 200);

//    public static final IForgeRegistry<IRecipeType<?>> RECIPE_TYPE = RegistryManager.ACTIVE.getRegistry(IRecipeType.class);

    @SubscribeEvent
    public static void onTETypeRegistry(final RegistryEvent.Register<TileEntityType<?>> TileEntityRegistryEvent) {
        LOGGER.info("Registering BetterBlastFurnaceTE");

        TileEntityRegistryEvent.getRegistry().registerAll(
//                BETTERBLASTFURNACETE
        );
    }

    @SubscribeEvent
    public static void onRecipeSerializerRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> RecipesSerializerRegistry) {

        RecipesSerializerRegistry.getRegistry().registerAll(
                BETTERBLASTINGRECIPE
        );
    }
}
