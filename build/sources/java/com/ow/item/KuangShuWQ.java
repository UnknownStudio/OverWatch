package com.ow.item;

import com.ow.entity.KuangShuZDEntity;
import com.ow.init.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class KuangShuWQ extends Item{
	public KuangShuWQ()
	{
		super();
		this.setFull3D();
		this.setUnlocalizedName("kuangshuwq");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
		this.setTextureName("overwatch:kuangshuwq");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
	        EntityPlayer par3EntityPlayer) {
			KuangShuZDEntity entity = new KuangShuZDEntity(par2World, par3EntityPlayer.posX,
				par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ, par3EntityPlayer);	
			if (!par2World.isRemote) {    	
				float angle = (par3EntityPlayer.rotationYaw / 180F) * 3.141593F; 
				float angle2 = (-par3EntityPlayer.rotationPitch / 180F) * 3.141593F; 
				final float speed = 2f; 
				entity.motionY = speed * MathHelper.sin(angle2); 
				entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle); 
				entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
				par2World.spawnEntityInWorld(entity);
			}
			return par1ItemStack;
		}

}

