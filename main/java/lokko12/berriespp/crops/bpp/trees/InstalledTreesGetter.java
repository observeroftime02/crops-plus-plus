package lokko12.berriespp.crops.bpp.trees;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.FMLLog;
import ic2.api.crops.CropCard;
import lokko12.berriespp.CropLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class InstalledTreesGetter {
	private static int anz = OreDictionary.getOres("treeSapling").size();
	private static ItemStack TreeS[] = new ItemStack[anz];
	public static String TreeName[]=new String[anz];
	private static CropCard ret[] = new CropCard[anz];
	public static Item Tree[] = new Item[anz];
	public static int TreeDMG[] = new int[anz];
	
	public static CropCard[] InstalledTreesGet() {
		OreDictionary.getOres("treeSapling").toArray(TreeS);
		for (int i=0; i < anz; i++) {
			Tree[i]=TreeS[i].getItem();
			TreeDMG[i]=TreeS[i].getItemDamage();
			TreeName[i]=TreeS[i].getDisplayName();
			if (TreeName[i] == "ic2.blockRubSapling") {
				//ic2 integration
				ret[i]=new BasicBonsaiCrop("Rubber Tree");
				FMLLog.info(TreeName[i]+" crop was created");
			}
			else {
				ret[i]=new BasicBonsaiCrop(TreeName[i].replace("Sapling", ""));
				FMLLog.info(TreeName[i]+" crop was created");
			
			}
		}
		return ret;
	}
	
	public static int Anz() {
		return anz;
	}
	
}