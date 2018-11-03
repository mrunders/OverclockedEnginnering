package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeCompresion extends ARecipeManager {
	
	private static RecipeRequestMap map = new RecipeRequestMap();
	private static RecipeRequestMap reversedmap = new RecipeRequestMap();
	
	public static RecipeRequest getRecipeResult(ItemStack... ingredients) {
		return map.get(ingredients);
	}
	
	public static RecipeRequest getReversedRecipeResult(ItemStack... ingredients) {
		return reversedmap.get(ingredients);
		
	}

	public static boolean initialise() {
		
		List<String> blocksDir = recipesOrdict.get("block");
		List<String> nuggetsDir = recipesOrdict.get("nugget");
		for (String ingot : recipesOrdict.get("ingot")) {
			
			if ( blocksDir.contains(ingot) ) {
				map.putCopyOredict("block"+ingot, 1, "ingot"+ingot, 9);
				reversedmap.putCopyOredict("ingot"+ingot, 9, "block"+ingot, 1);
			}
			
			if ( nuggetsDir.contains(ingot) ) {
				map.putCopyOredict("ingot"+ingot, 1, "nugget"+ingot, 9);
				reversedmap.putCopyOredict("nugget"+ingot, 9, "ingot"+ingot, 1);
			}
		}
		
		map.putCopyOredict("blockDiamond", 1, "gemDiamond", 9);
		map.putCopyOredict("blockEmerald", 1, "gemEmerald", 9);
		map.putCopyOredict("blockRedstone", 1, "dustRedstone", 9);
		map.putCopyOredict("blockLapis", 1, "gemLapis", 9);
		map.putCopyOredict("blockQuartz", 1, "gemQuartz", 4);
		map.putCopyOredict("blockPrismarine", 1, "gemPrismarine", 4);
		map.putCopy(new ItemStack(Blocks.BRICK_BLOCK), 1, new ItemStack(Items.BRICK), 4);
		map.putCopy(new ItemStack(OverclokedEngineeringItems.CIRCUIT_LARGE), 1, new ItemStack(OverclokedEngineeringItems.CIRCUIT), 9);
		map.putCopy(new ItemStack(OverclokedEngineeringItems.ALIEN_ROCK_FRAGMENT), 1, new ItemStack(OverclokedEngineeringItems.ALIEN_ROCK_DUST), 4);
		
		reversedmap.putCopyOredict("gemDiamond", 9,"blockDiamond", 1);
		reversedmap.putCopyOredict("gemEmerald", 9, "blockEmerald", 1);
		reversedmap.putCopyOredict("dustRedstone", 9, "blockRedstone", 1);
		reversedmap.putCopyOredict("gemLapis", 9, "blockLapis", 1);
		reversedmap.putCopyOredict("gemQuartz", 4, "blockQuartz", 1);
		reversedmap.putCopyOredict("gemPrismarine", 4, "blockPrismarine", 1);
		reversedmap.put(new ItemStack(Items.BRICK, 4), new ItemStack(Blocks.BRICK_BLOCK, 1));
		reversedmap.put(new ItemStack(OverclokedEngineeringItems.CIRCUIT, 9), new ItemStack(OverclokedEngineeringItems.CIRCUIT_LARGE, 1));
		
		return true;
		
	}

	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}

	public static Set<List<ItemStack>> getReversedRecipesList() {
		return reversedmap.keySet();
	}

}
