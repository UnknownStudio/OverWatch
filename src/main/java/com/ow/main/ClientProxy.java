package com.ow.main;

import com.ow.init.client.RenderLoader;
import com.ow.skill.HeroManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy{
	public static int renderChooseBlock;
	public static final KeyBinding kbShowNewGui = new KeyBinding("overwatch.key.shownewgui", Keyboard.KEY_H, "overwatch.keytitle");
    public static final KeyBinding sk1 = new KeyBinding("overwatch.key..sk1", Keyboard.KEY_C, "overwatch.keytitle");
    public static final KeyBinding sk2 = new KeyBinding("overwatch.key.sk2", Keyboard.KEY_V, "overwatch.keytitle");
    public static final KeyBinding sk3 = new KeyBinding("overwatch.key.sk3", Keyboard.KEY_B, "overwatch.keytitle");

	@Override
	public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    	new RenderLoader(event);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

        MinecraftForge.EVENT_BUS.register(new HeroManager());
        FMLCommonHandler.instance().bus().register(new HeroManager());

        ClientRegistry.registerKeyBinding(kbShowNewGui);
        ClientRegistry.registerKeyBinding(sk1);
        ClientRegistry.registerKeyBinding(sk2);
        ClientRegistry.registerKeyBinding(sk3);
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
