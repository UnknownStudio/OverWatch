package team.unstudio.overwatch.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.ItemLoader;

/**
 * Created by KevinWalker on 2017/2/1.
 */
public class ItemGiveMessage implements IMessage{
    @Override
    public void fromBytes(ByteBuf buf) {
    }
    @Override
    public void toBytes(ByteBuf buf) {
    }
    public static class Handler implements IMessageHandler<ItemGiveMessage, IMessage>
    {
        @Override
        public IMessage onMessage(ItemGiveMessage message, MessageContext ctx) {
            EntityPlayer player = ctx.getServerHandler().playerEntity;
            player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.dart));
            player.inventory.addItemStackToInventory(new ItemStack(ArmorLoader.YuanshiHelmet));
            player.inventory.addItemStackToInventory(new ItemStack(ArmorLoader.YuanshiChestplate));
            player.inventory.addItemStackToInventory(new ItemStack(ArmorLoader.YuanshiLeggings));
            player.inventory.addItemStackToInventory(new ItemStack(ArmorLoader.YuanshiBoots));
            return null;
        }
    }
}
