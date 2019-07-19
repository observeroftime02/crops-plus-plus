package com.github.bartimaeusnek.cropspp.crops.TF;

import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import twilightforest.block.TFBlocks;

public class MossCrop extends BasicDecorationCrop {

    @Override
    public String name() {
        return "Moss";
    }

    @Override
    public int tier() {
        return 4;
    }

    @Override
    public String[] attributes() {
        return new String[]{"Green", "Climbable"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(TFBlocks.twilight_plant, 1, 3);
    }

//    @SideOnly(Side.CLIENT)
//    public void registerSprites(IIconRegister iconRegister) {
//        textures = new IIcon[maxSize()];
//
//        for (int i = 1; i <= textures.length; i++) {
//            // ic2:crop/blockCrop.NAME.n is the legacy name for backwards compatiblity
//            textures[i - 1] = iconRegister.registerIcon("bpp:crop/blockCrop.Spanish Moss." + i);
//        }
//    }


    @Override
    public ItemStack getDisplayItem() {
        return new ItemStack(TFBlocks.twilight_plant, 1, 3);
    }
}
