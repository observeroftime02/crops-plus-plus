package lokko12.berriespp.crops.bpp;
import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class StrawberryCrop extends BasicBerryCrop {

    public StrawberryCrop(int id, ItemStack item) {
        super();
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
}
