package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class WolfsBaneCrop extends BasicWitcheryCrop {
	public WolfsBaneCrop() {
		super();
		OreDict.BSget("seedWolfsBane",this);
	}
	 	
	@Override
	public String name() {
	    return "Wolf's Bane";
	}
	
	@Override
	public int tier() {
		return super.tier();
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"Flower", "Toxic", "Purple", "Ingredient"};
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("itemWolfsBane");
    }	

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("itemWolfsBane");
	}

}
