package team.unstudio.overwatch.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import team.unstudio.overwatch.client.render.BlockRender;
import team.unstudio.overwatch.client.render.RenderChooseBlock;
import team.unstudio.overwatch.common.BlockLoader;
import team.unstudio.overwatch.common.EntityLoader;
import team.unstudio.overwatch.common.ItemLoader;
import team.unstudio.overwatch.tileentity.ChooseBlockTileEntity;

public class RenderLoader {
    public RenderLoader(FMLPreInitializationEvent event) {
        registerRender();
        registerTexture();
    }

    private static void registerRender() {
        ClientProxy.renderChooseBlock = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(ClientProxy.renderChooseBlock, new RenderChooseBlock());
        ClientRegistry.bindTileEntitySpecialRenderer(ChooseBlockTileEntity.class, new BlockRender());
    }

    private static void registerTexture() {
        BlockLoader.registerRenders();
        ItemLoader.registerRenders();
        EntityLoader.registerRenders();
    }
}
