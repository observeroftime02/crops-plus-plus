package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlackberryCrop extends BasicBerryCrop {

    public BlackberryCrop() {
        super();
    	OreDict.BSget("crop"+this.name(),this);
    	OreDict.BSget("seed"+this.name(),this);
    }

    public String name() {
        return "Blackberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Edible", "Tendrilly", "Black", "Purple"}; // purple like CropVenomilia
    }

    public String discoveredBy() {
        return "Ancient cultures";
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
    	if (ModsLoaded.Natura)
    		return new ItemStack(NContent.berryItem,3,2);
    	else
    	return OreDict.ISget("crop"+this.name());
	}

}
