package lokko12.berriespp.crops.natura.nether;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.bpp.VineCrop;
import mods.natura.common.NContent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class Thornvines extends VineCrop {

	public Thornvines() {
		super();
	}
	
    @Override
    public int tier() {
        return 3;
    }
    @Override
    public String name() {
        return "Thornvines";
    }

    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
	
    @Override
    public ItemStack getGain(ICropTile crop) {
        return new ItemStack(NContent.thornVines,2);
    }

    @Override
    public String[] attributes() {
        return new String[] {"Nether", "Climbable", "Bad"};
    }
    
    @Override
	public boolean onEntityCollision(ICropTile crop, Entity entity) {
    	if (!(entity instanceof EntityItem))
            entity.attackEntityFrom(DamageSource.cactus, 1);
    	if (entity instanceof EntityLivingBase) {
			return ((EntityLivingBase) entity).isSprinting();
		}
		return false;
	}
	@Override
	public ItemStack getDisplayItem() {
	    return new ItemStack(NContent.thornVines,2);
	}
}
