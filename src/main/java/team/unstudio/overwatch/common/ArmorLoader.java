package team.unstudio.overwatch.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
    public static int YuanshiHelmetID, YuanshiChestplateID, YuanshiLeggingsID, YuanshiBootsID;
    public static Item YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots;

    public static int BanzangHelmetID, BanzangChestplateID, BanzangLeggingsID, BanzangBootsID;
    public static Item BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots;

    public static final ItemArmor.ArmorMaterial EmeraldArmorMaterial = EnumHelper.addArmorMaterial("Armor", Int.MaxValue(), new int[]{3, 8, 6, 3}, 0);

    public ArmorLoader(FMLPreInitializationEvent event) {
//        源氏
        YuanshiHelmet = new YuanShiArmor(EmeraldArmorMaterial, YuanshiHelmetID, 0, "yuanshi", YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots).setUnlocalizedName("yuanshitk");
        YuanshiChestplate = new YuanShiArmor(EmeraldArmorMaterial, YuanshiChestplateID, 1, "yuanshi", YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots).setUnlocalizedName("yuanshikj");
        YuanshiLeggings = new YuanShiArmor(EmeraldArmorMaterial, YuanshiLeggingsID, 2, "yuanshi", YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots).setUnlocalizedName("yuanshikz");
        YuanshiBoots = new YuanShiArmor(EmeraldArmorMaterial, YuanshiBootsID, 3, "yuanshi", YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots).setUnlocalizedName("yuanshixz");
        RegArmor(YuanshiHelmet, YuanshiChestplate, YuanshiLeggings, YuanshiBoots, "yuanshi");
//        半藏
        BanzangHelmet = new YuanShiArmor(EmeraldArmorMaterial, BanzangHelmetID, 0, "banzang", BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots).setUnlocalizedName("bangzangtk");
        BanzangChestplate = new YuanShiArmor(EmeraldArmorMaterial, BanzangChestplateID, 1, "banzang", BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots).setUnlocalizedName("bangzangkj");
        BanzangLeggings = new YuanShiArmor(EmeraldArmorMaterial, BanzangLeggingsID, 2, "banzang", BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots).setUnlocalizedName("banzangkz");
        BanzangBoots = new YuanShiArmor(EmeraldArmorMaterial, BanzangBootsID, 3, "banzang", BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots).setUnlocalizedName("bangzangxz");
        RegArmor(BanzangHelmet, BanzangChestplate, BanzangLeggings, BanzangBoots, "banzang");
    }

    void RegArmor(Item item1, Item item2, Item item3, Item item4, String name) {
        GameRegistry.registerItem(item1, name + "tk");
        GameRegistry.registerItem(item2, name + "kj");
        GameRegistry.registerItem(item3, name + "kz");
        GameRegistry.registerItem(item4, name + "xz");
    }
}
