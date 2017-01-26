package com.ow.hero;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

/**
 * Created by winston_wang on 2017/1/23.
 */
public abstract class AbstractHero {

    private String unlocalizedName;

    public AbstractHero(){}

    /**
     * 获取本地化的名称
     * @return
     */
    public String getLocalizedName(){
        return StatCollector.translateToLocal("hero."+getUnlocalizedName()+".name");
    }

    /**
     * 获取未本地化的名称
     * @return
     */
    public String getUnlocalizedName(){
        return unlocalizedName;
    }

    /**
     * 设置未本地化名称
     * @param unlocalizedName
     */
    public void setUnlocalizedName(String unlocalizedName){
        this.unlocalizedName = unlocalizedName;
    }

    @SideOnly(Side.CLIENT)
    private ResourceLocation heroResourceLocation;

    /**
     * 获取英雄资源
     * @return
     */
    @SideOnly(Side.CLIENT)
    public ResourceLocation getHeroResourceLocation(){
        return heroResourceLocation;
    }

    /**
     * 设置英雄资源
     * @param heroResourceLocation
     */
    @SideOnly(Side.CLIENT)
    public void setHeroResourceLocation(ResourceLocation heroResourceLocation){
        this.heroResourceLocation = heroResourceLocation;
    }

    /**
     * 获取对应技能资源
     * @param skill
     * @return
     */
    @SideOnly(Side.CLIENT)
    public abstract ResourceLocation getSkillResourceLocation(int skill);

    /**
     * 获取技能未本地化名称
     * @param skill
     * @return
     */
    public abstract String getSkillUnlocalizedName(int skill);

    /**
     * 获取技能最长冷却时间
     * @param skill
     * @return
     */
    public abstract int getSkillMaxCooldownTime(int skill);

    /**
     * 获取技能本地化名称
     * @param skill
     * @return
     */
    public String getSkillLocalizedName(int skill){
        return StatCollector.translateToLocal("skill."+getSkillUnlocalizedName(skill)+".name");
    }

    public abstract void playerTigger(int skill, EntityPlayer player);

    private ItemArmor heroSuit[] = new ItemArmor[4];

    /**
     * 判断玩家是否穿套装
     * @param player
     * @return
     */
    public boolean isHeroSuit(EntityPlayer player){
        for(int i=0;i<=3;i++) if(player.getCurrentArmor(i)==null||!heroSuit[i].equals(player.getCurrentArmor(i).getItem())) return false;
        return true;
    }

    /**
     * 设置英雄套装
     * @param helmet
     */
    public void setHeroSuit(ItemArmor helmet,ItemArmor chestplates,ItemArmor legging,ItemArmor boots){
        if(helmet==null||chestplates==null||legging==null||boots==null) throw new IllegalArgumentException("NULL!");

        heroSuit[0]=helmet;
        heroSuit[1]=chestplates;
        heroSuit[2]=legging;
        heroSuit[3]=boots;
    }
}
