package fr.mru.OverclockedEngineering.Integration.Jei.GrinderModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import net.minecraft.item.ItemStack;

public class RecipeMakerGrinderFocus {
	
	public static List<RecipeWrapperGrinderFocus> getRecipes(){
		
		List<RecipeWrapperGrinderFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> a : RecipesGrinder.getRecipesList().keySet() ) {
			
			List<ItemStack> inputs = new ArrayList<>();
			
			inputs.add(a.get(0));
			ItemStack output = RecipesGrinder.getResultForInput(inputs.get(0)).getResult();
			
			list.add(new RecipeWrapperGrinderFocus(inputs, output));
		}
		
		return list;
	}

}
