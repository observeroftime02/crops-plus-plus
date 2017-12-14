package lokko12.berriespp.crops.natura.nether;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicNetherShroomCrop;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class NetherShroomPurple extends BasicNetherShroomCrop {

		public NetherShroomPurple()
		{
			super();
		}
		
	    @Override
	    public String name() {
	        return "Purple Glowshroom";
	    }
	    
		@Override
		public String[] attributes() {
		return new String[] {"Purple", "Edible", "Mushroom", "Ingredient", "Nether"};
		
		}
	    @Override
	    public ItemStack getGain(ICropTile crop) {
				return new ItemStack(NContent.glowshroom,1,1);
	    }

	}
