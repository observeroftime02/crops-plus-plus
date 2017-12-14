package mods.natura.common;

import mods.natura.blocks.crops.Glowshroom;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//Selfmade API possible due to License! TY!

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NContent{

	public static final Item berryItem = new Item();
	public static final Item netherBerryItem = new Item();
	public static final Block thornVines = Block.getBlockById(106);
	public static final Glowshroom glowshroom = new Glowshroom();
	public static Item spawnEgg;

    //Crops
    public static Item wheatBag;
    public static Item barleyBag;
    public static Item potatoBag;
    public static Item carrotBag;
    public static Item netherWartBag;
    public static Item cottonBag;
    public static Item boneBag;

    public static Item seeds;
    public static Item plantItem;
    public static Item berryMedley;
    public static Item seedFood;

    public static Item waterDrop;



    //Others
    public static Block cloud;

    //Trees    
    public static Block tree;
    public static Block redwood;
    public static Block planks;
    public static Block bloodwood;
    public static Block willow;



    public static Block saguaro;

    public static Block redwoodDoor;
    public static Block eucalyptusDoor;
    public static Block hopseedDoor;
    public static Block sakuraDoor;
    public static Block ghostDoor;
    public static Block bloodDoor;
    public static Block redwoodBarkDoor;

    public static Item doorItem;
    //public static Item floraBoat;

    //Nether
    public static Block taintedSoil;
    public static Block heatSand;
    //public static Block infernalStone;
    public static Block darkTree;


    public static Block glowshroomBlue;
    public static Block glowshroomGreen;
    public static Block glowshroomPurple;

    public static Block brail;
    public static Block brailPowered;
    public static Block brailDetector;
    public static Block brailActivator;

    public static Block netherrackFurnace;
    public static Block respawnObelisk;
 
    public static Block netherPressurePlate;
    public static Block netherButton;
    public static Block netherLever;
    
    public static Item potashApple;
    public static Item impMeat;

    //Tools
    public static Item ghostwoodSword;
    public static Item ghostwoodPickaxe;
    public static Item ghostwoodShovel;
    public static Item ghostwoodAxe;
    public static Item bloodwoodSword;
    public static Item bloodwoodPickaxe;
    public static Item bloodwoodShovel;
    public static Item bloodwoodAxe;
    public static Item darkwoodSword;
    public static Item darkwoodPickaxe;
    public static Item darkwoodShovel;
    public static Item darkwoodAxe;
    public static Item fusewoodSword;
    public static Item fusewoodPickaxe;
    public static Item fusewoodShovel;
    public static Item fusewoodAxe;
    public static Item netherquartzSword;
    public static Item netherquartzPickaxe;
    public static Item netherquartzShovel;
    public static Item netherquartzAxe;

    public static Item ghostwoodKama;
    public static Item bloodwoodKama;
    public static Item darkwoodKama;
    public static Item fusewoodKama;
    public static Item netherquartzKama;

    public static Item ghostwoodBow;
    public static Item bloodwoodBow;
    public static Item darkwoodBow;
    public static Item fusewoodBow;

    public static Item impHelmet;
    public static Item impJerkin;
    public static Item impLeggings;
    public static Item impBoots;

    public static Item flintAndBlaze;

    public static ItemStack impHelmetStack;
    public static ItemStack impJerkinStack;
    public static ItemStack impLeggingsStack;
    public static ItemStack impBootsStack;


    public static Item stickItem;
    public static Item bowlEmpty;
    public static Item bowlStew;

    //Vanilla overrides and alternates
    public static final String woodTextureNames[] = { "eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood", "hopseed", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood",
            "fusewood" };
    public static Block alternateWorkbench;
    public static Block alternateBookshelf;
    public static Block alternateFence;

    //Golem type things
    public static Block grassBlock;
    public static Block grassSlab;

    public static Block plankSlab1;
    public static Block plankSlab2;

    public static Block stairEucalyptus;
    public static Block stairSakura;
    public static Block stairGhostwood;
    public static Block stairRedwood;
    public static Block stairBloodwood;
    public static Block stairHopseed;
    public static Block stairMaple;
    public static Block stairSilverbell;
    public static Block stairAmaranth;
    public static Block stairTiger;
    public static Block stairWillow;
    public static Block stairDarkwood;
    public static Block stairFusewood;

    public static Block pressurePlateEucalyptus;
    public static Block pressurePlateSakura;
    public static Block pressurePlateGhostwood;
    public static Block pressurePlateRedwood;
    public static Block pressurePlateBloodwood;
    public static Block pressurePlateHopseed;
    public static Block pressurePlateMaple;
    public static Block pressurePlateAmaranth;
    public static Block pressurePlateSilverbell;
    public static Block pressurePlateTiger;
    public static Block pressurePlateWillow;
    public static Block pressurePlateDarkwood;
    public static Block pressurePlateFusewood;

    public static Block trapdoorEucalyptus;
    public static Block trapdoorSakura;
    public static Block trapdoorGhostwood;
    public static Block trapdoorRedwood;
    public static Block trapdoorBloodwood;
    public static Block trapdoorHopseed;
    public static Block trapdoorMaple;
    public static Block trapdoorAmaranth;
    public static Block trapdoorSilverbell;
    public static Block trapdoorTiger;
    public static Block trapdoorWillow;
    public static Block trapdoorDarkwood;
    public static Block trapdoorFusewood;

    public static Block buttonEucalyptus;
    public static Block buttonSakura;
    public static Block buttonGhostwood;
    public static Block buttonRedwood;
    public static Block buttonBloodwood;
    public static Block buttonHopseed;
    public static Block buttonMaple;
    public static Block buttonAmaranth;
    public static Block buttonSilverbell;
    public static Block buttonTiger;
    public static Block buttonWillow;
    public static Block buttonDarkwood;
    public static Block buttonFusewood;

    public static Block fenceGateEucalyptus;
    public static Block fenceGateSakura;
    public static Block fenceGateGhostwood;
    public static Block fenceGateRedwood;
    public static Block fenceGateBloodwood;
    public static Block fenceGateHopseed;
    public static Block fenceGateMaple;
    public static Block fenceGateAmaranth;
    public static Block fenceGateSilverbell;
    public static Block fenceGateTiger;
    public static Block fenceGateWillow;
    public static Block fenceGateDarkwood;
    public static Block fenceGateFusewood;
	}