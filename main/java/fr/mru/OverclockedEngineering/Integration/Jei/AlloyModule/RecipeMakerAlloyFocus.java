package fr.mru.OverclockedEngineering.Integration.Jei.AlloyModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesAlloy;
import net.minecraft.item.ItemStack;

public class RecipeMakerAlloyFocus {
	
	public static List<RecipeWrapperAlloyFocus> getRecipes(){
		
		List<RecipeWrapperAlloyFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> a : RecipesAlloy.getRecipesList().keySet() ) {
			
			List<ItemStack> inputs = new ArrayList<>();
			
			inputs.add(a.get(0));
			inputs.add(a.get(1));
			ItemStack output = RecipesAlloy.getResultForInputs(inputs.get(0), inputs.get(1)).getResult();
			
			list.add(new RecipeWrapperAlloyFocus(inputs, output));
		}
		
		return list;
	}

}
