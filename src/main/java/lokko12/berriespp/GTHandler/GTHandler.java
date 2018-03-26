package lokko12.berriespp.GTHandler;

public class GTHandler implements Runnable {

	private static GTMachineRecipeLoader MachineReps;
	private static GTCraftingRecipeLoader CraftingReps;
	
	public GTHandler() {
		super();
		MachineReps = new GTMachineRecipeLoader();
		CraftingReps = new GTCraftingRecipeLoader();
		
	}


	@Override
	public void run() {
		MachineReps.run();
		CraftingReps.run();
		
	}

}
