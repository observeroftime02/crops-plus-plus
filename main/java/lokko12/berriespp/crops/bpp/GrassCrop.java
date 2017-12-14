package lokko12.berriespp.crops.bpp;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.croploadcore.CropLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrassCrop extends BasicDecorationCrop {
	 public GrassCrop() {
		 super();
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(32),1,0),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(31),1,2),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 if (CropLoader.BoPInstalled == true)
		 {
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,0),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,1),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,2),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,3),lokko12.croploadcore.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 }
	 }

	    @Override
	    public int tier() {
	        return 0;
	    }
	    
	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 0;   // not chemical
	        case 1: return 0;   // not edible
	        case 2: return 0;   // no defensive properties
	        case 3: return 3;   // primarily decorative
	        case 4: return 4;   // weed-like
	        default: return 0;
	        }
	    }
	 
	    @Override
	    public String name() {
	        return "Grass";
	    }
	    
	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 0;
	    }

	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return true;
	    }
	    
	    @Override
	    public String[] attributes() {
	        return new String[] {"Green", "Tendrilly"};
	    }

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.getSize() == 3)
	    	return new ItemStack(Item.getItemById(32),1,0);	
	    	if (crop.getSize() == 2)
	    	return new ItemStack(Item.getItemById(31),1,2);
	    	return new ItemStack(Item.getItemById(31),1,1);
	    }
}
