package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.berriespp.items.BppItems;
import net.minecraft.item.ItemStack;

public class SugarBeetCrop extends BasicBerryCrop {

	public SugarBeetCrop() {
		super();
	}

	@Override
	public int tier() {
		return 4;
	}
	
	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(BppItems.BppBerries,1,1);
	}

	@Override
	public String name() {
		return "Sugar Beet";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Food","White","Ingredient"};
	}

	@Override
	public ItemStack getGain(ICropTile var1) {
		return new ItemStack(BppItems.BppBerries,1,1);
	}

}
