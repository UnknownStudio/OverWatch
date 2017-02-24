package team.unstudio.overwatch.hero;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import team.unstudio.overwatch.client.model.Landmines;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.ItemLoader;
import team.unstudio.overwatch.entity.LandmineEntity;
import team.unstudio.overwatch.entity.SprintEntity;
import team.unstudio.overwatch.entity.YuanShiEEntity;
import team.unstudio.overwatch.item.KuangShuRemote;

/**
 * Created by KevinWalker on 2017/2/8.
 */
public class KuangShu extends AbstractHero {
    private final int skillCD[] = new int[]{400, 300, 1000};
    private final ResourceLocation skillRes[] = new ResourceLocation[]{
            new ResourceLocation("overwatch", "textures/items/bangzang1.png"),
            new ResourceLocation("overwatch", "textures/items/bangzang2.png"),
            new ResourceLocation("overwatch", "textures/items/bangzang3.png")
    };
    private final String skillName[] = new String[]{
            "bangzang1",
            "bangzang2",
            "bangzang3",
    };
    public static LandmineEntity kuangshudl;
    public KuangShu() {
        setUnlocalizedName("bangzang");
        setHeroResourceLocation(new ResourceLocation("overwatch", "textures/items/bangzang.png"));
        setHeroSuit(Items.diamond_helmet, Items.diamond_chestplate, Items.diamond_leggings, Items.diamond_boots);
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
        World world=player.getEntityWorld();
        this.kuangshudl=new LandmineEntity(world,player.posX,player.posY,player.posZ);
        switch (skill) {
            case 0: {
                KuangShuRemote.boom=true;
                player.getEntityWorld().spawnEntityInWorld(this.kuangshudl);
                player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.kuangshure));
                break;
            }
            case 1: {
                break;
            }
            case 2: {

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
                break;
            }
            default:
                break;
        }
    }
}

