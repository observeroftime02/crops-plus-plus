package lokko12.berriespp.crops.bpp;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.Berriespp;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VineCrop extends BasicDecorationCrop {
    public VineCrop() {
    	super();
    	}

    @Override
    public int tier() {
        return 2;
    }	
    
    @Override
    public String name() {
        return "Vines";
    }

    @Override
    public String discoveredBy() {
        return "jeb_";
    }

    @Override
    public String[] attributes() {
        return new String[] {"Green", "Tendrilly", "Climbable"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(Item.getItemById(106),2,0);
    }

}
