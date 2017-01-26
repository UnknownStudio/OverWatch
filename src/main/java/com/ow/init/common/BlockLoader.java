package com.ow.init.common;

import com.ow.block.ChooseBlock;
import com.ow.init.CreativeTabsLoader;
import com.ow.main.OverWatch;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader {
    //Blocks
	public static ChooseBlock cblock = new ChooseBlock(Material.rock);
    //Methods start
	public BlockLoader(FMLInitializationEvent event)
	{
		register(cblock, "ChooseBlock");
	}
	private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block, name);
        block.setBlockName(name);
        block.setCreativeTab(CreativeTabsLoader.CreativeTabsWQ);
    }
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        bindTexture(cblock,"ChooseBlock");
    }
    private static void bindTexture(Block block,String name){
        block.setBlockTextureName(OverWatch.MODID+":"+name);
    }
}
