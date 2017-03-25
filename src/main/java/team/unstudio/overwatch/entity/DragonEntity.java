package team.unstudio.overwatch.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by KevinWalker on 2017/3/11.
 */
public class DragonEntity extends EntityThrowable {
    public int ticks = 400;
    public DragonEntity(World p_i1776_1_) {
        super(p_i1776_1_);
        setSize(3F, 3F);
    }
    public DragonEntity(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
        setSize(3F, 3F);
    }
    @Override
    protected void onImpact(MovingObjectPosition p_70184_1_) {
        if(p_70184_1_.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY){
            p_70184_1_.sideHit = 0;
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThornsDamage(this), 20);
        }
        setPosition(this.posX, this.posY, this.posZ);
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
}
