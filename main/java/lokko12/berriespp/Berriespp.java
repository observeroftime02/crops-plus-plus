package lokko12.berriespp;

import lokko12.Proxies.*;
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

import mods.natura.common.NContent;

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
import tconstruct.world.TinkerWorld;
import net.minecraft.item.ItemStack;

@Mod(
	modid = "berriespp", name = "Berries++", version = "F-0.0.3T+N",
	dependencies = "required-after:IC2; after:Mantle; after:Natura; after:TConstruct"
	)

public class Berriespp {

	@Instance(value = "Berries++")
	public static Berriespp instance;
	
	//Loader
	
	//OW Berrys Natura
	public CropLoader cropMaloberryL;
	public CropLoader cropBlackberryL;
	public CropLoader cropBlueberryL;
	public CropLoader cropRaspberryL;
	
	//Nether Berrys Natura
	public CropLoader cropBlightberryL;
	public CropLoader cropSkyberryL;
	public CropLoader cropStingberryL;
	public CropLoader cropDuskberryL;
	
	//TC 
	public CropLoader cropIronOreBerryL;
	public CropLoader cropGoldOreBerryL;
	public CropLoader cropCopperOreBerryL;
	public CropLoader cropTinOreBerryL;
	public CropLoader cropAluminiumOreBerryL;
	public CropLoader cropEssenceOreBerryL;
	
	// public CropLoader NameOfCropL;

	@SidedProxy(clientSide = "lokko12.Proxies.ClientProxy", serverSide = "lokko12.Proxies.Proxy")
	public static Proxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {

		//OW Berrys Natura
		cropMaloberryL = new CropLoader(new MaloberryCrop(4, null));
		cropBlueberryL = new CropLoader(new BlueberryCrop(3,null));
		cropBlackberryL = new CropLoader(new BlackberryCrop(2,null));
		cropRaspberryL = new CropLoader(new RaspberryCrop(1,null));
		
		//Nether Berrys Natura
		cropBlightberryL = new CropLoader(new BlightberryCrop(5,null));
		cropSkyberryL = new CropLoader(new SkyberryCrop(6,null));
		cropStingberryL = new CropLoader(new StingberryCrop(7,null));
		cropDuskberryL = new CropLoader(new DuskberryCrop(8,null));
		
		//TC
		
		cropIronOreBerryL = new CropLoader(new IronOreBerryCrop());
		cropGoldOreBerryL = new CropLoader(new GoldOreBerryCrop());
		cropCopperOreBerryL = new CropLoader(new CopperOreBerryCrop());
		cropTinOreBerryL = new CropLoader(new TinOreBerryCrop());
		cropAluminiumOreBerryL = new CropLoader(new AluminiumOreBerryCrop());
		cropEssenceOreBerryL = new CropLoader(new EssenceOreBerryCrop());
		
		config c = new config(preinit, "berriespp.cfg");
		
		//OW Berrys Natura
		cropMaloberryL.load(c.tConfig, "MaloberryCrop");
		cropBlueberryL.load(c.tConfig, "BlueberryCrop");
		cropBlackberryL.load(c.tConfig, "BlackberryCrop");
		cropRaspberryL.load(c.tConfig, "RaspberryCrop");
		
		//Nether Berrys Natura
		cropBlightberryL.load(c.tConfig, "BlightberryCrop");
		cropSkyberryL.load(c.tConfig, "SkyberryCrop");
		cropStingberryL.load(c.tConfig, "StingberryCrop");
		cropDuskberryL.load(c.tConfig, "DuskberryCrop");
		
		//TC
		cropIronOreBerryL.load(c.tConfig, "IronOreBerryCrop");
		cropGoldOreBerryL.load(c.tConfig, "GoldOreBerryCrop");
		cropCopperOreBerryL.load(c.tConfig, "CopperOreBerryCrop");
		cropTinOreBerryL.load(c.tConfig, "TinOreBerryCrop");
		cropAluminiumOreBerryL.load(c.tConfig, "AluminiumOreBerryCrop");
		cropEssenceOreBerryL.load(c.tConfig, "EssenceOreBerryCrop");


		//NameOfCropL.load(c.tConfig, "NameOfCrop");
		
		c.tConfig.save();
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		
		//OW Berrys Natura
		cropMaloberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 3));
		cropBlackberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 2));
		cropBlueberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 1));
		cropRaspberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 0));
		
		cropRaspberryL.register();
		cropMaloberryL.register();
		cropBlueberryL.register();
		cropBlackberryL.register();
		
		//Nether Berrys Natura
		cropBlightberryL.registerBaseSeed(new ItemStack(NContent.netherBerryItem, 1, 0));
		cropDuskberryL.registerBaseSeed(new ItemStack(NContent.netherBerryItem, 1 ,1));
		cropSkyberryL.registerBaseSeed(new ItemStack(NContent.netherBerryItem, 1, 2));
		cropStingberryL.registerBaseSeed(new ItemStack(NContent.netherBerryItem, 1, 3));
		
		cropBlightberryL.register();
		cropDuskberryL.register();
		cropSkyberryL.register();
		cropStingberryL.register();
		
		//TC integration try
		
		cropIronOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 0));
		cropIronOreBerryL.register();
		cropGoldOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 1));
		cropGoldOreBerryL.register();
		cropCopperOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 2));
		cropCopperOreBerryL.register();
		cropTinOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 3));
		cropTinOreBerryL.register();
		cropAluminiumOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 4));
		cropAluminiumOreBerryL.register();
		cropEssenceOreBerryL.registerBaseSeed(new ItemStack(TinkerWorld.oreBerries, 1, 5));
		cropEssenceOreBerryL.register();
	
		// NameOfCropL.registerBaseSeed(new ItemStack(PlaceOfItem, AmmountOfItem, DMG));
		// NameOfCropL.register();
	}

	/*
	 * TODO:
	 * 1. TC Integration
	 * 2. Make Natura/TC Berries as item when Natura/TC is not Present
	 * 3. Oredict
	 */
}
