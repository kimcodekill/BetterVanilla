package chokemonster.bettervanilla.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class BlockItemBurnable extends BlockItem {
    private int burnTime;

    public BlockItemBurnable(Block blockIn, Properties builder, int burnTime) {
        super(blockIn, builder);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return burnTime;
    }
}
