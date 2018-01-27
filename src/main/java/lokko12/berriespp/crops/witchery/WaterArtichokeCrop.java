package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class WaterArtichokeCrop extends BasicWitcheryCrop {
	public WaterArtichokeCrop() {
		super();
		OreDict.BSget("cropArtichoke",this);
	}
	 	
	@Override
	public String name() {
	    return "Artichoke";
	}
	
	@Override
	public int tier() {
		return super.tier();
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"Flower", "Water", "Blue", "Ingredient"};
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("itemWaterArtichoke");
    }	
    
	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("itemWaterArtichoke");
	}

}
