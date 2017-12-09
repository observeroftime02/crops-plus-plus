package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import mods.natura.common.NContent;
import ic2.api.crops.CropCard;
import net.minecraft.item.ItemStack;

public class DuskberryCrop extends BasicNetherBerryCrop {

    
    public static String CropSeed()
    {
        return "cropDuskberry";
    }

    public DuskberryCrop(int id, ItemStack item) {
        super();
    }
    
    public String name() {
        return "Duskberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Toxic", "Bad", "Gray", "Nether","Addictive"};
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(NContent.netherBerryItem,2,1);
	}

}
