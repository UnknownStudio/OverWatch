package com.ow.network;

import com.ow.event.SkillTiggerEvent;
import com.ow.skill.AbstractHero;
import com.ow.skill.HeroManager;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagInt;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Mouse on 2017/1/26.
 */
public final class SkillTriggerMessage implements IMessage{

    private int skill;

    public SkillTriggerMessage(int skill){}

    public SkillTriggerMessage(){}

    @Override
    public void fromBytes(ByteBuf buf) {
        skill=buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(skill);
    }

    public static final class Handler implements IMessageHandler<SkillTriggerMessage, IMessage>{

        @Override
        public IMessage onMessage(SkillTriggerMessage message, MessageContext ctx) {
            EntityPlayer player = ctx.getServerHandler().playerEntity;
            AbstractHero hero = HeroManager.getHero(player);
            if (hero==null) return null;

            if(!player.getCurrentArmor(1).hasTagCompound()){
                player.getCurrentArmor(1).setTagInfo("CD_1", new NBTTagInt(0));
                player.getCurrentArmor(1).setTagInfo("CD_2", new NBTTagInt(0));
                player.getCurrentArmor(1).setTagInfo("CD_3", new NBTTagInt(0));
            }

            switch (message.skill){
                case 0:{
                    if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") == 0) {
                        SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 0, hero);
                        MinecraftForge.EVENT_BUS.post(sevent);
                        if (!sevent.isCanceled()) {
                            hero.playerTigger(0, player);
                            player.getCurrentArmor(1).getTagCompound().setInteger("CD_1", hero.getSkillMaxCooldownTime(0));
                        }
                    }
                    break;
                }
                case 1:{
                    if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") == 0) {
                        SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 1, hero);
                        MinecraftForge.EVENT_BUS.post(sevent);
                        if (!sevent.isCanceled()) {
                            hero.playerTigger(1, player);
                            player.getCurrentArmor(1).getTagCompound().setInteger("CD_2", hero.getSkillMaxCooldownTime(1));
                        }
                    }
                    break;
                }
                case 2:{
                    if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") == 0) {
                        SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 2, hero);
                        MinecraftForge.EVENT_BUS.post(sevent);
                        if (!sevent.isCanceled()) {
                            hero.playerTigger(2, player);
                            player.getCurrentArmor(1).getTagCompound().setInteger("CD_3", hero.getSkillMaxCooldownTime(2));
                        }
                    }
                    break;
                }
                default: break;
            }
            return null;
        }
    }
}
