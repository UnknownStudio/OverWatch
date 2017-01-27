package team.unstudio.overwatch.client.creativetabs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
	public static CreativeTabs CreativeTabsOW;
	public static CreativeTabs CreativeTabsWQ;
    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	CreativeTabsOW = new CreativeTabsOW();
    	CreativeTabsWQ=new CreativeTabWQ();
    }
}
