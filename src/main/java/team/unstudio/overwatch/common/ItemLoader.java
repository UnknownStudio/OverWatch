package team.unstudio.overwatch.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import team.unstudio.overwatch.client.creativetabs.CreativeTabsLoader;
import team.unstudio.overwatch.item.*;

public class ItemLoader {
    //物品
    public static ItemDart dart = new ItemDart();
    public static Item tb = new Item();
    public static KuangShuWQ kuangshuwq = new KuangShuWQ();
    public static KuangShuRemote kuangshure = new KuangShuRemote();

    //武器
    public static final Item.ToolMaterial knife = EnumHelper.addToolMaterial("knife", 2, 2, 6.0F, 16.0F, 14);
    public static DragonSword dragonsword = new DragonSword(knife, Items.diamond_sword);
    public static BangZangBow banzangbow = new BangZangBow();

    public ItemLoader(FMLInitializationEvent event) {
        register(dart, "darts");
        register(tb, "overwatchtubiao");
        register(kuangshuwq, "kuangshuwq");
        register(dragonsword, "dragonsword");
        register(kuangshure, "kuangshure");
        register(banzangbow, "banzangbow");
    }

    private static void register(Item item, String name) {
        GameRegistry.registerItem(item, name);
        item.setUnlocalizedName(name);
        item.setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        bindTexture(dart, "darts");
        bindTexture(tb, "overwatchtubiao");
        bindTexture(dragonsword, "dragonsword");
        bindTexture(kuangshure, "kuangshure");
    }

    private static void bindTexture(Item item, String name) {
        item.setTextureName(OverWatch.MODID + ":" + name);
    }
}

