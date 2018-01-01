package lokko12.berriespp.items;

import biomesoplenty.api.content.BOPCBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BppItems {
	public static Item BerryItems = new Item();
	
	public static void register_Items() {
		BerryItems = new BerryItems(1).setUnlocalizedName("berry");
	        GameRegistry.registerItem(BerryItems, "berry");
	        GameRegistry.registerCustomItemStack("berryRasp", new ItemStack(BerryItems, 1, 0));
	        GameRegistry.registerCustomItemStack("berryBlue", new ItemStack(BerryItems, 1, 1));
	        GameRegistry.registerCustomItemStack("berryBlack", new ItemStack(BerryItems, 1, 2));
	        GameRegistry.registerCustomItemStack("berryMalo", new ItemStack(BerryItems, 1, 3));
	        GameRegistry.registerCustomItemStack("berryHuckle", new ItemStack(BerryItems, 1, 4));
	        GameRegistry.registerCustomItemStack("berryStraw", new ItemStack(BerryItems, 1, 5));
	        GameRegistry.registerCustomItemStack("berryBerry", new ItemStack(BerryItems, 1, 6));
	        GameRegistry.registerCustomItemStack("berrySaguaro", new ItemStack(BerryItems, 1, 7));
	}
	
	public static void OreDictItems() {
		
		//does not work :(
	ItemStack[] BerryItemsS = new ItemStack[8];
	for (int i = 0; i > 7; i++) {
	BerryItemsS[i] = new ItemStack(BerryItems,i);
	OreDictionary.registerOre("listAllberry", BerryItemsS[i]);
	OreDictionary.registerOre("listAllfruit", BerryItemsS[i]);
	}
	OreDictionary.registerOre("cropRaspberry", BerryItemsS[0]);
	OreDictionary.registerOre("cropBlueberry", BerryItemsS[1]);
	OreDictionary.registerOre("cropBlackberry", BerryItemsS[2]);
	OreDictionary.registerOre("cropMaloberry", BerryItemsS[3]);
	OreDictionary.registerOre("cropHuckleberry", BerryItemsS[4]);
	OreDictionary.registerOre("cropStrawberry", BerryItemsS[5]);
	OreDictionary.registerOre("cropBerry", BerryItemsS[6]);
	OreDictionary.registerOre("cropSaguaroBerry", BerryItemsS[7]);
	}
}
