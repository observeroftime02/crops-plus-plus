package lokko12.croploadcore;

import biomesoplenty.api.content.BOPCBlocks;
import mods.natura.common.NContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tconstruct.world.TinkerWorld;

public class OreDictionaryPlants {
	private static boolean isregistered = false;
	public static void register() {
		
		if (isregistered==false){
		//Grass
			OreDictionary.registerOre("cropGrass", new ItemStack(Item.getItemById(32),1,0));
			OreDictionary.registerOre("cropGrass", new ItemStack(Item.getItemById(31),1,2));
			OreDictionary.registerOre("cropGrass", new ItemStack(Item.getItemById(31),1,1));
			OreDictionary.registerOre("cropGrass", new ItemStack(Item.getItemById(175),1,2));
			OreDictionary.registerOre("cropGrass", new ItemStack(Item.getItemById(175),1,3));
		if (ModsLoaded.BoP)
		 {
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.plants,1,0));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.plants,1,1));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.plants,1,2));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.plants,1,3));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,1));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,2));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,5));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,7));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,9));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,10));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,11));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,12));
			 OreDictionary.registerOre("cropGrass",new ItemStack(BOPCBlocks.foliage,1,13)); 
		 }
		 if (ModsLoaded.TConstruct) {
			 OreDictionary.registerOre("cropGrass",new ItemStack(TinkerWorld.slimeGrass,1,0));
			 OreDictionary.registerOre("cropGrass",new ItemStack(TinkerWorld.slimeTallGrass,1,0));
	 	}
		 if (ModsLoaded.TC) {
			 OreDictionary.registerOre("cropGrass",thaumcraft.api.ItemApi.getBlock("blockTaintFibres",1));
		 }
		 //Vines
		 	 OreDictionary.registerOre("cropVines",Item.getItemById(106));
		 if (ModsLoaded.BoP)
		 {
			 OreDictionary.registerOre("cropVines",new ItemStack(BOPCBlocks.flowerVine,1,0));
		 	 OreDictionary.registerOre("cropVines",new ItemStack(BOPCBlocks.ivy,1,0));
		 }
		 if (ModsLoaded.Natura)
			 OreDictionary.registerOre("cropVines",new ItemStack(NContent.thornVines)); 
		 //Cacti
		 OreDictionary.registerOre("cropCactus", new ItemStack(Item.getItemById(81),1,0));
		 if (ModsLoaded.Natura)
			 OreDictionary.registerOre("cropCactus",new ItemStack(NContent.saguaro));
		 if (ModsLoaded.BoP)
		 {
			 OreDictionary.registerOre("cropCactus",new ItemStack(BOPCBlocks.plants,1,12));
		 } 
		 isregistered=true;
		}
	}
}
