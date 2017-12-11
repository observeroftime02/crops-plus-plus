package lokko12.croploadcore;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import lokko12.berriespp.crops.BoP.BoPBerryCrop;
import lokko12.berriespp.crops.TC.PrimordialPearlBerryCrop;
import lokko12.berriespp.crops.TConstruct.AluminiumOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.CopperOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.EssenceOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.GoldOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.IronOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.TinOreBerryCrop;
import lokko12.berriespp.crops.bpp.BasicBerryCrop;
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
import net.minecraft.item.ItemStack;

public class CropLoader {
	private static int anz = cropLoader().size();
	private static boolean bHasCropObj[] = new boolean[anz];
	private static boolean IC2Installed = false;
	private static boolean NaturaInstalled = false;
	private static boolean TConstructInstalled = false;
	private static boolean BoPInstalled = false;
	private static boolean TCInstalled = false;
	private CropCard cropObj;
	private ItemStack gain;
	
public CropLoader(CropCard cropObj,ItemStack gain) {
		
		this.cropObj = cropObj;
		this.gain = gain;
}
private static CropCard CropunpackerCC (CropLoader inp) {
	return inp.cropObj;
}
private static ItemStack CropunpackerCG (CropLoader inp) {
	return inp.gain;
}

private static List<CropLoader>  cropLoader() {
	IC2Installed = Loader.isModLoaded("IC2");
	NaturaInstalled = Loader.isModLoaded("Natura");
	TConstructInstalled = Loader.isModLoaded("TConstruct");
	BoPInstalled=Loader.isModLoaded("BiomesOPlenty");
	TCInstalled=Loader.isModLoaded("Thaumcraft");
	//ItemStack PrimP = thaumcraft.api.ItemApi.getItem("item.ItemEldritchObject", 3);
	
	List<CropLoader> p = new ArrayList<CropLoader>();
	if (NaturaInstalled == true) {
	p.add(new CropLoader(new init(new MaloberryCrop()).cropObj,new ItemStack(NContent.berryItem, 1, 3)));
	p.add(new CropLoader(new init(new BlackberryCrop()).cropObj,new ItemStack(NContent.berryItem, 1, 2)));
	p.add(new CropLoader(new init(new BlueberryCrop()).cropObj,new ItemStack(NContent.berryItem, 1, 1)));
	p.add(new CropLoader(new init(new RaspberryCrop()).cropObj,new ItemStack(NContent.berryItem, 1, 0)));
	p.add(new CropLoader(new init(new BlightberryCrop()).cropObj,new ItemStack(NContent.netherBerryItem, 1, 0)));
	p.add(new CropLoader(new init(new DuskberryCrop()).cropObj,new ItemStack(NContent.netherBerryItem, 1, 1)));
	p.add(new CropLoader(new init(new SkyberryCrop()).cropObj,new ItemStack(NContent.netherBerryItem, 1, 2)));
	p.add(new CropLoader(new init(new StingberryCrop()).cropObj,new ItemStack(NContent.netherBerryItem, 1, 3)));
	}
	if (TConstructInstalled == true) {
	p.add(new CropLoader(new init(new IronOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 0)));
	p.add(new CropLoader(new init(new GoldOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 1)));
	p.add(new CropLoader(new init(new CopperOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 2)));
	p.add(new CropLoader(new init(new TinOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 3)));
	p.add(new CropLoader(new init(new AluminiumOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 4)));
	p.add(new CropLoader(new init(new EssenceOreBerryCrop()).cropObj,new ItemStack(TinkerWorld.oreBerries, 1, 5)));
	}
	if(BoPInstalled==true) {
	p.add(new CropLoader(new init(new BoPBerryCrop()).cropObj,new ItemStack(biomesoplenty.api.content.BOPCItems.food,1,0)));
	}
	/*if(TCInstalled==true) {
	p.add(new CropLoader(new init(new PrimordialPearlBerryCrop()).cropObj, PrimP));
	}*/
	return p;
}
private static List<CropCard> cropObjs(){
	List<CropCard> p = new ArrayList<CropCard>();
	CropLoader[] f = new CropLoader[anz];
	cropLoader().toArray(f);
	for (int i=0;i < anz;i++) {
		p.add(CropunpackerCC(f[i]));
	}
	return p;
}
private static List<ItemStack> setBaseSeed(){
	List<ItemStack> p = new ArrayList<ItemStack>();
	CropLoader[] f = new CropLoader[anz];
	cropLoader().toArray(f);
	for (int i=0;i < anz;i++) {
		p.add(CropunpackerCG(f[i]));
	}
	return p;
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
public static void register () {
	for(int i=0; i < anz; i++) {
		CropCard[] g = new CropCard[anz];
		cropObjs().toArray(g);
	if (bHasCropObj[i]) {
    	Crops.instance.registerCrop(g[i]);
		}
    }
}		
public static void registerBaseSeed() {
	CropCard[] g = new CropCard[anz];
	cropObjs().toArray(g);
	ItemStack[] f = new ItemStack[anz];
	setBaseSeed().toArray(f);
	for(int i=0; i < anz; i++) {
			Crops.instance.registerBaseSeed(f[i],g[i], 1, 3, 3, 3);
	}
	if (IC2Installed == true)
		FMLLog.info("IC2 found! Berries++ will now load!");
	else 
		FMLLog.bigWarning("IC2 NOT INSTALLED! WTF? YOU NEED IT FOR CROPS! POWAOFCAPLSLOCK!",Loader.isModLoaded("IC2"));
	if (NaturaInstalled == true) 
		FMLLog.info("Natura found! Berries++ will use their items!");
	else
		FMLLog.warning("Natura NOT found! Berries++ will use NOT their items!");
	
	if (TConstructInstalled == true)
		FMLLog.info("Tinker's Construct found! Berries++ will use their items!");
	else
		FMLLog.warning("Tinker's Construct NOT found! Berries++ will NOT use their items!");
	
	if(BoPInstalled==true)
		FMLLog.info("Biomes O' Plenty found! Berries++ will use their items!");
	else
		FMLLog.warning("Biomes O' Plenty NOT found! Berries++ will NOT use their items!");
	if(TCInstalled==true)
		FMLLog.info("Thaumcraft found! Berries++ will use their items!");
	else
		FMLLog.warning("Thaumcraft NOT found! Berries++ will NOT use their items!");
		
	
}
}