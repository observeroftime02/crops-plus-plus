package lokko12.berriespp.crops.bpp;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import lokko12.berriespp.crops.abstracts.BasicDecorationCrop;
import lokko12.berriespp.items.BppItems;
import lokko12.croploadcore.MyRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

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
		if (ConfigValures.Debug)
			return 1;
	    else
	    	return 225;
	    }
	
	@Override
	public boolean rightclick(ICropTile crop, EntityPlayer player) {
		if (player instanceof EntityPlayer) {
			if (crop.getSize()!=this.maxSize())
			player.playSound("mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
			else if (crop.getSize()==this.maxSize())
            player.playSound("mob.ghast.scream", 5, (float) 0.5);
    	}
		return crop.harvest(true);
	}
	 
	@Override
	public boolean leftclick(ICropTile crop, EntityPlayer player) {
		if (player instanceof EntityPlayer) {
			if (crop.getSize()!=this.maxSize())
			player.playSound("mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
			else if (crop.getSize()==this.maxSize())
            player.playSound("mob.ghast.scream", 5, (float) 0.5);
    	}
		return crop.pick(true);
	}
	 
	@Override
	public boolean onEntityCollision(ICropTile crop, Entity entity) {
    	if (entity instanceof EntityLivingBase) {
			return ((EntityLivingBase) entity).isSprinting();
		}
    	
    	if (entity instanceof EntityPlayer) {
    		if (crop.getSize()!=this.maxSize())
    		entity.playSound("mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
    		else if (crop.getSize()==this.maxSize())
            entity.playSound("mob.ghast.scream", 5, (float) 0.5);
    	}
		return false;
	}
	
	@Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(BppItems.Goldfisch);
	}
	
	@Override
    public void tick(ICropTile crop) {
	    int r =	MyRandom.intrandom(512, 0);
	    switch (r) {
	    case 42:
	    {
	    	if (crop.getSize()!=this.maxSize())
	    	crop.getWorld().playSoundEffect(crop.getLocation().posX, crop.getLocation().posY, crop.getLocation().posZ, "mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
	    	else if (crop.getSize()==this.maxSize())
	    	crop.getWorld().playSoundEffect(crop.getLocation().posX, crop.getLocation().posY, crop.getLocation().posZ, "mob.ghast.scream", crop.getSize(), (maxSize()+1)+(-1)*crop.getSize());
	    }
	    }
	    
    }

}
