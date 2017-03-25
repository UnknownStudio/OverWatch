package team.unstudio.overwatch.item;

import java.util.List;

import team.unstudio.overwatch.entity.DartEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import scala.Int;

public class ItemDart extends Item {
	  public int ticks = 0;
	  public int t;
	public ItemDart()
	{
		super();
		this.setFull3D();
		this.isFull3D();
        this.setMaxStackSize(1); 
        this.setMaxDamage(Int.MaxValue());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.RED+"右键发射飞镖");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!world.isRemote){
            world.spawnEntityInWorld(new DartEntity(world,entityPlayer,4));
        }
		return super.onItemRightClick(itemStack, world, entityPlayer);
	}
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		return new DartEntity(world);
	}

}
