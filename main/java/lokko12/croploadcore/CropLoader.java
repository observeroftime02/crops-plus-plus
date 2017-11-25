package lokko12.croploadcore;

import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import lokko12.berriespp.crops.BasicBerryCrop;
import net.minecraftforge.common.config.Configuration;

public class CropLoader {
	public boolean bHasCropObj;
	private CropCard cropObj;
	
	public CropLoader() {
		
	}
	
	public CropLoader(CropCard cropObj) {
		this.cropObj = cropObj;
	}

	public void load(Configuration fConfig, String key){
		bHasCropObj = fConfig.get("crops", key, true).getBoolean(false);
	}	
	
	
	public void register () {
		if (bHasCropObj) {
        	Crops.instance.registerCrop(cropObj);
        }
	}
}
