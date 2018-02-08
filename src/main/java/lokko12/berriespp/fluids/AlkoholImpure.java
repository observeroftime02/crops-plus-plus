package lokko12.berriespp.fluids;

import static gregtech.api.enums.GT_Values.RES_PATH_BLOCK;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class AlkoholImpure extends Fluid implements Runnable{

	public long percentage;
	private String texture;
	
	public AlkoholImpure(String name,long d,String texture) {
				super(name);
				this.percentage=d;
				this.texture=texture;
				this.viscosity = 1125;
				this.isGaseous = false;
				this.temperature = 295;
				this.density = this.viscosity;
				GregTech_API.sGTBlockIconload.add(this);
				FluidRegistry.registerFluid(this);
			}
	
			@Override
			public void run() {
				 setIcons(GregTech_API.sBlockIcons.registerIcon(RES_PATH_BLOCK + "fluids/fluid." + texture));
			}
			
			public long getPercentage() {
				return percentage;
			}
			
			
	}

