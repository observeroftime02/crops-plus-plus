package lokko12.berriespp.items;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.RegistryNamespaced;

public class Modifier extends Item {
	public Modifier() {
		super();
	    this.setCreativeTab(CreativeTab.bpp);
	    this.bFull3D=false;
	    this.hasSubtypes = true;
	}
	
	public IIcon[] icons;
    public String[] textureNames = new String[] {"Space", "Magic", "Anti","Trophy"};

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage (int meta)
    {
        return icons[meta];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons (IIconRegister iconRegister)
    {
        this.icons = new IIcon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon("bpp:item_Modifier_" + textureNames[i]);
        }
    }
    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return (new StringBuilder()).append("item_Modifier_").append(textureNames[itemstack.getItemDamage()]).toString();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems (Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < textureNames.length; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
