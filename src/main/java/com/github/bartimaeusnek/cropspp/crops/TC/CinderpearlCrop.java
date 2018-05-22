package com.github.bartimaeusnek.cropspp.crops.TC;

import com.github.bartimaeusnek.croploadcore.Operators;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.ConfigValures;
import com.github.bartimaeusnek.cropspp.abstracts.BasicThaumcraftCrop;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CinderpearlCrop extends BasicThaumcraftCrop {

    public CinderpearlCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

	@Override
	public String name() {
		return "Cinderpearl";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Magic", "Blaze", "Nether"};
	}
    
    @Override
    public String discoveredBy() {
    	 return "bartimaeusnek and mitchej123";
    }

    @Override
    public int growthDuration(ICropTile crop) {
        	int r;
        	if (ConfigValures.Debug == true)
        		r = 1;
        	else if (crop.getSize() == 1)
                r = 2250;
        	else if (crop.getSize() == 2 && Operators.OR(crop.isBlockBelow("blockBlaze"),Operators.NOT(OreDictionary.doesOreNameExist("blockBlaze"))))
            	r = 1750;        	
            else 
                r = 250;
        	return r;
            }
        
	@Override
	public boolean canGrow(ICropTile crop) {
		boolean r = false;
    	if (ConfigValures.Debug == true)
    		r = crop.getSize() < 3;
    	else if (crop.getSize() <= 1)
    		r = crop.getSize() <= 1;
    	else if (crop.getSize() == 2)
    		r = (crop.getSize() == 2 && Operators.OR(crop.isBlockBelow("blockBlaze"),Operators.NOT(OreDictionary.doesOreNameExist("blockBlaze"))));
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
