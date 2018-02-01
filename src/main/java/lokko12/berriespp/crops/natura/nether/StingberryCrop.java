package lokko12.berriespp.crops.natura.nether;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicNetherBerryCrop;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class StingberryCrop extends BasicNetherBerryCrop {

    public StingberryCrop() {
        super();
    }
    
    public String name() {
        return "Stingberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Toxic", "Bad", "Green", "Nether","Addictive"};
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(NContent.netherBerryItem,2,3);
	}

	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(NContent.netherBerryItem,2,3);
	}
}
