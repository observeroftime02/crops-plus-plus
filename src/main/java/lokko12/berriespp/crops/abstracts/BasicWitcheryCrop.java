package lokko12.berriespp.crops.abstracts;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import net.minecraft.item.ItemStack;

public abstract class BasicWitcheryCrop extends BasicDecorationCrop {

	public BasicWitcheryCrop() {
		super();
	}

    @Override
    public int growthDuration(ICropTile crop) {
    	if (ConfigValures.Debug == true)
    		return 1;
    	else
        return 550;
    }

    @Override
    public int tier() {
        return 4;
    }
    
}
