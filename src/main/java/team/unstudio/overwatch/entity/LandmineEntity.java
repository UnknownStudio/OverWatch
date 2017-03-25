package team.unstudio.overwatch.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by KevinWalker on 2017/2/24.
 */
public class LandmineEntity extends Entity {
    private World world;
    public int ticks = 400;
    public LandmineEntity(World worldIn)
    {
        super(worldIn);
    }
    public LandmineEntity(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_) {
        super(p_i1730_1_);
        this.world = p_i1730_1_;
        this.setPosition(p_i1730_2_, p_i1730_4_, p_i1730_6_);
        this.setSize(1f,0.5f);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }
    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        this.setDead();
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }
    public void onEntityUpdate() {
        System.out.println(this.posX + "," + this.posY + "," + this.posZ);
        if (this.ticks <= 0) {
            this.ticks = 400;
            setDead();
        } else {
            this.ticks--;
        }
    }
}
