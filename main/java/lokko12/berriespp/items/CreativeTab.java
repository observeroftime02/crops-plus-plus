package lokko12.berriespp.items;

import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	
	
	public static CreativeTab bpp = new CreativeTab();

	public CreativeTab() {
		super("Berriespp");
	}
	
	@Override
	public Item getTabIconItem() {
		if (ModsLoaded.Natura)
		return OreDict.ISget("cropSaguaroBerry").getItem();
		else return null;
	}

}
