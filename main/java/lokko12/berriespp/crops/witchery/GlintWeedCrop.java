package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GlintWeedCrop extends BasicDecorationCrop {
	String color = "Orange";
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
		return super.tier()+1;
	}
	
    @Override
    public String[] attributes() {
        return new String[] {color, "Flower", "Magic"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+name().replaceAll(" ", ""));
    }
	
}
