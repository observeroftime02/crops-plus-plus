package com.github.bartimaeusnek.cropspp.abstracts;

import com.github.bartimaeusnek.cropspp.ConfigValures;

import ic2.api.crops.ICropTile;
import lokko12.croploadcore.Operators;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;

public abstract class BasicTinkerBerryCrop extends BasicCrop {

	public BasicTinkerBerryCrop ()
	{
		super();
	}

    
    @Override
    public int tier() {
        return 5;
    }

	@Override
	public float dropGainChance() { 
		return (float) ((Math.pow(0.95, (float) tier()))*ConfigValures.TConstructBerryGain);
	}
    
    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 3;   // Industrial Crop
        case 1: return 0;   // NOT Edible
        case 2: return 4;   // strong defensive properties
        case 3: return 1;   // a bit colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
    	boolean r;
    	if (ConfigValures.Debug == true)
    		r = crop.getSize() < 4;
    	else
    	r = crop.getSize() < 1 || (crop.getLightLevel() <= 10 && crop.getSize() < 4); //Codepiece by DaeFennek <3
    	return r;
    	}
    	

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 4;
    }

    
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() >= 3;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires no humidity but nutrients.
        return (int)((double)humidity*0.5 + (double)nutrients*1.5 + (double)air*1);
    }
    
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
    
	@Override
	public int maxSize() {
		return 4;
	}
	
	public static String OBname() {
		return "Oreberry";
	}
	
    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        // return to partially grown state when harvested
        return 2;
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
	
}
