package com.ow.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = OverWatch.MODID, name = OverWatch.NAME, version = OverWatch.VERSION)
public class OverWatch {
	public static final String MODID = "overwatch";
    public static final String NAME = "Over Watch";
    public static final String VERSION = "1.0.0v";
    @Instance(OverWatch.MODID)
    public static OverWatch instance;
    @SidedProxy(clientSide = "com.ow.main.ClientProxy",
                serverSide = "com.ow.main.CommonProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){proxy.preInit(event);}
    @EventHandler
    public void init(FMLInitializationEvent event){proxy.init(event);}
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {proxy.postInit(event);}
}
