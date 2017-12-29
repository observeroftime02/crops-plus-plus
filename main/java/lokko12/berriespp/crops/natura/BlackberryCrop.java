package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BlackberryCrop extends BasicBerryCrop {

    public BlackberryCrop() {
        super();
    	int anz = OreDictionary.getOres("cropBlackberry").size();
        ItemStack[] BaseSeeds = new ItemStack[anz];
        OreDictionary.getOres("cropBlackberry").toArray(BaseSeeds);
    	if (OreDictionary.getOres("cropBlackberry").size()!= 0)
    		for (int i=0; i < anz; i++)
            Crops.instance.registerBaseSeed(BaseSeeds[i],this,1,1,1,1);
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
		return new ItemStack(NContent.berryItem,3,2);
	}

}
