package lokko12.berriespp.crops.witchery;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class BelladonnaCrop extends BasicDecorationCrop {
		String color = "Purple";
		
		public BelladonnaCrop() {
			super();
			OreDict.BSget("seed"+name(),this);
		}
		 	
		@Override
		public String name() {
		    return "Belladonna";
		}
		
		@Override
		public int tier() {
			return super.tier()+1;
		}
		
		@Override
	    public String[] attributes() {
			return new String[] {color, "Flower", "Toxic", "Ingredient"};
		}

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	return OreDict.ISget("item"+name());
	    }

		@Override
		public ItemStack getDisplayItem() {
			return OreDict.ISget("item"+this.name());
		}
}
