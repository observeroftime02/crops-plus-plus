package com.github.bartimaeusnek.cropspp.crops.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.crops.cpp.VineCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FloweringVinesCrop extends VineCrop {
    public FloweringVinesCrop() {
        super();
    }

    @Override
    public int tier() {
        return 3;
    }

    @Override
    public boolean canGrow(ICropTile crop) {
        return crop.getCurrentSize() < 4;
    }

    @Override
    public int maxSize() {
        return 4;
    }

    @Override
    public String name() {
        return "Flowering Vines";
    }

    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }

    @Override
    public String[] attributes() {
        return new String[]{"Green", "Tendrilly", "Flower"};
    }

    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getCurrentSize() >= 3;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        if (crop.getCurrentSize() == 3)
            return new ItemStack(Item.getItemById(106), 2, 0);
        else if (crop.getCurrentSize() == 4)
            return getDisplayItem();
        else
            return null;
    }

    @Override
    public ItemStack getDisplayItem() {
        return OreDict.ISget("crop" + name()).copy().splitStack(2);
    }

}
