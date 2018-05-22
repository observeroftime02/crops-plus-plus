package com.github.bartimaeusnek.cropspp.croploader;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.cropspp.cpp.MagicModifierCrop;
import com.github.bartimaeusnek.cropspp.cpp.SpacePlantCrop;


public class DreamCraftLoader {

	public static List<CropLoader> load() {
		List<CropLoader> p = new ArrayList<CropLoader>();
		p.add(new CropLoader(new SpacePlantCrop(),null));
		p.add(new CropLoader(new MagicModifierCrop(),null));
		return p;
	}
}
