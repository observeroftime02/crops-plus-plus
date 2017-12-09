package lokko12.berriespp.crops.TC;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class IronOreBerryCrop extends BasicTinkerBerryCrop {
		
	
		public IronOreBerryCrop ()
		{}

		@Override
		public String name() {
			return "IronOreBerry";
		}
	       
	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.isBlockBelow("blockIron") == true)
	    	{
	    		return new ItemStack(TinkerWorld.oreBerries, 6, 0);
	        }
	    	else return new ItemStack(TinkerWorld.oreBerries, 2, 0);
	    }
	    
		@Override
		public String[] attributes() {
	        return new String[] {"Berry", "Gray", "Tendrilly", "Metal"};
		}
}
