package chokemonster.bettervanilla.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

/**
 * {@link net.minecraft.block.SoulSandBlock}
 * {@link net.minecraft.block.SandBlock}
 */
public class FallingSoulSandBlock extends FallingBlock {

    private final int dustColor;

    public FallingSoulSandBlock() {
        super(Block.Properties.create(Material.SAND, MaterialColor.BROWN).tickRandomly().hardnessAndResistance(0.5F).sound(SoundType.SAND));
        this.dustColor = 1837312;
    }

    @Override
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        entityIn.setMotion(entityIn.getMotion().mul(0.4D, 0.0D, 0.4D));
    }

    @Override
    public void tick(BlockState state, World world, BlockPos pos, Random random) {
        super.tick(state, world, pos, random);
        BubbleColumnBlock.placeBubbleColumn(world, pos.up(), false);
    }

//    @Override
//    public void neighborChanged(BlockState blockState, World world, BlockPos pos1, Block block, BlockPos pos2, boolean someBool) {
//        world.getPendingBlockTicks().scheduleTick(pos1, this, this.tickRate(world));
//    }

    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState p_189876_1_) {
        return this.dustColor;
    }
}
