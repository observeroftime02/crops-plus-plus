package com.github.bartimaeusnek.cropspp.crops.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class EyebulbCrop extends BasicDecorationCrop {

    public EyebulbCrop() {
        super();
        OreDict.BSget("crop" + name(), this);
    }

    @Override
    public ItemStack getDisplayItem() {
        return OreDict.ISget("crop" + name());
    }

    @Override
    public String name() {
        return "Eyebulb";
    }

    @Override
    public String[] attributes() {
        return new String[]{"Nether", "Evil", "Bad"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return getDisplayItem();
    }

}
