package lokko12.berriespp.crops.TC;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicBerryCrop;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PrimordialPearlBerryCrop extends BasicBerryCrop {


	public PrimordialPearlBerryCrop ()
	{}
	
	@Override
    public String name() {
        return "PrimordialBerry";
    }
    
    @Override
    public int tier() {
        return 16;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 0;   // not chemical
        case 1: return 0;   // not edible
        case 2: return 0;   // no defensive properties
        case 3: return 12;   // immensely colorful
        case 4: return 0;   // not weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
        return crop.getSize() < 2;
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 2;
    }

    
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 2;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires more humidity than nutrients or air, but not much more
        return (int)((double)humidity + (double)nutrients + (double)air);
    }

    @Override
    public int growthDuration(ICropTile crop) {
    	if (Berriespp.devbuild == true)
    		return 1;
    	else if (crop.getSize() == 2) {
            return 250000;
        } else {
            return 250000;
        }
    }

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        return 1;
    }
    
	@Override
	public int maxSize() {
		return 2;
	}

	/*@Override
	public ItemStack getGain(ICropTile crop) {
		return thaumcraft.api.ItemApi.getItem("item.ItemEldritchObject", 3);
	}*/

	@Override
	public String[] attributes() {
		return new String[] {"Berry", "Primordial", "Magic", "Unique"};
	}
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }

}