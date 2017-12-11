package lokko12.berriespp.crops.TConstruct;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class EssenceOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public EssenceOreBerryCrop ()
			{
				super();
			}

			@Override
			public String name() {
				return "EssenceOreBerry";
			}
		       
			@Override
			public int tier() {
		        return 5;
		    }
		    @Override
		    public ItemStack getGain(ICropTile crop) {

		    	if (crop.isBlockBelow("itemSkull") == true)
		    	{
		    		return new ItemStack(TinkerWorld.oreBerries, 6, 5);
		        }
		    	else return new ItemStack(TinkerWorld.oreBerries, 2, 5);
		    	
		    }
		    
		    @Override
		    public int growthDuration(ICropTile crop) {
		    	if (Berriespp.devbuild == true)
		    		return 1;
		        // Same growth stages as melons and pumpkins
		        if (crop.getSize() == 2) {
		            // Ripens "quickly"
		            return 3000;
		        } else {
		        	if (crop.getSize() == 3 && crop.isBlockBelow("itemSkull") == true)
		        	{ return 1500;
		        			}        	
		        else 
		        	{
		            // Takes a while to grow from seed
		            return 500;
		        }
		        }
		    }
		    @Override
		    public boolean canGrow(ICropTile crop) {
		    	return crop.getSize() < 4;
		    	}
		    
			@Override
			public String[] attributes() {
		        return new String[] {"Berry", "Essence", "Tendrilly", "Undead"};
			}

}

