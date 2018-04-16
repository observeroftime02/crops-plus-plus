package com.github.bartimaeusnek.cropspp.items;

import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class CreativeTab extends CreativeTabs {
	
	public final static CreativeTab cpp = new CreativeTab();

	public CreativeTab() {
		super("Cropspp");
	}
	
	@Override
	public Item getTabIconItem() {
		if (ModsLoaded.Natura)
		return OreDict.ISget("cropSaguaroBerry").getItem();
		else return CppItems.Goldfisch;
	}

}
