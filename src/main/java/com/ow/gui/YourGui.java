package com.ow.gui;

import org.lwjgl.input.Keyboard;

import com.ow.main.ClientProxy;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class YourGui extends GuiScreen{
	private ResourceLocation texture = new ResourceLocation("overwatch", "textures/gui/beijing"+(int)(1+Math.random()*(5-1+1))+".png"); 
    private GuiScreen parentScreen;
 
    public YourGui(GuiScreen parent)
    {
         parentScreen = parent; //记下是哪个界面打开了它,以便以后返回那个界面
        //在这里初始化与界面无关的数据,或者是只需初始化一次的数据.
    }
 
    public void initGui()
    {
    	buttonList.add(new GuiButton(0, (int)(width*0.05), (int)(height*0.13), 40, 15, "源氏"));
    	buttonList.add(new GuiButton(1, (int)(width*0.245), (int)(height*0.13), 40, 15,"士兵：76"));
    	buttonList.add(new GuiButton(2, (int)(width*0.45), (int)(height*0.13), 40, 15, "麦克雷"));
    	buttonList.add(new GuiButton(3, (int)(width*0.65), (int)(height*0.13), 40, 15, "猎空"));
    	buttonList.add(new GuiButton(4, (int)(width*0.853), (int)(height*0.13), 40, 15, "死神"));
    	
    	buttonList.add(new GuiButton(5, (int)(width*0.05), (int)(height*0.33), 40, 15, "黑影"));
    	buttonList.add(new GuiButton(6, (int)(width*0.245), (int)(height*0.33), 40, 15, "法老之鹰"));
    	buttonList.add(new GuiButton(7, (int)(width*0.45), (int)(height*0.33), 40, 15, "美"));
    	buttonList.add(new GuiButton(8, (int)(width*0.65), (int)(height*0.33), 40, 15, "狂鼠"));
    	buttonList.add(new GuiButton(9, (int)(width*0.853), (int)(height*0.33), 40, 15, "黑百合"));
    	
    	buttonList.add(new GuiButton(10, (int)(width*0.05), (int)(height*0.53), 40, 15, "托比昂"));
    	buttonList.add(new GuiButton(11, (int)(width*0.245), (int)(height*0.53), 40, 15, "堡垒"));
    	buttonList.add(new GuiButton(12, (int)(width*0.45), (int)(height*0.53), 40, 15, "半藏"));
    	buttonList.add(new GuiButton(13, (int)(width*0.65), (int)(height*0.53), 40, 15, "D.VA"));
    	buttonList.add(new GuiButton(14, (int)(width*0.853), (int)(height*0.53), 40, 15, "路霸"));
    	
    	buttonList.add(new GuiButton(15, (int)(width*0.05), (int)(height*0.73), 40, 15, "查莉娅"));
    	buttonList.add(new GuiButton(16, (int)(width*0.245), (int)(height*0.73), 40, 15, "温斯顿"));
    	buttonList.add(new GuiButton(17, (int)(width*0.45), (int)(height*0.73), 40, 15, "莱因哈特"));
    	buttonList.add(new GuiButton(18, (int)(width*0.65), (int)(height*0.73), 40, 15, "安娜"));
    	buttonList.add(new GuiButton(19, (int)(width*0.853), (int)(height*0.73), 40, 15, "卢西奥"));
    	
    	buttonList.add(new GuiButton(20, (int)(width*0.05), (int)(height*0.93), 40, 15, "秩序之光"));
    	buttonList.add(new GuiButton(21, (int)(width*0.245), (int)(height*0.93), 40, 15, "天使"));
    	buttonList.add(new GuiButton(22, (int)(width*0.45), (int)(height*0.93), 40, 15, "禅雅塔"));
    	
    	buttonList.add(new GuiButton(23, (int)(width*0.85), (int)(height*0.9), 40, 20, "关闭"));
        //每当界面被打开时调用
        //这里部署控件
    }
 
    public void drawScreen(int par1, int par2, float par3)
    {
        drawDefaultBackground();
        //在这里绘制文本或纹理等非控件内容,这里绘制的东西会被控件(即按键)盖住.
        mc.renderEngine.bindTexture(texture); //绑定纹理
        drawScaledCustomSizeModalRect(0, 0, 0, 0, 550, (int)(550*(height/(float)width)), width, height, 550, 309); 
//        drawRect((int)(width*0.02), (int)(height*0.05), (int)(width*0.98), (int)(height*0.95), 0x80FFFFFF);
        super.drawScreen(par1,par2,par3);
        drawString(fontRendererObj, String.format("作者：KevinWalker", par1, par2), (int)(width*1), (int)(height*0.9), 0xFFFFFF);
    }
    @Override
    public boolean doesGuiPauseGame() {
    	
    	return false;
    }
    @Override
    protected void actionPerformed(GuiButton button) {
        if(!button.enabled) return;
        switch (button.id){
            case 23: {
                mc.displayGuiScreen(parentScreen);
                break;
            }default:
                break;
        }
    }

    public static void drawScaledCustomSizeModalRect(int x, int y, float u, float v, int uWidth, int vHeight, int width, int height, float tileWidth, float tileHeight) {
        float f4 = 1.0F / tileWidth;
        float f5 = 1.0F / tileHeight;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)x, (double)(y + height), 0.0D, (double)(u * f4), (double)((v + (float)vHeight) * f5));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), 0.0D, (double)((u + (float)uWidth) * f4), (double)((v + (float)vHeight) * f5));
        tessellator.addVertexWithUV((double)(x + width), (double)y, 0.0D, (double)((u + (float)uWidth) * f4), (double)(v * f5));
        tessellator.addVertexWithUV((double)x, (double)y, 0.0D, (double)(u * f4), (double)(v * f5));
        tessellator.draw();
    }
    @Override
    protected void keyTyped(char p_73869_1_, int p_73869_2_) {
    	if(mc.theWorld != null && p_73869_2_ == ClientProxy.kbShowNewGui.getKeyCode())
    	    mc.displayGuiScreen(parentScreen);
    	super.keyTyped(p_73869_1_, p_73869_2_);
    }
    /*@Override
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
        Keyboard.enableRepeatEvents(true); //只有当输入框成为焦点时才打开键盘连续输入,这是为了防止玩家打开菜单时按住按键不放,从而导致菜单打开后又立刻关闭的情况.
        Keyboard.enableRepeatEvents(false);
    	super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
    }*/
}