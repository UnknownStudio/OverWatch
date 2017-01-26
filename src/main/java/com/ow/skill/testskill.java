package com.ow.skill;

import com.ow.init.common.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

/**
 * Created by winston_wang on 2017/1/23.
 */
public class testskill extends SkillBase{
    public testskill(){
        setName("测试");
        Skill1(new ResourceLocation("overwatch","textures/items/darts.png"),"test1",20*10);
        Skill2(new ResourceLocation("overwatch","textures/items/darts.png"),"test2",20*10);
        Skill3(new ResourceLocation("overwatch","textures/items/darts.png"),"test3",4);
        SkillPassive(new ResourceLocation("overwatch","textures/items/darts.png"),"test4");
        skillHero(new ResourceLocation("overwatch","textures/items/darts.png"),"测试英雄");
    }

    @Override
    public void playerTigger(int skill, EntityPlayer player) {
        if (skill == 0) {
            player.addPotionEffect(new PotionEffect(1, 200, 200));
            player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.dart));
        }
        if (skill == 1) {
            player.addPotionEffect(new PotionEffect(10, 200, 200));
        }
        if (skill == 2) {
            player.addPotionEffect(new PotionEffect(14, 200, 200));
        }
        System.out.println("skill" + (skill + 1));
    }
}
