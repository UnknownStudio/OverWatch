package com.ow.skill;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;

/**
 * Created by winston_wang on 2017/1/23.
 */
public class HeroSkill {
    public static ArrayList<ItemArmor[]> skill_armor = new ArrayList();
    public static ArrayList<SkillBase> skills = new ArrayList();
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderOverly(RenderGameOverlayEvent.Pre event){
        Minecraft mc = Minecraft.getMinecraft();
        final int width = event.resolution.getScaledWidth();
        final int height = event.resolution.getScaledWidth();
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        for(int i = 0;i<skill_armor.size();i++){
            ItemArmor stack_head = skill_armor.get(i)[3];
            ItemArmor stack_chest = skill_armor.get(i)[2];
            ItemArmor stack_leg = skill_armor.get(i)[1];
            ItemArmor stack_boots = skill_armor.get(i)[0];
            if(player.getCurrentArmor(0)!= null
                    &&player.getCurrentArmor(1)!= null
                    &&player.getCurrentArmor(2)!= null
                    &&player.getCurrentArmor(3)!= null
                    &&player.getCurrentArmor(0).getItem().getUnlocalizedName().equals(stack_head.getUnlocalizedName())
                    &&player.getCurrentArmor(1).getItem().getUnlocalizedName().equals(stack_chest.getUnlocalizedName())
                    &&player.getCurrentArmor(2).getItem().getUnlocalizedName().equals(stack_leg.getUnlocalizedName())
                    &&player.getCurrentArmor(3).getItem().getUnlocalizedName().equals(stack_boots.getUnlocalizedName())
                    ){
                FontRenderer fontRenderer = mc.fontRenderer;
                fontRenderer.drawStringWithShadow(skills.get(i).getName(),width-30,height/2-100,0xFFFFFF);
                fontRenderer.drawStringWithShadow("大招",width-31,height/2-100+40*2,0xFFFFFF);
                Gui.drawRect(width-40,height/2-100,width,height-100,0x20666666);
                mc.renderEngine.bindTexture(skills.get(i).resourceLocations[0]);
                Gui.func_146110_a(width-40+2,height/2-100+12,0,0,30,30,30,30);
                mc.renderEngine.bindTexture(skills.get(i).resourceLocations[1]);
                Gui.func_146110_a(width-40+2,height/2-100+2+42,0,0,30,30,30,30);
                mc.renderEngine.bindTexture(skills.get(i).resourceLocations[2]);
                Gui.func_146110_a(width-40+2,height/2-100+2+42*2,0,0,30,30,30,30);
                mc.renderEngine.bindTexture(skills.get(i).hero_res);
                Gui.func_146110_a(0,0,0,0,30,30,30,30);
                fontRenderer.drawStringWithShadow(skills.get(i).hero_name,32,12,0xFFFFFF);
                //CD
                try{
                    if(player.getCurrentArmor(1).getTagCompound().getInteger("CD_1") <= 40){
                        Gui.drawRect(width-40,height/2-100,width-player.getCurrentArmor(1).getTagCompound().getInteger("CD_1"),height/2-55,0x20FFFFFF);
                    }if(player.getCurrentArmor(1).getTagCompound().getInteger("CD_2") <= 40){
                        Gui.drawRect(width-40,height/2-55,width-player.getCurrentArmor(1).getTagCompound().getInteger("CD_2"),height/2-21,0x20FFFFFF);
                    }if(player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") >= 0
                            &&player.getCurrentArmor(1).getTagCompound().getInteger("CD_3") <= 40){
                        Gui.drawRect(width-40,height/2-21,width-40+player.getCurrentArmor(1).getTagCompound().getInteger("CD_3")*(40/skills.get(i).skill_cd[2]),height,0x20FFFF55);
                    }
                }catch(NullPointerException e){
                    if(player.getCurrentArmor(1)!= null
                     &&player.getCurrentArmor(1).getTagCompound()!=null){
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_1",0);
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_2",0);
                        player.getCurrentArmor(1).getTagCompound().setInteger("CD_3",0);
                    }else if(player.getCurrentArmor(1).getTagCompound() == null){
                        player.getCurrentArmor(1).stackTagCompound = new NBTTagCompound();
                    }
                }
                //Bind
                fontRenderer.drawStringWithShadow("",0,0,0xFFFFFF);
                mc.renderEngine.bindTexture(Gui.icons);
            }
        }
    }
    public static void addSkill(ItemArmor[] armors,SkillBase skill){
        skill_armor.add(armors);
        skills.add(skill);
    }
    public static ArrayList getSkill(){
        return skills;
    }
}
