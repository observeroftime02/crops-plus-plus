package lokko12.berriespp.crops.bpp;

import java.util.Random;

import biomesoplenty.api.content.BOPCBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.CropLoader;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.croploadcore.Intrandom;
import lokko12.croploadcore.ModsLoaded;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import tconstruct.world.TinkerWorld;

public class GrassCrop extends BasicDecorationCrop {
	private int random;
	 public GrassCrop() {
		 super();
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(32),1,0),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(31),1,2),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(175),1,2),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),2,1,1,1);
		 	Crops.instance.registerBaseSeed(new ItemStack(Item.getItemById(175),1,3),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),2,1,1,1);
		 if (ModsLoaded.BoP)
		 {
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,0),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,1),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,2),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,3),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,1),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,2),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,5),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,7),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,9),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,10),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,11),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,12),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.foliage,1,13),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1); 
		 }
		 if (ModsLoaded.TConstruct) {
			 Crops.instance.registerBaseSeed(new ItemStack(TinkerWorld.slimeGrass,1,0),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
			 Crops.instance.registerBaseSeed(new ItemStack(TinkerWorld.slimeTallGrass,1,0),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),2,1,1,1);
	 	}
		 if (ModsLoaded.TC) {
			 Crops.instance.registerBaseSeed(thaumcraft.api.ItemApi.getBlock("blockTaintFibres",1),lokko12.berriespp.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
		 }
	 }

	    @Override
	    public int tier() {
	        return 0;
	    }
	    
	    @Override
	    public int stat(int n) {
	        switch(n) {
	        case 0: return 0;   // not chemical
	        case 1: return 0;   // not edible
	        case 2: return 0;   // no defensive properties
	        case 3: return 3;   // primarily decorative
	        case 4: return 4;   // weed-like
	        default: return 0;
	        }
	    }
	 
	    @Override
	    public String name() {
	        return "Grass";
	    }
	    
	    @Override
	    public int getOptimalHavestSize(ICropTile crop) {
	        return 1;
	    }

	    @Override
		public boolean isWeed(ICropTile crop) {
			return true;
		}
	    
	    @Override
		public boolean onEntityCollision(ICropTile crop, Entity entity) {
	    	return false;
		}
	    @Override
	    public boolean leftclick(ICropTile crop, EntityPlayer player) {
	    	return false;
		}
		@Override
		public float dropGainChance() { 
			return (float) 1;
		}
	    
	    @Override
	    public boolean canBeHarvested(ICropTile crop) {
	    	return crop.getSize() > 1;
	    }
	    
	    @Override
	    public String[] attributes() {
	        return new String[] {"Green", "Tendrilly"};
	    }

	    @Override
	    public ItemStack getGain(ICropTile crop) {
	    	if (crop.getSize() == 3)
	    	return new ItemStack(Item.getItemById(32),1,0);	
	    	if (crop.getSize() == 2) {
	    	random = Intrandom.intrandom(10);
	    	switch (random){
	    		case 9:
	    			return new ItemStack(Item.getItemById(175),1,3);
	    		default:
	    			return new ItemStack(Item.getItemById(31),1,2);
	    		}
	    	}
	    	random = Intrandom.intrandom(10);
	    	switch (random){
	    		case 9:
	    			return new ItemStack(Item.getItemById(175),1,2);
	    		default:
	    			return new ItemStack(Item.getItemById(31),1,1);
	    		}
	    }
	    @Override
	    public byte getSizeAfterHarvest(ICropTile crop) {
	        return (byte)((int)crop.getSize()-1);
	    }
}
