package fr.mru.OverclockedEngineeringItems.Focus;

import fr.mru.OverclockedEngineering.Recipes.RecipeRequest;
import fr.mru.OverclockedEngineering.Recipes.RecipesPCB;
import net.minecraft.item.ItemStack;

public class PCBFocus extends AFocusManager {

	public PCBFocus() {
		super("pcb_focus");
	}

	@Override
	public RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return RecipesPCB.getRecipeResult(ingredients[0]);
	}

}
