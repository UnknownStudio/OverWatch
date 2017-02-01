package team.unstudio.overwatch.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import team.unstudio.overwatch.hero.AbstractHero;

import static team.unstudio.overwatch.hero.HeroManager.getHero;

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
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(SkillTriggerClientMessage message, MessageContext ctx) {
            EntityPlayer player = net.minecraft.client.Minecraft.getMinecraft().thePlayer;
            AbstractHero hero = getHero(player);
            if (hero == null) return null;
            hero.playerTriggerInClient(message.skill, player);
            return null;
        }
    }
}
