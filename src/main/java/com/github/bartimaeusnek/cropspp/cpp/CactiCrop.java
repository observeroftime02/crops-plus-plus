package com.github.bartimaeusnek.cropspp.cpp;

import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.croploadcore.Operators;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import com.github.bartimaeusnek.cropspp.croploader.CropLoader;

import biomesoplenty.api.content.BOPCBlocks;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class CactiCrop extends BasicDecorationCrop {
	
	public CactiCrop() {
		if (ModsLoaded.BoP == true)
		Crops.instance.registerBaseSeed(new ItemStack(BOPCBlocks.plants,1,12),com.github.bartimaeusnek.cropspp.croploader.CropLoader.CropunpackerCC(new CropLoader(this)),1,1,1,1);
	}

    @Override
    public int tier() {
        return 3;
    }
    
	@Override
	public String name() {
		return "Cactus";
	}
	
	@Override
	public String[] attributes() {
		return new String[] {"Green","Cactus"};
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		if (Operators.AND(ModsLoaded.BoP == true, crop.getSize()==2))
		return new ItemStack(BOPCBlocks.plants,1,12);
		else 
		return new ItemStack(Item.getItemById(81),1,0);
	}
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() >= 2;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires more humidity than nutrients or air, but not much more
        return (int)((double)humidity*0.5 + (double)nutrients*1.25 + (double)air*1.25);
    }
    @Override
	public boolean onEntityCollision(ICropTile crop, Entity entity) {
    	if (Operators.NOT(entity instanceof EntityItem))
            entity.attackEntityFrom(DamageSource.cactus, 1);
    	if (entity instanceof EntityLivingBase) {
			return ((EntityLivingBase) entity).isSprinting();
		}
		return false;
	}
	@Override
	public ItemStack getDisplayItem() {
		return new ItemStack(Item.getItemById(81),1,0);
	}

}
