package lokko12.berriespp.crops.BoP;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GlowflowerCrop extends BasicDecorationCrop {
	
	public GlowflowerCrop() {
		super();
	}

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+name());
	}
	
	@Override
	public int tier() {
		return super.tier()+2;
	}

	@Override
	public String name() {
		return "Glowflower";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Nether", "Light", "Shiny"};
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BOPCBlocks.flowers,1,3);
	}

}
