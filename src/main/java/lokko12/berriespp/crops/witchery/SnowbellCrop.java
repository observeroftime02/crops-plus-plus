package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class SnowbellCrop extends BasicWitcheryCrop {
	public SnowbellCrop() {
		super();
		OreDict.BSget("seed"+name(),this);
	}
	 	
	@Override
	public String name() {
	    return "Snowbell";
	}
	
	@Override
	public int tier() {
		return super.tier();
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"White","Flower", "Ice", "Toxic", "Ingredient"};
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("item"+name());
    }	

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("item"+this.name());
	}
}
