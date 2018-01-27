package lokko12.berriespp.GTHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GT_ModHandler;
import ic2.core.Ic2Items;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.OreDict;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class GTCraftingRecipeLoader implements Runnable {

	public GTCraftingRecipeLoader() {
		super();
	}
	
	public void run() {
		gregtech.api.util.GT_ModHandler.addCraftingRecipe(BppItems.itemSpadeStack,GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,new Object[] {"fPh", "PWP", " S ", 'P',OreDictionary.getOres("plateDenseSteel"), 'f', OreDictionary.getOres(ToolDictNames.craftingToolFile.name()),'h',OreDictionary.getOres(ToolDictNames.craftingToolHardHammer.name()), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
	}

}
