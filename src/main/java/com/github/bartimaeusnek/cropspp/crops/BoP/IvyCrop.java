//package com.github.bartimaeusnek.cropspp.crops.BoP;
//
//import biomesoplenty.api.content.BOPCBlocks;
//import com.github.bartimaeusnek.croploadcore.OreDict;
//import com.github.bartimaeusnek.cropspp.crops.cpp.VineCrop;
//import ic2.api.crops.ICropTile;
//import net.minecraft.item.ItemStack;
//
//public class IvyCrop extends VineCrop {
//    public IvyCrop() {
//        super();
//    }
//
//    @Override
//    public int tier() {
//        return 2;
//    }
//
//    @Override
//    public boolean canGrow(ICropTile crop) {
//        return crop.getCurrentSize() < 3;
//    }
//
//    @Override
//    public int maxSize() {
//        return 3;
//    }
//
//    @Override
//    public String name() {
//        return "Ivy";
//    }
//
//    @Override
//    public String discoveredBy() {
//        return "bartimaeusnek";
//    }
//
//    @Override
//    public String[] attributes() {
//        return new String[]{"Green", "Tendrilly", "Flower", "Bad", "Poison"};
//    }
//
//    @Override
//    public boolean canBeHarvested(ICropTile crop) {
//        return crop.getCurrentSize() == 3;
//    }
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        return getDisplayItem().copy().splitStack(2);
//    }
//
//    @Override
//    public ItemStack getDisplayItem() {
//        return OreDict.ISget("crop" + name());
//    }
//
//}
