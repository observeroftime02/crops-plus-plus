package com.github.bartimaeusnek.cropspp.cpp;

import com.github.bartimaeusnek.cropspp.ConfigValures;
import com.github.bartimaeusnek.cropspp.abstracts.BasicTinkerBerryCrop;

import ic2.api.crops.ICropTile;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ArditeBerryCrop extends BasicTinkerBerryCrop {

		public ArditeBerryCrop ()
		{
			super();
		}

		@Override
		public String name() {
			return "Ardite Berry";
		}
	       
		@Override
		public int tier() {
	        return 7;
	    }
	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if ((crop.isBlockBelow("blockArdite") == true||ConfigValures.Debug == true) && OreDictionary.getOres("nuggetArdite").size()!= 0)
	    	{
	            return OreDictionary.getOres("nuggetArdite").get(OreDictionary.getOres("nuggetArdite").size()-1);
	        }
	    	else 
	    		return null;
	    }
	    
	    @Override
	    public int growthDuration(ICropTile crop) {
	    	int r;
	    	if (ConfigValures.Debug == true)
	    		r = 1;
	    	else if (crop.getSize() == 2)
	            r = 3000;
	        else if (Operators.AND(crop.getSize() == 3,crop.isBlockBelow("blockArdite")))
			    r = 3000;
		    else
			    r = 500;
	        return r;
	        }
		@Override
		public String[] attributes() {
	        return new String[] {"OreBerry", "Ardite", "Metal", "Orange"};
		}

		@Override
		public ItemStack getDisplayItem() {
			return OreDict.ISget("nuggetArdite");
		}
}