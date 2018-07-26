package fr.mru.OverclockedEngineering.Integration.Jei.AgingGun;

import java.util.ArrayList;
import java.util.List;

import fr.mru.OverclockedEngineering.Recipes.RecipesTreeFarm;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunDecremantal;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunIncremental;
import fr.mru.OverclockedEngineeringItems.AgingGun.AgingGunManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class RecipeMakerAgingGun {
	
	public static List<RecipeWrapperAgingGun> getRecipes(){
		
		List<RecipeWrapperAgingGun> list = new ArrayList<>();
		
		for ( Block a : AgingGunIncremental.getRecipesList() ) {
			
			List<ItemStack> inputs = new ArrayList<>();
			
			inputs.add(new ItemStack(a));
			
			ItemStack output = new ItemStack(AgingGunIncremental.getResult(a));
			
			list.add(new RecipeWrapperAgingGun(inputs, output));
		}
		
		return list;
	}

}
