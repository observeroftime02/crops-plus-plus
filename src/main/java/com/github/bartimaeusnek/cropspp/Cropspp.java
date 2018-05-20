package com.github.bartimaeusnek.cropspp;

import org.apache.logging.log4j.LogManager;

import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.GTHandler.GTHandler;
import com.github.bartimaeusnek.cropspp.fluids.CppFluids;
import com.github.bartimaeusnek.cropspp.items.CppItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
	modid = Cropspp.modID, name = Cropspp.name, version = Cropspp.version,
	dependencies = "required-after:IC2; "
			+ "required-after:croploadcore@0.0.8; "
			+ "after:GalacticraftCore; "
			+ "after:Mantle; "
			+ "after:Natura; "
			+ "after:TConstruct; "
			+ "after:BiomesOPlenty; "
			+ "after:Thaumcraft; "
			+ "after:ExtraTrees; "
			+ "after:witchery; "
			+ "after:gregtech; "
			+ "after:TwilightForest; "
	)

public final class Cropspp {
	public static final String name = "Crops++";
	public static final String version = "@version@";
	public static final String modID = "berriespp";
	public static final org.apache.logging.log4j.Logger cpplogger = LogManager.getLogger(name);

	@Instance(value = "Crops++")
	public static Cropspp instance;


	@EventHandler
	public void preInit(FMLPreInitializationEvent preinit) {
		// (=<`:9876Z4321UT.-Q+*)M'&%$H\"!~}|Bzy?=|{z]KwZY44Eq0/{mlk**hKs_dG5[m_BA{?-Y;;Vb'rR5431M}/.zHGwEDCBA@98\\6543W10/.R,+O<
		//if(InstalledTreesGetter.check_bonsai(preinit))
		//	InstalledTreesGetter.InstalledTreesGet();
		CropLoader.cropLoader();
		CropLoader.load(preinit);
	}

	@EventHandler
	public void init(FMLInitializationEvent init) {
		if (ModsLoaded.GT) {
			final CppFluids CppFluids=new CppFluids();
			}
		CppItems.register_Items();
		CppItems.OreDictItems();
		CppItems.register_recipes();
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postinit) {
		CropLoader.register();
		CropLoader.registerBaseSeed();
		if (ModsLoaded.GT) {
			final GTHandler GTHandler = new GTHandler();
			GTHandler.run();
			}
		
		}
}
