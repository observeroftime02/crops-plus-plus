package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import ic2.core.crop.CropWheat;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.crops.abstracts.BasicFoodCrop;
import lokko12.croploadcore.OreDict;

public class BarleyCrop extends BasicFoodCrop {
	
	public BarleyCrop() {
		super();
		OreDict.BSget("crop"+name().replaceAll(" ", ""),this );
		OreDict.BSget("seed"+name().replaceAll(" ", ""),this );
	}

	@Override
	public String name() {
		return "Barley";
	}

	@Override
	public int tier() {
		return 2;
	}

	@Override
	public String[] attributes() {
		return new String[] {"Green", "Food", "Wheat"};
	}

	@Override
	public int maxSize() {
		return 4;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		return crop.getSize() < 4 && crop.getLightLevel() >= 9;
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		return 4;
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		return crop.getSize()==4;
	}

}
