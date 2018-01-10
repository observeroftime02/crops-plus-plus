package lokko12.berriespp.crops.abstracts;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDict;
import mods.natura.common.NContent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public abstract class BasicCrop extends ic2.api.crops.CropCard {

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
	public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+this.name());
	}
	
	@Override
	public String discoveredBy() {
	    return "bartimaeusnek";
	}
	
	@Override
	public String owner() {
		return "berriespp";
	}
	
	
	
}
