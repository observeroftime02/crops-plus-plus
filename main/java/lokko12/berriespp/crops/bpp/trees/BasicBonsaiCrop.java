package lokko12.berriespp.crops.bpp.trees;

import ic2.api.crops.CropCard;
import ic2.api.crops.ICropTile;
import lokko12.berriespp.ConfigValures;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BasicBonsaiCrop extends ic2.api.crops.CropCard {
	private String name;
	private ItemStack drop;

	public BasicBonsaiCrop(String name){
		super();
		this.name = name +" Wood";
		    }
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name.replace(" Wood", "Bonsai");
	}

	@Override
	public String[] attributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tier() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int stat(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		// TODO Auto-generated method stub
		return crop.getSize() > 3;
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		// TODO Auto-generated method stub
		return crop.getSize() == 3;
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		// TODO Auto-generated method stub
		return drop;
	}
}
