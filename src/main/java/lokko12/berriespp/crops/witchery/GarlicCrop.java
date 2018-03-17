package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GarlicCrop extends BasicDecorationCrop {
	public GarlicCrop() {
		super();
		OreDict.BSget("crop"+name(),this);
	}
	 	
	@Override
	public String name() {
	    return "Garlic";
	}
	
	@Override
	public int tier() {
		return super.tier()+2;
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"Food", "Ingredient", "Healing" };
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+name());
    }	
	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}	
}