//package com.github.bartimaeusnek.cropspp.crops.BoP;
//
//import com.github.bartimaeusnek.croploadcore.OreDict;
//import com.github.bartimaeusnek.cropspp.abstracts.BasicFoodCrop;
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//import ic2.api.crops.ICropTile;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.IIcon;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TurnipCrop extends BasicFoodCrop {
//    public TurnipCrop() {
//        super();
//        OreDict.BSget("crop" + this.name(), this);
//        OreDict.BSget("seed" + this.name(), this);
//    }
//
//    @Override
//    public String name() {
//        return "Turnip";
//    }
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        return OreDict.ISget("crop" + this.name());
//    }
//
//    @Override
//    public String[] attributes() {
//        return new String[]{"Food", "Purple", "Carrots"};
//    }
//
//    @SideOnly(Side.CLIENT)
//    public List<ResourceLocation> getTexturesLocation() {
//
//        List<ResourceLocation> ret = new ArrayList<>(this.getMaxSize());
//
//        for (int size = 1; size <= this.getMaxSize() - 1; size++) {
//            ret.add(new ResourceLocation("blocks/carrots_stage_" + size));
//        }
//        ret.add(new ResourceLocation("bpp", "blocks/crop/blockCrop.Turnip.3"));
//
//        return ret;
//    }
//
//    @Override
//    public ItemStack getDisplayItem() {
//        return OreDict.ISget("crop" + this.name());
//    }
//}
