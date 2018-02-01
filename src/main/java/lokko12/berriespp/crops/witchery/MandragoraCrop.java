package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicWitcheryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class MandragoraCrop extends BasicWitcheryCrop {
	
	public MandragoraCrop() {
		super();
		OreDict.BSget("seedMandrake",this);
	}
	 	
	@Override
	public int tier() {
		return super.tier();
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
    
	@Override
	public float dropGainChance() { 
		return (float) (((Math.pow(0.95, (float) tier()))*ConfigValures.BerryGain)*0.5);
	}
    
	@Override
	public ItemStack getDisplayItem() {
			return OreDict.ISget("itemMandrake");
	}
}
