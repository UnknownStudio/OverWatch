package team.unstudio.overwatch.hero;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.GuiIngameForge;
import team.unstudio.overwatch.event.SkillTiggerEvent;
import team.unstudio.overwatch.client.gui.YourGui;
import team.unstudio.overwatch.client.ClientProxy;
import team.unstudio.overwatch.common.OverWatch;
import team.unstudio.overwatch.common.network.SkillTriggerMessage;
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

import java.util.HashSet;
import java.util.Set;

/**
 * 英雄管理器
 */
public class HeroManager {
    public static final Set<AbstractHero> heros = new HashSet();

    /**
     * 添加英雄
     * @param hero
     */
    public static void addHero(AbstractHero hero){
        heros.add(hero);
    }

    /**
     * 获取玩家当前对应英雄
     * @param player
     * @return
     */
    public static AbstractHero getHero(EntityPlayer player){
        for(AbstractHero hero:heros) if(hero.isHeroSuit(player)) return hero;
        return null;
    }

    /**
     * 获取玩家技能冷却时间
     * @param player
     * @param skill
     * @return
     */
    public static int getCooldownTime(EntityPlayer player,int skill){
        ItemStack item = player.getCurrentArmor(1);
        if(item==null||!item.hasTagCompound()) return 0;

        NBTTagCompound nbt = item.getTagCompound();
        if(!nbt.hasKey("cd"+skill)) return 0;

        return nbt.getInteger("cd"+skill);
    }

    /**
     * 设置玩家技能冷却时间
     * @param player
     * @param skill
     * @param cd
     */
    public static void setCooldownTime(EntityPlayer player,int skill,int cd){
        ItemStack item = player.getCurrentArmor(1);
        if(item==null) return;
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
        float playerhealth = mc.thePlayer.getHealth();
        if (hero==null) return;

        //渲染文字
        FontRenderer fontRenderer = mc.fontRenderer;
        fontRenderer.drawStringWithShadow(hero.getLocalizedName(), width - 30, height / 2 - 100, 0xFFFFFF);
        //fontRenderer.drawStringWithShadow("大招", width - 31, height / 2 - 100 + 40 * 2, 0xFFFFFF);
        Gui.drawRect(width - 40, height / 2 - 100, width, height - 100, 0x20666666);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(0));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 12, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(1));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 2 + 42, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getSkillResourceLocation(2));
        Gui.func_146110_a(width - 40 + 2, height / 2 - 100 + 2 + 42 * 2, 0, 0, 30, 30, 30, 30);
        mc.renderEngine.bindTexture(hero.getHeroResourceLocation());
        Gui.func_146110_a(0, 0, 0, 0, 30, 30, 30, 30);
        fontRenderer.drawStringWithShadow(hero.getLocalizedName(), 35, 8, 0xFFFFFF);
        if (event.type == RenderGameOverlayEvent.ElementType.HEALTH) {
            //渲染血条
            event.setCanceled(true); //取消掉事件来阻止原图标的绘制
            mc.renderEngine.bindTexture(new ResourceLocation("overwatch", "textures/gui/hp.png"));
            Gui.func_146110_a(-4, 22,142, 36, (int)(playerhealth*7.1), 36, 142, 36);
            String hp = String.format(StatCollector.translateToLocal("overwatch.health.name")+": %d/%d",
                    MathHelper.ceiling_float_int(mc.thePlayer.getHealth()),
                    MathHelper.ceiling_double_int(mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue()));
            fontRenderer.drawStringWithShadow(hp, 55,13 , 0xFFFFFF);
            fontRenderer.drawStringWithShadow(StatCollector.translateToLocal("overwatch.player.name")+": "+Minecraft.getMinecraft().thePlayer.getCommandSenderName(), 55,4 , 0xFFFFFF);
            mc.renderEngine.bindTexture(Gui.icons);
        }
        //渲染技能CD
        Gui.drawRect(width - 40, height / 2 - 100, width - 40*getCooldownTime(player,0)/hero.getSkillMaxCooldownTime(0), height / 2 - 55, 0x20FFFFFF);
        Gui.drawRect(width - 40, height / 2 - 55, width - 40*getCooldownTime(player,1)/hero.getSkillMaxCooldownTime(1), height / 2 - 21, 0x20FFFFFF);
        Gui.drawRect(width - 40, height / 2 - 21, width - 40*getCooldownTime(player,2)/hero.getSkillMaxCooldownTime(2), height, 0x20FFFF55);

        //Bind
        fontRenderer.drawStringWithShadow("", 0, 0, 0xFFFFFF);
        mc.renderEngine.bindTexture(Gui.icons);
    }
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
