package com.github.bartimaeusnek.cropspp.croploader;

import com.github.bartimaeusnek.croploadcore.ModsLoaded;
import com.github.bartimaeusnek.cropspp.crops.TF.KnighmetalCrop;
import com.github.bartimaeusnek.cropspp.crops.TF.MossCrop;

import java.util.ArrayList;
import java.util.List;

public class TwilightForestLoader {

    public static List<CropLoader> load() {
        List<CropLoader> p = new ArrayList<CropLoader>();
        p.add(new CropLoader(new KnighmetalCrop()));

        if (ModsLoaded.BoP)
            p.add(new CropLoader(new MossCrop()));

        return p;
    }
}
