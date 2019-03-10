package fr.mru.OverclockedEngineering;

import org.apache.logging.log4j.Logger;

import fr.mru.OverclockedEngineering.Recipes.ARecipeManager;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.TileCobbleForm;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.TileDHole;
import fr.mru.OverclockedEngineering.Tiles.EnergyStorage.TileRFStorage;
import fr.mru.OverclockedEngineering.Tiles.FilterChest.TileFilterChest;
import fr.mru.OverclockedEngineering.Tiles.Machine.TileOverclockedFurnace;
import fr.mru.OverclockedEngineering.Tiles.OneItemDropper.TileOneItemDropper;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.TileStackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TransporterItems.TileTransporterItems;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TileTreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.TileTwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.rfbridge.TileRfBridge;
import fr.mru.OverclockedEngineeringItems.OverclokedEngineeringItems;
import fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringCommon;
import fr.mru.OverclockedEngineeringStructure.Structure;
import fr.mru.OverclockedEngineeringStructure.WorldGenCustomStructures;
import fr.mru.OverclockedEngineeringStructure.WorldGenCustomStructuresFactory;
import fr.mru.OverclockedEngineeringWorld.AlienRockGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid=OverclockedEngineering.MODID, name="Overclocked Engineering", version="0.1")
public class OverclockedEngineering {

	public static final String MODID = "overclockedengineering";
	
	@Instance(OverclockedEngineering.MODID)
	public static OverclockedEngineering instance;
	
	@SidedProxy(clientSide = "fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringClient", 
			    serverSide = "fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringServer")
	
	public static OverclockedEngineeringCommon proxy;
	public static Logger logger;
	
	public static CreativeTabs overclockedTab = new TabOverclocked(CreativeTabs.getNextID(), "Overclocked Tab");
	
	public OverclockedEngineering() {
		
	    MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
	    
	}

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TileOverclockedFurnace.class, MODID + ":tile_overclocked_furnace");
		GameRegistry.registerTileEntity(TileStackFurnace.class, MODID + ":tile_stack_furnace");
		GameRegistry.registerTileEntity(TileTreeFarmer.class, MODID + ":tile_tree_farmer");
		GameRegistry.registerTileEntity(TileDHole.class, MODID + ":tile_dimensional_hole");
		GameRegistry.registerTileEntity(TileTwoModulesMachine.class	, MODID + ":tile_two_modules_machine");
		GameRegistry.registerTileEntity(TileCobbleForm.class, MODID + ":tile_cobble_form");
		GameRegistry.registerTileEntity(TileFilterChest.class, MODID + ":tile_filter_chest");
		GameRegistry.registerTileEntity(TileRfBridge.class, MODID + ":tile_rf_bridge");
		GameRegistry.registerTileEntity(TileTransporterItems.class, MODID + ":tile_transporter_items");
		GameRegistry.registerTileEntity(TileRFStorage.class, MODID + ":tile_rf_storage_block");
		GameRegistry.registerTileEntity(TileOneItemDropper.class, 	MODID + ":tile_one_item_dropper");

		GameRegistry.registerWorldGenerator(new AlienRockGen(), 0);
		GameRegistry.registerWorldGenerator(WorldGenCustomStructuresFactory.generateCrashedSpaceShip(), 0);

		logger = event.getModLog();
		proxy.preInit(event.getSuggestedConfigurationFile());

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.init();
		
		OreDictionary.registerOre("ingotSteel", OverclokedEngineeringItems.INGOT_STEEL);
		
		ARecipeManager.initialise();

	}

}
