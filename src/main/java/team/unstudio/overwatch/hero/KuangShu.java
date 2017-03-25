package team.unstudio.overwatch.hero;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import team.unstudio.overwatch.client.model.Landmines;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.ItemLoader;
import team.unstudio.overwatch.entity.ClampEntity;
import team.unstudio.overwatch.entity.LandmineEntity;
import team.unstudio.overwatch.entity.SprintEntity;
import team.unstudio.overwatch.entity.YuanShiEEntity;
import team.unstudio.overwatch.item.KuangShuRemote;

/**
 * Created by KevinWalker on 2017/2/8.
 */
public class KuangShu extends AbstractHero {
    private final int skillCD[] = new int[]{400, 350, 1000};
    private final ResourceLocation skillRes[] = new ResourceLocation[]{
            new ResourceLocation("overwatch", "textures/items/kuangshu1.png"),
            new ResourceLocation("overwatch", "textures/items/kuangshu2.png"),
            new ResourceLocation("overwatch", "textures/items/kuangshu3.png")
    };
    private final String skillName[] = new String[]{
            "kuangshu1",
            "kuangshu2",
            "kuangshu3",
    };
    public static LandmineEntity kuangshudl;
    public KuangShu() {
        setUnlocalizedName("kuangshu");
        setHeroResourceLocation(new ResourceLocation("overwatch", "textures/items/kuangshu.png"));
        setHeroSuit((ItemArmor) ArmorLoader.KuangshuHelmet, (ItemArmor) ArmorLoader.KuangshuChestplate, (ItemArmor) ArmorLoader.KuangshuLeggings, (ItemArmor) ArmorLoader.KuangshuBoots);
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
        float angle = (player.rotationYaw / 180F) * 3.141593F;
        World world=player.getEntityWorld();
        this.kuangshudl=new LandmineEntity(world,player.posX,player.posY,player.posZ);
        ClampEntity entity =new ClampEntity(player.getEntityWorld(),player.posX,player.posY,player.posZ);
        switch (skill) {
            case 0: {
                KuangShuRemote.boom=true;
                player.getEntityWorld().spawnEntityInWorld(this.kuangshudl);
                player.inventory.addItemStackToInventory(new ItemStack(ItemLoader.kuangshure));
                break;
            }
            case 1: {
                player.getEntityWorld().spawnEntityInWorld(entity);
                System.out.println(-MathHelper.sin(angle)+1+","+player.posY+","+MathHelper.cos(angle)+1);
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

