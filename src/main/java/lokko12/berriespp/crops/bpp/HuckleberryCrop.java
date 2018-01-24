package lokko12.berriespp.crops.bpp;
import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.croploadcore.OreDict;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class HuckleberryCrop extends BasicBerryCrop {

    public HuckleberryCrop() {
        super();
        OreDict.BSget("crop"+this.name(),this);
    }

    public String name() {
        return "Huckelberry";
    }
    
    public String[] attributes() {
        return new String[] {"Berry", "Food", "Tendrilly", "Purple", "Leaves"}; // Purple like CropVenomilia, Leaves like CropFerru
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
