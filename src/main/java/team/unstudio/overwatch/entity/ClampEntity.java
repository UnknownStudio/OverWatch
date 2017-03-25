package team.unstudio.overwatch.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by KevinWalker on 2017/3/11.
 */
public class ClampEntity extends Entity{
    private World world;
    public int ticks = 150;
    public ClampEntity(World p_i1582_1_) {
        super(p_i1582_1_);
        this.setSize(0.5f,0.5f);
    }
    public ClampEntity(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_) {
        super(p_i1730_1_);
        this.world = p_i1730_1_;
        this.setPosition(p_i1730_2_, p_i1730_4_, p_i1730_6_);
        this.setSize(0.5f,0.5f);
    }
    @Override
    protected void entityInit() {

    }
    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        this.setDead();
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }

    public void onEntityUpdate() {
        if (this.ticks <= 0) {
            this.ticks = 150;
            setDead();
        } else {
            this.ticks--;
        }
    }
/*
    @Override
    public void onCollideWithPlayer(Entity entity) {
        super.applyEntityCollision(entity);
        this.player=(EntityPlayer) entity;
        System.out.println(this.posX + "," + this.posY + "," + this.posZ);
        entity.posX=this.posX;
        entity.posY=this.posY;
        entity.posZ=this.posZ;
//        player.addChatComponentMessage();
        this.collision=true;
    }*/

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        super.onCollideWithPlayer(player);
        System.out.println(this.posX + "," + this.posY+ "," + this.posZ);
        player.attackEntityFrom(DamageSource.causeThornsDamage(this), 4);
        player.setPosition(this.posX,this.posY+1,this.posZ);
    }
}