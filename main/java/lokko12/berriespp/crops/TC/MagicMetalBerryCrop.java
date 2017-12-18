package lokko12.berriespp.crops.TC;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicTinkerBerryCrop;
import lokko12.croploadcore.Operators;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class MagicMetalBerryCrop extends BasicTinkerBerryCrop{
			
				public MagicMetalBerryCrop()
				{
					super();
				}

				@Override
				public String name() {
					return "Magic Metal Berry";
				}
			       
				@Override
				public int tier() {
			        return 8;
			    }
			    @Override
			    public ItemStack getGain(ICropTile crop) {
			    	if (Operators.OR(crop.isBlockBelow("blockThaumium"),crop.isBlockBelow("blockIron")))
			    	{
			    		return thaumcraft.api.ItemApi.getItem("nuggetThaumium", 1);
			        }
			    	else if (crop.isBlockBelow("blockVoid")||ConfigValures.Debug == true)
			    	return thaumcraft.api.ItemApi.getItem("nuggetVoid", 1);
			    	else return null;
			    }
			    
			    @Override
			    public int growthDuration(ICropTile crop) {
			    	if (ConfigValures.Debug == true)
			    		return 1;
			        if (crop.getSize() == 2)
			            return 1500;
			        else
			        if (Operators.AND(crop.getSize() == 3,Operators.OR(crop.isBlockBelow("blockThaumium"),crop.isBlockBelow("blockIron"))))
			        	return 1500;     	
			        else
			        if (Operators.AND(crop.getSize() == 3,crop.isBlockBelow("blockVoid")))
			            return 3000;
			        else
			    	return 500;
			    }
			    
				@Override
				public String[] attributes() {
			        return new String[] {"Berry", "Magic", "Tendrilly", "Metal", "Thaumium", "Void"};
				}

	}
