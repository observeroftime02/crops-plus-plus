package lokko12.berriespp.items;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.core.Ic2Items;
import lokko12.berriespp.ConfigValures;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class BppItems {
	public final static Item BerryItems = new NaturaBerryItems(1).setUnlocalizedName("berry");
	public final static Item itemSpade = new ItemBppSpade();
	public final static Item itemWCan = new ItemBppWateringCan();
	public final static ItemStack itemSpadeStack = new ItemStack(itemSpade);
	public final static Item Goldfisch = new Goldfish();
	public final static ItemStack GoldfischS = new ItemStack(Goldfisch);
	public final static Item Modifier = new Modifier();
	public final static ItemStack ModifierSpace = new ItemStack(Modifier, 1, 0);
	public final static ItemStack ModifierMagic = new ItemStack(Modifier, 1, 1);
	//public final static ItemStack ModifierAnti = new ItemStack(Modifier, 1, 2);
	public final static ItemStack Trophy = new ItemStack(Modifier, 1, 3);
	public final static Item BppBerries = new BppBerries();
	
	public static void register_Items() {
			if (ConfigValures.Items==true)
			GameRegistry.registerItem(itemSpade, "itemSpade");
			GameRegistry.registerItem(Goldfisch,"foodGoldfish");
			GameRegistry.registerItem(Modifier,"Modifier");
			GameRegistry.registerCustomItemStack("ModifierSpace", ModifierSpace);
			GameRegistry.registerCustomItemStack("ModifierMagic", ModifierMagic);
			//GameRegistry.registerCustomItemStack("ModifierAnti", ModifierAnti);
			GameRegistry.registerCustomItemStack("Trophy", Trophy);
			GameRegistry.registerItem(BppBerries,"foodBerries");
			GameRegistry.registerCustomItemStack("berryHuckle", new ItemStack(BppBerries, 1, 0));
			if (ConfigValures.WiPItems==true)
			GameRegistry.registerItem(itemWCan,"itemWateringCan");
			if (ModsLoaded.Natura==false) {
	        GameRegistry.registerItem(BerryItems, "berry");
	        GameRegistry.registerCustomItemStack("berryRasp", new ItemStack(BerryItems, 1, 0));
	        GameRegistry.registerCustomItemStack("berryBlue", new ItemStack(BerryItems, 1, 1));
	        GameRegistry.registerCustomItemStack("berryBlack", new ItemStack(BerryItems, 1, 2));
	        GameRegistry.registerCustomItemStack("berryMalo", new ItemStack(BerryItems, 1, 3));
	        GameRegistry.registerCustomItemStack("berrySaguaro", new ItemStack(BerryItems, 1, 4));
			}
	}
	
	public static void register_recipes() {
		if (ConfigValures.Items==true) {
			if (!ModsLoaded.dreamcraft)
				GameRegistry.addShapelessRecipe(new ItemStack(Items.fish), new ItemStack(Goldfisch));
			if (!ModsLoaded.GT) {
				GameRegistry.addRecipe(itemSpadeStack, new Object[] {" P ", "PWP", " S ", 'P', OreDict.ISget("plateDenseSteel"), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
			}
			else {
				//GameRegistry.addRecipe(itemSpadeStack, new Object[] {"fPh", "PWP", " S ", 'f',OreDict.ISget("craftingToolFile"),'h',OreDict.ISget("craftingToolHardHammer"), 'P',OreDict.ISget("plateDenseSteel"), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
			}
		}
	}
	
	public static void OreDictItems() {
		if (ConfigValures.Items==true) {
			OreDictionary.registerOre("listAllfishraw",new ItemStack(Goldfisch));	
			OreDictionary.registerOre("listAllberry", new ItemStack(BppBerries,1,0));
			OreDictionary.registerOre("listAllfruit", new ItemStack(BppBerries,1,0));
			OreDictionary.registerOre("cropHuckleberry", new ItemStack(BppBerries,1,0));
		}
		
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
