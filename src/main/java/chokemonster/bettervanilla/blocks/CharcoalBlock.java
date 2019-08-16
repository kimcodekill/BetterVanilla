package chokemonster.bettervanilla.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class CharcoalBlock extends Block {
    public CharcoalBlock() {
        super(Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(5.0F, 6.0F));
    }
}
