package com.ow.main;

import com.ow.gui.YourGui;
import com.ow.init.client.RenderLoader;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy{
	public static int renderChooseBlock;
	public static final KeyBinding kbShowNewGui = new KeyBinding("overwatch.key.shownewgui", Keyboard.KEY_H, "overwatch.keytitle");
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
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        ClientRegistry.registerKeyBinding(kbShowNewGui);
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
    @SubscribeEvent
    public void keyListener(KeyInputEvent event) {
        if (kbShowNewGui.isPressed()) 
        {
            Minecraft mc = Minecraft.getMinecraft();
            mc.displayGuiScreen(new YourGui(mc.currentScreen));
        }
    }
}
