package lokko12.berriespp.crops.TC;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicThaumcraftCrop;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CinderpearlCrop extends BasicThaumcraftCrop {

    public CinderpearlCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

	@Override
	public String name() {
		return "Cinderpearl";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Berry", "Tendrilly", "Magic", "Blaze", "Nether"};
	}
    
    @Override
    public String discoveredBy() {
    	 return "bartimaeusnek and mitchej123";
    }

    @Override
    public int growthDuration(ICropTile crop) {
    	int r;
    	if (ConfigValures.Debug == true)
    		r = 1;
    	else if (crop.getSize() == 2) {
            r = 3000;
        } else {
        	if (crop.getSize() == 3 && crop.isBlockBelow("blockBlaze") == true && OreDictionary.doesOreNameExist("blockBlaze"))
        	r = 1500;        	
        else 
        	{
            r = 500;
        }
        }
        return r;
    }
	@Override
	public boolean canGrow(ICropTile crop) {
		boolean r;
    	if (ConfigValures.Debug == true)
    		r = true;
    	else if (crop.getSize() < 2)
    		r = crop.getSize() < 2;
    	else if (crop.getSize() == 3 && Operators.XOR(crop.isBlockBelow("blockBlaze"),Operators.NOT(OreDictionary.doesOreNameExist("blockBlaze"))))
    		r = (crop.getSize() == 3 && Operators.XOR(crop.isBlockBelow("blockBlaze"),Operators.NOT(OreDictionary.doesOreNameExist("blockBlaze"))));
    	else
    	    r = crop.getSize() < 3;
		return r;
	}
}
