package com.github.bartimaeusnek.cropspp;

import java.util.ArrayList;
import java.util.List;

import com.github.bartimaeusnek.cropspp.crops.natura.CottonCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.SaguaroCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.BasicNetherShroomCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.BlightberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.DuskberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.SkyberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.StingberryCrop;
import com.github.bartimaeusnek.cropspp.crops.natura.nether.Thornvines;

import lokko12.croploadcore.ModsLoaded;
import net.minecraft.item.ItemStack;

public class NaturaLoader {
	
	

	public static List<CropLoader> NaturaLoaderList() {

		List<CropLoader> p = new ArrayList<CropLoader>();
		
		p.add(new CropLoader(new BlightberryCrop(),new ItemStack(mods.natura.common.NContent.netherBerryItem, 1, 0)));
		p.add(new CropLoader(new DuskberryCrop(),new ItemStack(mods.natura.common.NContent.netherBerryItem, 1, 1)));
		p.add(new CropLoader(new SkyberryCrop(),new ItemStack(mods.natura.common.NContent.netherBerryItem, 1, 2)));
		p.add(new CropLoader(new StingberryCrop(),new ItemStack(mods.natura.common.NContent.netherBerryItem, 1, 3)));
		p.add(new CropLoader(new Thornvines(), new ItemStack(mods.natura.common.NContent.thornVines,1,0))); 
		p.add(new CropLoader(new BasicNetherShroomCrop("Blue"), new ItemStack(mods.natura.common.NContent.glowshroom,1,2)));
		p.add(new CropLoader(new BasicNetherShroomCrop("Green"), new ItemStack(mods.natura.common.NContent.glowshroom,1,0)));
		p.add(new CropLoader(new BasicNetherShroomCrop("Purple"), new ItemStack(mods.natura.common.NContent.glowshroom,1,1)));
		p.add(new CropLoader(new SaguaroCrop(),new ItemStack(mods.natura.common.NContent.seedFood,1,0)));
		
		if (ModsLoaded.BoP)
		p.add(new CropLoader(new BasicNetherShroomCrop("Yellow"), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms,1,3)));
		
		return p;
	}

}
