package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class CottonCrop extends BasicDecorationCrop {
	
	public CottonCrop() {
		super();
		OreDict.BSget("crop"+name().replaceAll(" ", ""),this );
	}

	@Override
	public String name() {
		return "Cotton";
	}

	@Override
	public int tier() {
		return 3;
	}

	@Override
	public int stat(int n) {
        switch (n) {
        case 0: {
            return 4;
        }
        case 1: {
            return 4;
        }
        case 2: {
            return 0;
        }
        case 3: {
            return 0;
        }
        case 4: {
            return 2;
        }
    }
    return 0;
	}

	@Override
	public String[] attributes() {
		return new String[] {"White", "Cotton"};
	}

	@Override
	public int maxSize() {
		return 5;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		return crop.getSize() < 5 && crop.getLightLevel() >= 9;
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		return 5;
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		return crop.getSize()==5;
	}
	
	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+this.name());
	}

}
