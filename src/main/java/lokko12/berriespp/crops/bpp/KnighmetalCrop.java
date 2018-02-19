package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicTinkerBerryCrop;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.world.TinkerWorld;

public class KnighmetalCrop extends BasicTinkerBerryCrop{

	public KnighmetalCrop() {
		super();
	}

    @Override
    public int tier() {
        return 8;
    }
	
	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(twilightforest.item.TFItems.armorShard);
	}

	@Override
	public String name() {
		return "Knightly "+ BasicTinkerBerryCrop.OBname();
	}

	@Override
	public String[] attributes() {
		return new String[] {"OreBerry","Knightly","Metal"};
	}
	
	@Override
    public int growthDuration(ICropTile crop) {
    	int r;
    	if (ConfigValures.Debug == true)
    		r = 1;
    	else if (crop.getSize() >= 2) {
            r = 4500;
        } else if (crop.getSize() == 3 && (crop.isBlockBelow("blockKnightmetal") == true || !OreDictionary.doesOreNameExist("blockKnightmetal")))
        	r = 3000;        	
        else 
        	{
            // Takes a while to grow from seed
            r = 1000;
        }
        
        return r;
    }
	
	 @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.getSize() == 4 && (crop.isBlockBelow("blockKnightmetal") == true || !OreDictionary.doesOreNameExist("blockKnightmetal")))
	    	{
	    		return new ItemStack(twilightforest.item.TFItems.armorShard).splitStack(4);
	        }
	    	else return new ItemStack(twilightforest.item.TFItems.armorShard);
	    }

}
