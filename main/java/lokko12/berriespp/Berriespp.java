package lokko12.berriespp;

import lokko12.Proxies.*;
import lokko12.berriespp.crops.BlackberryCrop;
import lokko12.berriespp.crops.BlueberryCrop;
import lokko12.berriespp.crops.MaloberryCrop;
import lokko12.berriespp.crops.RaspberryCrop;
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

@Mod(modid = "berriespp", name = "Berrys++", version = "F-0.01a")
public class Berriespp {

	@Instance(value = "Berrys++")
	public static Berriespp instance;
	public CropLoader cropMaloberryL;
	public CropLoader cropBlackberryL;
	public CropLoader cropBlueberryL;
	public CropLoader cropRaspberryL;
	// public CropLoader NameOfCropL;

	@SidedProxy(clientSide = "lokko12.Proxies.ClientProxy", serverSide = "lokko12.Proxies.Proxy")
	public static Proxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {

		cropMaloberryL = new CropLoader(new MaloberryCrop(4,null));
		cropBlueberryL = new CropLoader(new BlueberryCrop(3,null));
		cropBlackberryL = new CropLoader(new BlackberryCrop(2,null));
		cropRaspberryL = new CropLoader(new RaspberryCrop(1,null));
		config c = new config(preinit, "berriespp.cfg");
		cropMaloberryL.load(c.tConfig, "MaloberryCrop");
		cropBlueberryL.load(c.tConfig, "BlueberryCrop");
		cropBlackberryL.load(c.tConfig, "BlackberryCrop");
		cropRaspberryL.load(c.tConfig, "RaspberryCrop");
		//NameOfCropL.load(c.tConfig, "NameOfCrop");
		c.tConfig.save();
	}

	@EventHandler
	public void load(FMLPreInitializationEvent load) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		cropMaloberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 3));
		cropMaloberryL.register();
		cropBlackberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 2));
		cropBlackberryL.register();
		cropBlueberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 1));
		cropBlueberryL.register();
		cropRaspberryL.registerBaseSeed(new ItemStack(NContent.berryItem, 1, 0));
		cropRaspberryL.register();
		// NameOfCropL.registerBaseSeed(new ItemStack(PlaceOfItem, AmmountOfItem, DMG));
		// NameOfCropL.register();
	}

}
