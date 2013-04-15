package com.gods.mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class GodsItem extends Item
{
    private String iconPath;
    
	@SideOnly(Side.CLIENT)
    private Icon icon;
    
	public GodsItem(int par1, String par2String) {
		super(par1);

		this.iconPath = par2String;
	}
    
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister){
	{
		this.icon = par1IconRegister.registerIcon(this.iconPath);
	}
}
	@SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1) {
		return this.icon;
	}
}


