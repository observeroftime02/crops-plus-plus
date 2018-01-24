package lokko12.berriespp.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Goldfish extends ItemFood {

	public Goldfish() {
		super(1, 2, false);
		this.setCreativeTab(CreativeTab.bpp);
		this.setUnlocalizedName("foodGoldfish");
		this.setTextureName("bpp:foodGoldfish");
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("Hozuki no Reitetsu!");
	}
	
}
