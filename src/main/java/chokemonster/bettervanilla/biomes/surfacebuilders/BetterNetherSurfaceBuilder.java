package chokemonster.bettervanilla.biomes.surfacebuilders;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.NetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class BetterNetherSurfaceBuilder extends NetherSurfaceBuilder {

    private static final BlockState CAVE_AIR;
    private static final BlockState NETHERRACK;
    private static final BlockState GRAVEL;
    private static final BlockState SOUL_SAND;
    protected long seed;
    protected OctavesNoiseGenerator noiseGenerator;

    public BetterNetherSurfaceBuilder() {
        super(SurfaceBuilderConfig::deserialize);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int middleY = seaLevel + 1;
        int posX = x & 15;
        int posZ = z & 15;
        double multiplier = 0.03125D;
        boolean addNoiseA = this.noiseGenerator.func_205563_a((double) x * multiplier, (double) z * multiplier, 0.0D) + random.nextDouble() * 0.2D > 0.0D;
        boolean addNoiseB = this.noiseGenerator.func_205563_a((double) x * multiplier, 109.0D, (double) z * multiplier) + random.nextDouble() * 0.2D > 0.0D;
        int noiseInt = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int stateFlag = -1;
        BlockState blockToPlaceA = NETHERRACK;
        BlockState blockToPlaceB = NETHERRACK;

        for (int posY = 127; posY >= 0; --posY) {
            mutableBlockPos.setPos(posX, posY, posZ);
            BlockState blockState = chunkIn.getBlockState(mutableBlockPos);
            if (blockState.getBlock() != null && !blockState.isAir(chunkIn.getWorldForge(), mutableBlockPos)) {
                if (blockState.getBlock() == defaultBlock.getBlock()) {
                    if (stateFlag == -1) {
                        if (noiseInt <= 0) {
                            blockToPlaceA = CAVE_AIR;
                            blockToPlaceB = NETHERRACK;
                        } else if (posY >= middleY - 4 && posY <= middleY + 1) {
                            blockToPlaceA = NETHERRACK;
                            blockToPlaceB = NETHERRACK;
                            if (addNoiseB) {
                                blockToPlaceA = GRAVEL;
                                blockToPlaceB = NETHERRACK;
                            }

                            if (addNoiseA) {
                                blockToPlaceA = SOUL_SAND;
                                blockToPlaceB = SOUL_SAND;
                            }
                        }

                        if (posY < middleY && (blockToPlaceA == null || blockToPlaceA.getBlock() == Blocks.CAVE_AIR /* blocktoPlaceA.isAir()*/)) {
                            blockToPlaceA = defaultFluid;
                        }

                        stateFlag = noiseInt;
                        if (posY >= middleY - 1) {
                            chunkIn.setBlockState(mutableBlockPos, blockToPlaceA, false);
                        } else {
                            chunkIn.setBlockState(mutableBlockPos, blockToPlaceB, false);
                        }
                    } else if (stateFlag > 0) {
                        --stateFlag;
                        chunkIn.setBlockState(mutableBlockPos, blockToPlaceB, false);
                    }
                }
            } else {
                stateFlag = -1;
            }
        }

    }

    @Override
    public void setSeed(long seedIn) {
        if (this.seed != seedIn || this.noiseGenerator == null) {
            this.noiseGenerator = new OctavesNoiseGenerator(new SharedSeedRandom(seedIn), 4);
        }

        this.seed = seedIn;
    }

    static {
        CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
        NETHERRACK = Blocks.NETHERRACK.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        SOUL_SAND = chokemonster.bettervanilla.blocks.Blocks.soul_sand.getDefaultState();
    }
}
