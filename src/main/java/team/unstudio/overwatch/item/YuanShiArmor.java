package team.unstudio.overwatch.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import team.unstudio.overwatch.client.creativetabs.CreativeTabsLoader;
import team.unstudio.overwatch.common.ArmorLoader;
import team.unstudio.overwatch.common.OverWatch;

/**
 * Created by KevinWalker on 2017/2/1.
 */
public class YuanShiArmor extends ItemArmor {
    private static Object shiftedIndex;

    public YuanShiArmor(ItemArmor.ArmorMaterial material, int id, int slot)
    {
        super(material, id, slot);
        setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
        if (slot == 0)
            setTextureName("overwatch:yuanshitk");
        else if (slot == 1)
            setTextureName("overwatch:yuanshikj");
        else if (slot == 2)
            setTextureName("overwatch:yuanshikz");
        else if (slot == 3)
            setTextureName("overwatch:yuanshixz");
    }
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
    {
        if ((itemstack.getItem() == ArmorLoader.YuanshiHelmet) || (itemstack.getItem() == ArmorLoader.YuanshiChestplate) || (itemstack.getItem() == ArmorLoader.YuanshiBoots))
            return "overwatch:textures/models/armor/yuanshi_layer_1.png";
        if (itemstack.getItem() == ArmorLoader.YuanshiLeggings) {
            return "overwatch:textures/models/armor/yuanshi_layer_2.png";
        }
        return null;
    }
}
