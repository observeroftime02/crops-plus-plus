package lokko12.berriespp.crops.TC;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class EssenceOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public EssenceOreBerryCrop ()
			{}

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
		    public boolean canGrow(ICropTile crop) {
		    	if (crop.getSize() < 3)
				{
					return true;
				}
		    			else 
		    					{
		    						return false;
		    					}
		    	}
		    
			@Override
			public String[] attributes() {
		        return new String[] {"Berry", "Essence", "Tendrilly", "Undead"};
			}

}

