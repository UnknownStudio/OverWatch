package team.unstudio.overwatch.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class SprintEntity extends EntityThrowable
{
	public EntityPlayer player;
	  public int ticks = 3;
    int damage = 3; 
    public SprintEntity(World par1World) {
        super(par1World);
        setSize(10F, 10F);
    }
    public SprintEntity(World par1World, EntityLivingBase par2EntityLivingBase, int dmg) {
        super(par1World, par2EntityLivingBase);
        this.damage = dmg;
        setSize(10F, 10F);
    }
    @Override
    protected void onImpact(MovingObjectPosition mop) {
    	if(mop.typeOfHit==MovingObjectType.BLOCK){
    		mop.sideHit=-1;
    	}
    	if(mop.typeOfHit == MovingObjectType.ENTITY){
    		mop.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this), damage);
    	}
        setPosition(this.posX, this.posY, this.posZ);
    }

    protected float func_70182_d()	
    {
        return 3.5F;
    }

    protected float getMotionFactor()
    {
      return 3.5F;
    }
    
    protected float getGravityVelocity()
    {
        return 0.001F;
    }
    public boolean canBeCollidedWith()
    {
      return true;
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
    public void onEntityUpdate()
    {
      if (this.ticks <= 0) {
        this.ticks = 100;
        setDead();
      }
      else {
        this.ticks -= 1;
      }
    }
}