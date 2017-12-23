package lokko12.berriespp;

import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.OreDictionaryPlants;
import lokko12.croploadcore.config;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.*;
import net.minecraftforge.common.config.Configuration;


@Mod(
	modid = "berriespp", name = "Berries++", version = "0.2.3",
	/*
	 * Versions: 
	 * 			 0=Realises
	 * 			 2=Milestones
	 * 			 1=internal version Nr 
	 */
	dependencies = "required-after:IC2; after:Mantle; after:Natura; after:TConstruct; after:BiomesOPlenty; after:Thaumcraft;"
	)

public class Berriespp {
	public static String name = "Berries++";

	@Instance(value = "Berries++")
	public static Berriespp instance;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		ModsLoaded.check_init(name);
		CropLoaderNBS.load(preinit);
		CropLoader.load(preinit);
		if (ConfigValures.OreDictPlants==true)
		OreDictionaryPlants.register();
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		CropLoader.registerBaseSeed();
		CropLoaderNBS.register();
		CropLoader.register();
	/*
	 * TODO:
	 * 1. Witchery, Pam's Harvestcraft, Twilight Forrest 
	 */
		}
}
