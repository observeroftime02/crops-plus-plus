package lokko12.berriespp;

import java.util.ArrayList;
import java.util.List;
//Forge
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
//IC2API
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
//Crops
import lokko12.berriespp.crops.BoP.BoPBerryCrop;
import lokko12.berriespp.crops.BoP.BoPGlowShroom;
import lokko12.berriespp.crops.BoP.FloweringVinesCrop;
import lokko12.berriespp.crops.BoP.IvyCrop;
import lokko12.berriespp.crops.TC.MagicMetalBerryCrop;
import lokko12.berriespp.crops.TC.PrimordialPearlBerryCrop;
import lokko12.berriespp.crops.TConstruct.AluminiumOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.CopperOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.EssenceOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.GoldOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.IronOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.TinOreBerryCrop;
import lokko12.berriespp.crops.abstracts.BasicBerryCrop;
import lokko12.berriespp.crops.abstracts.BasicNetherShroomCrop;
import lokko12.berriespp.crops.bpp.GrassCrop;
import lokko12.berriespp.crops.bpp.StrawberryCrop;
import lokko12.berriespp.crops.bpp.CactiCrop;
import lokko12.berriespp.crops.bpp.VineCrop;
import lokko12.berriespp.crops.natura.BlackberryCrop;
import lokko12.berriespp.crops.natura.BlueberryCrop;
import lokko12.berriespp.crops.natura.MaloberryCrop;
import lokko12.berriespp.crops.natura.RaspberryCrop;
import lokko12.berriespp.crops.natura.SaguaroCrop;
import lokko12.berriespp.crops.natura.nether.BlightberryCrop;
import lokko12.berriespp.crops.natura.nether.DuskberryCrop;
import lokko12.berriespp.crops.natura.nether.NetherShroomBlue;
import lokko12.berriespp.crops.natura.nether.NetherShroomGreen;
import lokko12.berriespp.crops.natura.nether.NetherShroomPurple;
import lokko12.berriespp.crops.natura.nether.SkyberryCrop;
import lokko12.berriespp.crops.natura.nether.StingberryCrop;
import lokko12.berriespp.crops.natura.nether.Thornvines;
import lokko12.berriespp.crops.bpp.trees.InstalledTreesGetter;
//Core
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.config;
//ItemsFromAPIs
import mods.natura.common.NContent;
import tconstruct.world.TinkerWorld;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.api.content.BOPCItems;
//MinecraftAPI
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CropLoader {
	private static boolean mods[] = new boolean[4];
	private static int anz;
	private static boolean bHasCropObj[];
	private CropCard cropObj;
	private ItemStack gain;
	
	
	/*
	 * This Class Loades Crops with Base Seed.
	 * Call it with:
	 * CropLoader.load(preinit);
	 * at the preinit phase to load the crops into the config.
	 * Then call it at postinit with
	 * CropLoader.register();
	 * to load the Crops into the game.
	 */

	
public CropLoader(CropCard cropObj) {
		this.cropObj = cropObj;
}
public CropLoader(CropCard cropObj, ItemStack gain) {
		
		this.cropObj = cropObj;
		this.gain = gain;
}
public static CropCard CropunpackerCC (CropLoader inp) {
	return inp.cropObj;
}
private static ItemStack CropunpackerCG (CropLoader inp) {
	return inp.gain;
}

private static List<CropLoader> cropLoader() {
	
	List<CropLoader> p = new ArrayList<CropLoader>();
	
	/*
	 * Add your crops with base seed here by
	 * p.add(new CropLoader(new YourCropClass(),YourItem));
	 */
	
	p.add(new CropLoader(new VineCrop(),new ItemStack(Item.getItemById(106),1,0)));
	p.add(new CropLoader(new GrassCrop(),new ItemStack(Item.getItemById(31),1,1)));
	p.add(new CropLoader(new CactiCrop(),new ItemStack(Item.getItemById(81),1,0)));
	if (Operators.AND(ModsLoaded.Natura,mods[0])) {
	p.add(new CropLoader(new MaloberryCrop(),new ItemStack(NContent.berryItem, 1, 3)));
	p.add(new CropLoader(new BlackberryCrop(),new ItemStack(NContent.berryItem, 1, 2)));
	p.add(new CropLoader(new BlueberryCrop(),new ItemStack(NContent.berryItem, 1, 1)));
	p.add(new CropLoader(new RaspberryCrop(),new ItemStack(NContent.berryItem, 1, 0)));
	p.add(new CropLoader(new BlightberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 0)));
	p.add(new CropLoader(new DuskberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 1)));
	p.add(new CropLoader(new SkyberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 2)));
	p.add(new CropLoader(new StingberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 3)));
	p.add(new CropLoader(new Thornvines(), new ItemStack(NContent.thornVines,1,0))); 
	p.add(new CropLoader(new NetherShroomBlue(), new ItemStack(NContent.glowshroom,1,2)));
	p.add(new CropLoader(new NetherShroomGreen(), new ItemStack(NContent.glowshroom,1,0)));
	p.add(new CropLoader(new NetherShroomPurple(), new ItemStack(NContent.glowshroom,1,1)));
	p.add(new CropLoader(new SaguaroCrop(),new ItemStack(NContent.seedFood,1,0)));
	}
	if (Operators.AND(ModsLoaded.TConstruct,mods[1])) {
	p.add(new CropLoader(new IronOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 0)));
	p.add(new CropLoader(new GoldOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 1)));
	p.add(new CropLoader(new CopperOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 2)));
	p.add(new CropLoader(new TinOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 3)));
	p.add(new CropLoader(new AluminiumOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 4)));
	p.add(new CropLoader(new EssenceOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 5)));
	}
	if (Operators.AND(ModsLoaded.BoP,mods[2])) {
	p.add(new CropLoader(new BoPBerryCrop(),new ItemStack(BOPCItems.food,1,0)));
	p.add(new CropLoader(new BoPGlowShroom(), new ItemStack(BOPCBlocks.mushrooms,1,3)));
	p.add(new CropLoader(new FloweringVinesCrop(),new ItemStack(BOPCBlocks.flowerVine,1,0)));
	p.add(new CropLoader(new IvyCrop(),new ItemStack(BOPCBlocks.ivy,1,0)));
	}
	if (Operators.AND(ModsLoaded.TC, mods[3])) {
	p.add(new CropLoader(new PrimordialPearlBerryCrop(), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3)));
	//p.add(new CropLoader(new MagicMetalBerryCrop(),thaumcraft.api.ItemApi.getItem("itemResource", 17)));
	}
	//trees
	if (lokko12.berriespp.ConfigValures.ayo_bonsai == true)
	for(int i=0; i < InstalledTreesGetter.Anz(); i++)
		p.add(new CropLoader(InstalledTreesGetter.InstalledTreesGet()[i],new ItemStack(InstalledTreesGetter.Tree[i],1,InstalledTreesGetter.TreeDMG[i])));
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
	c.tConfig.addCustomCategoryComment("System", "enable or disable system config:"
			+ "\nDebug will set all crops groth duration to 1 and disable all requirements.(aka. \"Cheatmode\")"
			+ "\nBonsai Generation will generate crops from saplings, WiP state. (disabled bc of bugs with metadata, but sure you can try it.)");
	ConfigValures.Debug = c.tConfig.get("System", "Debug", false).getBoolean(true);
	ConfigValures.ayo_bonsai = c.tConfig.get("System", "Bonsai Generation", false).getBoolean(true);
	ConfigValures.OreDictPlants = c.tConfig.get("System", "Register plants to OreDict", true).getBoolean(false);
	
	c.tConfig.addCustomCategoryComment("Mods", "enable crops from mods here:");
	mods[0]=c.tConfig.get("Mods", "Natura", true).getBoolean(false);
	mods[1]=c.tConfig.get("Mods", "Tinker\'s Construct", true).getBoolean(false);
	mods[2]=c.tConfig.get("Mods", "Biomes O\' Plenty", true).getBoolean(false);
	mods[3]=c.tConfig.get("Mods", "Thaumcraft", true).getBoolean(false);
	anz=cropLoader().size();
	
	c.tConfig.addCustomCategoryComment("Crops", "enable single plants here:");
	bHasCropObj = new boolean[anz];
	for(int i=0; i < anz; i++) {
		bHasCropObj[i] = c.tConfig.get("Crops", setnames()[i], true).getBoolean(false);
	}
	
	c.tConfig.addCustomCategoryComment("Gain", "Set custom gain modifiers here:"
			+ "\n Tinker's Construct Berries' Gain is not modified by All Crops."
			+ "\n Primordial Berry's gain is absolut."
			+ "\n Primordial Berry's groth time is divided by 4, in IC2 groth points."
			+ "\n IC2 groth points are calculated by 3 + random 0-7 + statGrowth per 256ticks");
	ConfigValures.BerryGain = (float) c.tConfig.get("Gain", "All crops",(float) 1).getDouble(1);
	ConfigValures.TConstructBerryGain = (float) c.tConfig.get("Gain", "Tinker's Construct berries",(float) 1).getDouble(1);
	ConfigValures.PrimordialBerryGain = (float) c.tConfig.get("Gain", "Primordial Berry",(float) 0.5).getDouble(0.5);
	ConfigValures.PrimordialBerryGroth = c.tConfig.get("Gain", "Primordial Berry groth time.",125000).getInt(125000);
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
			Crops.instance.registerBaseSeed(f[i],g[i], 1, 1, 1, 1);
	}	
}
}