package fr.mru.OverclockedEngineering;

import org.apache.logging.log4j.Logger;

import fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringCommon;
import fr.mru.OverclockedengineeringBlocks.GuiHandler;
import fr.mru.OverclockedengineeringBlocks.TileOverclockedFurnace;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=OverclockedEngineering.MODID, name="Overclocked Engineering", version="0.1")
public class OverclockedEngineering {

	public static final String MODID = "overclockedengineering";
	
	@Instance(OverclockedEngineering.MODID)
	public static OverclockedEngineering instance;
	
	@SidedProxy(clientSide = "fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringClient", 
			    serverSide = "fr.mru.OverclockedEngineeringProxy.OverclockedEngineeringServer")
	
	public static OverclockedEngineeringCommon proxy;
	public static Logger logger;
	
	public OverclockedEngineering() {
		
	    MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
	}

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		GameRegistry.registerTileEntity(TileOverclockedFurnace.class, MODID + ":tile_overclocked_furnace");
		
		logger = event.getModLog();
		proxy.preInit(event.getSuggestedConfigurationFile());
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.init();
		
		
	}

}
