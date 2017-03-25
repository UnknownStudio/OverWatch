package team.unstudio.overwatch.common;

import team.unstudio.overwatch.client.render.*;
import team.unstudio.overwatch.entity.*;
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
        register(LandmineEntity.class,"landmine");
        register(DragonEntity.class,"dragon");
        register(ClampEntity.class,"clamp");
        register(BanZangArrow.class,"banzangarrow");
    }
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(DartEntity.class, new DartModelRender());
        RenderingRegistry.registerEntityRenderingHandler(KuangShuZDEntity.class, new KuangShuZDRrender());
        RenderingRegistry.registerEntityRenderingHandler(LandmineEntity.class, new LandmineRender());
        RenderingRegistry.registerEntityRenderingHandler(DragonEntity.class, new DragonsRender());
        RenderingRegistry.registerEntityRenderingHandler(ClampEntity.class, new ClampRender());
        RenderingRegistry.registerEntityRenderingHandler(BanZangArrow.class, new BanZangArrowRender());
    }
    static int nextEntityID = 0;
    private void register(Class<? extends Entity> entityClass, String name) {
        EntityRegistry.registerModEntity(entityClass, name, ++nextEntityID, OverWatch.instance, 32, 3, true);
    }
}
