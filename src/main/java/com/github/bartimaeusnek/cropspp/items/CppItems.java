package com.github.bartimaeusnek.cropspp.items;

import com.github.bartimaeusnek.croploadcore.CraftingRecipeHandler;
import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.Loaders.ItemLoader;
import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class CppItems {
//    public final static Item BerryItems = new NaturaBerryItems(1).setTranslationKey("berry");
    public final static Item itemSpade = new ItemBppSpade();
    public final static Item itemLens = new ItemBppLens();
    public final static ItemStack itemSpadeStack = new ItemStack(itemSpade);
    public final static Item Goldfisch = new Goldfish();
    public final static ItemStack GoldfischS = new ItemStack(Goldfisch);
//    public final static Item Modifier = new Modifier();
//    public final static ItemStack ModifierSpace = new ItemStack(Modifier, 1, 0);
//    public final static ItemStack ModifierMagic = new ItemStack(Modifier, 1, 1);
//    //public final static ItemStack ModifierAnti = new ItemStack(Modifier, 1, 3);
//    public final static ItemStack Trophy = new ItemStack(Modifier, 1, 2);
    //public final static ItemStack Gr = new ItemStack(Modifier, 1, 4);
    //public final static ItemStack Ga = new ItemStack(Modifier, 1, 5);
    //public final static ItemStack Re = new ItemStack(Modifier, 1, 6);
    public final static Item CppBerries = new CppBerries();
//    public final static Item CppPotions = new CppPotions();

    public final static void register_Items() {
        if (ConfigValues.Items) {
            ItemLoader.registerItem(itemLens, "itemLens");
            ItemLoader.registerItem(itemSpade, "itemSpade");
            ItemLoader.registerItem(Goldfisch, "foodGoldfish");
//            ItemLoader.registerItem(Modifier, "Modifier");
//            if (ModsLoaded.GT)
//                ItemLoader.registerItem(CppPotions, "BppPotions");
            ItemLoader.registerItem(CppBerries, "foodBerries");

            if (ConfigValues.WiPItems) {
//                ItemLoader.registerItem(new ItemBppWateringCan(), "itemWateringCan");
                ItemLoader.registerItem(new Weedmaker(), "debugitemWeedmaker");
            }
//            if (!ModsLoaded.Natura) {
//                ItemLoader.registerItem(BerryItems, "berry");
//            }
        }
    }

    public final static void register_recipes() {
        if (ConfigValues.Items) {
            if (!ModsLoaded.GT) {
                CraftingRecipeHandler.addShapedOreRecipe(itemSpadeStack, " P ", "PWP", " S ", 'P', "plateSteel", 'W', IC2Items.getItem("weeding_trowel"), 'S', Items.STICK);
                CraftingRecipeHandler.addShapelessRecipe(new ItemStack(Items.SUGAR, 8), new ItemStack(CppBerries, 1, 1));
                CraftingRecipeHandler.addShapelessRecipe(new ItemStack(Items.DYE, 2, 5), new ItemStack(CppBerries, 1, 0));
                CraftingRecipeHandler.addShapelessRecipe(new ItemStack(Items.GOLD_NUGGET, 9), new ItemStack(Goldfisch), new ItemStack(Items.FLINT));
                CraftingRecipeHandler.addShapedRecipe(new ItemStack(itemLens)," Gs"," S "," S ",'G', Blocks.GLASS_PANE,'s',Items.STRING,'S',Items.STICK);
            }
            if (!ModsLoaded.PHC) {
                CraftingRecipeHandler.addShapelessRecipe(new ItemStack(Items.FISH), new ItemStack(Goldfisch));
                CraftingRecipeHandler.addSmelting(new ItemStack(Goldfisch), new ItemStack(Items.COOKED_FISH), 0);
            }
        }
    }

    public final static void OreDictItems() {
        if (ConfigValues.Items) {
            OreDictionary.registerOre("listAllfishraw", new ItemStack(Goldfisch));
            OreDictionary.registerOre("listAllberry", new ItemStack(CppBerries, 1, 0));
            OreDictionary.registerOre("listAllfruit", new ItemStack(CppBerries, 1, 0));
            OreDictionary.registerOre("cropHuckleberry", new ItemStack(CppBerries, 1, 0));
            OreDictionary.registerOre("listAllveggie", new ItemStack(CppBerries, 1, 1));
            OreDictionary.registerOre("listAllrootveggie", new ItemStack(CppBerries, 1, 1));
            OreDictionary.registerOre("cropSugarbeet", new ItemStack(CppBerries, 1, 1));
        }

//        if (!ModsLoaded.Natura) {
//            ItemStack[] BerryItemsS = new ItemStack[5];
//            for (int i = 0; i < 5; ++i) {
//                BerryItemsS[i] = new ItemStack(BerryItems, i);
//                OreDictionary.registerOre("listAllberry", BerryItemsS[i]);
//                OreDictionary.registerOre("listAllfruit", BerryItemsS[i]);
//            }
//            OreDictionary.registerOre("cropRaspberry", BerryItemsS[0]);
//            OreDictionary.registerOre("cropBlueberry", BerryItemsS[1]);
//            OreDictionary.registerOre("cropBlackberry", BerryItemsS[2]);
//            OreDictionary.registerOre("cropMaloberry", BerryItemsS[3]);
//            OreDictionary.registerOre("cropSaguaroBerry", BerryItemsS[4]);
//        }
    }
}
