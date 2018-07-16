package fr.mru.OverclockedEngineeringItems;

import java.util.ArrayList;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EngineManager extends Item {

	
	public static final Item HYBRIDE_ENGINE1 = new EngineManager("hybride_engine1",200),
							 HYBRIDE_ENGINE2 = new EngineManager("hybride_engine2",140),
							 HYBRIDE_ENGINE3 = new EngineManager("hybride_engine3",75),
							 HYBRIDE_ENGINE4 = new EngineManager("hybride_engine4",20),
							 HYBRIDE_ENGINE5 = new EngineManager("hybride_engine5", 1);
	
	public static ArrayList<Item> itemsList = new ArrayList<>();

	static {
		itemsList.add(HYBRIDE_ENGINE1);
		itemsList.add(HYBRIDE_ENGINE2);
		itemsList.add(HYBRIDE_ENGINE3);
		itemsList.add(HYBRIDE_ENGINE4);
		itemsList.add(HYBRIDE_ENGINE5);
	}
	
	private int full_time_recipe;
	
	public EngineManager(String NAME, int full_time_recipe) {
		
		super();
		this.full_time_recipe = full_time_recipe;
		setMaxStackSize(1);
		OverclokedEngineeringItems.setItemName(this, NAME);
		setCreativeTab(CreativeTabs.MISC);
	}

	public int getFullTimeRecipe() {
		
		return full_time_recipe;
	}
	
	public static int getFullTimeRecipe(Item engine) {
		
		return ((EngineManager)engine).getFullTimeRecipe();
		
	}
	
	public static boolean itemIsEngine(Item item) {
		
		return item instanceof EngineManager;
	}


}
