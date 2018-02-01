package lokko12.berriespp.GTHandler;

public class GTHandler implements Runnable {

	private GTMachineRecipeLoader MachineReps;
	private GTCraftingRecipeLoader CraftingReps;
	
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
