package com.gods.mod;

import net.minecraft.creativetab.*;
import net.minecraft.item.ItemStack;

public class GodTab extends CreativeTabs{

	public GodTab(String label) {
		super(label);
	}

	public ItemStack getIconItemStack() { 
	return new ItemStack(GodsMod.CrackedMossyStone);
	
	
		
}
}