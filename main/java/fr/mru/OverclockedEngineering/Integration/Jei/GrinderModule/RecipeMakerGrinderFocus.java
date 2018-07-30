package fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import net.minecraft.item.ItemStack;

public class RecipeMakerGrinderFocus {
	
	public static List<RecipeWrapperGrinderFocus> getRecipes(){
		
		List<RecipeWrapperGrinderFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesGrinder.getRecipesList()) {
			
			ItemStack output = RecipesGrinder.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperGrinderFocus(inputs, output));
		}
		
		return list;
	}

}
