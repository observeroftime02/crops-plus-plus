package lokko12.berriespp.crops.BoP;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicFoodCrop;
import lokko12.croploadcore.OreDict;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class WildCarrotsCrop extends BasicFoodCrop {
	public WildCarrotsCrop()
	{
		super();
		OreDict.BSget("cropWildcarrots",this);
	}
	
	@Override
    public String name() {
        return "Wild Carrots";
    }
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return OreDict.ISget("cropWildcarrots");
	}
	
	@Override
	public String[] attributes() {
		String[] r = new String[super.attributes().length+2];
		for (int i =0; i < super.attributes().length; i++)
		{
			r[i] = super.attributes()[i];
		}
		r[super.attributes().length+1] = "White";
		r[super.attributes().length+2] = "Carrots";
		
		return r;
	}
}
