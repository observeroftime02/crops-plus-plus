package lokko12.berriespp.crops.bpp;
import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.CropLoader;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;

public class StrawberryCrop extends BasicBerryCrop {

    public StrawberryCrop() {
    	super();
    	int anz = OreDictionary.getOres("cropStrawberry").size();
        ItemStack[] BaseSeeds = new ItemStack[anz];
        OreDictionary.getOres("cropStrawberry").toArray(BaseSeeds);
    	if (OreDictionary.getOres("cropStrawberry").size()!= 0)
    		for (int i=0; i < anz; i++)
            Crops.instance.registerBaseSeed(BaseSeeds[i],this,1,1,1,1);
    }

    public String name() {
        return "Strawberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Food", "Tendrilly", "Red"}; // Red like CropRedWheat, CropNetherWart
    }


    public String discoveredBy() {
        return "Ancient cultures";
    }
    
    @Override
    public ItemStack getGain(ICropTile crop) {
    	if (OreDictionary.getOres("cropStrawberry").size()!= 0)
    	{
            return OreDictionary.getOres("cropStrawberry").get(OreDictionary.getOres("cropStrawberry").size()-1);
        }
    	else 
    		return null;
    }
}
