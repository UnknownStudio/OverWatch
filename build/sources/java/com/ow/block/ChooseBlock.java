package com.ow.block;

import com.ow.gui.YourGui;
import com.ow.main.OverWatch;
import com.ow.tileentity.ChooseBlockTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class  ChooseBlock extends  BlockContainer {
	private IIcon inner;
	private Class<? extends ModelBase> model;
	public ChooseBlock(Material materia) {
        super(materia);
    }
	@SideOnly(Side.CLIENT)
    public IIcon getInner(){return inner;}
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new ChooseBlockTileEntity(model, OverWatch.MODID+":"+"overwatchtubiao");
	}
	@Override
	public int getRenderType(){return -1;}
	@Override
	public boolean isOpaqueCube(){return false;}
	@Override
	public boolean renderAsNormalBlock(){return false;}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World worldIn, int x, int y, int z,
									EntityPlayer playerIn, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		 if (!worldIn.isRemote){
			 Minecraft mc = Minecraft.getMinecraft();
		     mc.displayGuiScreen(new YourGui(mc.currentScreen));
		 }
		return true;
	}
}
