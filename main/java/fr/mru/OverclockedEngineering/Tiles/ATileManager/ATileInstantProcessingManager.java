package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import net.minecraft.item.ItemStack;

public abstract class ATileInstantProcessingManager extends ATileManager {

	public ATileInstantProcessingManager(int stacksLenght, String name) {
		super(stacksLenght, name);
	}

	@Override
	public int getFullRecipeTime() {
		return 0;
	}

	@Override
	public boolean isBurning() {
		return true;
	}

}
