package lokko12.berriespp.GTHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;
import ic2.core.Ic2Items;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.OreDict;
import net.minecraft.init.Items;

public class GTCraftingRecipeLoader implements Runnable {

	public GTCraftingRecipeLoader() {
		super();
	}
	
	public void run() {
		gregtech.api.util.GT_ModHandler.addCraftingRecipe(BppItems.itemSpadeStack,GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,new Object[] {"fPh", "PWP", " S ", 'P',OreDict.ISget("plateDenseSteel"), 'W', Ic2Items.weedingTrowel.getItem(),'S',Items.stick});
	}

}
