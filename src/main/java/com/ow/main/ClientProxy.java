package com.ow.main;

import com.ow.event.SkillTiggerEvent;
import com.ow.gui.YourGui;
import com.ow.init.client.RenderLoader;
import com.ow.skill.HeroSkill;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy{
	public static int renderChooseBlock;
	public static final KeyBinding kbShowNewGui = new KeyBinding("overwatch.key.shownewgui", Keyboard.KEY_H, "overwatch.keytitle");
    public static final KeyBinding sk1 = new KeyBinding("overwatch.key..sk1", Keyboard.KEY_C, "overwatch.keytitle");
    public static final KeyBinding sk2 = new KeyBinding("overwatch.key.sk2", Keyboard.KEY_V, "overwatch.keytitle");
    public static final KeyBinding sk3 = new KeyBinding("overwatch.key.sk3", Keyboard.KEY_B, "overwatch.keytitle");
	@Override
	public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    	new RenderLoader(event);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        MinecraftForge.EVENT_BUS.register(new HeroSkill());
        ClientRegistry.registerKeyBinding(kbShowNewGui);
        ClientRegistry.registerKeyBinding(sk1);
        ClientRegistry.registerKeyBinding(sk2);
        ClientRegistry.registerKeyBinding(sk3);
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
    //W-J-R OW-Skill-Engine Start **Do not edit**
    @SubscribeEvent
    public void keyListener(InputEvent.KeyInputEvent event) {
        if (ClientProxy.kbShowNewGui.isPressed())
        {
            Minecraft mc = Minecraft.getMinecraft();
            mc.displayGuiScreen(new YourGui(mc.currentScreen));
        }
        EntityPlayer player = null;
        if(Minecraft.getMinecraft().isSingleplayer()) {
            for (int i = 0; i < MinecraftServer.getServer().getEntityWorld().playerEntities.size(); i++) {
                if ((EntityPlayer) MinecraftServer.getServer().getEntityWorld().playerEntities.get(i) == Minecraft.getMinecraft().thePlayer) {
                    player = (EntityPlayer) MinecraftServer.getServer().getEntityWorld().playerEntities.get(i);
                } else {
                    player = MinecraftServer.getServer().getEntityWorld().getPlayerEntityByName(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
                }
            }
        }else {
            player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
        }
            for (int i = 0; i < HeroSkill.skill_armor.size(); i++) {
                ItemArmor stack_head = HeroSkill.skill_armor.get(i)[3];
                ItemArmor stack_chest = HeroSkill.skill_armor.get(i)[2];
                ItemArmor stack_leg = HeroSkill.skill_armor.get(i)[1];
                ItemArmor stack_boots = HeroSkill.skill_armor.get(i)[0];
                if (player.getCurrentArmor(0) != null
                        && player.getCurrentArmor(1) != null
                        && player.getCurrentArmor(2) != null
                        && player.getCurrentArmor(3) != null
                        && player.getCurrentArmor(0).getItem().getUnlocalizedName().equals(stack_head.getUnlocalizedName())
                        && player.getCurrentArmor(1).getItem().getUnlocalizedName().equals(stack_chest.getUnlocalizedName())
                        && player.getCurrentArmor(2).getItem().getUnlocalizedName().equals(stack_leg.getUnlocalizedName())
                        && player.getCurrentArmor(3).getItem().getUnlocalizedName().equals(stack_boots.getUnlocalizedName())
                        ) {
                    if (player.getCurrentArmor(1) != null
                            && player.getCurrentArmor(1).getTagCompound() != null) {
                        if (ClientProxy.sk1.isPressed()) {
                            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") == 0) {
                                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 0, HeroSkill.skills.get(i));
                                OverWatch.EVENT_BUS.post(sevent);
                                if (!sevent.isCanceled()) {
                                    HeroSkill.skills.get(i).playerTigger(0, player);
                                    player.getCurrentArmor(1).getTagCompound().setInteger("CD_1", HeroSkill.skills.get(i).skill_cd[0]);
                                }
                            }
                        }
                        if (ClientProxy.sk2.isPressed()) {
                            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") == 0) {
                                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 1, HeroSkill.skills.get(i));
                                OverWatch.EVENT_BUS.post(sevent);
                                if (!sevent.isCanceled()) {
                                    HeroSkill.skills.get(i).playerTigger(1, player);
                                    player.getCurrentArmor(1).getTagCompound().setInteger("CD_2", HeroSkill.skills.get(i).skill_cd[1]);
                                }
                            }
                        }
                        if (ClientProxy.sk3.isPressed()) {
                            if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") >= HeroSkill.skills.get(i).skill_cd[2]) {
                                SkillTiggerEvent sevent = new SkillTiggerEvent(player, player.worldObj, 2, HeroSkill.skills.get(i));
                                OverWatch.EVENT_BUS.post(sevent);
                                if (!sevent.isCanceled()) {
                                    HeroSkill.skills.get(i).playerTigger(2, player);
                                    player.getCurrentArmor(1).getTagCompound().setInteger("CD_3", 0);
                                }
                            }
                        }
                    }
                }
            }
    }
    @SubscribeEvent
    public void onHurt(AttackEntityEvent event) {
        if (!event.entityPlayer.worldObj.isRemote) {
            EntityPlayer player = event.entityPlayer;
            for (int i = 0; i < HeroSkill.skill_armor.size(); i++) {
                ItemArmor stack_head = HeroSkill.skill_armor.get(i)[3];
                ItemArmor stack_chest = HeroSkill.skill_armor.get(i)[2];
                ItemArmor stack_leg = HeroSkill.skill_armor.get(i)[1];
                ItemArmor stack_boots = HeroSkill.skill_armor.get(i)[0];
                if (player.getCurrentArmor(0) != null
                        && player.getCurrentArmor(1) != null
                        && player.getCurrentArmor(2) != null
                        && player.getCurrentArmor(3) != null
                        && player.getCurrentArmor(0).getItem().getUnlocalizedName().equals(stack_head.getUnlocalizedName())
                        && player.getCurrentArmor(1).getItem().getUnlocalizedName().equals(stack_chest.getUnlocalizedName())
                        && player.getCurrentArmor(2).getItem().getUnlocalizedName().equals(stack_leg.getUnlocalizedName())
                        && player.getCurrentArmor(3).getItem().getUnlocalizedName().equals(stack_boots.getUnlocalizedName())
                        ) {
                    try {
                        if (player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") < HeroSkill.skills.get(i).skill_cd[2]) {
                            player.getCurrentArmor(1).getTagCompound().setInteger("CD_3", player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") + 1);
                        }
                    } catch (NullPointerException e) {
                        if (player.getCurrentArmor(1) != null
                                && player.getCurrentArmor(1).getTagCompound() != null) {
                            player.getCurrentArmor(1).getTagCompound().setInteger("CD_3", 0);
                        }else if(player.getCurrentArmor(1).getTagCompound() == null){
                            player.getCurrentArmor(1).stackTagCompound = new NBTTagCompound();
                        }
                    }
                }
            }
        }
    }
}
