package lokko12.berriespp.items;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class NutrientSolution extends Fluid {

	public NutrientSolution(String NutrientSolution) {
		super(NutrientSolution);
		FluidRegistry.registerFluid(this);
		this.viscosity = 1125;
		this.isGaseous = false;
		this.density = this.viscosity;
	}
	
	@Override
	public int getColor() {
		return 0x75963d;
	}
	
}
