package lokko12.berriespp.GTHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.ModsLoaded;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class GTMachineRecipeLoader implements Runnable{
	
	
	public GTMachineRecipeLoader(){
		super();
	}
	
    @Override
public void run(){
    	
    	//Space Modifier = Space Plant (Tier13, Naquadah plant +1 tier)
    	//Magic Modifier = Primordial Pearl
    	
    	//StonePlant
    	GT_Values.RA.addCompressorRecipe(Materials.Marble.getDust(9), Materials.Marble.getBlocks(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteRed.getDust(9), Materials.GraniteRed.getBlocks(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.GraniteBlack.getDust(9), Materials.GraniteBlack.getBlocks(1), 300, 2);
    	GT_Values.RA.addCompressorRecipe(Materials.Stone.getPlates(9), Materials.Stone.getBlocks(1),300,2);
    	
    	
    	//Goldfish
    	GT_Values.RA.addFluidExtractionRecipe(BppItems.GoldfischS, new ItemStack(Items.gold_nugget), Materials.FishOil.getFluid(100L), 1, 16, 8);
    	GT_Values.RA.addPulveriserRecipe(BppItems.GoldfischS, new ItemStack[] {Materials.MeatRaw.getDust(1), Materials.Gold.getDustTiny(1), null, null, null}, new int[] {10000,100,0,0,0},3,8,false); //(ItemStack aInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt, boolean hidden
    	
    	if(ModsLoaded.dreamcraft) {
    	//Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricIron.getNeutrons()+Materials.MeteoricIron.getProtons())}, null, new ItemStack[] {Materials.MeteoricIron.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Steel.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.MeteoricSteel.getNeutrons()+Materials.MeteoricSteel.getProtons())}, null, new ItemStack[] {Materials.MeteoricSteel.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Bismuth.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Oriharukon.getNeutrons()+Materials.Oriharukon.getProtons())}, null, new ItemStack[] {Materials.Oriharukon.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Titanium.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Desh.getNeutrons()+Materials.Desh.getProtons())}, null, new ItemStack[] {Materials.Desh.getDust(1)}, 240, 512);
    	//NON-ELEMENTAR
    	//UV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Plutonium241.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Neutronium.getNeutrons()+Materials.Neutronium.getProtons()))}, null, new ItemStack[] {Materials.BlackPlutonium.getDust(1)}, 120, 524544);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.MeteoricIron.getDust(1),new ItemStack(BppItems.Modifier,64,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Neutronium.getNeutrons()+Materials.Neutronium.getProtons()))}, null, new ItemStack[] {Materials.DeepIron.getDust(1)}, 120, 524544);
    	//IV
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Ice.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Water.getProtons()+Materials.Water.getNeutrons())*10)}, null, new ItemStack[] {Materials.CallistoIce.getDust(1)}, 240, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Lead.getDust(1),new ItemStack(BppItems.Modifier,16,0) }, new FluidStack[] {Materials.UUMatter.getFluid((Materials.Water.getProtons()+Materials.Water.getNeutrons())*10)}, null, new ItemStack[] {Materials.Ledox.getDust(1)}, 240, 8196);
    	}
    	
    	if(ModsLoaded.TC) {
    	//Magic Modifier PrimP
    	GT_Values.RA.addExtractorRecipe(thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), new ItemStack(BppItems.Modifier,8,1), 2000, 128);
    	GT_Values.RA.addExtractorRecipe(new ItemStack(BppItems.Modifier,1,1),new ItemStack(thaumcraft.api.ItemApi.getItem("itemResource", 14).getItem(),16,14), 2400, 128);
    	GT_Values.RA.addAutoclaveRecipe(new ItemStack(BppItems.Modifier,16,1), Materials.UUMatter.getFluid(52L),thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3), 10000, 24000, 384, false);	
    	GT_Values.RA.addAutoclaveRecipe(new ItemStack(thaumcraft.api.ItemApi.getItem("itemResource", 14).getItem(),32,14), Materials.UUMatter.getFluid(500L),new ItemStack(BppItems.Modifier,1,1), 3300, 2400, 128, false);	
    	//Magic Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Iron.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Thaumium.getNeutrons()+Materials.Thaumium.getProtons())}, null, new ItemStack[] {Materials.Thaumium.getDust(1)}, 240, 128);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Thaumium.getDust(1),new ItemStack(BppItems.Modifier,1,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Arsenic.getNeutrons()+Materials.Arsenic.getProtons())}, null, new ItemStack[] {Materials.Void.getDust(1)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Void.getDust(1),new ItemStack(BppItems.Modifier,2,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Indium.getNeutrons()+Materials.Indium.getProtons())}, null, new ItemStack[] {Materials.Shadow.getDust(1)}, 240, 8196);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {Materials.Shadow.getDust(1),new ItemStack(BppItems.Modifier,16,1) }, new FluidStack[] {Materials.UUMatter.getFluid(Materials.Osmium.getNeutrons()+Materials.Osmium.getProtons())}, null, new ItemStack[] {Materials.Ichorium.getIngots(1)}, 1800, 32768);
    	}
    	if(ModsLoaded.dreamcraft) {
    	//Magic Modifier + Space Modifier
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] { new ItemStack(BppItems.Modifier,16,0), new ItemStack(BppItems.Modifier,4,1)}, new FluidStack[] {Materials.Platinum.getMolten(288L),Materials.MeteoricIron.getMolten(144L), Materials.UUMatter.getFluid(Materials.Platinum.getProtons()+Materials.Platinum.getNeutrons())}, null, new ItemStack[] {Materials.Mytryl.getDust(1)}, 1800, 8196);
    	}
    	//Trophy
    	GT_Values.RA.addExtruderRecipe(Materials.Neutronium.getBlocks(64), Materials.Neutronium.getBlocks(64), new ItemStack(BppItems.Modifier,1,3), 2147483647, 8);
    	GT_Values.RA.addFluidExtractionRecipe(new ItemStack(BppItems.Modifier,1,0), null, Materials.UUMatter.getFluid(2L), 5000, 128, 4);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), new ItemStack(GCItems.meteoricIronRaw,1) }, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {Materials.MeteoricIron.getDust(4)}, 240, 512);
    	GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[] {new ItemStack(BppItems.Modifier,9,0), GT_OreDictUnificator.get(OrePrefixes.crushed.get(Materials.MeteoricIron), 1)}, new FluidStack[] {Materials.Water.getFluid(1000L)}, null, new ItemStack[] {GT_OreDictUnificator.get(OrePrefixes.crushedPurified.get(Materials.MeteoricIron), 4)}, 240, 512);
    	
    }
}