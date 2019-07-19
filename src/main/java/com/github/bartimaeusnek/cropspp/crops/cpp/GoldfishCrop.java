package com.github.bartimaeusnek.cropspp.crops.cpp;

import com.github.bartimaeusnek.croploadcore.MyRandom;
import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import com.github.bartimaeusnek.cropspp.items.CppItems;
import ic2.api.crops.ICropTile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.Collections;
import java.util.List;

public class GoldfishCrop extends BasicDecorationCrop {

    public GoldfishCrop() {
        super();
    }

    @Override
    public int tier() {
        return 4;
    }

    @Override
    public ItemStack getDisplayItem() {
        return new ItemStack(CppItems.Goldfisch);
    }

    @Override
    public String name() {
        return "Goldfish Plant";
    }

    @Override
    public String[] attributes() {
        return new String[]{"Nether", "Fish", "Food", "Bad", "Water"};
    }

    @Override
    public int growthDuration(ICropTile crop) {
        if (ConfigValues.debug)
            return 1;
        else
            return 225;
    }

    @Override
    public boolean onRightClick(ICropTile crop, EntityPlayer player) {
        boolean ret;
        if (((int) crop.getCurrentSize()) != this.maxSize()) {
            player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), crop.getCurrentSize(), (maxSize() + 1) + (-1) * crop.getCurrentSize());
            ret = crop.performManualHarvest();
        } else if (((int) crop.getCurrentSize()) == this.maxSize()) {
            player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), 5, (float) 0.5);
            ret = crop.performManualHarvest();
        } else
            ret = false;
        return ret;
    }

    @Override
    public boolean onLeftClick(ICropTile crop, EntityPlayer player) {
        boolean ret;
        if (((int) crop.getCurrentSize()) != this.maxSize()) {
            player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), crop.getCurrentSize(), (maxSize() + 1) + (-1) * crop.getCurrentSize());
            ret = crop.pick();
        } else if (((int) crop.getCurrentSize()) == this.maxSize()) {
            player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), 5, (float) 0.5);
            ret = crop.pick();
        } else
            ret = false;
        return ret;
    }

    @Override
    public boolean onEntityCollision(ICropTile crop, Entity entity) {

        if (entity instanceof EntityLivingBase) {
            if (entity instanceof EntityPlayer && lastScream == 100) {
                if (((int) crop.getCurrentSize()) != this.maxSize())
                    entity.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), crop.getCurrentSize(), (maxSize() + 1) + (-1) * crop.getCurrentSize());
                else if (((int) crop.getCurrentSize()) == this.maxSize())
                    entity.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), 5, (float) 0.5);
                lastScream = 0;
            }
            return ((EntityLivingBase) entity).isSprinting();
        }
        return false;
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(CppItems.Goldfisch);
    }

    @Override
    public List<String> getCropInformation() {
        return Collections.singletonList("Screams.");
    }

    private int lastScream = 100;

    @Override
    public void tick(ICropTile crop) {
        if (lastScream<100)
            ++lastScream;
        int r = MyRandom.intrandom(512, 0);
        if (r == 42){
            if (((int) crop.getCurrentSize()) != this.maxSize())
                crop.getWorldObj().getClosestPlayer(crop.getPosition().getX(),crop.getPosition().getY(),crop.getPosition().getZ(),42,false).playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), crop.getCurrentSize(), (maxSize() + 1) + (-1) * crop.getCurrentSize());
            else if (((int) crop.getCurrentSize()) == this.maxSize())
                crop.getWorldObj().getClosestPlayer(crop.getPosition().getX(),crop.getPosition().getY(),crop.getPosition().getZ(),42,false).playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.scream")), 5, (float) 0.5);
        }
    }

}
