package lokko12.berriespp.crops.natura;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.bpp.BasicBerryCrop;
import net.minecraft.init.Blocks;

public abstract class BasicNetherBerryCrop extends BasicBerryCrop {


	public BasicNetherBerryCrop ()
	{
		super();
	}

    
    @Override
    public int tier() {
        return 4;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 1;   // a bit chemical
        case 1: return 3;   // kinda edible
        case 2: return 4;   // strong defensive properties
        case 3: return 4;   // quite colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
    	if (crop.getSize() < 3) 
    	{
            return true;
        }
    	/*else if ((crop.getSize() < 3) && (crop.isBlockBelow(Blocks.soul_sand))) 
    	{
            return true;
        }
        
        Maybe add this in a future Version...
        */
        return false;
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
        // Requires no humidity but nutrients.
        return (int)((double)humidity*0.5 + (double)nutrients*1.5 + (double)air*1);
    }

    @Override
    public int growthDuration(ICropTile crop) {
        // Same growth stages as melons and pumpkins
    	if (Berriespp.devbuild == true)
    		return 1;
    	else if (crop.getSize() == 2) {
            // Ripens not so quickly
        	return 300;
        } else {
            // Takes a while to grow from seed
        	return 700;
        }
    }
    
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
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

}
