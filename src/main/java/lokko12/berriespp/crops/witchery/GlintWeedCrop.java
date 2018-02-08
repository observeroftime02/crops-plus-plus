package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GlintWeedCrop extends BasicWitcheryCrop {
	public GlintWeedCrop() {
		super();
		OreDict.BSget("crop"+name().replaceAll(" ", ""),this );
	}
	 	
	@Override
	public String name() {
	    return "Glint Weed";
	}

	@Override
	public int tier() {
		return super.tier();
	}
	
    @Override
    public String[] attributes() {
        return new String[] {"Orange", "Flower", "Magic"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+name().replaceAll(" ", ""));
    }
	
	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name().replaceAll(" ", ""));
	}	
}
