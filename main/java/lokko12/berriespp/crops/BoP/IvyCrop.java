package lokko12.berriespp.crops.BoP;
import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.crops.bpp.VineCrop;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

	public class IvyCrop extends VineCrop {
	    public IvyCrop() {
	    	super();
	    	}

	    @Override
	    public int tier() {
	        return 2;
	    }	
	    
	    @Override
	    public boolean canGrow(ICropTile crop) {
	    	return crop.getSize() < 3;
	    }
		
	    @Override
		public int maxSize() {
			return 3;
		}
	    
	    @Override
	    public String name() {
	        return "Ivy";
	    }

	    @Override
	    public String discoveredBy() {
	        return "bartimaeusnek";
	    }

	    @Override
	    public String[] attributes() {
	        return new String[] {"Green", "Tendrilly", "Climbable", "Flower", "Bad", "Poison"};
	    }
	    
	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 3;
	    }

	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	        return crop.getSize() == 3;
	    }

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    		return new ItemStack(BOPCBlocks.ivy,2,0);
	    }

	}
