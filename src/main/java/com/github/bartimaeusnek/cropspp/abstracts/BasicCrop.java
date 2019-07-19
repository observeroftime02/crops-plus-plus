package com.github.bartimaeusnek.cropspp.abstracts;
import com.github.bartimaeusnek.croploadcore.OreDict;
import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.Cropspp;
import ic2.api.crops.CropCard;
import ic2.api.crops.CropProperties;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import speiger.src.crops.api.ICropCardInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicCrop extends CropCard implements ICropCardInfo {

    @SideOnly(Side.CLIENT)
    public List<ResourceLocation> getTexturesLocation() {

        List<ResourceLocation> ret = new ArrayList<>(getMaxSize());

        for(int size = 1; size <= getMaxSize(); ++size) {
            ret.add(new ResourceLocation("bpp", "blocks/crop/blockCrop." + name() + "." + size));
        }

        return ret;
    }

    @Override
    public String getUnlocalizedName() {
        return this.getId();
    }

    @Override
    public String getId() {
        return name();
    }

    public abstract String name();

    protected abstract int tier();

    protected abstract int stat(int n);

    protected abstract String[] attributes();

    protected int weightInfluences(ICropTile crop, float humidity, float nutrients, float air){
        return (int) (humidity + nutrients + air);
    }

    @Override
    public int getWeightInfluences(ICropTile crop, int humidity, int nutrients, int air) {
        return weightInfluences(crop, humidity, nutrients, air);
    }

    @Override
    public String[] getAttributes() {
        return attributes();
    }

    @Override
    public CropProperties getProperties() {
        return new CropProperties(tier(), stat(0), stat(1), stat(2), stat(3), stat(4));
    }

    @Override
    public double dropGainChance() {
        return (double) ((Math.pow(0.95, (double) tier())) * ConfigValues.BerryGain);
    }

    @Override
    public boolean canCross(ICropTile crop) {
        return crop.getCurrentSize() == this.getMaxSize();
    }

    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getCurrentSize() == getMaxSize();
    }

    @Override
    public int getOptimalHarvestSize(ICropTile cropTile) {
        return getMaxSize();
    }

    @Override
    public int getRootsLength(ICropTile crop) {
        return 5;
    }

    protected String discoveredBy() {
        return "bartimaeusnek";
    }

    @Override
    public String getDiscoveredBy() {
        return discoveredBy();
    }

    @Override
    public String getOwner() {
        return owner();
    }

    protected String owner() {
        return Cropspp.modID;
    }

    @Override
    public int getMaxSize() {
        return maxSize();
    }

    @Override
    public int getGrowthDuration(ICropTile cropTile) {
        return growthDuration(cropTile);
    }

    public abstract int growthDuration(ICropTile crop);

    protected abstract int maxSize();

    @Override
    public List<String> getCropInformation() {
        return null;
    }

    public ItemStack getDisplayItem() {
        return OreDict.ISget("crop" + this.name());
    }

}
