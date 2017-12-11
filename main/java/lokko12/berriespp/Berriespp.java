package lokko12.berriespp;

import lokko12.Proxies.*;
import lokko12.croploadcore.CropLoader;

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
import scala.actors.threadpool.Arrays;


@Mod(
	modid = "berriespp", name = "Berries++", version = "F-0.0.6",
	dependencies = "required-after:IC2; after:Mantle; after:Natura; after:TConstruct; after:BiomesOPlenty"
	)

public class Berriespp {

	public static boolean devbuild = false;
	
	@Instance(value = "Berries++")
	public static Berriespp instance;

	@SidedProxy(clientSide = "lokko12.Proxies.ClientProxy", serverSide = "lokko12.Proxies.Proxy")
	public static Proxy proxy;


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		CropLoader.load(preinit);
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		
		CropLoader.registerBaseSeed(); //mb add itemlist for crops that gain != base seed
		CropLoader.register();

	/*
	 * TODO:
	 * 1. Witchery, Pam's Harvestcraft, Twilight Forrest 
	 * 2. Make Natura/TC Berries as item when Natura/TC is not Present
	 * 3. Oredict
	 */
		}
}
