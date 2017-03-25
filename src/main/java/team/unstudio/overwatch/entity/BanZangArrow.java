package team.unstudio.overwatch.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by KevinWalker on 2017/3/12.
 */
public class BanZangArrow extends EntityThrowable{
        public int ticks = 200;
        /**
     * 在客户端同步时被调用的构造器。
     */
    public BanZangArrow(World par1World) {
        super(par1World);
        setSize(0.8F, 0.8F); //大小0.8格
    }

    /**
     * 我们在服务端生成时调用的构造器。
     */
    public BanZangArrow(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        setSize(0.8F, 0.8F); //大小0.8格
    }

    /**
     * 当实体碰撞到其他世界物品时被调用。进行碰撞计算。
     */
    @Override
    protected void onImpact(MovingObjectPosition mop) {
        //伤害实体
        if(mop.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY) {
            mop.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this), 4);
        }
        this.setDead();
    }

    /**
     * 获取实体的初速度值。
     */
    protected float func_70182_d()
    {
        return 1.7F;
    }

    /**
     * 获取重力加速度的大小。
     */
    protected float getGravityVelocity()
    {
        return 0.001F; //重力影响极小
    }
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticks <= 0) {
            this.ticks = 200;
            setDead();
        }
        else {
            this.ticks -= 1;
        }
    }

}
