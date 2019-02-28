package com.github.bartimaeusnek.cropspp.crops.BoP;

import biomesoplenty.api.content.BOPCBlocks;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class GlowingCoralCrop extends BasicDecorationCrop {

    public GlowingCoralCrop() {
        super();
    }

    @Override
    public ItemStack getDisplayItem() {
        return OreDict.ISget("crop" + name().replace(" ", ""));
    }

    @Override
    public String name() {
        return "Glowing Earth Coral";
    }

    @Override
    public int tier() {
        return super.tier() + 4;
    }

    @Override
    public String[] attributes() {
        return new String[]{"Water", "Light", "Shiny"};
    }

    @Override
    public int getEmittedLight(ICropTile crop) {
        return 7;
    }

    @Override
    public boolean canGrow(ICropTile crop) {
        return crop.getSize() < 3;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        if (crop.isBlockBelow(Blocks.glowstone))
            return new ItemStack(BOPCBlocks.coral1, 2, 15);
        else
            return new ItemStack(BOPCBlocks.coral1, 1, 15);
    }

}