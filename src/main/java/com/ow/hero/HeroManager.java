package com.ow.hero;

import com.ow.event.SkillTiggerEvent;
import com.ow.gui.YourGui;
import com.ow.main.ClientProxy;
import com.ow.main.OverWatch;
import com.ow.network.SkillTriggerMessage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winston_wang on 2017/1/23.
 */
public class HeroManager {
    public static List<AbstractHero> heros = new ArrayList();

    public static void addHero(AbstractHero hero){
        heros.add(hero);
    }

    public static AbstractHero getHero(EntityPlayer player){
        for(AbstractHero hero:heros) if(hero.isHeroSuit(player)) return hero;
        return null;
    }

    public static int getCooldownTime(EntityPlayer player,int skill){
        ItemStack item = player.getCurrentArmor(1);
        if(item==null||!item.hasTagCompound()) return 0;

        NBTTagCompound nbt = item.getTagCompound();
        if(!nbt.hasKey("cd"+skill)) return 0;

        return nbt.getInteger("cd"+skill);
    }

    public static void setCooldownTime(EntityPlayer player,int skill,int cd){
        ItemStack item = player.getCurrentArmor(1);
        if(item==null||!item.hasTagCompound()) return;
        item.setTagInfo("cd"+skill,new NBTTagInt(cd));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onRenderOverly(RenderGameOverlayEvent.Pre event){
        final Minecraft mc = Minecraft.getMinecraft();
        final int width = event.resolution.getScaledWidth();
        final int height = event.resolution.getScaledWidth();
        final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        final AbstractHero hero = getHero(player);
        if (hero==null) return;

        //渲染文字
        FontRenderer fontRenderer = mc.fontRenderer;
        fontRenderer.drawStringWithShadow(hero.getLocalizedName(), width - 30, height / 2 - 100, 0xFFFFFF);
        fontRenderer.drawStringWithShadow("大招", width - 31, height / 2 - 100 + 40 * 2, 0xFFFFFF);
        Gui.drawRect(width - 40, height / 2 - 100, width, height - 100, 0x20666666);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(0));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 12, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(1));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 2 + 42, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(2));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 2 + 42 * 2, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getHeroResourceLocation());
        Gui.func_146110_a(0, 0, 0, 0, 30, 30, 30, 30);
        fontRenderer.drawStringWithShadow(hero.getLocalizedName(), 32, 12, 0xFFFFFF);

        //渲染技能CD
        Gui.drawRect(width - 40, height / 2 - 100, width - getCooldownTime(player,0), height / 2 - 55, 0x20FFFFFF);
        Gui.drawRect(width - 40, height / 2 - 55, width - getCooldownTime(player,1), height / 2 - 21, 0x20FFFFFF);
        Gui.drawRect(width - 40, height / 2 - 21, width - 40 + getCooldownTime(player,2) * (40 / hero.getSkillMaxCooldownTime(2)), height, 0x20FFFF55);

        //Bind
        fontRenderer.drawStringWithShadow("", 0, 0, 0xFFFFFF);
        mc.renderEngine.bindTexture(Gui.icons);
    }

    //W-J-R OW-Skill-Engine Start **Do not edit**
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void keyListener(InputEvent.KeyInputEvent event) {
        if (ClientProxy.kbShowNewGui.isPressed()){
            Minecraft mc = Minecraft.getMinecraft();
            mc.displayGuiScreen(new YourGui(mc.currentScreen));
            return;
        }

        final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        final AbstractHero hero = getHero(player);
        if (hero==null) return;

        if (!player.getCurrentArmor(1).hasTagCompound()) return;

        int skill = 0;
        if (ClientProxy.sk1.isPressed()) skill=0;
        else if (ClientProxy.sk2.isPressed()) skill=1;
        else if (ClientProxy.sk3.isPressed()) skill=2;
        else return;

        if (getCooldownTime(player,skill) <= 0) {
            SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, skill, hero);
            MinecraftForge.EVENT_BUS.post(sevent);
            if (!sevent.isCanceled()) OverWatch.Network.sendToServer(new SkillTriggerMessage(skill));
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event){
        EntityPlayer player = event.player;
        for(int i=0;i<3;i++) {
            if(getCooldownTime(player,i)==0) continue;
            setCooldownTime(player,i,getCooldownTime(player,i)-1);
        }
    }
}
