package team.unstudio.overwatch.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DragonModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
  
  public DragonModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, -2F, 20, 6, 6);
      Shape1.setRotationPoint(0F, 3F, 7F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0.669215F, 0.1487144F, 0.1487144F);
      Shape2 = new ModelRenderer(this, 0, 22);
      Shape2.addBox(0F, 0F, 0F, 17, 5, 5);
      Shape2.setRotationPoint(-16F, 3F, 3F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0.8551081F, -0.1487144F, 0.1115358F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 20, 6, 6);
      Shape3.setRotationPoint(0F, 0F, -6F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, -0.8922867F, -0.2974289F, -0.2230717F);
      Shape4 = new ModelRenderer(this, 0, 22);
      Shape4.addBox(0F, 0F, 0F, 17, 5, 5);
      Shape4.setRotationPoint(-16F, 7F, -7F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0.8551081F, 0.1115358F, -0.1312612F);
      Shape5 = new ModelRenderer(this, 0, 15);
      Shape5.addBox(1F, 0F, 0F, 8, 3, 3);
      Shape5.setRotationPoint(-23F, 3F, 1F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0.4461433F, -0.5205006F, -0.0743572F);
      Shape6 = new ModelRenderer(this, 0, 15);
      Shape6.addBox(0F, 0F, 0F, 8, 3, 3);
      Shape6.setRotationPoint(-23F, 8F, -2F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0.5205006F, 0.4461433F, -0.2230717F);
      Shape7 = new ModelRenderer(this, 36, 9);
      Shape7.addBox(-1F, -1F, 0F, 7, 6, 6);
      Shape7.setRotationPoint(19F, 5F, 4F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0.418879F, 0F);
      Shape8 = new ModelRenderer(this, 35, 9);
      Shape8.addBox(-6F, 0F, 0F, 8, 6, 6);
      Shape8.setRotationPoint(26F, -4F, -3F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, -0.2094395F, 0F);
      Shape9 = new ModelRenderer(this, 45, 22);
      Shape9.addBox(28F, -1F, -7F, 4, 1, 3);
      Shape9.setRotationPoint(-1F, 0F, 0F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, -0.2094395F, 0F);
      Shape10 = new ModelRenderer(this, 45, 27);
      Shape10.addBox(27F, 1F, -7F, 4, 1, 3);
      Shape10.setRotationPoint(0F, -2F, 0F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, -0.2094395F, 0.0743572F);
      Shape11 = new ModelRenderer(this, 45, 22);
      Shape11.addBox(-1F, 1F, -6F, 4, 1, 3);
      Shape11.setRotationPoint(28F, 6F, 8F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0.418879F, 0F);
      Shape12 = new ModelRenderer(this, 45, 27);
      Shape12.addBox(-3F, 1F, 0F, 4, 1, 3);
      Shape12.setRotationPoint(27F, 8F, 2F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0.418879F, -0.0371786F);
      Shape13 = new ModelRenderer(this, 26, 15);
      Shape13.addBox(24F, -6F, -3F, 1, 2, 1);
      Shape13.setRotationPoint(1F, 0F, 0F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, -0.2094395F, 0F);
      Shape14 = new ModelRenderer(this, 26, 15);
      Shape14.addBox(25F, -6F, -8F, 1, 2, 1);
      Shape14.setRotationPoint(0F, 0F, 0F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, -0.2094395F, 0F);
      Shape15 = new ModelRenderer(this, 26, 15);
      Shape15.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape15.setRotationPoint(23F, 2F, 2F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0.418879F, 0F);
      Shape16 = new ModelRenderer(this, 26, 15);
      Shape16.addBox(0F, 2F, 1F, 1, 2, 1);
      Shape16.setRotationPoint(25F, 0F, 6F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0.418879F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
