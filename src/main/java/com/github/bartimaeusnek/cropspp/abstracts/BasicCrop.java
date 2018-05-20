package com.github.bartimaeusnek.cropspp.abstracts;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.ConfigValures;
import com.github.bartimaeusnek.cropspp.Cropspp;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import speiger.src.crops.api.ICropCardInfo;

public abstract class BasicCrop extends CropCard implements ICropCardInfo {

	@SideOnly(Side.CLIENT)
	public void registerSprites(IIconRegister iconRegister) {
		textures = new IIcon[maxSize()];

		for (int i = 1; i <= textures.length; i++) {
			// ic2:crop/blockCrop.NAME.n is the legacy name for backwards compatiblity
			textures[i - 1] = iconRegister.registerIcon("bpp:crop/blockCrop."+name()+"."+i);
		}
	}
	
	@Override
	public float dropGainChance() { 
		return (float) ((Math.pow(0.95, (float) tier()))*ConfigValures.BerryGain);
	}
	
	@Override
	public boolean canCross(ICropTile crop) {
		return crop.getSize() == maxSize();
	}
	
	@Override
    public int getrootslength(ICropTile crop) {
        return 3;
    }
	
	@Override
	public String discoveredBy() {
	    return "bartimaeusnek";
	}
	
	@Override
	public String owner() {
		return Cropspp.modID;
	}
	
	public List<String> getCropInformation(){
		List<String> ret = new ArrayList<String>();
			ret.add(attributes().toString());
		return ret;
	}
	
	public ItemStack getDisplayItem(CropCard card) {
		return OreDict.ISget("crop"+this.name());
	}
	
}
