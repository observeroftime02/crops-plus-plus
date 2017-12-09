package lokko12.berriespp.crops.TC;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class AluminiumOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public AluminiumOreBerryCrop ()
			{}

			@Override
			public String name() {
				return "AluminiumOreBerry";
			}
		       
			@Override
			public int tier() {
		        return 5;
		    }
		    @Override
		    public ItemStack getGain(ICropTile crop) {
		    	if (crop.isBlockBelow("blockAluminium") == true)
		    	{
		    		return new ItemStack(TinkerWorld.oreBerries, 6, 4);
		        }
		    	else return new ItemStack(TinkerWorld.oreBerries, 2, 4);
		    }
		    
			@Override
			public String[] attributes() {
		        return new String[] {"Berry", "Aluminium", "Tendrilly", "Metal", "Aluminum"};
			}

}

