package lokko12.berriespp.crops.TC;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class GoldOreBerryCrop extends BasicTinkerBerryCrop {
			
		
			public GoldOreBerryCrop ()
			{}

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
			public String[] attributes() {
		        return new String[] {"Berry", "Gold", "Tendrilly", "Metal"};
			}

}

