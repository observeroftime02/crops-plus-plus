package com.github.bartimaeusnek.cropspp;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.croploadcore.config;
import com.github.bartimaeusnek.cropspp.cpp.ArditeBerryCrop;
import com.github.bartimaeusnek.cropspp.cpp.CactiCrop;
import com.github.bartimaeusnek.cropspp.cpp.CobaltBerryCrop;
import com.github.bartimaeusnek.cropspp.cpp.GoldfishCrop;
import com.github.bartimaeusnek.cropspp.cpp.GrassCrop;
import com.github.bartimaeusnek.cropspp.cpp.HuckleberryCrop;
import com.github.bartimaeusnek.cropspp.cpp.KnighmetalCrop;
import com.github.bartimaeusnek.cropspp.cpp.MagicModifierCrop;
import com.github.bartimaeusnek.cropspp.cpp.PapyrusCrop;
import com.github.bartimaeusnek.cropspp.cpp.SpacePlantCrop;
import com.github.bartimaeusnek.cropspp.cpp.StonelillyCrop;
import com.github.bartimaeusnek.cropspp.cpp.StrawberryCrop;
import com.github.bartimaeusnek.cropspp.cpp.SugarBeetCrop;
import com.github.bartimaeusnek.cropspp.cpp.VineCrop;
import com.github.bartimaeusnek.cropspp.crops.TC.CinderpearlCrop;
import com.github.bartimaeusnek.cropspp.crops.TC.MagicMetalBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TC.PrimordialPearlBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TC.ShimmerleafCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.AluminiumOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.CopperOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.EssenceOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.GoldOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.IronOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.TConstruct.TinOreBerryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.BarleyCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.BlackberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.BlueberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.CottonCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.MaloberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.RaspberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.SaguaroCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.BelladonnaCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.EmberMossCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.GarlicCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.GlintWeedCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.MandragoraCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.SnowbellCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.SpanishMossCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.WaterArtichokeCrop;
import com.github.bartimaeusnek.cropspp.crops.witchery.WolfsBaneCrop;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//IC2API
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
//ItemsFromAPIs
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CropLoader {
	private static List<Boolean> bHasCropObj = new ArrayList<Boolean>();
	private CropCard cropObj;
	private ItemStack baseseed;
	private static List<CropLoader> list = cropLoader();
	
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
		if (gain != null)
		this.baseseed = gain;
		else
		this.baseseed = null;
}
public static CropCard CropunpackerCC (CropLoader inp) {
	return inp.cropObj;
}
private static ItemStack CropunpackerCG (CropLoader inp) {
	if (inp.baseseed!=null)
	return inp.baseseed;
	else
	return null;
}

private static CropLoader CropHelper(CropCard cropObj) {
	return new CropLoader(cropObj,OreDict.ISget("crop"+cropObj.name()));
}

public final static List<CropLoader> cropLoader() {
	
	List<CropLoader> p = new ArrayList<CropLoader>();
	
	/*
	 * Add your crops with base seed here by
	 * p.add(new CropLoader(new YourCropClass(),YourItem));
	 */
	
	if(Loader.isModLoaded("TwilightForest")) {
	p.add(new CropLoader(new KnighmetalCrop(),null));
	}
	if(ModsLoaded.dreamcraft) {
	p.add(new CropLoader(new SpacePlantCrop(),null));
	p.add(new CropLoader(new MagicModifierCrop(),null));
	}
	if(ModsLoaded.GT) {
	p.add(new CropLoader(new StonelillyCrop("Red"),null));
	p.add(new CropLoader(new StonelillyCrop("Black"),null));
	p.add(new CropLoader(new StonelillyCrop("Gray"),null));
	p.add(new CropLoader(new StonelillyCrop("White"),null));
	p.add(new CropLoader(new StonelillyCrop("Yellow"),null));
	p.add(new CropLoader(new StonelillyCrop("Nether"),null));
	}

	if(ModsLoaded.Natura)
		p.addAll(NaturaLoader.NaturaLoaderList());
	else {
		p.add(new CropLoader(new SaguaroCrop(),null));
	}
	if (ModsLoaded.Natura||ModsLoaded.PHC) {
	p.add(new CropLoader(new CottonCrop(),null));
	}
	

	if (ModsLoaded.TConstruct) {
	p.add(new CropLoader(new IronOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 0)));
	p.add(new CropLoader(new GoldOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 1)));
	p.add(new CropLoader(new CopperOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 2)));
	p.add(new CropLoader(new TinOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 3)));
	p.add(new CropLoader(new AluminiumOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 4)));
	p.add(new CropLoader(new EssenceOreBerryCrop(),new ItemStack(tconstruct.world.TinkerWorld.oreBerries, 1, 5)));
	p.add(new CropLoader(new ArditeBerryCrop(),null));
	p.add(new CropLoader(new CobaltBerryCrop(),null));
	}

	if (ModsLoaded.BoP) {
		p.addAll(BoPLoader.BoPLoaderList());
	}
	if (ModsLoaded.BoP || ModsLoaded.PHC) {
	p.add(new CropLoader(new BarleyCrop(),null));
	}

	if (ModsLoaded.TC) {
	p.add(new CropLoader(new PrimordialPearlBerryCrop(), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3)));
	p.add(new CropLoader(new MagicMetalBerryCrop(), thaumcraft.api.ItemApi.getItem("itemResource", 17)));
	p.add(new CropLoader(new ShimmerleafCrop(),null));
	p.add(new CropLoader(new CinderpearlCrop(),null));
	}
	if (ModsLoaded.witchery) {
	p.add(new CropLoader(new GlintWeedCrop(),null));
	p.add(new CropLoader(new SpanishMossCrop(),null));
	p.add(new CropLoader(new BelladonnaCrop(),null));
	p.add(new CropLoader(new MandragoraCrop(),null));
	p.add(new CropLoader(new SnowbellCrop(),null));;
	p.add(new CropLoader(new WolfsBaneCrop(),null));
	p.add(new CropLoader(new WaterArtichokeCrop(),null));
	p.add(new CropLoader(new EmberMossCrop(),null));
	}
	if (ModsLoaded.witchery || ModsLoaded.PHC) {
	p.add(new CropLoader(new GarlicCrop(),null));
	}
	
	p.add(new CropLoader(new VineCrop(),new ItemStack(Item.getItemById(106),1,0)));
	p.add(new CropLoader(new GrassCrop(),new ItemStack(Item.getItemById(31),1,1)));
	p.add(new CropLoader(new CactiCrop(),new ItemStack(Item.getItemById(81),1,0)));
	p.add(new CropLoader(new PapyrusCrop(),null));
	p.add(new CropLoader(new GoldfishCrop(),null));
	p.add(new CropLoader(new SugarBeetCrop(),null));
	
	p.add(new CropLoader(new HuckleberryCrop(),null));
	p.add(new CropLoader(new StrawberryCrop(),null)); 
	p.add(new CropLoader(new MaloberryCrop(),null)); 
	p.add(new CropLoader(new BlackberryCrop(),null)); 
	p.add(new CropLoader(new BlueberryCrop(),null)); 
	p.add(new CropLoader(new RaspberryCrop(),null)); 

	//p.add(new WeedCrop());

	/*if (lokko12.berriespp.ConfigValures.ayo_bonsai)
		if (InstalledTreesGetter.savedNames != null)	
	for(int i=0; i < InstalledTreesGetter.savedNames.size(); ++i) {
		if( Operators.AND(Operators.NOR( InstalledTreesGetter.savedNames.get(i).contains("Shimmerleaf"),InstalledTreesGetter.savedNames.get(i).contains("Cinderpearl") ) , Operators.NOR(InstalledTreesGetter.savedNames.get(i).contains("Vishroom"),InstalledTreesGetter.savedNames.get(i).contains("Ethereal Bloom")))) 
		{
			p.add(new CropLoader(new BasicBonsaiCrop(InstalledTreesGetter.savedNames.get(i),
					"bpp:"+InstalledTreesGetter.BaseSeed.get(i).getIconIndex().getIconName().replaceAll(":","_")
					,InstalledTreesGetter.savedDrop.get(i)),InstalledTreesGetter.BaseSeed.get(i)));
		}
		
			
	}
		else
			Berriespp.bpplogger.info("Something wrent wrong at getting Trees, BonsaiGen Disabled!");*/
	return p;
}
private final static List<CropCard> cropObjs(){
	List<CropCard> p = new ArrayList<CropCard>();
	for (int i=0;i < list.size();++i) {
		p.add(CropunpackerCC(list.get(i)));
	}
	return p;
}
private final static List<ItemStack> setBaseSeed(){
	List<ItemStack> p = new ArrayList<ItemStack>();
	for (int i=0;i < list.size();++i) {
		p.add(CropunpackerCG(list.get(i)));
	}
	return p;
}

private final static List<String> setnames() {
	List<String> s = new ArrayList<String>();
	 for (int i=0; i<list.size(); ++i) {
	 s.add(cropObjs().get(i).name());
	}
	 return s;
}
public static void load(FMLPreInitializationEvent preinit){
	config c = new config(preinit, "berriespp.cfg");
	c.tConfig.addCustomCategoryComment("System", "enable or disable system config:"
			+ "\nDebug will set all crops groth duration to 1 and disable all requirements.(aka. \"Cheatmode\")"
			+ "\nBonsai Generation will generate crops from saplings, WiP state. (disabled bc of bugs with metadata, but sure you can try it.)"
			+ "\nWiP Items are not finished items."
			+ "\nItems will enable/disable all items.");
	ConfigValures.Debug 		= c.tConfig.get("System", "Debug", false).getBoolean(true);
	ConfigValures.WiPItems 		= c.tConfig.get("System", "WiP Items", false).getBoolean(true);
	ConfigValures.Items 		= c.tConfig.get("System", "Items", true).getBoolean(false);
	
	c.tConfig.addCustomCategoryComment("Crops", "enable single plants here:");
	
	for(int i=0; i < list.size(); ++i) {
		bHasCropObj.add(c.tConfig.get("Crops", setnames().get(i), true).getBoolean(false));
	}
	
	c.tConfig.addCustomCategoryComment("Gain", "Set custom gain modifiers here:"
			+ "\n Tinker's Construct Berries' Gain is not modified by All Crops."
			+ "\n Primordial Berry's gain is absolut"
			+ "\n Primordial Berry's growth time is divided by 4, in IC2 groth points. F.e. 10 = 40GP per groth-period"
			+ "\n IC2 groth points are calculated by 3 + random 0-7 + statGrowth per 256ticks");
	ConfigValures.BerryGain = (float) c.tConfig.get("Gain", "All crops",(float) 1).getDouble(1);
	ConfigValures.TConstructBerryGain = (float) c.tConfig.get("Gain", "Tinker's Construct berries",(float) 1).getDouble(1);
	ConfigValures.PrimordialBerryGain = (float) c.tConfig.get("Gain", "Primordial Berry",(float) 0.5).getDouble(0.5);
	ConfigValures.PrimordialBerryGroth = c.tConfig.get("Gain", "Primordial Berry growth time",125000).getInt(125000);
	c.save();
}

public static void register () {
	for(int i=0; i < list.size(); ++i) {
	if (bHasCropObj.get(i)&&cropObjs().get(i)!=null)
		Crops.instance.registerCrop(cropObjs().get(i));
    }
	if (com.github.bartimaeusnek.cropspp.ConfigValures.ayo_bonsai == true)
	Cropspp.cpplogger.info("Bonsais registered!");
}

public static void registerBaseSeed() {
	
	List<ItemStack> baseseed = new ArrayList<ItemStack>(setBaseSeed());
	
	for(int i=0; i < list.size(); ++i) {
		if(baseseed.get(i)!=null && cropObjs().get(i)!=null)
			Crops.instance.registerBaseSeed(baseseed.get(i),cropObjs().get(i), 1, 1, 1, 1);
	}
	
	if (com.github.bartimaeusnek.cropspp.ConfigValures.ayo_bonsai == true)
	Cropspp.cpplogger.info("Bonsai Base Seed registered!");
}
}