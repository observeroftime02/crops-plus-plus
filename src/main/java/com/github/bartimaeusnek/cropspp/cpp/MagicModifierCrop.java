package com.github.bartimaeusnek.cropspp.cpp;

import com.github.bartimaeusnek.cropspp.ConfigValures;
import com.github.bartimaeusnek.cropspp.crops.TC.PrimordialPearlBerryCrop;
import com.github.bartimaeusnek.cropspp.items.CppItems;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MagicModifierCrop extends PrimordialPearlBerryCrop {

	public MagicModifierCrop() {
		super();
	}
	
	@Override
    public String name() {
        return "Magical Nightshade";
    }
	
	@Override
	public int tier() {
		return 13;
	}
	
	@Override
	public boolean canCross(ICropTile crop) {
		return crop.getSize()==this.maxSize();
	}

	@Override
	public ItemStack getSeeds(ICropTile crop) {
		return crop.generateSeeds(crop.getCrop(),crop.getGrowth(),crop.getGain(),crop.getResistance(), crop.getScanLevel());
	}
	
    @Override
    public int growthDuration(ICropTile crop) {
    	if (ConfigValures.Debug == true)
    		return 1;
        else {
            return ConfigValures.PrimordialBerryGroth/16;
        }
    }
    
	@Override
	public float dropGainChance() { 
		return (float) ((float) ((Math.pow(0.95, (float) tier()))*ConfigValures.BerryGain)*(ConfigValures.PrimordialBerryGain*1.5));
	}

	@Override
	public int getEmittedLight(ICropTile crop) {
		if (crop.getSize()==4)
        return 4;
		else return 0;
    }
	
    @Override
    public boolean canGrow(ICropTile crop) {
    	boolean ret = false;
    	if (crop.getSize() < 3)
    		ret = true;
    	else if ((crop.getSize() == 3 && crop.isBlockBelow("blockIchorium")) || (crop.getSize() == 3 && !OreDictionary.doesOreNameExist("blockIchorium")))
    		ret = true;
        return ret;
    }
	
    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        return 1;
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
	return new ItemStack(CppItems.Modifier,1,1);
	}
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
}

