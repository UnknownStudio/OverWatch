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
    static public ResourceLocation modelLocation = new ResourceLocation("overwatch", "models/item/dragonsword2.obj");
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case INVENTORY:
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
            case EQUIPPED:
                GL11.glPushMatrix();
                GL11.glRotatef(0F, 0F, 0.0F, 2F);
                GL11.glTranslatef(90F, 0F, 0F);
                GL11.glScalef(1f, 1f, 1f);
                standModel.renderAll();
                GL11.glPopMatrix();
                return;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                GL11.glRotatef(0F, 0F, 0.0F, 0F);
                GL11.glTranslatef(90F, 0F, 0F);
                GL11.glScalef(0.5f, 0.5f, 0.5f);
                standModel.renderAll();
                GL11.glPopMatrix();
                return;
            case INVENTORY:
                GL11.glPushMatrix();
//                GL11.glRotatef(0F, 0F, 0.0F, 1F);
                GL11.glTranslatef(90F, 0F, 0F);
                GL11.glScalef(0.5f, 0.5f, 0.5f);
                standModel.renderAll();
                GL11.glPopMatrix();
                return;
            default:
                return;
        }
    }

}
