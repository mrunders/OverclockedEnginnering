package fr.mru.OverclockedEngineering.Integration.Jei.PCBModule;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Integration.Jei.CompresionModule.RecipeWrapperCompresionFocus;
import fr.mru.OverclockedEngineering.Recipes.RecipeCompresion;
import fr.mru.OverclockedEngineering.Recipes.RecipesGear;
import fr.mru.OverclockedEngineering.Recipes.RecipesPCB;
import net.minecraft.item.ItemStack;

public class RecipeMakerPCBFocus {
	
	public static List<RecipeWrapperPCBFocus> getRecipes(){
		
		List<RecipeWrapperPCBFocus> list = new ArrayList<>();
		
		for ( List<ItemStack> inputs : RecipesPCB.getRecipesMap() ) {
			
			ItemStack output = RecipesPCB.getRecipeResult(inputs.get(0)).getResult();
			list.add(new RecipeWrapperPCBFocus(inputs, output));
		}
		
		return list;
	}

}
