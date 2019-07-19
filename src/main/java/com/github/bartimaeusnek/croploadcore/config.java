package com.github.bartimaeusnek.croploadcore;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class config {
    public Configuration tConfig;

    public config(FMLPreInitializationEvent preinit, String cfgname) {
        File tFile = new File(preinit.getModConfigurationDirectory(), cfgname);
        tConfig = new Configuration(tFile);
        tConfig.load();
    }

    public void save() {
        tConfig.save();
    }

}