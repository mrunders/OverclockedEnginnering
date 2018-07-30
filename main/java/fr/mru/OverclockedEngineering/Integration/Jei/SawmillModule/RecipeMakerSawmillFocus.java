package fr.mru.OverclockedEngineering.Integration.Jei.SawmillModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesSawmill;
import net.minecraft.item.ItemStack;

public class RecipeMakerSawmillFocus {
	
	public static List<RecipeWrapperSawmillFocus> getRecipes(){
		
		List<RecipeWrapperSawmillFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesSawmill.getRecipesMap() ) {
			
			ItemStack output = RecipesSawmill.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperSawmillFocus(inputs, output));
		}
		
		return list;
	}

}
