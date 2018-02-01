package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.TC.PrimordialPearlBerryCrop;
import lokko12.berriespp.items.BppItems;
import net.minecraft.item.ItemStack;

public class MagicModifierCrop extends PrimordialPearlBerryCrop {

	public MagicModifierCrop() {
		super();
	}
	
	@Override
    public String name() {
        return "Magical Nightshade";
    }

	public int tier() {
		return 13;
	}
	
	@Override
	public boolean canCross(ICropTile crop) {
		return crop.getSize()==this.maxSize();
	}

	@Override
	public ItemStack getSeeds(ICropTile crop) {
		return crop.generateSeeds(crop.getCrop(),crop.getGrowth(),crop.getGain(),crop.getResistance(), crop.getScanLevel());
	}
	
    @Override
    public int growthDuration(ICropTile crop) {
    	if (ConfigValures.Debug == true)
    		return 1;
        else {
            return ConfigValures.PrimordialBerryGroth/16;
        }
    }
    
	@Override
	public float dropGainChance() { 
		return (float) ((float) ((Math.pow(0.95, (float) tier()))*ConfigValures.BerryGain)*(ConfigValures.PrimordialBerryGain*1.5));
	}

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        return 1;
    }
    
	@Override
	public int maxSize() {
		return 3;
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
	return new ItemStack(BppItems.Modifier,1,1);
	}
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
}

