package lokko12.croploadcore;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.Crops;
import lokko12.berriespp.CropLoader;
import mods.natura.common.NContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.world.TinkerWorld;

public class OreDictionaryPlants {
	public static void register() {
		//Grass
			OreDictionary.registerOre("plantGrass", new ItemStack(Item.getItemById(32),1,0));
			OreDictionary.registerOre("plantGrass", new ItemStack(Item.getItemById(31),1,2));
			OreDictionary.registerOre("plantGrass", new ItemStack(Item.getItemById(31),1,1));
			OreDictionary.registerOre("plantGrass", new ItemStack(Item.getItemById(175),1,2));
			OreDictionary.registerOre("plantGrass", new ItemStack(Item.getItemById(175),1,3));
		if (ModsLoaded.BoP)
		 {
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.plants,1,0));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.plants,1,1));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.plants,1,2));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.plants,1,3));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,1));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,2));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,5));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,7));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,9));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,10));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,11));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,12));
			 OreDictionary.registerOre("plantGrass",new ItemStack(BOPCBlocks.foliage,1,13)); 
		 }
		 if (ModsLoaded.TConstruct) {
			 OreDictionary.registerOre("plantGrass",new ItemStack(TinkerWorld.slimeGrass,1,0));
			 OreDictionary.registerOre("plantGrass",new ItemStack(TinkerWorld.slimeTallGrass,1,0));
	 	}
		 if (ModsLoaded.TC) {
			 OreDictionary.registerOre("plantGrass",thaumcraft.api.ItemApi.getBlock("blockTaintFibres",1));
		 }
		 //Vines
		 	 OreDictionary.registerOre("plantVines",Item.getItemById(106));
		 if (ModsLoaded.BoP)
			 OreDictionary.registerOre("plantVines",new ItemStack(BOPCBlocks.flowerVine,1,0));
		 if (ModsLoaded.Natura)
			 OreDictionary.registerOre("plantVines",new ItemStack(NContent.thornVines));
	}
	
	
}
