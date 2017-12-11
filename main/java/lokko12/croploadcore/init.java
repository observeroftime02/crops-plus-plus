package lokko12.croploadcore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
//BoP
import lokko12.berriespp.crops.BoP.BoPBerryCrop;
//TC Berries
import lokko12.berriespp.crops.TC.AluminiumOreBerryCrop;
import lokko12.berriespp.crops.TC.CopperOreBerryCrop;
import lokko12.berriespp.crops.TC.EssenceOreBerryCrop;
import lokko12.berriespp.crops.TC.GoldOreBerryCrop;
import lokko12.berriespp.crops.TC.IronOreBerryCrop;
import lokko12.berriespp.crops.TC.TinOreBerryCrop;
import lokko12.berriespp.crops.bpp.BasicBerryCrop;
//Natura Berries
import lokko12.berriespp.crops.natura.BlackberryCrop;
import lokko12.berriespp.crops.natura.BlightberryCrop;
import lokko12.berriespp.crops.natura.BlueberryCrop;
import lokko12.berriespp.crops.natura.DuskberryCrop;
import lokko12.berriespp.crops.natura.MaloberryCrop;
import lokko12.berriespp.crops.natura.RaspberryCrop;
import lokko12.berriespp.crops.natura.SkyberryCrop;
import lokko12.berriespp.crops.natura.StingberryCrop;
import mods.natura.common.NContent;
import net.minecraftforge.common.config.Configuration;
import tconstruct.world.TinkerWorld;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class init {
	
	private static int anz = cropObjs().size();
	private static boolean IC2Installed = false;
	private static boolean NaturaInstalled = false;
	private static boolean TConstructInstalled = false;
	private static boolean BoPInstalled = false;
	private static boolean bHasCropObj[] = new boolean[anz];
	private CropCard cropObj;
	
	public init() {
		
	}
	
	public init(CropCard cropObj) {
		this.cropObj = cropObj;
	}

	private static List<CropCard> cropObjs() {
		
		List<CropCard> p = new ArrayList<CropCard>();
		p.add(new init(new MaloberryCrop()).cropObj);
		p.add(new init(new BlackberryCrop()).cropObj);
		p.add(new init(new BlueberryCrop()).cropObj);
		p.add(new init(new RaspberryCrop()).cropObj);
		p.add(new init(new BlightberryCrop()).cropObj);
		p.add(new init(new DuskberryCrop()).cropObj);
		p.add(new init(new SkyberryCrop()).cropObj);
		p.add(new init(new StingberryCrop()).cropObj);
		p.add(new init(new IronOreBerryCrop()).cropObj);
		p.add(new init(new GoldOreBerryCrop()).cropObj);
		p.add(new init(new CopperOreBerryCrop()).cropObj);
		p.add(new init(new TinOreBerryCrop()).cropObj);
		p.add(new init(new AluminiumOreBerryCrop()).cropObj);
		p.add(new init(new EssenceOreBerryCrop()).cropObj);
		p.add(new init(new BoPBerryCrop()).cropObj);
		return p;
	}
	
	private static ItemStack[] setBaseSeed() {
		IC2Installed = Loader.isModLoaded("IC2");
		NaturaInstalled = Loader.isModLoaded("Natura");
		TConstructInstalled = Loader.isModLoaded("TConstruct");
		BoPInstalled=Loader.isModLoaded("BiomesOPlenty");
		if (IC2Installed == false) 
		{
			System.out.println("IC2 NOT INSTALLED! WTF? YOU NEED IT FOR CROPS! POWAOFCAPLSLOCK!");
			
		}
		else 
		{
			System.out.println("IC2 found! Berries++ will now load!");
		}
		List<ItemStack> p = new ArrayList<ItemStack>();
		if (NaturaInstalled == true) {
			System.out.println("Natura found! Berries++ will use their items!");
			p.add(new ItemStack(NContent.berryItem, 1, 3));
			p.add(new ItemStack(NContent.berryItem, 1, 2));
			p.add(new ItemStack(NContent.berryItem, 1, 1));
			p.add(new ItemStack(NContent.berryItem, 1, 0));
			p.add(new ItemStack(NContent.netherBerryItem, 1, 0));
			p.add(new ItemStack(NContent.netherBerryItem, 1, 1));
			p.add(new ItemStack(NContent.netherBerryItem, 1, 2));
			p.add(new ItemStack(NContent.netherBerryItem, 1, 3));
		}
		else
		{
			System.out.println("Natura NOT found! Berries++ will use  NOT their items!");
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
		}
		if (TConstructInstalled == true) 
		{
		System.out.println("Tinker's Construct found! Berries++ will use their items!");
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 0));
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 1));
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 2));
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 3));
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 4));
			p.add(new ItemStack(TinkerWorld.oreBerries, 1, 5));
		}
		else {
			System.out.println("Tinker's Construct NOT found! Berries++ will NOT use their items!");
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
			p.add(new ItemStack(Items.wheat, 1));
		}
		
		if(BoPInstalled==true) {
		System.out.println("Biomes O' Plenty found! Berries++ will use their items!");
		p.add(new ItemStack(biomesoplenty.api.content.BOPCItems.food,1,0));
		}
		else
		{
			System.out.println("Biomes O' Plenty NOT found! Berries++ will NOT use their items!");
			p.add(new ItemStack(Items.wheat, 1));
		}
		ItemStack[] f = new ItemStack[anz];
		p.toArray(f);
		return f;
	}
	
	private static String[] setnames() {
		CropCard[] f = new CropCard[anz];
		cropObjs().toArray(f);
		String[] s = new String[anz];
		 for (int i=0; i<anz; i++) {
		 s[i]=f[i].name();
		}
		 return s;
	}

	public static void load(FMLPreInitializationEvent preinit){
		
		config c = new config(preinit, "berriespp.cfg");
		
		for(int i=0; i < anz; i++) {
		bHasCropObj[i] = c.tConfig.get("crops", setnames()[i], true).getBoolean(false);
		}
		c.save();
	}
	
	public static void registerBaseSeed() {
	
		CropCard[] g = new CropCard[anz];
		cropObjs().toArray(g);
		for(int i=0; i < anz; i++) {
				Crops.instance.registerBaseSeed(setBaseSeed()[i],g[i], 1, 3, 3, 3);
		}
	}
	
	
	public static void register () {
		for(int i=0; i < anz; i++) {
			CropCard[] g = new CropCard[anz];
			cropObjs().toArray(g);
		if (bHasCropObj[i]) {
        	Crops.instance.registerCrop(g[i]);
		}
        }
	}
}
	
