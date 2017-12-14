package lokko12.berriespp.crops.TC;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicBerryCrop;
import lokko12.croploadcore.BlockGetterTC;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public abstract class BasicManaBeanCrop extends BasicBerryCrop {

		public BasicManaBeanCrop()
		{
			super();
		}

	    
	    @Override
	    public int tier() {
	        return 7;
	    }

	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 0;   // a bit chemical
	        case 1: return 4;   // edible
	        case 2: return 0;   // strong defensive properties
	        case 3: return 4;   // quite colorful
	        case 4: return 0;   // not particularly weed-like
	        default: return 0;
	        }
	    }

	    @Override
	    public boolean canGrow(ICropTile crop) {
	    	if (crop.getSize() > 1)
	    	{ 
	    	return crop.isBlockBelow(BlockGetterTC.getBlock_asBlock("blockCrystal", 6));
	    	}
	    	else
	    		return true;
	    }

	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 3;
	    }

	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return crop.getSize() == 3;
	    }

	    @Override
	    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
	        // Requires no humidity but nutrients.
	        return (int)((double)humidity*1.3 + (double)nutrients*1 + (double)air*0.7);
	    }

	    @Override
	    public int growthDuration(ICropTile crop) {
	        // Same growth stages as melons and pumpkins
	    	if (Berriespp.devbuild == true)
	    		return 1;
	    	else if (crop.getSize() == 2) {
	            // Ripens not so quickly
	        	return 1200;
	        } else {
	            // Takes a while to grow from seed
	        	return 800;
	        }
	    }
	    
	    @Override
	    public String discoveredBy() {
	        return "bartimaeusnek";
	    }
	    

	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        // return to partially grown state when harvested
	        return 2;
	    }
	    
		@Override
		public int maxSize() {
			return 3;
		}
		
		@Override
		public String[] attributes() {
			return new String[] {"Berry", "Bean", "Magic", "Colorful"};
		}

	
}
