package team.unstudio.overwatch.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by KevinWalker on 2017/2/26.
 */
public class DragonRender implements IItemRenderer {
    static public IModelCustom standModel = null;
    static public ResourceLocation modelLocation = new ResourceLocation("overwatch", "models/item/yuanshi.obj");
    static public ResourceLocation texture = new ResourceLocation("overwatch", "models/item/yuanshi.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        standModel = AdvancedModelLoader.loadModel(modelLocation);
        switch (type) {
            case ENTITY:
                break;
            case EQUIPPED:
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.58F, 0.45F, 0F);
                GL11.glScalef(0.03f, 0.03f, 0.03f);
                GL11.glRotatef(180, 0, 0, 0);
                standModel.renderAll();
                GL11.glPopMatrix();
                return;
            case EQUIPPED_FIRST_PERSON:
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                GL11.glPushMatrix();
                GL11.glTranslatef(6F, 3F, 4F);
                GL11.glScalef(0.1f, 0.1f, 0.1f);
                GL11.glRotatef(90,0, 0, 1);
                standModel.renderAll();
                GL11.glPopMatrix();
                return;
            case FIRST_PERSON_MAP:
                break;
            default:
                return;
        }
    }

}
