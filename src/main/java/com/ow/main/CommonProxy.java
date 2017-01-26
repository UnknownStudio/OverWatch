package com.ow.main;

import com.ow.init.CreativeTabsLoader;
import com.ow.init.common.BlockLoader;
import com.ow.init.common.EntityLoader;
import com.ow.init.common.ItemLoader;
import com.ow.skill.HeroManager;
import com.ow.skill.TestHero;
import com.ow.tileentity.ChooseBlockTileEntity;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new CreativeTabsLoader(event);
    }

    public void init(FMLInitializationEvent event) {
        new ItemLoader(event);
        new BlockLoader(event);
        new EntityLoader(event);

        GameRegistry.registerTileEntity(ChooseBlockTileEntity.class,"TileChooseBlock");

        HeroManager.addHero(new TestHero());
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}