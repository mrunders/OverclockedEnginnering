package fr.mru.OverclockedEngineering.Integration.Jei.GearModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule.RecipeWrapperCompresionFocus;
import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipesGear;
import net.minecraft.item.ItemStack;

public class RecipeMakerGearFocus {
	
	public static List<RecipeWrapperGearFocus> getRecipes(){
		
		List<RecipeWrapperGearFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesGear.getRecipesMap() ) {
			
			ItemStack output = RecipesGear.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperGearFocus(inputs, output));
		}
		
		return list;
	}

}
