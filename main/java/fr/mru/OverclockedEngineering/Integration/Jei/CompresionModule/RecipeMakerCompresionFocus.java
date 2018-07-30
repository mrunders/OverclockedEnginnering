package fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipesGrinder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesMapCloning;

public class RecipeMakerCompresionFocus {
	
	public static List<RecipeWrapperCompresionFocus> getRecipes(){
		
		List<RecipeWrapperCompresionFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipeCompresion.getRecipesList() ) {
			
			ItemStack output = RecipeCompresion.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperCompresionFocus(inputs, output));
		}
		
		return list;
	}

}
