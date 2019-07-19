package com.github.bartimaeusnek.croploadcore.oredict;

import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;

public class RegisterBoP implements OreDictRegistrator {


    @Override
    public String getModWhichRegisters() {
        return "biomesoplenty";
    }

    @Override
    public void run() {
        HashSet<Triage<String,String,Integer>> toRegister = new HashSet<>();
        toRegister.add(new Triage<>("cropEyebulb","biomesoplenty:double_plant",2));
        toRegister.add(new Triage<>("cropEyebulb","biomesoplenty:double_plant",10));
        toRegister.add(new Triage<>("cropGlowingCoral","biomesoplenty:coral",3));
        toRegister.add(new Triage<>("cropVine","biomesoplenty:willow_vine",0));
        toRegister.add(new Triage<>("cropFloweringVines","biomesoplenty:willow_vine",0));
        toRegister.add(new Triage<>("cropIvy","biomesoplenty:ivy",0));
        toRegister.add(new Triage<>("cropVine","biomesoplenty:ivy",0));
        toRegister.add(new Triage<>("cropCacti","biomesoplenty:plant_1",6));
        toRegister.add(new Triage<>("cropSmallCactus","biomesoplenty:plant_1",6));
        toRegister.add(new Triage<>("cropBerry","biomesoplenty:berries",0));
        toRegister.add(new Triage<>("listAllberry","biomesoplenty:berries",0));
        //toRegister.add(new Triage<>("cropGlowflower","",0));


        for (Triage<String,String,Integer> T : toRegister)
            OreDictionary.registerOre(T.getA(),GameRegistry.makeItemStack(T.getB(),T.getC(),1,null));

        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_1, 1, 2));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_1, 1, 7));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 1));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 2));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 5));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 7));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 9));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 10));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 11));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 12));
        OreDictionary.registerOre("cropGrass", new ItemStack(BOPBlocks.plant_0, 1, 13));


    }
}
