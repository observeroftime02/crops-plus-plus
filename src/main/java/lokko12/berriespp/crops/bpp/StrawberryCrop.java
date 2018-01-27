package lokko12.berriespp.crops.bpp;
import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.CropLoader;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.croploadcore.OreDict;
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
    	OreDict.BSget("crop"+this.name(),this);
    }

    public String name() {
        return "Strawberry";
    }

    public String[] attributes() {
        return new String[] {"Berry", "Food", "Red"}; // Red like CropRedWheat, CropNetherWart
    }


    public String discoveredBy() {
        return "Ancient cultures";
    }
    
    @Override
    public ItemStack getGain(ICropTile crop) {
    	return OreDict.ISget("crop"+this.name());
    }

	@Override
	public ItemStack getDisplayItem() {
		return OreDict.ISget("crop"+this.name());
	}
}
