package team.unstudio.overwatch.hero;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.ItemLoader;
import team.unstudio.overwatch.entity.DragonEntity;
import team.unstudio.overwatch.entity.SprintEntity;
import team.unstudio.overwatch.entity.YuanShiEEntity;

/**
 * Created by KevinWalker on 2017/2/6.
 */
public class BanZang extends AbstractHero {
    public static int skillNum=0;
    private final int skillCD[] = new int[]{130, 350, 1000};
    private final ResourceLocation skillRes[] = new ResourceLocation[]{
            new ResourceLocation("overwatch", "textures/items/banzang1.png"),
            new ResourceLocation("overwatch", "textures/items/banzang2.png"),
            new ResourceLocation("overwatch", "textures/items/banzang3.png")
    };
    private final String skillName[] = new String[]{
            "banzang1",
            "banzang2",
            "banzang3",
    };

    public BanZang() {
        setUnlocalizedName("banzang");
        setHeroResourceLocation(new ResourceLocation("overwatch", "textures/items/banzang.png"));
        setHeroSuit((ItemArmor) ArmorLoader.BanzangHelmet, (ItemArmor) ArmorLoader.BanzangChestplate, (ItemArmor) ArmorLoader.BanzangLeggings, (ItemArmor) ArmorLoader.BanzangBoots);
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
        DragonEntity entity = new DragonEntity(player.getEntityWorld(), player);
        switch (skill) {
            case 0: {
                this.skillNum=1;
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                player.getEntityWorld().spawnEntityInWorld(entity);
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
