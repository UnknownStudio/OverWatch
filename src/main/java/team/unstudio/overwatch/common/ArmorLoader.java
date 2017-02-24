package team.unstudio.overwatch.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import scala.Int;
import team.unstudio.overwatch.item.YuanShiArmor;

/**
 * Created by KevinWalker on 2017/2/1.
 */
public class ArmorLoader {
    public static int YuanshiHelmetID;
    public static int YuanshiChestplateID;
    public static int YuanshiLeggingsID;
    public static int YuanshiBootsID;
    public static Item YuanshiHelmet;
    public static Item YuanshiChestplate;
    public static Item YuanshiLeggings;
    public static Item YuanshiBoots;

    public static int BanZangHelmetID;
    public static int BanzangChestplateID;
    public static int BanzangLeggingsID;
    public static int BanzangBootsID;
    public static Item BanzangHelmet;
    public static Item BanzangChestplate;
    public static Item BanzangLeggings;
    public static Item BanzangBoots;
    public static final ItemArmor.ArmorMaterial EmeraldArmorMaterial = EnumHelper.addArmorMaterial("Armor", Int.MaxValue(), new int[] { 3, 8, 6, 3 },0);
    public ArmorLoader(){
//        源氏
        YuanshiHelmet = new YuanShiArmor(EmeraldArmorMaterial, YuanshiHelmetID, 0,"yuanshi").setUnlocalizedName("yuanshitk");
        GameRegistry.registerItem(YuanshiHelmet, "yuanshitk");

        YuanshiChestplate = new YuanShiArmor(EmeraldArmorMaterial, YuanshiChestplateID, 1,"yuanshi").setUnlocalizedName("yuanshikj");
        GameRegistry.registerItem(YuanshiChestplate, "yuanshikj");

        YuanshiLeggings = new YuanShiArmor(EmeraldArmorMaterial, YuanshiLeggingsID, 2,"yuanshi").setUnlocalizedName("yuanshikz");
        GameRegistry.registerItem(YuanshiLeggings, "yuanshikz");

        YuanshiBoots = new YuanShiArmor(EmeraldArmorMaterial, YuanshiBootsID, 3,"yuanshi").setUnlocalizedName("yuanshixz");
        GameRegistry.registerItem(YuanshiBoots, "yuanshixz");
//        半藏
        BanzangHelmet = new YuanShiArmor(EmeraldArmorMaterial, BanZangHelmetID, 0,"banzang").setUnlocalizedName("bangzangtk");
        GameRegistry.registerItem(BanzangHelmet, "bangzangtk");

        BanzangChestplate = new YuanShiArmor(EmeraldArmorMaterial, BanzangChestplateID, 1,"banzang").setUnlocalizedName("bangzangkj");
        GameRegistry.registerItem(BanzangChestplate, "bangzangkj");

        BanzangLeggings = new YuanShiArmor(EmeraldArmorMaterial, BanzangLeggingsID, 2,"banzang").setUnlocalizedName("banzangkz");
        GameRegistry.registerItem(BanzangLeggings, "banzangkz");

        BanzangBoots = new YuanShiArmor(EmeraldArmorMaterial, BanzangBootsID, 3,"banzang").setUnlocalizedName("bangzangxz");
        GameRegistry.registerItem(BanzangBoots, "bangzangxz");
    }
}
