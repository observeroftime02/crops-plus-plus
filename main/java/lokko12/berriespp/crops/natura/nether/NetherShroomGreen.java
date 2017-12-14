package lokko12.berriespp.crops.natura.nether;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicNetherShroomCrop;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class NetherShroomGreen extends BasicNetherShroomCrop {

		public NetherShroomGreen()
		{
			super();
		}
		
	    @Override
	    public String name() {
	        return "Green Glowshroom";
	    }
	    
		@Override
		public String[] attributes() {
		return new String[] {"Green", "Edible", "Mushroom", "Ingredient", "Nether"};
		
		}
	    @Override
	    public ItemStack getGain(ICropTile crop) {
				return new ItemStack(NContent.glowshroom,1,0);
	    }

	}
