package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class BlueberryCrop extends BasicBerryCrop {

    public BlueberryCrop() {
        super();
    	OreDict.BSget("crop"+this.name(),this);
    }

    public String name() {
        return "Blueberry";
    }
    
    public String[] attributes() {
        return new String[] {"Berry", "Food", "Blue"}; // Blue like CropTerraWart
    }

    public String discoveredBy() {
        return "Ancient cultures";
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
    	if (ModsLoaded.Natura)
    		return new ItemStack(NContent.berryItem,3,1);
    	else
    	return OreDict.ISget("crop"+this.name());
	}
    
	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(NContent.berryItem,3,1);
	}
}
