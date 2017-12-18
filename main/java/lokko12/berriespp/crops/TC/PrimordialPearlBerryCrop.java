package lokko12.berriespp.crops.TC;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PrimordialPearlBerryCrop extends BasicBerryCrop {


	public PrimordialPearlBerryCrop ()
	{}
	
	@Override
    public String name() {
        return "Primordial Berry";
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
        return crop.getSize() < 4;
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 4;
    }

    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 4;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires Tons of everything
        return (int)((double)humidity*2 + (double)nutrients*2 + (double)air*2);
    }

    @Override
    public int growthDuration(ICropTile crop) {
    	if (ConfigValures.Debug == true)
    		return 1;
        else {
            return 125000;
        }
    }
    
	@Override
	public float dropGainChance() { 
		return ConfigValures.PrimordialBerryGain;
	}

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        return 1;
    }
    
	@Override
	public int maxSize() {
		return 4;
	}
	
	@Override
	public ItemStack getSeeds(ICropTile crop) {
		return crop.generateSeeds(crop.getCrop(),(byte)1,(byte)1,(byte)1, crop.getScanLevel());
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3);
	}

	@Override
	public String[] attributes() {
		return new String[] {"Berry", "Primordial", "Magic", "Unique"};
	}
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek and ForTheHorde01";
    }

}