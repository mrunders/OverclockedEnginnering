package fr.mru.OverclockedEngineering.Tiles.ATileManager;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public abstract class ATileMultiblocksManager extends ATileManager {
	
	private boolean hasMaster, isMaster;
	private BlockPos masterBlockLocation;
	private int masterX, masterY, masterZ;

	public ATileMultiblocksManager(int stacksLenght, String name) {
		super(stacksLenght, name);
	}
	
	@Override
	public abstract void update();
	
    public abstract boolean checkStructure();
    protected abstract void setupStructure();
    protected abstract void resetStructure();
    protected abstract boolean isInstanceOf(TileEntity tile);
    protected abstract boolean isMaster(TileEntity tile);
    
	
	public boolean hasMaster() { return this.hasMaster; }
    public boolean isMaster() { return this.isMaster; }
    public int getMasterX() { return this.masterX; }
    public int getMasterY() { return this.masterY; }
    public int getMasterZ() { return this.masterZ; }
    public BlockPos getMasterPos() { return this.masterBlockLocation; }

    public void setMaster(int x, int y, int z) {
        this.hasMaster = true;
        this.masterX = x;
        this.masterY = y;
        this.masterZ = z;
        this.masterBlockLocation = new BlockPos(x, y, z);
    }
    
    protected void setMaster() {
    	this.isMaster = true;
    }
    
    protected void reset() {
    	this.hasMaster = false;
    	this.masterX = 0;
    	this.masterY = 0;
    	this.masterZ = 0;
    	this.masterBlockLocation = null;
    }
    
    protected boolean checkForMaster() {

        TileEntity tile = this.getWorld().getTileEntity(masterBlockLocation);
        return isMaster(tile);
    }
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
        super.readFromNBT(compound);
        this.hasMaster = compound.getBoolean("HasMaster");
        this.isMaster = compound.getBoolean("IsMaster");
        this.masterX = compound.getInteger("MasterX");
        this.masterY = compound.getInteger("MasterY");
        this.masterZ = compound.getInteger("MasterZ");
        
        this.masterBlockLocation = new BlockPos(this.masterX, this.masterY, this.masterZ);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
        super.writeToNBT(compound);
        compound.setBoolean("HasMaster", hasMaster);
        compound.setBoolean("IsMaster", isMaster);
        compound.setInteger("MasterX", masterX);
        compound.setInteger("MasterY", masterY);
        compound.setInteger("MasterZ", masterZ);
        
        return compound;
	}

	@Override
	public Object getServerGuiElement(TileEntity te, InventoryPlayer inventory) { return null; }

	@Override
	public Object getClientGuiElement(TileEntity te, InventoryPlayer inventory) { return null; }

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) { return false; }

	@Override
	public int getFullRecipeTime() { return 0; }

	@Override
	public ItemStack getRecipeResult() { return null; }

	@Override
	public boolean canSmelt() { return false; }

	@Override
	public void smelt() { }

	@Override
	public boolean isBurning() { return false; }

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) { return false; }

	@Override
	public int[] getInputSlots() { return null; }

	@Override
	public int[] getOutputSlots() { return null; }

}
