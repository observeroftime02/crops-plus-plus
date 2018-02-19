package lokko12.berriespp;

import java.util.ArrayList;
import java.util.List;

import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.api.content.BOPCItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//IC2API
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
//Crops
import lokko12.berriespp.crops.BoP.BoPBerryCrop;
import lokko12.berriespp.crops.BoP.EyebulbCrop;
import lokko12.berriespp.crops.BoP.FloweringVinesCrop;
import lokko12.berriespp.crops.BoP.GlowflowerCrop;
import lokko12.berriespp.crops.BoP.GlowingCoralCrop;
import lokko12.berriespp.crops.BoP.IvyCrop;
import lokko12.berriespp.crops.BoP.TurnipCrop;
import lokko12.berriespp.crops.BoP.WildCarrotsCrop;
import lokko12.berriespp.crops.TC.CinderpearlCrop;
import lokko12.berriespp.crops.TC.MagicMetalBerryCrop;
import lokko12.berriespp.crops.TC.PrimordialPearlBerryCrop;
import lokko12.berriespp.crops.TC.ShimmerleafCrop;
import lokko12.berriespp.crops.TConstruct.AluminiumOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.CopperOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.EssenceOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.GoldOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.IronOreBerryCrop;
import lokko12.berriespp.crops.TConstruct.TinOreBerryCrop;
import lokko12.berriespp.crops.bpp.ArditeBerryCrop;
import lokko12.berriespp.crops.bpp.CactiCrop;
import lokko12.berriespp.crops.bpp.CobaltBerryCrop;
import lokko12.berriespp.crops.bpp.GoldfishCrop;
import lokko12.berriespp.crops.bpp.GrassCrop;
import lokko12.berriespp.crops.bpp.HuckleberryCrop;
import lokko12.berriespp.crops.bpp.KnighmetalCrop;
import lokko12.berriespp.crops.bpp.MagicModifierCrop;
import lokko12.berriespp.crops.bpp.PapyrusCrop;
import lokko12.berriespp.crops.bpp.SpacePlantCrop;
import lokko12.berriespp.crops.bpp.StonelillyCrop;
import lokko12.berriespp.crops.bpp.StrawberryCrop;
import lokko12.berriespp.crops.bpp.VineCrop;
import lokko12.berriespp.crops.natura.BarleyCrop;
import lokko12.berriespp.crops.natura.BlackberryCrop;
import lokko12.berriespp.crops.natura.BlueberryCrop;
import lokko12.berriespp.crops.natura.CottonCrop;
import lokko12.berriespp.crops.natura.MaloberryCrop;
import lokko12.berriespp.crops.natura.RaspberryCrop;
import lokko12.berriespp.crops.natura.SaguaroCrop;
import lokko12.berriespp.crops.natura.nether.BasicNetherShroomCrop;
import lokko12.berriespp.crops.natura.nether.BlightberryCrop;
import lokko12.berriespp.crops.natura.nether.DuskberryCrop;
import lokko12.berriespp.crops.natura.nether.SkyberryCrop;
import lokko12.berriespp.crops.natura.nether.StingberryCrop;
import lokko12.berriespp.crops.natura.nether.Thornvines;
import lokko12.berriespp.crops.witchery.BelladonnaCrop;
import lokko12.berriespp.crops.witchery.EmberMossCrop;
import lokko12.berriespp.crops.witchery.GarlicCrop;
import lokko12.berriespp.crops.witchery.GlintWeedCrop;
import lokko12.berriespp.crops.witchery.MandragoraCrop;
import lokko12.berriespp.crops.witchery.SnowbellCrop;
import lokko12.berriespp.crops.witchery.SpanishMossCrop;
import lokko12.berriespp.crops.witchery.WaterArtichokeCrop;
import lokko12.berriespp.crops.witchery.WolfsBaneCrop;
//Core
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import lokko12.croploadcore.config;
//ItemsFromAPIs
import mods.natura.common.NContent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tconstruct.world.TinkerWorld;

public class CropLoader {
	private static boolean mods[] = new boolean[4];
	private static List<Boolean> bHasCropObj = new ArrayList<Boolean>();
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
		if (gain != null)
		this.gain = gain;
		else
		this.gain = null;
}
public static CropCard CropunpackerCC (CropLoader inp) {
	return inp.cropObj;
}
private static ItemStack CropunpackerCG (CropLoader inp) {
	if (inp.gain!=null)
	return inp.gain;
	else
	return null;
}

private static CropLoader CropHelper(CropCard cropObj) {
	return new CropLoader(cropObj,OreDict.ISget("crop"+cropObj.name()));
}

public static List<CropLoader> cropLoader() {
	
	List<CropLoader> p = new ArrayList<CropLoader>();
	
	/*
	 * Add your crops with base seed here by
	 * p.add(new CropLoader(new YourCropClass(),YourItem));
	 */
	p.add(new CropLoader(new VineCrop(),new ItemStack(Item.getItemById(106),1,0)));
	p.add(new CropLoader(new GrassCrop(),new ItemStack(Item.getItemById(31),1,1)));
	p.add(new CropLoader(new CactiCrop(),new ItemStack(Item.getItemById(81),1,0)));
	p.add(new CropLoader(new PapyrusCrop(),null));
	p.add(new CropLoader(new GoldfishCrop(),null));
	if(Loader.isModLoaded("TwilightForest"))
	p.add(new CropLoader(new KnighmetalCrop(),null));
	
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
	if (Operators.AND(ModsLoaded.Natura,mods[0])) {
	p.add(new CropLoader(new BlightberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 0)));
	p.add(new CropLoader(new DuskberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 1)));
	p.add(new CropLoader(new SkyberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 2)));
	p.add(new CropLoader(new StingberryCrop(),new ItemStack(NContent.netherBerryItem, 1, 3)));
	p.add(new CropLoader(new Thornvines(), new ItemStack(NContent.thornVines,1,0))); 
	p.add(new CropLoader(new BasicNetherShroomCrop("Blue"), new ItemStack(NContent.glowshroom,1,2)));
	p.add(new CropLoader(new BasicNetherShroomCrop("Green"), new ItemStack(NContent.glowshroom,1,0)));
	p.add(new CropLoader(new BasicNetherShroomCrop("Purple"), new ItemStack(NContent.glowshroom,1,1)));
	p.add(new CropLoader(new SaguaroCrop(),new ItemStack(NContent.seedFood,1,0)));
	p.add(new CropLoader(new CottonCrop(),null));
	}
	if (Operators.AND(ModsLoaded.TConstruct,mods[1])) {
	p.add(new CropLoader(new IronOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 0)));
	p.add(new CropLoader(new GoldOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 1)));
	p.add(new CropLoader(new CopperOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 2)));
	p.add(new CropLoader(new TinOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 3)));
	p.add(new CropLoader(new AluminiumOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 4)));
	p.add(new CropLoader(new EssenceOreBerryCrop(),new ItemStack(TinkerWorld.oreBerries, 1, 5)));
	p.add(new CropLoader(new ArditeBerryCrop(),null));
	p.add(new CropLoader(new CobaltBerryCrop(),null));
	}
	if (Operators.AND(ModsLoaded.BoP,mods[2])) {
	p.add(new CropLoader(new BoPBerryCrop(),new ItemStack(BOPCItems.food,1,0)));
	p.add(new CropLoader(new BasicNetherShroomCrop("Yellow"), new ItemStack(BOPCBlocks.mushrooms,1,3)));
	p.add(new CropLoader(new FloweringVinesCrop(),new ItemStack(BOPCBlocks.flowerVine,1,0)));
	p.add(new CropLoader(new IvyCrop(),new ItemStack(BOPCBlocks.ivy,1,0)));
	p.add(new CropLoader(new EyebulbCrop(),new ItemStack(BOPCBlocks.flowers,1,13)));
	p.add(new CropLoader(new GlowingCoralCrop(),new ItemStack(BOPCBlocks.coral1,1,15)));
	p.add(new CropLoader(new GlowflowerCrop(), new ItemStack(BOPCBlocks.flowers,1,3)));
	p.add(new CropLoader(new TurnipCrop(),null));
	p.add(new CropLoader(new WildCarrotsCrop(),null));
	p.add(new CropLoader(new BarleyCrop(),null));
	}
	if (Operators.AND(ModsLoaded.TC, mods[3])) {
	p.add(new CropLoader(new PrimordialPearlBerryCrop(), thaumcraft.api.ItemApi.getItem("itemEldritchObject", 3)));
	p.add(new CropLoader(new MagicMetalBerryCrop(), thaumcraft.api.ItemApi.getItem("itemResource", 17)));
	p.add(new CropLoader(new ShimmerleafCrop(),null));
	p.add(new CropLoader(new CinderpearlCrop(),null));
	}
	p.add(new CropLoader(new HuckleberryCrop(),null));
	p.add(new CropLoader(new StrawberryCrop(),null)); 
	p.add(new CropLoader(new MaloberryCrop(),null)); 
	p.add(new CropLoader(new BlackberryCrop(),null)); 
	p.add(new CropLoader(new BlueberryCrop(),null)); 
	p.add(new CropLoader(new RaspberryCrop(),null)); 
	if (lokko12.croploadcore.ModsLoaded.witchery) {
	p.add(new CropLoader(new GlintWeedCrop(),null));
	p.add(new CropLoader(new SpanishMossCrop(),null));
	p.add(new CropLoader(new BelladonnaCrop(),null));
	p.add(new CropLoader(new MandragoraCrop(),null));
	p.add(new CropLoader(new SnowbellCrop(),null));;
	p.add(new CropLoader(new WolfsBaneCrop(),null));
	p.add(new CropLoader(new WaterArtichokeCrop(),null));
	p.add(new CropLoader(new EmberMossCrop(),null));
	}
	p.add(new CropLoader(new GarlicCrop(),null));

	//p.add(new WeedCrop());

	/*if (lokko12.berriespp.ConfigValures.ayo_bonsai)
		if (InstalledTreesGetter.savedNames != null)	
	for(int i=0; i < InstalledTreesGetter.savedNames.size(); i++) {
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
private static List<CropCard> cropObjs(){
	List<CropCard> p = new ArrayList<CropCard>();
	for (int i=0;i < cropLoader().size();i++) {
		p.add(CropunpackerCC(cropLoader().get(i)));
	}
	return p;
}
private static List<ItemStack> setBaseSeed(){
	List<ItemStack> p = new ArrayList<ItemStack>();
	for (int i=0;i < cropLoader().size();i++) {
		p.add(CropunpackerCG(cropLoader().get(i)));
	}
	return p;
}

private static List<String> setnames() {
	List<String> s = new ArrayList<String>();
	 for (int i=0; i<cropLoader().size(); i++) {
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
	
	c.tConfig.addCustomCategoryComment("Mods", "enable crops from mods here:");
	mods[0]=c.tConfig.get("Mods", "Natura", true).getBoolean(false);
	mods[1]=c.tConfig.get("Mods", "Tinker\'s Construct", true).getBoolean(false);
	mods[2]=c.tConfig.get("Mods", "Biomes O\' Plenty", true).getBoolean(false);
	mods[3]=c.tConfig.get("Mods", "Thaumcraft", true).getBoolean(false);
	
	c.tConfig.addCustomCategoryComment("Crops", "enable single plants here:");
	for(int i=0; i < cropLoader().size(); i++) {
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
	for(int i=0; i < cropLoader().size(); i++) {
	if (bHasCropObj.get(i)&&cropObjs().get(i)!=null)
		Crops.instance.registerCrop(cropObjs().get(i));
    }
	if (lokko12.berriespp.ConfigValures.ayo_bonsai == true)
	Berriespp.bpplogger.info("Bonsais registered!");
}

public static void registerBaseSeed() {
	
	List<ItemStack> baseseed = new ArrayList<ItemStack>(setBaseSeed());
	
	for(int i=0; i < cropLoader().size(); i++) {
		if(baseseed.get(i)!=null && cropObjs().get(i)!=null)
			Crops.instance.registerBaseSeed(baseseed.get(i),cropObjs().get(i), 1, 1, 1, 1);
	}
	
	if (lokko12.berriespp.ConfigValures.ayo_bonsai == true)
	Berriespp.bpplogger.info("Bonsai Base Seed registered!");
}
}