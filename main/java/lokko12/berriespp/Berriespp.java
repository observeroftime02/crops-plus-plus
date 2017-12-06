package lokko12.berriespp;

import lokko12.Proxies.*;

import lokko12.berriespp.crops.BlackberryCrop;
import lokko12.berriespp.crops.BlightberryCrop;
import lokko12.berriespp.crops.BlueberryCrop;
import lokko12.berriespp.crops.DuskberryCrop;
import lokko12.berriespp.crops.MaloberryCrop;
import lokko12.berriespp.crops.RaspberryCrop;
import lokko12.berriespp.crops.SkyberryCrop;
import lokko12.berriespp.crops.StingberryCrop;

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
import net.minecraft.item.ItemStack;

@Mod(
	modid = "berriespp", name = "Berrys++", version = "F-0.01N",
	dependencies = "required-after:IC2@[2.2.828-experimental]"
	)

public class Berriespp {

	@Instance(value = "Berrys++")
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
		
	
		// NameOfCropL.registerBaseSeed(new ItemStack(PlaceOfItem, AmmountOfItem, DMG));
		// NameOfCropL.register();
	}

}
