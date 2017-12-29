package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicTinkerBerryCrop;
import lokko12.croploadcore.Operators;
import net.minecraft.item.Item;
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
	        return new String[] {"Berry", "Ardite", "Tendrilly", "Metal", "Orange"};
		}
}