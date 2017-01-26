package com.ow.init.common;

import com.ow.entity.DartEntity;
import com.ow.entity.KuangShuZDEntity;
import com.ow.main.OverWatch;
import com.ow.render.DartModelRender;
import com.ow.render.KuangShuZDRrender;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;

/**
 * Created by winston_wang on 2017/1/22.
 */
public class EntityLoader {
    public  EntityLoader(FMLInitializationEvent event)
    {
        register(DartEntity.class, "dart");
        register(KuangShuZDEntity.class, "kuangshuzd");
    }
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(DartEntity.class, new DartModelRender());
        RenderingRegistry.registerEntityRenderingHandler(KuangShuZDEntity.class, new KuangShuZDRrender());
    }
    static int nextEntityID = 0;
    private void register(Class<? extends Entity> entityClass, String name) {
        EntityRegistry.registerModEntity(entityClass, name, ++nextEntityID, OverWatch.instance, 32, 3, true);
    }
}
