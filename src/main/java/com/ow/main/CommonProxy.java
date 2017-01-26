package com.ow.main;

import com.ow.event.SkillTiggerEvent;
import com.ow.init.CreativeTabsLoader;
import com.ow.init.common.BlockLoader;
import com.ow.init.common.EntityLoader;
import com.ow.init.common.ItemLoader;
import com.ow.skill.HeroSkill;
import com.ow.skill.testskill;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;


public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event){new CreativeTabsLoader(event);}
    public void init(FMLInitializationEvent event) {
        new ItemLoader(event);
        new BlockLoader(event);
        new EntityLoader(event);
        MinecraftForge.EVENT_BUS.register(new HeroSkill());
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        ItemArmor[] armor = {Items.iron_helmet,Items.iron_chestplate,Items.iron_leggings,Items.iron_boots};
        HeroSkill.addSkill(armor,new testskill());
    }
    public void postInit(FMLPostInitializationEvent event) {}
    //W-J-R OW-Skill-Engine Start **Do not edit**
    @SubscribeEvent
    //@SideOnly(Side.SERVER)
    public void keyListener(InputEvent.KeyInputEvent event) {
        EntityPlayer player = null;
        for(int i = 0;i<MinecraftServer.getServer().getEntityWorld().playerEntities.size();i++){
            if((EntityPlayer) MinecraftServer.getServer().getEntityWorld().playerEntities.get(i) == Minecraft.getMinecraft().thePlayer){
                player = (EntityPlayer) MinecraftServer.getServer().getEntityWorld().playerEntities.get(i);
            }else{
                player = MinecraftServer.getServer().getEntityWorld().getPlayerEntityByName(Minecraft.getMinecraft().thePlayer.getCommandSenderName());
            }
        }
        //if(!player.worldObj.isRemote) {
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
                                    player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.kuangshuwq));
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
        //}
    }
    @SubscribeEvent
    public void onTikck(TickEvent.PlayerTickEvent event){
        //Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = event.player;
        for(int i = 0;i<HeroSkill.skill_armor.size();i++){
            ItemArmor stack_head = HeroSkill.skill_armor.get(i)[3];
            ItemArmor stack_chest = HeroSkill.skill_armor.get(i)[2];
            ItemArmor stack_leg = HeroSkill.skill_armor.get(i)[1];
            ItemArmor stack_boots = HeroSkill.skill_armor.get(i)[0];
            if(player.getCurrentArmor(0)!= null
                    &&player.getCurrentArmor(1)!= null
                    &&player.getCurrentArmor(2)!= null
                    &&player.getCurrentArmor(3)!= null
                    &&player.getCurrentArmor(0).getItem().getUnlocalizedName().equals(stack_head.getUnlocalizedName())
                    &&player.getCurrentArmor(1).getItem().getUnlocalizedName().equals(stack_chest.getUnlocalizedName())
                    &&player.getCurrentArmor(2).getItem().getUnlocalizedName().equals(stack_leg.getUnlocalizedName())
                    &&player.getCurrentArmor(3).getItem().getUnlocalizedName().equals(stack_boots.getUnlocalizedName())
                    ) {

                try{
                    if(player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") != 0){
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_1",player.getCurrentArmor(1).getTagCompound().getInteger("CD_1")-1);
                    }if(player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") != 0){
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_2",player.getCurrentArmor(1).getTagCompound().getInteger("CD_2")-1);
                    }
                }catch(NullPointerException e){
                    if(player.getCurrentArmor(1)!= null
                            &&player.getCurrentArmor(1).getTagCompound()!=null){
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_1", 0);
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_2", 0);
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_3", 0);
                    }else if(player.getCurrentArmor(1).getTagCompound() == null){
                        player.getCurrentArmor(1).stackTagCompound = new NBTTagCompound();
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public void onHurt(AttackEntityEvent event){
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