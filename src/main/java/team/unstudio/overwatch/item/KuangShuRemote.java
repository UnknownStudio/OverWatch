package team.unstudio.overwatch.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import team.unstudio.overwatch.common.ItemLoader;
import team.unstudio.overwatch.hero.KuangShu;

/**
 * Created by KevinWalker on 2017/2/24.
 */
public class KuangShuRemote extends Item {
    public static boolean boom;

    public KuangShuRemote() {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        if (this.boom == true) {
            KuangShu.kuangshudl.worldObj.createExplosion(KuangShu.kuangshudl, KuangShu.kuangshudl.posX, KuangShu.kuangshudl.posY, KuangShu.kuangshudl.posZ, 1.5f, false);
            KuangShu.kuangshudl.setDead();
            this.boom = false;
        }
        return new ItemStack(ItemLoader.tb);
    }
}
