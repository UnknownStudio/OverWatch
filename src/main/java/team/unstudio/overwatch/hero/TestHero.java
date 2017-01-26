package team.unstudio.overwatch.hero;

import team.unstudio.overwatch.common.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

/**
 * Created by winston_wang on 2017/1/23.
 */
public class TestHero extends AbstractHero {

    private final int skillCD[] = new int[]{200,200,4};
    private final ResourceLocation skillRes[] = new ResourceLocation[]{
            new ResourceLocation("overwatch","textures/items/darts.png"),
            new ResourceLocation("overwatch","textures/items/darts.png"),
            new ResourceLocation("overwatch","textures/items/darts.png"),
            new ResourceLocation("overwatch","textures/items/darts.png")
    };
    private final String skillName[] = new String[]{
            "test1",
            "test2",
            "test3",
            "test4"
    };

    public TestHero(){
        setUnlocalizedName("test");
        setHeroResourceLocation(new ResourceLocation("overwatch","textures/items/darts.png"));
        setHeroSuit(Items.iron_helmet,Items.iron_chestplate,Items.iron_leggings,Items.iron_boots);
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
    public void playerTigger(int skill, EntityPlayer player) {
        switch (skill) {
            case 0: {
                player.addPotionEffect(new PotionEffect(1, 200, 200));
                player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.dart));
                break;
            }
            case 1: {
                player.addPotionEffect(new PotionEffect(10, 200, 200));
                break;
            }
            case 2: {
                player.addPotionEffect(new PotionEffect(14, 200, 200));
                break;
            }
            default: break;
        }
    }
}
