package fr.mru.OverclockedEngineering;

import fr.mru.OverclockedEngineeringItems.Focus.FocusManager;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabOverclocked extends CreativeTabs {

	public TabOverclocked(int index, String label) {
		super(index, label);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(FocusManager.FOCUS_SMELTER);
	}

}
