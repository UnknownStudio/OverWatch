package com.ow.init;

import com.ow.creativeTabs.CreativeTabWQ;
import com.ow.creativeTabs.CreativeTabsOW;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
	public static CreativeTabs CreativeTabsOW;
	public static CreativeTabs CreativeTabsWQ;
    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	CreativeTabsOW = new CreativeTabsOW();
    	CreativeTabsWQ=new CreativeTabWQ();
    }
}
