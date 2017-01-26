package team.unstudio.overwatch.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ChooseBlockTileEntity extends TileEntity{
	private ResourceLocation resourceLocation;
    private ModelBase model;

    public ChooseBlockTileEntity(Class<? extends ModelBase> modelClass, String texture) {

    }

    public ModelBase getModel() {
        return model;
    }
    
    @SideOnly(Side.CLIENT)
    public ResourceLocation getTexture() {
        return resourceLocation;
    }
}
