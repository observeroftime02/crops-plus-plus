package com.github.bartimaeusnek.cropspp.crops.TC;

import com.github.bartimaeusnek.cropspp.ConfigValures;
import com.github.bartimaeusnek.cropspp.abstracts.BasicThaumcraftCrop;

import ic2.api.crops.ICropTile;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ShimmerleafCrop extends BasicThaumcraftCrop {

    public ShimmerleafCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

	@Override
	public String name() {
		return "Shimmerleaf";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Magic", "Silver", "Toxic"};
	}
    
    @Override
    public int growthDuration(ICropTile crop) {
        	int r = 9999999;
        	if (ConfigValures.Debug == true)
        		r = 1;
        	else if (crop.getSize() == 1)
                r = 2250;
        	else if (crop.getSize() == 2 && Operators.OR(crop.isBlockBelow("blockQuicksilver") == true, !OreDictionary.doesOreNameExist("blockQuicksilver")))
            	r = 1750;
        	return r;
            }
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek and DreamMasterXXL";
    }

	@Override
	public boolean canGrow(ICropTile crop) {
		boolean r = false;
    	if (ConfigValures.Debug == true)
    		r = crop.getSize() < 3;
    	else if (crop.getSize() == 1)
    		r = crop.getSize() == 1;
    	else if (crop.getSize() == 2)
    		r = (crop.getSize() == 2 && Operators.OR(crop.isBlockBelow("blockQuicksilver"),!(OreDictionary.doesOreNameExist("blockQuicksilver"))));
		return r;
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+this.name());
	}
}
