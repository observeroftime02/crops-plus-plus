package lokko12.berriespp.crops.witchery;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.BoP.FloweringVinesCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SpanishMossCrop extends FloweringVinesCrop{
	
	public SpanishMossCrop()
	{
		super();
		OreDict.BSget("crop"+name().replaceAll(" ", ""),this );
	}
	 	
	@Override
	public String name() {
	    return "Spanish Moss";
	}

	@Override
	public int tier() {
		return super.tier()+1;
	}
	
    @Override
    public String[] attributes() {
        return new String[] {"Green", "Tendrilly", "Climbable", "Magic"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+name().replaceAll(" ", ""));
    }

}
