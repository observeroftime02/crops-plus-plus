package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicCrop;
import lokko12.berriespp.items.BppItems;
import net.minecraft.item.ItemStack;

public class SpacePlantCrop extends BasicCrop {
	
	public SpacePlantCrop() {
		super();
	}

	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(BppItems.Modifier,1,0);
	}

	@Override
	public String name() {
		return "Space Plant";
	}

	@Override
	public int tier() {
		return 13;
	}

	@Override
	public int stat(int n) {
		switch(n) {
        case 0: return 8;   // chemical
        case 1: return 0;   // edible
        case 2: return 0;   // defensive properties
        case 3: return 4;   // colorful
        case 4: return 0;   // weed-like
        default: return 0;
        }
	}

	@Override
	public String[] attributes() {
		return new String[] {"Alien","Space","Radiation","Transform"};
	}

	@Override
	public int maxSize() {
		return 4;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		return false;
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		return this.maxSize();
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		return crop.getSize()==this.maxSize();
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BppItems.Modifier,1,0);
	}

}
