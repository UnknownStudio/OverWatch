package team.unstudio.overwatch.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import team.unstudio.overwatch.client.model.DartModel;
import team.unstudio.overwatch.common.OverWatch;

public class SprintEntityRender extends Render {
	private ResourceLocation text = new ResourceLocation(OverWatch.MODID,"textures/models/sprintentity.png");
	@Override
	public void doRender(Entity entity, double x, double y, double z,
						 float f, float f1) {
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.5, y+1.5, z+0.5);
		GL11.glRotated(180, 0, 0, 1);
		this.bindTexture(text);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

		return null;
	}

}
