package com.github.bartimaeusnek.cropspp.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class WildCarrotsCrop extends BasicFoodCrop {
	public WildCarrotsCrop()
	{
		super();
		OreDict.BSget("cropWildcarrots",this);
		OreDict.BSget("seedWildcarrots",this);
	}
	
	@Override
    public String name() {
        return "Wild Carrots";
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("cropWildcarrots");
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
