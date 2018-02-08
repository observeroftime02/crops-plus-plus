package lokko12.berriespp.fluids;

import gregtech.GT_Mod;
import gregtech.api.enums.ItemList;
import lokko12.berriespp.Berriespp;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class BppFluids implements Runnable{
	
	public final static AlkoholImpure FWheat = new lokko12.berriespp.fluids.AlkoholImpure("potion.FWheat",40,"potion.alcopops");
	public final static AlkoholImpure Korn = new lokko12.berriespp.fluids.AlkoholImpure("potion.Korn",320,"potion.vodka");
	public final static AlkoholImpure DKorn = new lokko12.berriespp.fluids.AlkoholImpure("potion.DKorn",380,"potion.vodka");
	public final static AlkoholImpure FReed = new lokko12.berriespp.fluids.AlkoholImpure("potion.FReed",50,"potion.alcopops");
	public final static AlkoholImpure SWhine = new lokko12.berriespp.fluids.AlkoholImpure("potion.SWhine",700,"potion.reedwater");
	public final static AlkoholImpure Mash =  new lokko12.berriespp.fluids.AlkoholImpure("potion.Mash",25,"potion.reedwater");
	public final static AlkoholImpure Wash =  new lokko12.berriespp.fluids.AlkoholImpure("potion.Wash",50,"potion.alcopops");
	public final static AlkoholImpure GHP = new lokko12.berriespp.fluids.AlkoholImpure("potion.GHP",700,"potion.vodka");
	public final static AlkoholImpure jagi = new lokko12.berriespp.fluids.AlkoholImpure("potion.jagi",100000,"potion.alcopops");
	public final static AlkoholImpure njagi = new lokko12.berriespp.fluids.AlkoholImpure("potion.njagi",350,"potion.alcopops");
	//public final static AlkoholImpure NutrientSolution = new lokko12.berriespp.fluids.AlkoholImpure("Nutrient Solution",250,"for.honey");
	
	public BppFluids() {
		super();
	}

	@Override
	public void run() {
	}

}
