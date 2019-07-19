package com.github.bartimaeusnek.cropspp.crops.TF;

import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.abstracts.BasicTinkerBerryCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import twilightforest.item.TFItems;

public class KnighmetalCrop extends BasicTinkerBerryCrop {

    public KnighmetalCrop() {
        super();
    }

    @Override
    public int tier() {
        return 8;
    }

    @Override
    public ItemStack getDisplayItem() {
        return new ItemStack(TFItems.armor_shard);
    }

    @Override
    public String name() {
        return "Knightly " + BasicTinkerBerryCrop.OBname();
    }

    @Override
    public String[] attributes() {
        return new String[]{"OreBerry", "Knightly", "Metal"};
    }

    @Override
    protected String hasBlock() {
        return "blockKnightmetal";
    }

    @Override
    public int growthDuration(ICropTile crop) {
        int r;
        if (ConfigValues.debug)
            r = 1;
        else if (crop.getCurrentSize() >= 2) {
            r = 4500;
        } else if (crop.getCurrentSize() == 3 && (crop.isBlockBelow("blockKnightmetal") || !OreDictionary.doesOreNameExist("blockKnightmetal")))
            r = 3000;
        else {
            // Takes a while to grow from seed
            r = 1000;
        }

        return r;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        if (crop.getCurrentSize() == 4 && (crop.isBlockBelow("blockKnightmetal") || !OreDictionary.doesOreNameExist("blockKnightmetal"))) {
            return new ItemStack(TFItems.armor_shard).splitStack(4);
        } else return new ItemStack(TFItems.armor_shard);
    }

}
