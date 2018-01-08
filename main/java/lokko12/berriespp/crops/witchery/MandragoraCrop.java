package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class MandragoraCrop extends BasicDecorationCrop {
	
	public MandragoraCrop() {
		super();
		OreDict.BSget("seedMandrake",this);
	}
	 	
	@Override
	public int tier() {
		return super.tier()+1;
	}
	
	@Override
	public String name() {
	    return "Mandragora";
	}
	
	@Override
    public String[] attributes() {
		return new String[] {"Flower", "Magic", "Bad", "Toxic", "Ingredient"};
	}

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("itemMandrake");
    }

}
