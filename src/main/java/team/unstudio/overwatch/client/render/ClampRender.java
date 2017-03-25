package team.unstudio.overwatch.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import team.unstudio.overwatch.client.model.ClampModel;
import team.unstudio.overwatch.client.model.Landmines;
import team.unstudio.overwatch.common.OverWatch;

/**
 * Created by KevinWalker on 2017/3/12.
 */
public class ClampRender extends Render {
    private ResourceLocation text = new ResourceLocation(OverWatch.MODID,"textures/models/ClampModel.png");
    private ClampModel model;
    @Override
    public void doRender(Entity p_76986_1_, double x, double y, double z,
                         float f, float f1) {
        model=new ClampModel();
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y+1.5, z+0.5);
        GL11.glRotated(180, 0, 0, 1);
        this.bindTexture(text);
        this.model.render(p_76986_1_, 0, -0.1f, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }
}
