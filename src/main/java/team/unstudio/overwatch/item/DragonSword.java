package team.unstudio.overwatch.item;

        import cpw.mods.fml.common.registry.GameRegistry;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.ItemSword;

/**
 * Created by KevinWalker on 2017/2/1.
 */
public class DragonSword extends ItemSword implements ItemHugh {
    public float weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    private Item baseItem;
    public DragonSword(ToolMaterial toolMaterial, Item baseItem) {
        super(toolMaterial);
        this.toolMaterial = toolMaterial;
        this.maxStackSize = 1;
        this.weaponDamage = toolMaterial.getDamageVsEntity();
        this.setMaxDamage(5);
        this.baseItem=baseItem;
    }
    @Override
    public void addRepices() {
        GameRegistry.addShapelessRecipe(new ItemStack(this,1),baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem);
    }
}
