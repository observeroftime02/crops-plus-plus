package lokko12.berriespp.crops.bpp;

import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.core.Ic2Items;
import ic2.core.crop.CropWeed;
import ic2.core.crop.TileEntityCrop;
import net.minecraft.item.ItemStack;

public class WeedCrop extends ic2.core.crop.CropWeed {
	public WeedCrop() {
		super();
		Crops.instance.registerBaseSeed(new ItemStack(Ic2Items.weed.getItem()),(CropCard)this,1,1,1,1);
	}

}
