package com.ow.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class KuangShuZDEntity extends EntityThrowable
{
	  	public int ticks = 150;
	  	public int fuse;
	    private EntityLivingBase tntPlacedBy;
	    public KuangShuZDEntity(World p_i1729_1_)
	    {
	        super(p_i1729_1_);
	        this.preventEntitySpawning = true;
	        this.setSize(0.98F, 0.98F);
	        this.yOffset = this.height / 2.0F;
	    }

	    public KuangShuZDEntity(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_, EntityLivingBase p_i1730_8_)
	    {
	        this(p_i1730_1_);
	        this.setPosition(p_i1730_2_, p_i1730_4_, p_i1730_6_);
	        float f = (float)(Math.random() * Math.PI * 2.0D);
	        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
	        this.motionY = 0.20000000298023224D;
	        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
	        this.fuse = 80;
	        this.prevPosX = p_i1730_2_;
	        this.prevPosY = p_i1730_4_;
	        this.prevPosZ = p_i1730_6_;
	        this.tntPlacedBy = p_i1730_8_;
	    }

	    protected void entityInit() {}

	    protected boolean canTriggerWalking()
	    {
	        return false;
	    }

	    public boolean canBeCollidedWith()
	    {
	        return !this.isDead;
	    }


		@Override
		protected void onImpact(MovingObjectPosition mop) {
			if(mop.typeOfHit==MovingObjectType.BLOCK){
	    		mop.sideHit=-1;
	    		float f = 1.5F;
		        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, false);
		        this.setDead();
	    	}
	        if (isInWater())
	        {
	          this.setDead();
	        }
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