package team.unstudio.overwatch.hero;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import team.unstudio.overwatch.entity.SprintEntity;
import team.unstudio.overwatch.entity.YuanShiEEntity;

/**
 * Created by winston_wang on 2017/1/23.
 */
public class YuanShi extends AbstractHero {
    private final int skillCD[] = new int[]{130, 300, 1000};
    private final ResourceLocation skillRes[] = new ResourceLocation[]{
            new ResourceLocation("overwatch", "textures/items/yuanshi1.png"),
            new ResourceLocation("overwatch", "textures/items/yuanshi2.png"),
            new ResourceLocation("overwatch", "textures/items/yuanshi3.png")
    };
    private final String skillName[] = new String[]{
            "yuanshi1",
            "yuanshi2",
            "yuanshi3",
    };

    public YuanShi() {
        setUnlocalizedName("yuanshi");
        setHeroResourceLocation(new ResourceLocation("overwatch", "textures/items/yuanshi.png"));
        setHeroSuit((ItemArmor) ArmorLoader.YuanshiHelmet, (ItemArmor) ArmorLoader.YuanshiChestplate, (ItemArmor) ArmorLoader.YuanshiLeggings, (ItemArmor) ArmorLoader.YuanshiBoots);
    }

    @Override
    public ResourceLocation getSkillResourceLocation(int skill) {
        return skillRes[skill];
    }

    @Override
    public String getSkillUnlocalizedName(int skill) {
        return skillName[skill];
    }

    @Override
    public int getSkillMaxCooldownTime(int skill) {
        return skillCD[skill];
    }

    @Override
    public void playerTrigger(int skill, EntityPlayer player) {
        SprintEntity entity = new SprintEntity(player.getEntityWorld(), player, 4);
        YuanShiEEntity entity2 = new YuanShiEEntity(player.getEntityWorld(), player.posX, player.posY, player.posZ);
        switch (skill) {
            case 0: {
                float angle = (player.rotationYaw / 180F) * 3.141593F;
                float angle2 = (-player.rotationPitch / 180F) * 3.141593F;
                final float speed = 2.5f;
                entity.motionY = speed * MathHelper.sin(angle2);
                entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle);
                entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
                player.getEntityWorld().spawnEntityInWorld(entity);
                break;
            }
            case 1: {
                player.getEntityWorld().spawnEntityInWorld(entity2);
                break;
            }
            case 2: {
                player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.dragonsword));

                break;
            }
            default:
                break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void playerTriggerInClient(int skill, EntityPlayer player) {
        switch (skill) {
            case 0: {
                player.motionX = -Math.sin(Math.toRadians(player.rotationYaw)) * 2.5;
                player.motionZ = Math.cos(Math.toRadians(player.rotationYaw)) * 2.5;
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                player.addPotionEffect(new PotionEffect(14, 200, 200));
                break;
            }
            default:
                break;
        }
    }
}
