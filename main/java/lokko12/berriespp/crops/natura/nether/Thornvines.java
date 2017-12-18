package lokko12.berriespp.crops.natura.nether;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.bpp.VineCrop;
import mods.natura.common.NContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Thornvines extends VineCrop {

	public Thornvines() {
		super();
	}
	
    @Override
    public int tier() {
        return 3;
    }
    @Override
    public String name() {
        return "Thornvines";
    }

    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
	
    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(NContent.thornVines,2);
    }

    @Override
    public String[] attributes() {
        return new String[] {"Nether", "Climbable", "Bad"};
    }
}
