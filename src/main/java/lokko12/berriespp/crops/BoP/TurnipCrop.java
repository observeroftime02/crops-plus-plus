package lokko12.berriespp.crops.BoP;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicFoodCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class TurnipCrop extends BasicFoodCrop {
	public TurnipCrop()
	{
		super();
		OreDict.BSget("crop"+this.name(),this);
		OreDict.BSget("seed"+this.name(),this);
	}
	
	@Override
    public String name() {
        return "Turnip";
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("crop"+this.name());
	}

	@Override
	public String[] attributes() {
        return new String[]{"Food", "Purple", "Carrots"};
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
}
