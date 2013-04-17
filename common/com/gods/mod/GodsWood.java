package com.gods.mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class GodsWood extends Block{
	@SideOnly(Side.CLIENT)
    private Icon field_Side;
	@SideOnly(Side.CLIENT)
	private Icon field_Top;
	@SideOnly(Side.CLIENT)
	private Icon field_Bottom;
	
	    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	        return par1 == 1 ? this.field_Top : (par1 == 0 ? this.field_Bottom : (par1 == par2 ? this.blockIcon : this.field_Side));                         
	    }
	    
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	    this.field_Side = par1IconRegister.registerIcon("GodsMod:GodsWood_Side");
	    this.field_Top = par1IconRegister.registerIcon("GodsMod:GodsWood_Top");
	    this.field_Bottom = par1IconRegister.registerIcon("GodsMod:GodsWood_Top");
	    }
	public GodsWood(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setCreativeTab(GodsMod.GodsTab);
	}
  }