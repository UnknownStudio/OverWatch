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
    public String name;
    public YuanShiArmor(ItemArmor.ArmorMaterial material, int id, int slot,String name)
    {
        super(material, id, slot);
        this.name=name;
        setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
        if (slot == 0)
            setTextureName("overwatch:"+name+"tk");
        else if (slot == 1)
            setTextureName("overwatch:"+name+"kj");
        else if (slot == 2)
            setTextureName("overwatch:"+name+"kz");
        else if (slot == 3)
            setTextureName("overwatch:"+name+"xz");
    }
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type,String txtname)
    {
        this.name=txtname;
        if ((itemstack.getItem() == ArmorLoader.YuanshiHelmet) || (itemstack.getItem() == ArmorLoader.YuanshiChestplate) || (itemstack.getItem() == ArmorLoader.YuanshiBoots))
            return "overwatch:textures/models/armor/"+txtname+"_1.png";
        if (itemstack.getItem() == ArmorLoader.YuanshiLeggings) {
            return "overwatch:textures/models/armor/"+txtname+"_2.png";
        }
        return null;
    }
}
