package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicCrop;
import lokko12.berriespp.items.BppItems;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
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
	public int growthDuration(ICropTile crop) {
		if(ConfigValures.Debug)
		return 1;
		return 5000;
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
		boolean ret= false;
		if (ConfigValures.Debug)
			ret = (crop.getSize() < (maxSize()-1));
		if (crop.getSize()==3) 
		{
			//if((new ItemStack(crop.getWorld().getBlock((crop.getLocation().posX), (crop.getLocation().posY-1), (crop.getLocation().posZ))).equals(new ItemStack(GCBlocks.blockMoon,1,3)))||(new ItemStack(crop.getWorld().getBlock((crop.getLocation().posX), (crop.getLocation().posY-1), (crop.getLocation().posZ))).equals(new ItemStack(GCBlocks.blockMoon,1,4)))||(new ItemStack(crop.getWorld().getBlock((crop.getLocation().posX), (crop.getLocation().posY-1), (crop.getLocation().posZ))).equals(new ItemStack(GCBlocks.blockMoon,1,5)))||(new ItemStack(crop.getWorld().getBlock((crop.getLocation().posX), (crop.getLocation().posY-1), (crop.getLocation().posZ))).equals(new ItemStack(GCBlocks.blockMoon,1,14))))
				if (crop.isBlockBelow(GCBlocks.blockMoon))
				ret = true;
			}
		else if (crop.getSize() < 3)
			ret = true;
		return ret;
		
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
