package com.github.bartimaeusnek.cropspp.croploader;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.cropspp.cpp.KnighmetalCrop;

public class TwilightForestLoader {

	public static List<CropLoader> load() {
		List<CropLoader> p = new ArrayList<CropLoader>();
		p.add(new CropLoader(new KnighmetalCrop(),null));
		return p;
	}
}
