package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.Operators;
import lokko12.croploadcore.OreDict;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

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
		return new ItemStack(BppItems.Goldfisch);
	}

	@Override
	public String name() {
		return "Goldfish Plant";
	}

	@Override
	public String[] attributes() {
		return new String[] {"Nether", "Fish", "Bad", "Water"};
	}
	
	 @Override
	    public int growthDuration(ICropTile crop) {
	    	if (ConfigValures.Debug == true)
	    		return 1;
	    	else
	    		return 225;
	    	}
	
	@Override
	public boolean onEntityCollision(ICropTile crop, Entity entity) {
    	if (entity instanceof EntityPlayer) {
            entity.playSound("mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
            if (crop.getSize()==this.maxSize())
            entity.playSound("mob.ghast.scream", 5, (float) 0.5);
    	}
    	if (entity instanceof EntityLivingBase) {
			return ((EntityLivingBase) entity).isSprinting();
		}
		return false;
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BppItems.Goldfisch);
	}

}
