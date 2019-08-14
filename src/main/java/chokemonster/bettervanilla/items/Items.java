package chokemonster.bettervanilla.items;

import chokemonster.bettervanilla.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Items {

    public static final BlockItem BETTERBLASTFURNACEITEM = provideBlockItem(Blocks.BETTERBLASTFURNACEBLOCK, new Item.Properties().group(ItemGroup.DECORATIONS));

    private static BlockItem provideBlockItem(Block block, Item.Properties properties) {
        return (BlockItem) new BlockItem(block, properties).setRegistryName(block.getRegistryName());
    }
}
