package team.unstudio.overwatch.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import team.unstudio.overwatch.event.SkillTiggerEvent;
import team.unstudio.overwatch.hero.AbstractHero;

import static team.unstudio.overwatch.hero.HeroManager.getCooldownTime;
import static team.unstudio.overwatch.hero.HeroManager.getHero;
import static team.unstudio.overwatch.hero.HeroManager.setCooldownTime;

/**
 * Created by Mouse on 2017/1/27.
 */
public class SkillTriggerClientMessage implements IMessage {

    private int skill;

    public SkillTriggerClientMessage(int skill){
        this.skill = skill;
    }

    public SkillTriggerClientMessage(){}

    @Override
    public void fromBytes(ByteBuf buf) {
        skill=buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(skill);
    }

    public static final class Handler implements IMessageHandler<SkillTriggerClientMessage, IMessage> {

        @Override
        public IMessage onMessage(SkillTriggerClientMessage message, MessageContext ctx) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            AbstractHero hero = getHero(player);
            if (hero==null) return null;
            hero.playerTriggerInClient(message.skill,player);
            return null;
        }
    }

}
