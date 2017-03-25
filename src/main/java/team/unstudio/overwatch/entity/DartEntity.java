package team.unstudio.overwatch.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class DartEntity extends EntityThrowable
{
    public int ticks = 150;
    int damage = 3; 
    public DartEntity(World par1World) {
        super(par1World);
        setSize(0.8F, 0.8F);
    }
    public DartEntity(World par1World, EntityLivingBase par2EntityLivingBase, int dmg) {
        super(par1World, par2EntityLivingBase);
        this.damage = dmg;
        setSize(0.8F, 0.8F);
    }
    @Override
    protected void onImpact(MovingObjectPosition mop) {
    	if(mop.typeOfHit==MovingObjectType.BLOCK){
    	    this.setDead();
    	}
    	if(mop.typeOfHit == MovingObjectType.ENTITY){
    		mop.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this), damage);
            this.setDead();
        }
        if (this.isInWater())
        {
        }
    }

//    protected float func_70182_d()
//    {
//        return 3.5F;
//    }
//
//    protected float getMotionFactor()
//    {
//      return 3.5F;
//    }

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
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticks <= 0) {
            this.ticks = 100;
            setDead();
        }
        else {
            this.ticks -= 1;
        }
    }
    protected float func_70182_d()
    {
        return 2F;
    }
}