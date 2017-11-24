package lokko12.berriespp.crops;

import ic2.api.crops.ICropTile;
import ic2.api.item.IC2Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.crops.CropCard;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import java.util.Random;

public abstract class BasicBerryCrop extends ic2.api.crops.CropCard {
    public ItemStack seed;
    public int spriteIndex;
    public Random random;

    public BasicBerryCrop(int id, ItemStack seed, int spriteIndex) {
        /*CropCard.registerBaseSeed(seed, id, 1, 10, 10, 10);
    	deprecated, IDs aren't used anymore.
    	*/

        this.seed = seed;
        this.spriteIndex = spriteIndex;
        this.random = new Random();

        //CropCard.registerCrop(this, id);
    }

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 0;   // not chemical
        case 1: return 4;   // very edible
        case 2: return 0;   // no defensive properties
        case 3: return 4;   // quite colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    /*@Override
    public int getSpriteIndex(TECrop crop) {
        return crop.size - 1 + spriteIndex;
    }
    
    
    
    @Override
    public String getTextureFile() {
        return "/berries_crops.png";
    }
 
 	deprecated
     */
    
    @Override
    public boolean canGrow(ICropTile crop) {
        if (crop.getSize() < 2) {
            return true;
        }
        return false;
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 5;
    }

    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 5;
    }

    @Override
    public int weightInfluences(TECrop crop, float humidity, float nutrients, float air) {
        // Requires more humidity than nutrients or air, but not much more
        return (int)(humidity*1.2 + nutrients*0.9 + air*0.9);
    }

    @Override
    public int growthDuration(TECrop crop) {
        // Same growth stages as melons and pumpkins
        if (crop.size == 2) {
            // Ripens quickly
            return 200;
        } else {
            // Takes a while to grow from seed
            return 700;
        }
    }

    @Override
    public ItemStack getGain(TECrop crop) {
        // Harvest up to 10 berries when ripe; has 16 in picture but 6 remain unripe, and some spoil
        ItemStack drop = new ItemStack(seed.itemID, 5 + random.nextInt(5), seed.getItemDamage()); 

        return drop;
    }

    @Override
    public byte getSizeAfterHarvest(TECrop crop) {
        // return to partially grown state when harvested
        return 2;
    }

    @Override
    public boolean onEntityCollision(TECrop crop, Entity entity) {
        // you can walk through berries! they don't mind
        return false;
    }
}
