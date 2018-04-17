package com.github.bartimaeusnek.cropspp.abstracts;

import com.github.bartimaeusnek.cropspp.ConfigValures;

import ic2.api.crops.ICropTile;

public abstract class BasicWitcheryCrop extends BasicDecorationCrop {

	public BasicWitcheryCrop() {
		super();
	}

    @Override
    public int growthDuration(ICropTile crop) {
    	if (ConfigValures.Debug == true)
    		return 1;
    	else
        return 550;
    }

    @Override
    public int tier() {
        return 4;
    }
    
}
