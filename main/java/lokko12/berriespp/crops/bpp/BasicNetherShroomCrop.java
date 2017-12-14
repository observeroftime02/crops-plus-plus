package lokko12.berriespp.crops.bpp;
import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.natura.nether.BasicNetherBerryCrop;
import lokko12.croploadcore.CropLoader;
import mods.natura.common.NContent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class BasicNetherShroomCrop extends BasicNetherBerryCrop {
		
		private String name;

		public BasicNetherShroomCrop()
		{
			super();
		}

	    
	    @Override
	    public int tier() {
	        return 3;
	    }

	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 1;   // a bit chemical
	        case 1: return 3;   // kinda edible
	        case 2: return 0;   // no defensive properties
	        case 3: return 4;   // quite colorful
	        case 4: return 0;   // not particularly weed-like
	        default: return 0;
	        }
	    }
   
	    @Override
	    public int growthDuration(ICropTile crop) {
	        // Same growth stages as melons and pumpkins
	    	if (Berriespp.devbuild == true)
	    		return 1;
	    	else if (crop.getSize() == 2) {
	            // Ripens not so quickly
	        	return 250;
	        } else {
	            // Takes a while to grow from seed
	        	return 600;
	        }
	    
	    }
	    
		@Override
		public int getOptimalHavestSize(ICropTile crop) {
			return 2;
		}

		@Override
		public boolean canBeHarvested(ICropTile crop) {
			return crop.getSize() == 2;
		}
		
	    public boolean canGrow(ICropTile crop) {
            return crop.getSize() < 2;
	    }
    
	    @Override
	    public int maxSize() {
	    	return 2;
	    }


		@Override
		public String[] attributes() {
			if (name == "Green"+" Glowshroom")
				return new String[] {"Green", "Edible", "Mushroom", "Ingredient", "Nether"};
			if (name == "Blue"+" Glowshroom")
		        return new String[] {"Blue", "Edible", "Mushroom", "Ingredient", "Nether"};
			if (name == "Purple"+" Glowshroom")
				return new String[] {"Purple", "Edible", "Mushroom", "Ingredient", "Nether"};
			else
				return new String[] {"Yellow", "Edible", "Mushroom", "Ingredient", "Nether"};
		}
	    @Override
	    public ItemStack getGain(ICropTile crop) {
			if (name == "Blue"+" Glowshroom")
				return new ItemStack(NContent.glowshroom,1,2);
			if (name == "Green"+" Glowshroom")
				return new ItemStack(NContent.glowshroom,1,0);
			if (name == "Purple"+" Glowshroom")
				return new ItemStack(NContent.glowshroom,1,1);
			else return new ItemStack(BOPCBlocks.mushrooms,1,4);
	    }
	    
	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        return 1;
	    }
	}
