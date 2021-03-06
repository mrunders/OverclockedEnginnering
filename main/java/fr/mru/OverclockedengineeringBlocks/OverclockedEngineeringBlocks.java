package fr.mru.OverclockedengineeringBlocks;

import java.util.ArrayList;

import fr.mru.OverclockedEngineering.Crops.AlienGrass;
import fr.mru.OverclockedEngineering.Crops.MagiusBlock;
import fr.mru.OverclockedEngineering.Tiles.Cobble_form.CobbleForm;
import fr.mru.OverclockedEngineering.Tiles.DimensionalHole.DHole;
import fr.mru.OverclockedEngineering.Tiles.EnergyStorage.RFStorage;
import fr.mru.OverclockedEngineering.Tiles.FilterChest.FilterChest;
import fr.mru.OverclockedEngineering.Tiles.Machine.MachineBlock;
import fr.mru.OverclockedEngineering.Tiles.OneItemDropper.OneItemDropper;
import fr.mru.OverclockedEngineering.Tiles.StackFurnace.StackFurnace;
import fr.mru.OverclockedEngineering.Tiles.TransporterItems.TransporterItems;
import fr.mru.OverclockedEngineering.Tiles.TreeFarmer.TreeFarmer;
import fr.mru.OverclockedEngineering.Tiles.TwoModuleMachine.TwoModulesMachine;
import fr.mru.OverclockedEngineering.Tiles.UncraftingTable.UncraftingTable;
import fr.mru.OverclockedEngineering.Tiles.WitherPlacer.WitherPlacer;
import fr.mru.OverclockedEngineering.Tiles.rfbridge.RfBridge;
import net.minecraft.block.Block;

public class OverclockedEngineeringBlocks {
	
	public static final Block MACHINE_BLOCK = new MachineBlock(),
							  STACK_FURNACE = new StackFurnace(),
							  TREE_FARMER   = new TreeFarmer(),
							  UNCRAFTING_TABLE = new UncraftingTable(),
							  DIMENSIONAL_HOLE = new DHole(),
							  MACHINE_CASING = new MachineCasing(),
							  MASS_ANVIL     = new MassAnvil(),
							  TWO_MODULES_MACHINE = new TwoModulesMachine(),
							  COBBLE_FORM = new CobbleForm(),
							  FILTER_CHEST = new FilterChest(),
							  ALIEN_ROCK = new AlienRock(),
							  RF_BRIDGE = new RfBridge(),
							  TRANSPORTER_ITEMS = new TransporterItems(),
							  ALIEN_GRASS = new AlienGrass(),
							  RF_STORAGE_BLOCK = new RFStorage(),
							  MAGIUS_BLOCK_SEED = new MagiusBlock(),
							  STRUCTURE_SHIP_BLOCK = new StructureShipBlock(),
							  HEAVY_SHIP_BLOCK = new OverclockedEngineeringBlocksBase("heavy_ship_block").setBlockUnbreakable(),
							  HEAVY_SHIP_GLASS = new OverclockedEngineeringGlassBase("heavy_ship_glass").setBlockUnbreakable(),
							  CATALYSER_SLOT = new CatalyserSlot(),
							  ONE_ITEM_DROPPER = new OneItemDropper(),
							  WITHER_PLACER = new WitherPlacer()
							  ;
	
	public static ArrayList<Block> blockList = new ArrayList<>();
	
	static {
		
		blockList.addAll(EngineBlockManager.engineList);
		
		blockList.add(MACHINE_BLOCK);
		blockList.add(STACK_FURNACE);
		blockList.add(TREE_FARMER);
		blockList.add(UNCRAFTING_TABLE);
		blockList.add(DIMENSIONAL_HOLE);
		blockList.add(MACHINE_CASING);
		blockList.add(MASS_ANVIL);
		blockList.add(TWO_MODULES_MACHINE);
		blockList.add(COBBLE_FORM);
		blockList.add(FILTER_CHEST);
		blockList.add(ALIEN_ROCK);
		blockList.add(RF_BRIDGE);
		blockList.add(TRANSPORTER_ITEMS);
		blockList.add(ALIEN_GRASS);
		blockList.add(RF_STORAGE_BLOCK);
		blockList.add(MAGIUS_BLOCK_SEED);
		blockList.add(STRUCTURE_SHIP_BLOCK);
		blockList.add(HEAVY_SHIP_BLOCK);
		blockList.add(CATALYSER_SLOT);
		blockList.add(HEAVY_SHIP_GLASS);
		blockList.add(ONE_ITEM_DROPPER);
		blockList.add(WITHER_PLACER);
		
	}
	
	public static void setBlockName(Block block, String name) {
		
		String m = fr.mru.OverclockedEngineering.OverclockedEngineering.MODID;
		block.setRegistryName(m, name).setUnlocalizedName(m + "." + name);
	}

}
