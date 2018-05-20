package com.github.bartimaeusnek.cropspp.BoP;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
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
    public boolean canGrow(ICropTile crop) {
    	return crop.getSize()<3;
    }
	
	@Override
	public int getEmittedLight(ICropTile crop) {
		if (crop.getSize()==3)
        return 7;
		else return 0;
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		if (crop.isBlockBelow(Blocks.glowstone))
			return new ItemStack(BOPCBlocks.flowers,2,3);
		else
		return new ItemStack(BOPCBlocks.flowers,1,3);
	}

}
