package team.unstudio.overwatch.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;
import team.unstudio.overwatch.tileentity.ChooseBlockTileEntity;

/**
 * Created by KevinWalker on 2017/2/8.
 */
public class TileEntityLoader {
    public TileEntityLoader(FMLInitializationEvent event) {
        registerTileEntity(ChooseBlockTileEntity.class, "chooseblock");
    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
        GameRegistry.registerTileEntity(tileEntityClass, OverWatch.MODID + ":" + id);
    }
}
