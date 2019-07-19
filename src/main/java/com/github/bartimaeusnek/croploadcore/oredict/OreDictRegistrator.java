package com.github.bartimaeusnek.croploadcore.oredict;


import net.minecraftforge.fml.common.Loader;

public interface OreDictRegistrator extends Runnable {

    String getModWhichRegisters();

    default void register() {
        if (Loader.isModLoaded(getModWhichRegisters()))
            run();
    }

}
