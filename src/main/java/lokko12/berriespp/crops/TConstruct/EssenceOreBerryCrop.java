package lokko12.berriespp.crops.TConstruct;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicTinkerBerryCrop;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class EssenceOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public EssenceOreBerryCrop ()
			{
				super();
			}

			@Override
			public String name() {
				return "Essence Berry"; 
			}
		       
		    @Override
		    public ItemStack getGain(ICropTile crop) {

		    	if (crop.getSize() == 4 && crop.isBlockBelow("itemSkull") == true)
		    	{
		    		return new ItemStack(TinkerWorld.oreBerries, 6, 5);
		        }
		    	else return new ItemStack(TinkerWorld.oreBerries, 2, 5);
		    	
		    }
		    
		    @Override
			public int growthDuration(ICropTile crop) {
			    	int r;
			    	if (ConfigValures.Debug == true)
			    		r = 1;
			    	// Same growth stages as melons and pumpkins
			    	else if (crop.getSize() >= 2) {

			            // Ripens "quickly"
			            r = 3000;
			        } else if (crop.getSize() == 3 && crop.isBlockBelow("itemSkull") == true)
			        	r = 1500;        	
			        else 
			        	{
			            // Takes a while to grow from seed
			            r = 500;
			        }
			        return r;
			    }
		    @Override
		    public boolean canGrow(ICropTile crop) {
		    	return crop.getSize() < 4;
		    	}
		    
			@Override
			public String[] attributes() {
		        return new String[] {"OreBerry", "Essence", "Undead"};
			}

			@Override
			public ItemStack getDisplayItem() {
				return new ItemStack(TinkerWorld.oreBerries, 6, 5);
			}
}

