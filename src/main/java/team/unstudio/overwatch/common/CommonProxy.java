package team.unstudio.overwatch.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import team.unstudio.overwatch.client.creativetabs.CreativeTabsLoader;
import team.unstudio.overwatch.hero.BanZang;
import team.unstudio.overwatch.hero.HeroManager;
import team.unstudio.overwatch.hero.KuangShu;
import team.unstudio.overwatch.hero.YuanShi;
import team.unstudio.overwatch.tileentity.ChooseBlockTileEntity;


public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new CreativeTabsLoader(event);
        new ArmorLoader(event);
    }

    public void init(FMLInitializationEvent event) {
        new ItemLoader(event);
        new BlockLoader(event);
        new EntityLoader(event);

        MinecraftForge.EVENT_BUS.register(new HeroManager());
        FMLCommonHandler.instance().bus().register(new HeroManager());

        GameRegistry.registerTileEntity(ChooseBlockTileEntity.class,"TileChooseBlock");

        HeroManager.addHero(new YuanShi());
        HeroManager.addHero(new BanZang());
        HeroManager.addHero(new KuangShu());
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}