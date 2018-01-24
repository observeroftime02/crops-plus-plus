package lokko12.berriespp.crops.TC;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicThaumcraftCrop;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ShimmerleafCrop extends BasicThaumcraftCrop {

    public ShimmerleafCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

	@Override
	public String name() {
		return "Shimmerleaf";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Berry", "Magic", "Silver", "Toxic"};
	}
    
    @Override
    public int growthDuration(ICropTile crop) {
        	int r;
        	if (ConfigValures.Debug == true)
        		r = 1;
        	else if (crop.getSize() == 1)
                r = 2250;
        	else if (crop.getSize() == 2 && crop.isBlockBelow("blockQuicksilver") == true && OreDictionary.doesOreNameExist("blockQuicksilver"))
            	r = 1750;        	
            else 
                r = 250;
        	return r;
            }
	
    @Override
    public String discoveredBy() {
        return "bartimaeusnek and DreamMasterXXL";
    }

	@Override
	public boolean canGrow(ICropTile crop) {
		boolean r;
    	if (ConfigValures.Debug == true)
    		r = crop.getSize() < 3;
    	else if (crop.getSize() < 1)
    		r = crop.getSize() < 1;
    	else if (crop.getSize() == 2 && Operators.XOR(crop.isBlockBelow("blockQuicksilver"),Operators.NOT(OreDictionary.doesOreNameExist("blockQuicksilver"))))
    		r = (crop.getSize() == 2 && Operators.XOR(crop.isBlockBelow("blockQuicksilver"),Operators.NOT(OreDictionary.doesOreNameExist("blockQuicksilver"))));
    	else
    		r = crop.getSize() < 3;
		return r;
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
