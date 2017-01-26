package com.ow.event;

import com.ow.skill.SkillBase;
import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by winston_wang on 2017/1/25.
 */
@Cancelable
public class SkillTiggerEvent extends net.minecraftforge.event.entity.player.PlayerEvent {
    public final World tiggerWorld;
    public final EntityPlayer thePlayer;
    public final int skill;
    public final SkillBase skill_from;
    public SkillTiggerEvent(EntityPlayer player, World world, int skillId, SkillBase skill_list) {
        super(player);
        thePlayer = player;
        tiggerWorld = world;
        skill = skillId;
        skill_from = skill_list;
    }
}
