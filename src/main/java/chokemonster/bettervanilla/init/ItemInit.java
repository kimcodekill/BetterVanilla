package chokemonster.bettervanilla.init;

import chokemonster.bettervanilla.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> ItemRegistryEvent) {

        ItemRegistryEvent.getRegistry().registerAll(
//                Items.BETTERBLASTFURNACEITEM
        );
    }
}
