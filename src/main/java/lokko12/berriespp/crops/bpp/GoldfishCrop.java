package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GoldfishCrop extends BasicDecorationCrop {
	
	public GoldfishCrop() {
		super();
	}

	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(BppItems.Goldfisch);
	}

	@Override
	public String name() {
		return "Goldfish Plant";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Nether", "Fish", "Bad", "Water"};
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BppItems.Goldfisch);
	}

}
