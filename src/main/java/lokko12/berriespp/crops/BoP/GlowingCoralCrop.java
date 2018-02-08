package lokko12.berriespp.crops.BoP;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.item.ItemStack;

public class GlowingCoralCrop extends BasicDecorationCrop {

	public GlowingCoralCrop() {
		super();
	}
	
	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+name().replace(" ", ""));
	}

	@Override
	public String name() {
		return "Glowing Earth Coral";
	}
	
	@Override
	public int tier() {
		return super.tier()+4;
	}

	@Override
	public String[] attributes() {
		return new String[] {"Water", "Light", "Shiny"};
	}

	@Override
	public int getEmittedLight(ICropTile crop) {
        return 7;
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BOPCBlocks.coral1,1,15);
	}

}