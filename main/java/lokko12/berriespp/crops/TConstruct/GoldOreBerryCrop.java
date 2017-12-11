package lokko12.berriespp.crops.TConstruct;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class GoldOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public GoldOreBerryCrop ()
			{
				super();
			}

			@Override
			public String name() {
				return "GoldOreBerry";
			}
		       
			@Override
			public int tier() {
		        return 8;
		    }
		    @Override
		    public ItemStack getGain(ICropTile crop) {
		    	if (crop.isBlockBelow("blockGold") == true)
		    	{
		    		return new ItemStack(TinkerWorld.oreBerries, 6, 1);
		        }
		    	else return new ItemStack(TinkerWorld.oreBerries, 2, 1);
		    }
		    
		    @Override
		    public int growthDuration(ICropTile crop) {
		    	if (Berriespp.devbuild == true)
		    		return 1;
		    	// Same growth stages as melons and pumpkins
		    	else if (crop.getSize() == 2) {
		            // Ripens "quickly"
		            return 3000;
		        } else {
		        	if (crop.getSize() == 3 && crop.isBlockBelow("blockGold") == true)
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
			public String[] attributes() {
		        return new String[] {"Berry", "Gold", "Tendrilly", "Metal"};
			}

}

