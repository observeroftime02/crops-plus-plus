package com.github.bartimaeusnek.cropspp.crops.cpp;

import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;
import com.github.bartimaeusnek.cropspp.items.CppItems;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class SugarBeetCrop extends BasicFoodCrop {

    public SugarBeetCrop() {
        super();
    }

    @Override
    public int tier() {
        return 4;
    }

    @Override
    public ItemStack getDisplayItem() {
        return new ItemStack(CppItems.CppBerries, 1, 1);
    }

    @Override
    public String name() {
        return "Sugar Beet";
    }

    @Override
    public String[] attributes() {
        return new String[]{"Food", "White", "Ingredient"};
    }


    @SideOnly(Side.CLIENT)
    public List<ResourceLocation> getTexturesLocation() {

        List<ResourceLocation> ret = new ArrayList<>(this.getMaxSize());

        for (int size = 1; size <= this.getMaxSize() - 1; size++) {
            ret.add(new ResourceLocation("blocks/carrots_stage_" + size));
        }
        ret.add(new ResourceLocation("bpp", "blocks/crop/blockCrop.Wild Carrots.3"));

        return ret;
    }

    @Override
    public ItemStack getGain(ICropTile var1) {
        return new ItemStack(CppItems.CppBerries, 1, 1);
    }

}
