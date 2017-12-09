package lokko12.berriespp.crops.TC;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class TinOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public TinOreBerryCrop ()
			{}

			@Override
			public String name() {
				return "TinOreBerry";
			}
		       
			@Override
			public int tier() {
		        return 5;
		    }
		    @Override
		    public ItemStack getGain(ICropTile crop) {
		    	if (crop.isBlockBelow("blockTin") == true)
		    	{
		    		return new ItemStack(TinkerWorld.oreBerries, 6, 3);
		        }
		    	else return new ItemStack(TinkerWorld.oreBerries, 2, 3);
		    }
		    
			@Override
			public String[] attributes() {
		        return new String[] {"Berry", "Tin", "Tendrilly", "Metal", "Shiny"};
			}

}

