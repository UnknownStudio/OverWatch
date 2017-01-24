package com.ow.init.client;

import com.ow.init.common.BlockLoader;
import com.ow.init.common.EntityLoader;
import com.ow.init.common.ItemLoader;
import com.ow.main.ClientProxy;
import com.ow.render.BlockRender;
import com.ow.render.RenderChooseBlock;
import com.ow.tileentity.ChooseBlockTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class RenderLoader {
	public RenderLoader(FMLPreInitializationEvent event)
    { 
		registerRender();
		registerTexture();
    }
	private static void registerRender(){
		ClientProxy.renderChooseBlock = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(ClientProxy.renderChooseBlock , new RenderChooseBlock());
		ClientRegistry.bindTileEntitySpecialRenderer(ChooseBlockTileEntity.class, new BlockRender());
	}
	private static void registerTexture(){
		BlockLoader.registerRenders();
        ItemLoader.registerRenders();
        EntityLoader.registerRenders();
	}
}
