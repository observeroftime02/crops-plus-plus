package lokko12.berriespp.crops.natura.nether;
import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicNetherBerryCrop;
import lokko12.croploadcore.Operators;
import mods.natura.common.NContent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BasicNetherShroomCrop extends BasicNetherBerryCrop {
		
		private String name;

		public BasicNetherShroomCrop(String color)
		{
			super();
			if(color=="Purple"||color=="Yellow"||color=="Blue"||color=="Green") 
			{
			if (Operators.NOT(color=="Yellow"))
			this.name = color+" Glowshroom";
			else
			this.name = "Glowshroom";
			}
		}

		@Override
	    public String name() {
	        return name;
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
	    	int r;
	        // Same growth stages as melons and pumpkins
	    	if (ConfigValures.Debug == true)
	    		r = 1;
	    	else if (crop.getSize() == 2) {
	            // Ripens not so quickly
	        	r = 250;
	        } else {
	            // Takes a while to grow from seed
	        	r = 600;
	        }
	    	return r;
	    
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
			String[] r;
			if (name == "Green"+" Glowshroom")
				r = new String[] {"Green", "Edible", "Mushroom", "Ingredient", "Nether"};
			if (name == "Blue"+" Glowshroom")
		        r = new String[] {"Blue", "Edible", "Mushroom", "Ingredient", "Nether"};
			if (name == "Purple"+" Glowshroom")
				r = new String[] {"Purple", "Edible", "Mushroom", "Ingredient", "Nether"};
			else
				r = new String[] {"Yellow", "Edible", "Mushroom", "Ingredient", "Nether"};
			return r;
		}
	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	ItemStack r;
			if (name == "Blue"+" Glowshroom")
				r = new ItemStack(NContent.glowshroom,1,2);
			if (name == "Green"+" Glowshroom")
				r = new ItemStack(NContent.glowshroom,1,0);
			if (name == "Purple"+" Glowshroom")
				r = new ItemStack(NContent.glowshroom,1,1);
			else r = new ItemStack(BOPCBlocks.mushrooms,1,4);
			return r;
	    }
	    
	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        return 1;
	    }
	}
