package com.ow.main;

import com.ow.init.common.BlockLoader;
import com.ow.init.CreativeTabsLoader;
import com.ow.init.common.EntityLoader;
import com.ow.init.common.ItemLoader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    private static int renderChooseBlock;
	public void preInit(FMLPreInitializationEvent event){new CreativeTabsLoader(event);}
    public void init(FMLInitializationEvent event) {
        new ItemLoader(event);
        new BlockLoader(event);
        new EntityLoader(event);
    }
    public void postInit(FMLPostInitializationEvent event) {}
}