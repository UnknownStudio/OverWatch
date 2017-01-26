package team.unstudio.overwatch.creativetabs;

import team.unstudio.overwatch.common.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabWQ extends CreativeTabs {
	public CreativeTabWQ() {
		super("OverWatchWQ");
		setBackgroundImageName("overwatchtab.png");
	}
	@Override
	public Item getTabIconItem(){return ItemLoader.tb;}
}
