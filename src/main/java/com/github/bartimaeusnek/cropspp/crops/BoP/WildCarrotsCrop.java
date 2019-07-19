package com.github.bartimaeusnek.cropspp.crops.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class WildCarrotsCrop extends BasicFoodCrop {
    public WildCarrotsCrop() {
        super();
        OreDict.BSget("cropWildcarrots", this);
        OreDict.BSget("seedWildcarrots", this);
    }

    @Override
    public String name() {
        return "Wild Carrots";
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return OreDict.ISget("cropWildcarrots");
    }

    @SideOnly(Side.CLIENT)
    public List<ResourceLocation> getTexturesLocation() {

        List<ResourceLocation> ret = new ArrayList<>(this.getMaxSize());

        for (int size = 1; size <= this.getMaxSize() - 1; size++) {
            ret.add(new ResourceLocation("blocks/carrots_stage_" + size));
        }
            ret.add(new ResourceLocation("bpp", "blocks/crop/blockCrop.Wild Carrots.3"));

        return ret;
    }

    @Override
    public String[] attributes() {
        return new String[]{"Food", "White", "Carrots"};
    }

    @Override
    public ItemStack getDisplayItem() {
        return OreDict.ISget("cropWildcarrots");
    }
}
