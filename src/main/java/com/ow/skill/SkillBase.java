package com.ow.skill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by winston_wang on 2017/1/23.
 */
public abstract class SkillBase {
    private String name;
    public String[] skill_name = new String[4];
    public int[] skill_cd = new int[4];
    public ResourceLocation hero_res = new ResourceLocation("overwatch","textures/hero/null.png");
    public String hero_name = "";
    public ResourceLocation[] resourceLocations = new ResourceLocation[4];
    public final String getName(){
        return name;
    }
    public final void setName(String n){
        name = n;
    }
    public final void Skill1(ResourceLocation rl, String name,int CD){
        resourceLocations[0]=rl;
        skill_name[0]=name;
        skill_cd[0] = CD;
    }
    public final void Skill2(ResourceLocation rl, String name,int CD){
        resourceLocations[1]=rl;
        skill_name[1]=name;
        skill_cd[1] = CD;
    }
    public final void Skill3(ResourceLocation rl, String name,int COUNT){
        resourceLocations[2]=rl;
        skill_name[2]=name;
        skill_cd[2] = COUNT;
    }
    public final void SkillPassive(ResourceLocation rl, String name){
        resourceLocations[3]=rl;
        skill_name[3]=name;
    }
    public final void skillHero(ResourceLocation rl, String name){
        hero_res=rl;
        hero_name=name;
    }
    public void playerTigger(int skill,EntityPlayer player){}
}
