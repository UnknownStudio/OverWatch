package team.unstudio.overwatch.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class YuanShiEEntity extends Entity
{
    World world;
	public EntityPlayer player;
	public int ticks = 50;
    int damage = 3; 
    public YuanShiEEntity(World par1World) {
        super(par1World);
        this.world=par1World;
        this.setSize(2F, 2F);
    }
    @Override
    protected void entityInit() {
    }
    public YuanShiEEntity(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_)
    {
        this(p_i1730_1_);
        this.world=p_i1730_1_;
        this.setPosition(p_i1730_2_,p_i1730_4_,p_i1730_6_);
        this.setSize(2F, 2F);
    }
    public boolean canBeCollidedWith()
    {
      return true;
    }
    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    }
    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    }
    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
      return 0.0F;
    }
    public float getBrightness(float f)
    {
      return 1.0F;
    }
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float f)
    {
        return 15728880;
    }
    public void onEntityUpdate() {
        System.out.println(this.posX+","+this.posY+","+this.posZ);
        if (this.ticks <= 0) {
        this.ticks = 200;
        setDead();
      }
      else {
        this.ticks--;
      }
    }
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        p_70097_1_.getEntity().attackEntityFrom(DamageSource.causeThornsDamage(this), 4);
		return true;
	}
	@Override
	public boolean isEntityEqual(Entity p_70028_1_)
    {
		return true;
	}
	@Override
	public boolean canAttackWithItem()
    {
		return false;
	}
}