package lokko12.berriespp.crops.natura.nether;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicNetherShroomCrop;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;
public class NetherShroomBlue extends BasicNetherShroomCrop {


			public NetherShroomBlue()
			{
				super();
			}
		    @Override
		    public String name() {
		        return "Blue Glowshroom";
		    }
			@Override
			public String[] attributes() {
					return new String[] {"Blue", "Edible", "Mushroom", "Ingredient", "Nether"};
			}
		    @Override
		    public ItemStack getGain(ICropTile crop) {
					return new ItemStack(NContent.glowshroom,1,2);
		    }

}
