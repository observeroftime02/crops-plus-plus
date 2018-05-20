package com.github.bartimaeusnek.cropspp.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class TurnipCrop extends BasicFoodCrop {
	public TurnipCrop()
	{
		super();
		OreDict.BSget("crop"+this.name(),this);
		OreDict.BSget("seed"+this.name(),this);
	}
	
	@Override
    public String name() {
        return "Turnip";
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("crop"+this.name());
	}

	@Override
	public String[] attributes() {
        return new String[]{"Food", "Purple", "Carrots"};
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
}
