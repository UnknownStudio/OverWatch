package com.ow.main;

import com.ow.network.SkillTriggerMessage;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = OverWatch.MODID, name = OverWatch.NAME, version = OverWatch.VERSION)
public class OverWatch {
    @Deprecated
    public static final EventBus EVENT_BUS = new EventBus();
    public static final String MODID = "overwatch";
    public static final String NAME = "OverWatch";
    public static final String VERSION = "1.0.0";
    public static SimpleNetworkWrapper Network;

    @Instance(OverWatch.MODID)
    public static OverWatch instance;

    @SidedProxy(clientSide = "com.ow.main.ClientProxy", serverSide = "com.ow.main.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Network = NetworkRegistry.INSTANCE.newSimpleChannel("OverWatch");
        Network.registerMessage(new SkillTriggerMessage.Handler(),SkillTriggerMessage.class,0, Side.SERVER);
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
