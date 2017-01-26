package com.ow.skill;

import com.ow.event.SkillTiggerEvent;
import com.ow.gui.YourGui;
import com.ow.main.ClientProxy;
import com.ow.main.OverWatch;
import com.ow.network.SkillTriggerMessage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
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
        if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") <= 40) {
            Gui.drawRect(width - 40, height / 2 - 100, width - player.getCurrentArmor(1).getTagCompound().getInteger("CD_1"), height / 2 - 55, 0x20FFFFFF);
        }
        if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") <= 40) {
            Gui.drawRect(width - 40, height / 2 - 55, width - player.getCurrentArmor(1).getTagCompound().getInteger("CD_2"), height / 2 - 21, 0x20FFFFFF);
        }
        if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") >= 0
                && player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") <= 40) {
            Gui.drawRect(width - 40, height / 2 - 21, width - 40 + player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") * (40 / hero.getSkillMaxCooldownTime(2)), height, 0x20FFFF55);
        }

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

        if (ClientProxy.sk1.isPressed()) {
            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") == 0) {
                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 0, hero);
                MinecraftForge.EVENT_BUS.post(sevent);
                if (!sevent.isCanceled()) OverWatch.Network.sendToServer(new SkillTriggerMessage(0));
            }
        }else if (ClientProxy.sk2.isPressed()) {
            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") == 0) {
                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 1, hero);
                MinecraftForge.EVENT_BUS.post(sevent);
                if (!sevent.isCanceled()) OverWatch.Network.sendToServer(new SkillTriggerMessage(1));
            }
        }else if (ClientProxy.sk3.isPressed()) {
            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") == 0) {
                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 2, hero);
                MinecraftForge.EVENT_BUS.post(sevent);
                if (!sevent.isCanceled()) OverWatch.Network.sendToServer(new SkillTriggerMessage(2));
            }
        }
    }
}
