package com.github.bartimaeusnek.cropspp.croploader;

import com.github.bartimaeusnek.cropspp.crops.BoP.*;

import java.util.ArrayList;
import java.util.List;

public class BoPLoader {

    public static List<CropLoader> BoPLoaderList() {

        List<CropLoader> p = new ArrayList<CropLoader>();
        p.add(new CropLoader(new BoPBerryCrop(),"cropBerry"));
        p.add(new CropLoader(new FloweringVinesCrop(), "cropFloweringVines"));
//        p.add(new CropLoader(new IvyCrop(),"cropIvy"));
        p.add(new CropLoader(new EyebulbCrop(), "cropEyebulb"));
//        p.add(new CropLoader(new GlowingCoralCrop(), "cropGlowingCoral"));
//        p.add(new CropLoader(new GlowflowerCrop(), "cropGlowflower"));
//        p.add(new CropLoader(new TurnipCrop()));
        p.add(new CropLoader(new WildCarrotsCrop()));
        p.add(new CropLoader(new GlintWeedCrop(),"flowerBurningBlossom"));
        return p;
    }
}
