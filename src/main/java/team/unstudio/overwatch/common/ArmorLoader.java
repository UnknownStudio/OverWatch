package team.unstudio.overwatch.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
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
    public static ItemArmor.ArmorMaterial EmeraldArmorMaterial = EnumHelper.addArmorMaterial("Armor", 2147483647, new int[] { 3, 8, 6, 3 },0);
    public ArmorLoader(){
        YuanshiHelmet = new YuanShiArmor(EmeraldArmorMaterial, YuanshiHelmetID, 0).setUnlocalizedName("yuanshitk");
        GameRegistry.registerItem(YuanshiHelmet, "yuanshitk");

        YuanshiChestplate = new YuanShiArmor(EmeraldArmorMaterial, YuanshiChestplateID, 1).setUnlocalizedName("yuanshikj");
        GameRegistry.registerItem(YuanshiChestplate, "yuanshikj");

        YuanshiLeggings = new YuanShiArmor(EmeraldArmorMaterial, YuanshiLeggingsID, 2).setUnlocalizedName("yuanshikz");
        GameRegistry.registerItem(YuanshiLeggings, "yuanshikz");

        YuanshiBoots = new YuanShiArmor(EmeraldArmorMaterial, YuanshiBootsID, 3).setUnlocalizedName("yuanshixz");
        GameRegistry.registerItem(YuanshiBoots, "yuanshixz");
    }
}
