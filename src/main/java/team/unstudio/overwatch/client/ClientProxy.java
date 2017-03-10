package team.unstudio.overwatch.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.input.Keyboard;
import team.unstudio.overwatch.client.render.DragonRender;
import team.unstudio.overwatch.client.render.HugeItemRenderer;
import team.unstudio.overwatch.common.CommonProxy;
import team.unstudio.overwatch.common.ItemLoader;

public class ClientProxy extends CommonProxy {
    public static int renderChooseBlock;
    public static final KeyBinding kbShowNewGui = new KeyBinding("overwatch.key.shownewgui", Keyboard.KEY_H, "overwatch.keytitle");
    public static final KeyBinding sk1 = new KeyBinding("overwatch.key.sk1", Keyboard.KEY_C, "overwatch.keytitle");
    public static final KeyBinding sk2 = new KeyBinding("overwatch.key.sk2", Keyboard.KEY_V, "overwatch.keytitle");
    public static final KeyBinding sk3 = new KeyBinding("overwatch.key.sk3", Keyboard.KEY_B, "overwatch.keytitle");

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        Minecraft mc = FMLClientHandler.instance().getClient();
        new RenderLoader(event);
        HugeItemRenderer hugeItemRenderer = new HugeItemRenderer(mc.gameSettings);
//        MinecraftForgeClient.registerItemRenderer(ItemLoader.dragonsword, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(ItemLoader.dragonsword, new DragonRender());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        ClientRegistry.registerKeyBinding(kbShowNewGui);
        ClientRegistry.registerKeyBinding(sk1);
        ClientRegistry.registerKeyBinding(sk2);
        ClientRegistry.registerKeyBinding(sk3);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
