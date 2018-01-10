package lokko12.berriespp;

import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.ModsLoaded;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import lokko12.croploadcore.config;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.common.*;
import net.minecraftforge.common.config.Configuration;


@Mod(
	modid = "berriespp", name = "Berries++", version = "1.1.0",
	/*
	 * Versions: 
	 * 			 1=Realises
	 * 			 0=Milestones
	 * 			 0=internal version Nr 
	 */
	dependencies = "required-after:IC2; after:gregtech; after:Mantle; after:Natura; after:TConstruct; after:BiomesOPlenty; after:Thaumcraft; after:ExtraTrees; after:witchery"
	)

public class Berriespp {
	public static String name = "Berries++";

	@Instance(value = "Berries++")
	public static Berriespp instance;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		ModsLoaded.check_init(name);
		BppItems.register_Items();
		CropLoaderNBS.load(preinit);
		CropLoader.load(preinit);
		OreDict.register();
		BppItems.OreDictItems();
		
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
	 * 1. Pam's Harvestcraft, Twilight Forrest
	 * 2. OreDict EVERYTHING!
	 */
		}
}
