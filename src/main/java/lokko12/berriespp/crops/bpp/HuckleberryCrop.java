package lokko12.berriespp.crops.bpp;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class HuckleberryCrop extends BasicBerryCrop {

    public HuckleberryCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

    public String name() {
        return "Huckelberry";
    }
    
    public String[] attributes() {
        return new String[] {"Berry", "Food", "Purple", "Leaves"}; // Purple like CropVenomilia, Leaves like CropFerru
    }


    public String discoveredBy() {
        return "Ancient cultures";
    }

	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("crop"+this.name());
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
}
