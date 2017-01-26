package com.ow.network;

import com.ow.event.SkillTiggerEvent;
import com.ow.hero.AbstractHero;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagInt;
import net.minecraftforge.common.MinecraftForge;
import static com.ow.hero.HeroManager.*;

/**
 * Created by Mouse on 2017/1/26.
 */
public final class SkillTriggerMessage implements IMessage{

    private int skill;

    public SkillTriggerMessage(int skill){
        this.skill = skill;
    }

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
            AbstractHero hero = getHero(player);
            if (hero==null) return null;

            if (getCooldownTime(player,message.skill) <= 0) {

                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, message.skill, hero);
                MinecraftForge.EVENT_BUS.post(sevent);
                if (sevent.isCanceled()) return null;

                hero.playerTigger(message.skill, player);
                setCooldownTime(player,message.skill,hero.getSkillMaxCooldownTime(message.skill));
            }
            return null;
        }
    }
}
