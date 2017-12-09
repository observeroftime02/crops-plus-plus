package lokko12.berriespp.crops.TC;

import java.util.List;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;

public abstract class BasicTinkerBerryCrop extends ic2.api.crops.CropCard {
	
	//private ChunkCoordinates c;
	//private ChunkCoordinates e;


	public BasicTinkerBerryCrop ()
	{}

    
    @Override
    public int tier() {
        return 6;
    }

    @Override
    public int stat(int n) {
        switch(n) {
        case 0: return 3;   // Industrial Crop
        case 1: return 0;   // NOT Edible
        case 2: return 4;   // strong defensive properties
        case 3: return 1;   // a bit colorful
        case 4: return 0;   // not particularly weed-like
        default: return 0;
        }
    }

    @Override
    public boolean canGrow(ICropTile crop) {
    	if (crop.getSize() < 1)
			{
				return true;
			}
    		else if (crop.getSize() < 3)
    			{
    			if (crop.getLightLevel() <= 3) 
    				{
    					return true;
    				}
    			else
    				{
						return false;
    				}
    			}
    	else 
    		{
    			return false;
    		}
    	}
    	

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return 3;
    }

    
    @Override
    public boolean canBeHarvested(ICropTile crop) {
        return crop.getSize() == 3;
    }

    @Override
    public int weightInfluences(ICropTile crop, float humidity, float nutrients, float air) {
        // Requires no humidity but nutrients.
        return (int)((double)humidity*0.5 + (double)nutrients*1.5 + (double)air*1);
    }

    @Override
    public int growthDuration(ICropTile crop) {
        // Same growth stages as melons and pumpkins
        if (crop.getSize() == 2) {
            // Ripens "quickly"
            return 3000;
        } else {
            // Takes a while to grow from seed
            return 500;
        }
    }
    
    @Override
    public String discoveredBy() {
        return "bartimaeusnek";
    }
    
	@Override
	public int maxSize() {
		return 3;
	}
	
	
	/*public void tick(ICropTile crop) 
	{
		//try to make them spiky
		
		e.posX = entity.chunkCoordX;
		e.posY = entity.chunkCoordY;
		e.posZ = entity.chunkCoordZ;
		c = crop.getLocation();
		if (e == c || e.posX++ == c.posX || e.posZ++ == c.posZ || e.posY++ == c.posY) 
		 if (!(entity instanceof EntityItem))
	            entity.attackEntityFrom(DamageSource.cactus, 2);
	}*/
}
