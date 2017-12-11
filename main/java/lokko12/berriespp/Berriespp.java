package lokko12.berriespp;

import lokko12.Proxies.*;
/*
//BoP
import lokko12.berriespp.crops.BoP.BoPBerryCrop;
//TC Berries
import lokko12.berriespp.crops.TC.AluminiumOreBerryCrop;
import lokko12.berriespp.crops.TC.CopperOreBerryCrop;
import lokko12.berriespp.crops.TC.EssenceOreBerryCrop;
import lokko12.berriespp.crops.TC.GoldOreBerryCrop;
import lokko12.berriespp.crops.TC.IronOreBerryCrop;
import lokko12.berriespp.crops.TC.TinOreBerryCrop;
//Natura Berries
import lokko12.berriespp.crops.natura.BlackberryCrop;
import lokko12.berriespp.crops.natura.BlightberryCrop;
import lokko12.berriespp.crops.natura.BlueberryCrop;
import lokko12.berriespp.crops.natura.DuskberryCrop;
import lokko12.berriespp.crops.natura.MaloberryCrop;
import lokko12.berriespp.crops.natura.RaspberryCrop;
import lokko12.berriespp.crops.natura.SkyberryCrop;
import lokko12.berriespp.crops.natura.StingberryCrop;
//cfg
import lokko12.croploadcore.CropLoader;
import lokko12.croploadcore.config;

//items
import mods.natura.common.NContent;
import tconstruct.world.TinkerWorld;
import net.minecraft.item.ItemStack;

*/
import lokko12.croploadcore.init;


import java.util.ArrayList;
import java.util.List;

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
	modid = "berriespp", name = "Berries++", version = "F-0.0.4",
	dependencies = "required-after:IC2; after:Mantle; after:Natura; after:TConstruct; after:BiomesOPlenty"
	)

public class Berriespp {

	@Instance(value = "Berries++")
	public static Berriespp instance;

	@SidedProxy(clientSide = "lokko12.Proxies.ClientProxy", serverSide = "lokko12.Proxies.Proxy")
	public static Proxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		init.load(preinit);
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		
		init.registerBaseSeed(); //mb add itemlist for crops that gain != base seed
		init.register();

	/*
	 * TODO:
	 * 1. Witchery, Pam's Harvestcraft, Twilight Forrest 
	 * 2. Make Natura/TC Berries as item when Natura/TC is not Present
	 * 3. Oredict
	 */
		}
}
