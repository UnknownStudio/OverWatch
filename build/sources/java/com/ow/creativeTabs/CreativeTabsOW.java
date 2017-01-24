package com.ow.creativeTabs;

import com.ow.init.common.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsOW extends CreativeTabs {
	public CreativeTabsOW() {
		super("OverWatchOW");
		setBackgroundImageName("overwatchtab.png");
	}
	@Override
	public Item getTabIconItem(){return ItemLoader.tb;}
}
