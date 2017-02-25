package team.unstudio.overwatch.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import scala.Int;
import team.unstudio.overwatch.common.OverWatch;
import team.unstudio.overwatch.entity.DartEntity;

/**
 * Created by KevinWalker on 2017/2/25.
 */
public class BangZangBow extends ItemBow {
    public static final String[] bowPullIconNameArray = new String[]{"banzangbow_0", "banzangbow_1", "banzangbow_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BangZangBow() {
        this.setMaxDamage(Int.MaxValue());
        this.maxStackSize = 1;
        this.setFull3D();
        this.isFull3D();
    }

    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if (flag) {
            float f = (float) j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double) f < 0.1D) {
                return;
            }

            if (f > 1.0F) {
                f = 1.0F;
            }

            DartEntity entity = new DartEntity(p_77615_2_, p_77615_3_, 4);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!p_77615_2_.isRemote) {
                p_77615_2_.spawnEntityInWorld(entity);
            }
        }
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        return p_77654_1_;
    }


    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }


    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }


    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        if (p_77659_3_.capabilities.isCreativeMode) {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }

        return p_77659_1_;
    }

    public int getItemEnchantability() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_) {
        this.itemIcon = p_94581_1_.registerIcon(OverWatch.MODID + ":banzangbow");
        this.iconArray = new IIcon[bowPullIconNameArray.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = p_94581_1_.registerIcon(OverWatch.MODID + ":banzangbow_" + i);
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if (usingItem != null)
        {
            int time = 72000 - useRemaining;
            if (time < 8)
                return iconArray[0];
            if (time < 14)
                return iconArray[1];
            return iconArray[2];
        }
        return getIcon(stack, renderPass);
    }
    @Override
    public IIcon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
}
