package com.github.bartimaeusnek.cropspp;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.cropspp.BoP.BoPBerryCrop;
import com.github.bartimaeusnek.cropspp.BoP.EyebulbCrop;
import com.github.bartimaeusnek.cropspp.BoP.FloweringVinesCrop;
import com.github.bartimaeusnek.cropspp.BoP.GlowflowerCrop;
import com.github.bartimaeusnek.cropspp.BoP.GlowingCoralCrop;
import com.github.bartimaeusnek.cropspp.BoP.IvyCrop;
import com.github.bartimaeusnek.cropspp.BoP.TurnipCrop;
import com.github.bartimaeusnek.cropspp.BoP.WildCarrotsCrop;

import net.minecraft.item.ItemStack;

public class BoPLoader {

	public static List<CropLoader> BoPLoaderList() {

		List<CropLoader> p = new ArrayList<CropLoader>();
		p.add(new CropLoader(new BoPBerryCrop(),new ItemStack(biomesoplenty.api.content.BOPCItems.food,1,0)));
		p.add(new CropLoader(new FloweringVinesCrop(),new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowerVine,1,0)));
		p.add(new CropLoader(new IvyCrop(),new ItemStack(biomesoplenty.api.content.BOPCBlocks.ivy,1,0)));
		p.add(new CropLoader(new EyebulbCrop(),new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowers,1,13)));
		p.add(new CropLoader(new GlowingCoralCrop(),new ItemStack(biomesoplenty.api.content.BOPCBlocks.coral1,1,15)));
		p.add(new CropLoader(new GlowflowerCrop(), new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowers,1,3)));
		p.add(new CropLoader(new TurnipCrop(),null));
		p.add(new CropLoader(new WildCarrotsCrop(),null));
		return p;
	}
}
