package chokemonster.bettervanilla.items;

import chokemonster.bettervanilla.BetterVanilla;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class BetterCompassItem extends Item {
    private BlockPos focus;

    public BetterCompassItem(Properties properties) {
        super(properties);
        this.addPropertyOverride(new ResourceLocation("angle"), new IItemPropertyGetter() {
            @OnlyIn(Dist.CLIENT)
            private double rotation;
            @OnlyIn(Dist.CLIENT)
            private double rota;
            @OnlyIn(Dist.CLIENT)
            private long lastUpdateTick;

            @OnlyIn(Dist.CLIENT)
            public float call(ItemStack thisCompass, @Nullable World worldIn, @Nullable LivingEntity playerIn) {
                if (playerIn == null && !thisCompass.isOnItemFrame()) {
                    return 0.0F;
                } else {
                    boolean isHeld = playerIn != null;
                    Entity entityHolding = isHeld ? playerIn : thisCompass.getItemFrame();
                    if (worldIn == null) {
                        worldIn = ((Entity) entityHolding).world;
                    }

                    if (focus == null)
                        focus = worldIn.getSpawnPoint();

                    double pointerAngle;
                    if (worldIn.dimension.isSurfaceWorld()) {
                        double rotation = isHeld ? (double) ((Entity) entityHolding).rotationYaw : this.getFrameRotation((ItemFrameEntity) entityHolding);
                        rotation = MathHelper.positiveModulo(rotation / 360.0D, 1.0D);
                        double angle = this.getSpawnToAngle(worldIn, (Entity) entityHolding) / 6.2831854820251465D;
                        pointerAngle = 0.5D - (rotation - 0.25D - angle);
                    } else {
                        pointerAngle = Math.random();
                    }

                    if (isHeld) {
                        pointerAngle = this.wobble(worldIn, pointerAngle);
                    }

                    return MathHelper.positiveModulo((float) pointerAngle, 1.0F);
                }
            }

            @OnlyIn(Dist.CLIENT)
            private double wobble(World worldIn, double angle) {
                if (worldIn.getGameTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = worldIn.getGameTime();
                    double wobbleAngle = angle - this.rotation;
                    wobbleAngle = MathHelper.positiveModulo(wobbleAngle + 0.5D, 1.0D) - 0.5D;
                    this.rota += wobbleAngle * 0.1D;
                    this.rota *= 0.8D;
                    this.rotation = MathHelper.positiveModulo(this.rotation + this.rota, 1.0D);
                }

                return this.rotation;
            }

            @OnlyIn(Dist.CLIENT)
            private double getFrameRotation(ItemFrameEntity itemFrame) {
                return (double) MathHelper.wrapDegrees(180 + itemFrame.getHorizontalFacing().getHorizontalIndex() * 90);
            }

            @OnlyIn(Dist.CLIENT)
            private double getSpawnToAngle(IWorld worldIn, Entity entityIn) {

                return Math.atan2((double) focus.getZ() - entityIn.posZ, (double) focus.getX() - entityIn.posX);
            }
        });
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (playerIn instanceof ServerPlayerEntity) {
            if (playerIn.getBedLocation(worldIn.getDimension().getType()) != null) {
                this.focus = playerIn.getBedLocation(worldIn.getDimension().getType());
            } else {
                this.focus = worldIn.getSpawnPoint();
            }
            BetterVanilla.sendHiVisDebug(this.focus.toString());
            return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
        } else {
            return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
        }
    }
}
