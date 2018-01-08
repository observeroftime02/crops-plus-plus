package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class WaterArtichokeCrop extends BasicDecorationCrop {
	public WaterArtichokeCrop() {
		super();
		OreDict.BSget("seedWaterArtichoke",this);
	}
	 	
	@Override
	public String name() {
	    return "Artichoke";
	}
	
	@Override
	public int tier() {
		return super.tier()+1;
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"Flower", "Water", "Blue", "Ingredient"};
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("itemWaterArtichoke");
    }	
}
