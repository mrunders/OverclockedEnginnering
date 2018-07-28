package fr.mru.OverclockedEngineering.Recipes;

import java.util.List;
import java.util.Set;

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
				map.puttCopyOreDict("block"+ingot, 1, "ingot"+ingot, 9);
				reversedmap.puttCopyOreDict("ingot"+ingot, 9, "block"+ingot, 1);
			}
			
			if ( nuggetsDir.contains(ingot) ) {
				map.puttCopyOreDict("ingot"+ingot, 1, "nugget"+ingot, 9);
				reversedmap.puttCopyOreDict("nugget"+ingot, 9, "ingot"+ingot, 1);
			}
		}
		
		map.puttCopyOreDict("blockDiamond", 1, "gemDiamond", 9);
		map.puttCopyOreDict("blockEmerald", 1, "gemEmerald", 9);
		map.puttCopyOreDict("blockRedstone", 1, "dustRedstone", 9);
		map.puttCopyOreDict("blockLapis", 1, "gemLapis", 9);
		map.puttCopyOreDict("blockQuartz", 1, "gemQuartz", 4);
		map.puttCopyOreDict("blockPrismarine", 1, "gemPrismarine", 4);
		map.puttCopy(new ItemStack(Blocks.BRICK_BLOCK), 1, new ItemStack(Items.BRICK), 4);
		
		reversedmap.puttCopyOreDict("gemDiamond", 9,"blockDiamond", 1);
		reversedmap.puttCopyOreDict("gemEmerald", 9, "blockEmerald", 1);
		reversedmap.puttCopyOreDict("dustRedstone", 9, "blockRedstone", 1);
		reversedmap.puttCopyOreDict("gemLapis", 9, "blockLapis", 1);
		reversedmap.puttCopyOreDict("gemQuartz", 4, "blockQuartz", 1);
		reversedmap.puttCopyOreDict("gemPrismarine", 4, "blockPrismarine", 1);
		reversedmap.puttCopy(new ItemStack(Items.BRICK), 4, new ItemStack(Blocks.BRICK_BLOCK), 1);
		
		return true;
		
	}

	public static Set<List<ItemStack>> getRecipesList() {
		return map.keySet();
	}

	public static Set<List<ItemStack>> getReversedRecipesList() {
		return reversedmap.keySet();
	}
	
	public static RecipeRequest getResultForInput(ItemStack... itemStack) {
		return getRecipeResult(itemStack);
	}
	
	public static RecipeRequest getReversedResultForInput(ItemStack... itemStack) {
		return getReversedRecipeResult(itemStack);
	}

}
