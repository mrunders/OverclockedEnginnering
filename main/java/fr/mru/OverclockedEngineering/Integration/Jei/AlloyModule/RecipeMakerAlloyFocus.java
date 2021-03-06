package fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import net.minecraft.item.ItemStack;

public class RecipeMakerAlloyFocus {
	
	public static List<RecipeWrapperAlloyFocus> getRecipes(){
		
		List<RecipeWrapperAlloyFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesAlloy.getRecipesList() ) {
			
			ItemStack output = RecipesAlloy.getRecipeResult(inputs.toArray(new ItemStack[] {})).getResult();
			list.add(new RecipeWrapperAlloyFocus(inputs, output));
		}
		
		return list;
	}

}
