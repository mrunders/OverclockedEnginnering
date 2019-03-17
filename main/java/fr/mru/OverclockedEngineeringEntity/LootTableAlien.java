package fr.mru.OverclockedEngineeringEntity;

import fr.mru.OverclockedEngineering.OverclockedEngineering;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableAlien extends LootTableList {

    public static final ResourceLocation ENTITIES_MAD_VILLAGER = register("entities/villager");
    
    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(OverclockedEngineering.MODID, id));
    }
}
