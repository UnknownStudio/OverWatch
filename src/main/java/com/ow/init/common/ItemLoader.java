package com.ow.init.common;

import com.ow.init.CreativeTabsLoader;
import com.ow.item.ItemDart;
import com.ow.item.KuangShuWQ;
import com.ow.main.OverWatch;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

public class ItemLoader {
	//Items
	public static ItemDart dart = new ItemDart();
	public static Item tb = new Item();
	public static KuangShuWQ kuangshuwq = new KuangShuWQ();
	//Methods start
	public  ItemLoader(FMLInitializationEvent event)
	{
		register(dart, "darts");
		register(tb, "overwatchtubiao");
		register(kuangshuwq, "kuangshuwq");
	}
	
	private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
        item.setUnlocalizedName(name);
        item.setCreativeTab(CreativeTabsLoader.CreativeTabsOW);
    }
	@SideOnly(Side.CLIENT)
	public static void registerRenders(){
		bindTexture(dart,"darts");
		bindTexture(tb,"overwatchtubiao");
	}
	private static void bindTexture(Item item, String name){
		item.setTextureName(OverWatch.MODID+":"+name);
	}
}
