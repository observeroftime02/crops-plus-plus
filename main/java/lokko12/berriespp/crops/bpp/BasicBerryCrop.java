package lokko12.berriespp.crops.bpp;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class BasicBerryCrop extends ic2.api.crops.CropCard {


	public BasicBerryCrop ()
	{
		super();
	}
	
	
	public boolean IsBaseSeedGain()
	{
		return true;
	}
	
    @Override
    public int tier() {
        return 2;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 0;   // not chemical
        case 1: return 4;   // very edible
        case 2: return 0;   // no defensive properties
        case 3: return 4;   // quite colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
    	return crop.getSize() < 3;
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 3;
    }

    
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 3;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires more humidity than nutrients or air, but not much more
        return (int)((double)humidity*1.2 + (double)nutrients*0.9 + (double)air*0.9);
    }

    @Override
    public int growthDuration(ICropTile crop) {
        // Same growth stages as melons and pumpkins
        if (crop.getSize() == 2) {
            // Ripens quickly
            return 200;
        } else {
            // Takes a while to grow from seed
            return 700;
        }
    }

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        // return to partially grown state when harvested
        return 2;
    }
    
	@Override
	public int maxSize() {
		return 3;
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(Items.wheat, 1);
	}

}
