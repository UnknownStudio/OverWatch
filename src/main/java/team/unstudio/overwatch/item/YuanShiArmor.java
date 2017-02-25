package team.unstudio.overwatch.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
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
    public String textname;
    public YuanShiArmor(ItemArmor.ArmorMaterial material, int id, int slot,String name,Item Helmet,Item Chestplate,Item Leggings,Item Boots)
    {
        super(material, id, slot);
        this.textname=name;
        this.setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
        System.out.println(this.textname);
        if (slot == 0)
            this.setTextureName("overwatch:"+name+"tk");
        else if (slot == 1)
            this.setTextureName("overwatch:"+name+"kj");
        else if (slot == 2)
            this.setTextureName("overwatch:"+name+"kz");
        else if (slot == 3)
            this.setTextureName("overwatch:"+name+"xz");
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
        if ((itemstack.getItem() == ArmorLoader.YuanshiHelmet) || (itemstack.getItem() == ArmorLoader.YuanshiChestplate) || (itemstack.getItem() == ArmorLoader.YuanshiBoots) || (itemstack.getItem() == ArmorLoader.YuanshiLeggings))
            return "overwatch:textures/models/armor/yuanshi_layer_1.png";
        return null;
    }
}