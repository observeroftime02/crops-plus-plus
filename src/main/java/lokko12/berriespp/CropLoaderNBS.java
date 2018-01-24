package lokko12.berriespp;

import java.util.ArrayList;
import java.util.List;
//Forge
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
//IC2API
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import lokko12.berriespp.crops.BoP.TurnipCrop;
import lokko12.berriespp.crops.BoP.WildCarrotsCrop;
import lokko12.berriespp.crops.TC.CinderpearlCrop;
import lokko12.berriespp.crops.TC.ShimmerleafCrop;
//Crops
import lokko12.berriespp.crops.bpp.ArditeBerryCrop;
import lokko12.berriespp.crops.bpp.CobaltBerryCrop;
import lokko12.berriespp.crops.bpp.HuckleberryCrop;
import lokko12.berriespp.crops.bpp.SpacePlantCrop;
import lokko12.berriespp.crops.bpp.StrawberryCrop;
import lokko12.berriespp.crops.bpp.WeedCrop;
import lokko12.berriespp.crops.bpp.GoldfishCrop;
import lokko12.berriespp.crops.bpp.trees.InstalledTreesGetter;
import lokko12.berriespp.crops.natura.BarleyCrop;
import lokko12.berriespp.crops.natura.BlackberryCrop;
import lokko12.berriespp.crops.natura.BlueberryCrop;
import lokko12.berriespp.crops.natura.CottonCrop;
import lokko12.berriespp.crops.natura.MaloberryCrop;
import lokko12.berriespp.crops.natura.RaspberryCrop;
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
import lokko12.croploadcore.config;

/*
 * This Class Loades Crops without Base Seed.
 * Call it with:
 * CropLoaderNBS.load(preinit);
 * at the preinit phase to load the crops into the config.
 * Then call it at postinit with
 * CropLoaderNBS.register();
 * to load the Crops into the game.
 */

public class CropLoaderNBS {
	private static boolean mods[] = new boolean[4];
	private static int anz;
	private static boolean bHasCropObj[];
	private CropCard cropObj;
	
public static List<CropCard> cropLoader() {
	List<CropCard> p = new ArrayList<CropCard>();
	/*
	 * Add your crops without base seed here by
	 * p.add(new CropLoader(new YourCropClass());
	 */
	if (lokko12.croploadcore.ModsLoaded.TConstruct) {
	p.add(new ArditeBerryCrop());
	p.add(new CobaltBerryCrop());
	}
	
	p.add(new GoldfishCrop());
	
	if(ModsLoaded.dreamcraft)
	p.add(new SpacePlantCrop());
	
	//has Base seeds but is called via Oredict:
	p.add(new StrawberryCrop()); 
	p.add(new MaloberryCrop()); 
	p.add(new BlackberryCrop()); 
	p.add(new BlueberryCrop()); 
	p.add(new RaspberryCrop()); 
	//p.add(new HuckleberryCrop()); 
	
	if (lokko12.croploadcore.ModsLoaded.TC) {
	p.add(new ShimmerleafCrop());
	p.add(new CinderpearlCrop());
	}
	
	if (lokko12.croploadcore.ModsLoaded.witchery) {
	p.add(new GlintWeedCrop());
	p.add(new SpanishMossCrop());
	p.add(new BelladonnaCrop());
	p.add(new MandragoraCrop());
	p.add(new SnowbellCrop());
	p.add(new WolfsBaneCrop());
	p.add(new WaterArtichokeCrop());
	//p.add(new EmberMossCrop());
	}
	
	p.add(new GarlicCrop());
	
	p.add(new TurnipCrop());
	p.add(new WildCarrotsCrop());
	//p.add(new WeedCrop());
	p.add(new BarleyCrop());
	p.add(new CottonCrop());
	return p;
}

private static String[] setnames() {
	if (anz != 0) {
	CropCard[] f = new CropCard[anz];
	cropLoader().toArray(f);
	String[] s = new String[anz];
	 for (int i=0; i<anz; i++) {
	 s[i]=f[i].name();
	}
	 return s;
}
	return null;
}
public static void load(FMLPreInitializationEvent preinit){
	config c = new config(preinit, "berriespp.cfg");
	anz=cropLoader().size();
	if (anz != 0)
	bHasCropObj = new boolean[anz];
	if (setnames() != null)
	for(int i=0; i < anz; i++) {
		bHasCropObj[i] = c.tConfig.get("Crops", setnames()[i], true).getBoolean(false);
	}
	c.save();
}

public static void register () {
	if (anz != 0) {
	for(int i=0; i < anz; i++) {
		CropCard[] g = new CropCard[anz];
		cropLoader().toArray(g);
	if (bHasCropObj[i]) {
    	Crops.instance.registerCrop(g[i]);
		}
    }
	}
}

}