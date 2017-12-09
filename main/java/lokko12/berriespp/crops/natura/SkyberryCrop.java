package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import mods.natura.common.NContent;
import ic2.api.crops.CropCard;
import net.minecraft.item.ItemStack;

public class SkyberryCrop extends BasicNetherBerryCrop {

    
    public static String CropSeed()
    {
        return "cropSkyberry";
    }

    public SkyberryCrop(int id, ItemStack item) {
        super();
    }
    
    public String name() {
        return "Skyberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Toxic", "Bad", "Blue", "Nether","Addictive"};
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(NContent.netherBerryItem,2,2);
	}

}
