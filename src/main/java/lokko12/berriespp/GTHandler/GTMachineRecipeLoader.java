package lokko12.berriespp.GTHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.objects.MaterialStack;
import gregtech.common.items.GT_FluidDisplayItem;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.ModsLoaded;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class GTMachineRecipeLoader implements Runnable{
	
	
	public GTMachineRecipeLoader(){
		super();
	}
	
    @Override
public void run(){
    	//Goldfish
    	GT_Values.RA.addFluidExtractionRecipe(BppItems.GoldfischS, new ItemStack(Items.gold_nugget), Materials.FishOil.getFluid(100L), 1, 16, 8);
    	GT_Values.RA.addPulveriserRecipe(BppItems.GoldfischS, new ItemStack[] {Materials.MeatRaw.getDust(1), Materials.Gold.getDustTiny(1), null, null, null}, new int[] {10000,100,0,0,0},3,8,false); //(ItemStack aInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt, boolean hidden
    	
    	if(ModsLoaded.dreamcraft) {
    	//Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricIron.getNeutrons()+Materials.MeteoricIron.getProtons())}, null, new ItemStack[] {Materials.MeteoricIron.getDust(1)}, 200, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Steel.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricSteel.getNeutrons()+Materials.MeteoricSteel.getProtons())}, null, new ItemStack[] {Materials.MeteoricSteel.getDust(1)}, 200, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Bismuth.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Oriharukon.getNeutrons()+Materials.Oriharukon.getProtons())}, null, new ItemStack[] {Materials.Oriharukon.getDust(1)}, 200, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Titanium.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Desh.getNeutrons()+Materials.Desh.getProtons())}, null, new ItemStack[] {Materials.Desh.getDust(1)}, 200, 512);
    	//NON-ELEMENTAR
    	//UV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Plutonium241.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.BlackPlutonium.getNeutrons()+Materials.BlackPlutonium.getProtons())*1000)}, null, new ItemStack[] {Materials.BlackPlutonium.getDust(1)}, 18000, 524544);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.MeteoricIron.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Trinium.getNeutrons()+Materials.Trinium.getProtons())*1000)}, null, new ItemStack[] {Materials.DeepIron.getDust(1)}, 18000, 524544);
    	//IV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(Blocks.ice),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Water.getProtons()+Materials.Water.getNeutrons())*10)}, null, new ItemStack[] {Materials.CallistoIce.getDust(1)}, 200, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Lead.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Ledox.getProtons()+Materials.Ledox.getNeutrons())}, null, new ItemStack[] {Materials.Ledox.getDust(1)}, 200, 8196);
    	}
    	
    	if(ModsLoaded.TC) {
    	//Magic Modifier PrimP
    	GT_Values.RA.addExtractorRecipe(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), new ItemStack(BppItems.Modifier,16,1), 2000, 8196);
    	GT_Values.RA.addAutoclaveRecipe(new ItemStack(BppItems.Modifier,16,1), Materials.UUMatter.getFluid(500L),thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), 5000, 2000, 8196, false);	
    	
    	//Magic Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Thaumium.getNeutrons()+Materials.Thaumium.getProtons())}, null, new ItemStack[] {Materials.Thaumium.getDust(1)}, 200, 128);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Thaumium.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Void.getNeutrons()+Materials.Void.getProtons())}, null, new ItemStack[] {Materials.Void.getDust(1)}, 200, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Void.getDust(1),new ItemStack(BppItems.Modifier,2,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Shadow.getNeutrons()+Materials.Shadow.getProtons())}, null, new ItemStack[] {Materials.Shadow.getDust(1)}, 200, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Shadow.getDust(1),new ItemStack(BppItems.Modifier,16,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Ichorium.getNeutrons()+Materials.Ichorium.getProtons())}, null, new ItemStack[] {Materials.Ichorium.getDust(1)}, 1800, 32768);
    	}
    	if(ModsLoaded.dreamcraft&&ModsLoaded.witchery) {
    	//Magic Modifier + Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,16,0), new ItemStack(BppItems.Modifier,4,1),new ItemStack(com.emoniph.witchery.Witchery.Items.GENERIC,1,130) }, new FluidStack[] {Materials.Platinum.getMolten(288L),Materials.MeteoricIron.getMolten(144L), Materials.UUMatter.getFluid(Materials.Mytryl.getProtons()+Materials.Mytryl.getNeutrons())}, null, new ItemStack[] {Materials.Mytryl.getDust(1)}, 1800, 8196);
    	}
    	//Trophy
    	GT_Values.RA.addExtruderRecipe(Materials.Neutronium.getBlocks(64), Materials.Neutronium.getBlocks(64), new ItemStack(BppItems.Modifier,1,3), 2147483647, 8);
    	
    }
}