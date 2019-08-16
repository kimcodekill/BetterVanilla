package chokemonster.bettervanilla.registry;

import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.blocks.FallingSoulSandBlock;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> BlockRegistryEvent) {

        BlockRegistryEvent.getRegistry().registerAll(
                new FallingSoulSandBlock().setRegistryName("minecraft", "soul_sand")
        );
    }
}