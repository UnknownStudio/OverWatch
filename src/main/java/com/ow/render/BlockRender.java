package com.ow.render;

import org.lwjgl.opengl.GL11;

import com.ow.main.OverWatch;
import com.ow.model.ChooseBlockModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class BlockRender extends TileEntitySpecialRenderer {
	
	private ChooseBlockModel model;
	private ResourceLocation text = new ResourceLocation(OverWatch.MODID,"textures/models/ChooseBlock.png");
	public BlockRender()
	{
		model=new ChooseBlockModel();
	}
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z,
			float scale) {
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.5, y+1.5, z+0.5);
		GL11.glRotated(180, 0, 0, 1);
		this.bindTexture(text);
		this.model.render((Entity)null, 0, -0.1f, 0, 0, 0, 0.0625f);
		GL11.glPopMatrix();
	}
}