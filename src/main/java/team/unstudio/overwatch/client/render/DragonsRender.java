package team.unstudio.overwatch.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import team.unstudio.overwatch.client.model.DragonModel;
import team.unstudio.overwatch.common.OverWatch;

/**
 * Created by KevinWalker on 2017/3/11.
 */
public class DragonsRender extends Render{
    private DragonModel model;
    private ResourceLocation text = new ResourceLocation(OverWatch.MODID,"textures/models/DragonModel.png");
    @Override
    public void doRender(Entity entity, double x, double y, double z,
                         float f, float f1) {
        model=new DragonModel();
        GL11.glPushMatrix();
//        GL11.glTranslated(x+0.5, y+1.5, z+0.5);
//        GL11.glRotated(180, 0, 0, 1);
        GL11.glTranslated(x, y, z); //位移到Entity位置
        GL11.glRotatef(entity.rotationYaw, 0.0F, 0.0F, 0.0F); //横向旋转
        GL11.glRotatef(-entity.rotationPitch, 1.0F, 0.0F, 0.0F);//上下旋转
        this.bindTexture(text);
        this.model.render(entity, 0, -0.1f, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {

        return null;
    }
}
