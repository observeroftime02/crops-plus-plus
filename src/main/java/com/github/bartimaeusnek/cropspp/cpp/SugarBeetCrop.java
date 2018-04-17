package com.github.bartimaeusnek.cropspp.cpp;

import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;
import com.github.bartimaeusnek.cropspp.items.CppItems;

import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;

public class SugarBeetCrop extends BasicFoodCrop {

	public SugarBeetCrop() {
		super();
	}

	@Override
	public int tier() {
		return 4;
	}
	
	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(CppItems.CppBerries,1,1);
	}

	@Override
	public String name() {
		return "Sugar Beet";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Food","White","Ingredient"};
	}

	@Override
	public ItemStack getGain(ICropTile var1) {
		return new ItemStack(CppItems.CppBerries,1,1);
	}

}
