package chokemonster.bettervanilla.registry;

import chokemonster.bettervanilla.Reference;
import chokemonster.bettervanilla.blocks.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> ItemRegistryEvent) {

        ItemRegistryEvent.getRegistry().registerAll(
                new BlockItem(Blocks.soul_sand, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(Blocks.soul_sand.getRegistryName())
        );
    }
}