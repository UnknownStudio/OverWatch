package team.unstudio.overwatch.client.render;

import org.lwjgl.opengl.GL11;

import team.unstudio.overwatch.common.OverWatch;
import team.unstudio.overwatch.client.model.DartModel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class DartModelRender extends  Render{
	private DartModel model;
	private ResourceLocation text = new ResourceLocation(OverWatch.MODID,"textures/models/Darts.png");
	@Override
	public void doRender(Entity entity, double x, double y, double z,
            float f, float f1) {
		model=new DartModel();
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.5, y+1.5, z+0.5);
		GL11.glRotated(180, 0, 0, 1);
		this.bindTexture(text);
		this.model.render(entity, 0, -0.1f, 0, 0, 0, 0.0625f);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return null;
	}

}