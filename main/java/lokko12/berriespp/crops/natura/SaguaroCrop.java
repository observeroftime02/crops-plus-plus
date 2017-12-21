package lokko12.berriespp.crops.natura;
import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.CropLoader;
import lokko12.berriespp.crops.bpp.CactiCrop;
import mods.natura.common.NContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SaguaroCrop extends CactiCrop {
		
		public SaguaroCrop() {
			Crops.instance.registerBaseSeed(new ItemStack(NContent.saguaro,1,0),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		}

	    @Override
	    public int tier() {
	        return 4;
	    }
	    
		@Override
		public String name() {
			return "Saguaro Cactus";
		}

		@Override
		public String[] attributes() {
			return new String[] {"Green","Edible","Cactus"};
		}
		
		@Override
		public ItemStack getGain(ICropTile crop) {
			if (crop.getSize()==2)
			return new ItemStack(NContent.saguaro,2,0);
			else 
			return new ItemStack(NContent.seedFood,3,0);
		}
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return crop.getSize() >= 2;
	    }

	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        if (crop.getSize() == 2)
	    	return 1;
	        else
	        return 2;
	    }
	    
	    @Override
	    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
	        // Requires more humidity than nutrients or air, but not much more
	        return (int)((double)humidity*0.5 + (double)nutrients*1.25 + (double)air*1.25);
	    }
}
