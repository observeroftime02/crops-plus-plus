package com.github.bartimaeusnek.cropspp.croploader;

import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.croploadcore.config;
import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.Cropspp;
import com.github.bartimaeusnek.cropspp.abstracts.BasicCrop;
import com.github.bartimaeusnek.cropspp.crops.cpp.*;
import com.github.bartimaeusnek.cropspp.crops.natura.*;
import com.github.bartimaeusnek.cropspp.crops.witchery.GarlicCrop;
import com.google.gson.internal.LinkedTreeMap;

import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import net.minecraft.client.gui.ServerListEntryLanDetected;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import static com.github.bartimaeusnek.cropspp.ConfigValues.c;

import java.util.*;


public class CropLoader {
    private static List<Boolean> bHasCropObj = new ArrayList<Boolean>();
    private static LinkedHashMap<BasicCrop,List<ItemStack>> list = new LinkedHashMap<>();

    public CropLoader(BasicCrop cropObj) {
        list.put(cropObj,new ArrayList<ItemStack>());
    }

    public CropLoader(BasicCrop cropObj, ItemStack baseseed) {
        list.put(cropObj, Collections.singletonList(baseseed));
    }

    public CropLoader(BasicCrop cropObj, String baseseed) {
        list.put(cropObj, OreDictionary.getOres(baseseed));
    }

    private static CropLoader CropHelper(BasicCrop cropObj) {
        return new CropLoader(cropObj, OreDict.ISget("crop" + cropObj.name()));
    }

    public final static List<CropLoader> cropLoader() {

        List<CropLoader> p = new ArrayList<CropLoader>();

        /*
         * Add your crops with base seed here by
         * p.add(new CropLoader(new YourCropClass(),YourItem));
         */

        if (Loader.isModLoaded("TwilightForest")) {
            p.addAll(TwilightForestLoader.load());
        }
//        if (ModsLoaded.dreamcraft) {
//            p.addAll(DreamCraftLoader.load());
//        }
//        if (ModsLoaded.GT) {
//            p.addAll(GTLoader.load());
//        }
//        if (ModsLoaded.Natura)
//            p.addAll(NaturaLoader.load());
//        else {
//            p.add(new CropLoader(new SaguaroCrop()));
//        }
//        if (ModsLoaded.Natura || ModsLoaded.PHC) {
//            p.add(new CropLoader(new CottonCrop()));
//        }

        if (ModsLoaded.TConstruct) {
            p.addAll(TConstructLoader.load());
        }
        if (ModsLoaded.BoP) {
            p.addAll(BoPLoader.BoPLoaderList());
        }

//        if (ModsLoaded.TC) {
//            p.addAll(ThaumcraftLoader.load());
//        }
        if (ModsLoaded.witchery) {
            p.addAll(WitcheryLoader.load());
        }
        if (ModsLoaded.witchery || ModsLoaded.PHC) {
            p.add(new CropLoader(new GarlicCrop()));
        }
        if (ModsLoaded.BoP || ModsLoaded.PHC) {
            p.add(new CropLoader(new BarleyCrop()));
        }

        p.add(new CropLoader(new VineCrop(), new ItemStack(Item.getItemById(106), 1, 0)));
        p.add(new CropLoader(new GrassCrop(), new ItemStack(Item.getItemById(31), 1, 1)));
        p.add(new CropLoader(new CactiCrop(), new ItemStack(Item.getItemById(81), 4, 0)));
        p.add(new CropLoader(new WaterlillyCrop(), new ItemStack(Item.getItemById(111), 2)));
        p.add(new CropLoader(new PapyrusCrop()));
        p.add(new CropLoader(new GoldfishCrop()));
        p.add(new CropLoader(new SugarBeetCrop()));

        p.add(new CropLoader(new HuckleberryCrop()));
        p.add(new CropLoader(new StrawberryCrop()));
//        p.add(new CropLoader(new MaloberryCrop()));
//        p.add(new CropLoader(new BlackberryCrop()));
//        p.add(new CropLoader(new BlueberryCrop()));
//        p.add(new CropLoader(new RaspberryCrop()));

        return p;
    }

    private final static List<BasicCrop> cropObjs() {
        List<BasicCrop> p = new ArrayList<BasicCrop>();
        p.addAll(list.keySet());
        return p;
    }

    private final static List<String> setnames() {
        List<String> s = new ArrayList<String>();
        for (int i = 0; i < list.size(); ++i) {
            s.add(cropObjs().get(i).name());
        }
        return s;
    }

    public static void load(FMLPreInitializationEvent preinit) {
        cropLoader();
        c = new config(preinit, "berriespp.cfg");
        c.tConfig.addCustomCategoryComment("System", "enable or disable system config:"
                + "\nDebug will set all crops groth duration to 1 and disable all requirements.(aka. \"Cheatmode\")"
                + "\nBonsai Generation will generate crops from saplings, WiP state. (disabled bc of bugs with metadata, but sure you can try it.)"
                + "\nWiP Items are not finished items."
                + "\nItems will enable/disable all items.");
        ConfigValues.debug = c.tConfig.get("System", "Debug", false).getBoolean(true);
        ConfigValues.WiPItems = c.tConfig.get("System", "WiP Items", false).getBoolean(true);
        ConfigValues.Items = c.tConfig.get("System", "Items", true).getBoolean(false);

        c.tConfig.addCustomCategoryComment("Crops", "enable single plants here:");

        for (int i = 0; i < cropObjs().size(); ++i) {
            bHasCropObj.add(c.tConfig.get("Crops", setnames().get(i), true).getBoolean(false));
        }

        c.tConfig.addCustomCategoryComment("Gain", "Set custom gain modifiers here:"
                + "\n Tinker's Construct Berries' Gain is not modified by All Crops."
                + "\n Primordial Berry's gain is absolut"
                + "\n Primordial Berry's growth time is divided by 4, in IC2 groth points. F.e. 10 = 40GP per groth-period"
                + "\n IC2 groth points are calculated by 3 + random 0-7 + statGrowth per 256ticks");
        ConfigValues.BerryGain = (float) c.tConfig.get("Gain", "All crops", (float) 1).getDouble(1);
        ConfigValues.TConstructBerryGain = (float) c.tConfig.get("Gain", "Tinker's Construct berries", (float) 1).getDouble(1);
        ConfigValues.PrimordialBerryGain = (float) c.tConfig.get("Gain", "Primordial Berry", (float) 0.5).getDouble(0.5);
        ConfigValues.PrimordialBerryGroth = c.tConfig.get("Gain", "Primordial Berry growth time", 125000).getInt(125000);
        if (c.tConfig.hasChanged())
            c.save();
    }

    public static class EventSubscriber{

        @SubscribeEvent
        public static void register(Crops.CropRegisterEvent event) {

            for (int i = 0; i < cropObjs().size(); ++i) {
                if (bHasCropObj.get(i) && cropObjs().get(i) != null)
                    event.register(cropObjs().get(i));
            }
            if (ConfigValues.ayo_bonsai)
                Cropspp.cpplogger.info("Bonsais registered!");
            registerBaseSeed();
        }
    }

    public static void registerBaseSeed() {
        for (BasicCrop b : list.keySet()) {
            for (ItemStack is : list.get(b))
                registerBaseSeedSafe(is, b, 1, 1, 1, 1);
        }

        if (ConfigValues.ayo_bonsai)
            Cropspp.cpplogger.info("Bonsai Base Seed registered!");
    }


    public static boolean registerBaseSeedSafe(ItemStack Seed, CropCard Crop, int Growth, int Gain, int Resistance, int Scanlevel){
        if (Crop == null && Seed == null) {
            Cropspp.cpplogger.warn("Tried to register a NULL Seed onto an NULL Crop WTF ARE YOU DOING?!?");
            return false;
        }
        if (Crop == null){
            Cropspp.cpplogger.warn("Tried to register a Seed onto an NULL Crop "+Seed.getDisplayName());
            return false;
        }
        if (Seed == null) {
            Cropspp.cpplogger.warn("Tried to register a NULL Seed onto "+Crop.getUnlocalizedName());
            return false;
        }
        return Crops.instance.registerBaseSeed(Seed, Crop, 1, 1, 1, 1);
    }
}