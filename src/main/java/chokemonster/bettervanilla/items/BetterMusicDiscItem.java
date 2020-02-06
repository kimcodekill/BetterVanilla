package chokemonster.bettervanilla.items;

import chokemonster.bettervanilla.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

//If you really want to do this, go to: https://minecraft.gamepedia.com/Tutorials/Sound_directory
//Check if music-file is mono
public class BetterMusicDiscItem extends MusicDiscItem {
    public BetterMusicDiscItem(int comparatorValueIn, SoundEvent soundIn) {
        super(comparatorValueIn, soundIn, (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
    }
}
