package lokko12.berriespp.crops.bpp;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class BasicDecorationCrop extends BasicBerryCrop {

	    public BasicDecorationCrop() {
	    	super();
	    	}

	    @Override
	    public int tier() {
	        return 1;
	    }

	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 0;   // not chemical
	        case 1: return 0;   // not edible
	        case 2: return 0;   // no defensive properties
	        case 3: return 3;   // primarily decorative
	        case 4: return 0;   // not particularly weed-like
	        default: return 0;
	        }
	    }

	    @Override
	    public int growthDuration(ICropTile crop) {
	    	if (Berriespp.devbuild == true)
	    		return 1;
	    	else
	        return 225;
	    }

	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        return 1;
	    }
}
