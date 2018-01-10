package lokko12.berriespp.items;

import biomesoplenty.api.content.BOPCBlocks;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameData.GameDataSnapshot;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.Type;
import gregtech.api.enums.ToolDictNames;
import ic2.core.Ic2Items;
import ic2.core.init.InternalName;
import lokko12.berriespp.ConfigValures;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class BppItems {
	public enum InternalName2 {BppCrop};
	public final static Item BerryItems = new NaturaBerryItems(1).setUnlocalizedName("berry");
	public final static Item itemSpade = new ItemBppSpade();
	public final static Item itemWCan = new ItemBppWateringCan();
	public final static ItemStack itemSpadeStack = new ItemStack(itemSpade);
	
	public static void register_Items() {
			GameRegistry.registerItem(itemSpade, "itemSpade");
			if (ConfigValures.WiPItems==true)
			GameRegistry.registerItem(itemWCan,"itemWateringCan");
			if (!ModsLoaded.GT) {
				GameRegistry.addRecipe(itemSpadeStack, new Object[] {" P ", "PWP", " S ", 'P', OreDict.ISget("plateDenseSteel"), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
			}
			else {
				//gregtech.api.util.GT_ModHandler.addCraftingRecipe(itemSpadeStack,new Object[] {"fPh","PWP"," S ",'P', OreDict.ISget("plateDenseSteel"),'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
				GameRegistry.addRecipe(itemSpadeStack, new Object[] {"fPh", "PWP", " S ", 'f',OreDict.ISget("craftingToolFile"),'h',OreDict.ISget("craftingToolHardHammer"), 'P',OreDict.ISget("plateDenseSteel"), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
			}
			if (ModsLoaded.Natura==false) {
	        GameRegistry.registerItem(BerryItems, "berry");
	        GameRegistry.registerCustomItemStack("berryRasp", new ItemStack(BerryItems, 1, 0));
	        GameRegistry.registerCustomItemStack("berryBlue", new ItemStack(BerryItems, 1, 1));
	        GameRegistry.registerCustomItemStack("berryBlack", new ItemStack(BerryItems, 1, 2));
	        GameRegistry.registerCustomItemStack("berryMalo", new ItemStack(BerryItems, 1, 3));
	        GameRegistry.registerCustomItemStack("berrySaguaro", new ItemStack(BerryItems, 1, 4));
			}
	}
	
	public static void OreDictItems() {
	if (ModsLoaded.Natura==false) {
	final ItemStack[] BerryItemsS = new ItemStack[4];
	for (int i = 0; i < 4; i++) {
	BerryItemsS[i] = new ItemStack(BerryItems,i);
	OreDictionary.registerOre("listAllberry", BerryItemsS[i]);
	OreDictionary.registerOre("listAllfruit", BerryItemsS[i]);
	}
	OreDictionary.registerOre("cropRaspberry", BerryItemsS[0]);
	OreDictionary.registerOre("cropBlueberry", BerryItemsS[1]);
	OreDictionary.registerOre("cropBlackberry", BerryItemsS[2]);
	OreDictionary.registerOre("cropMaloberry", BerryItemsS[3]);
	OreDictionary.registerOre("cropSaguaroBerry", BerryItemsS[4]);
	}
	}
	
	/*	OreDictionary.registerOre("cropHuckleberry", BerryItemsS[4]);
	OreDictionary.registerOre("cropStrawberry", BerryItemsS[5]);
	OreDictionary.registerOre("cropBerry", BerryItemsS[6]);*/
}
