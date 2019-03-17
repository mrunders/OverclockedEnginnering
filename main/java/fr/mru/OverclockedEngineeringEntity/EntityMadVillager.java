package fr.mru.OverclockedEngineeringEntity;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerInteract;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class EntityMadVillager extends EntityVillager {
	
	private static final DataParameter<Integer> PROFESSION = EntityDataManager.<Integer>createKey(EntityMadVillager.class, DataSerializers.VARINT);
	
	public EntityMadVillager(World worldIn) {
		super(worldIn, VillagerRegistry.instance().getId(AlienVillagers.alien_mad));
		
	}
	
	public static int getId() {
		return VillagerRegistry.instance().getId(AlienVillagers.alien_mad);
	}
	
    protected void initEntityAI() {

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAITradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(10, new EntityAIAvoidEntity(this, EntityGolem.class, 8.0F, 1.6D, 0.6D));
        this.tasks.addTask(10, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityCreeper.class, 2.0F));
        
        this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(PROFESSION, Integer.valueOf(getId()));
    }
    
    public ITextComponent getDisplayName() {
    	return new TextComponentTranslation("Mad Villager");
    }
    
    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableAlien.ENTITIES_MAD_VILLAGER;
    }
    
    public void setProfession(int professionId) {
    	
        this.dataManager.set(PROFESSION, Integer.valueOf(getId()));
        net.minecraftforge.fml.common.registry.VillagerRegistry.onSetProfession(this, getId());
    }

}
