package com.gods.mod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class WhiteGrass extends Block  
{
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
	    this.field_Side = par1IconRegister.registerIcon("GodsMod:WhiteGrass_Side");
	    this.field_Top = par1IconRegister.registerIcon("GodsMod:WhiteGrass_Top");
	    this.field_Bottom = par1IconRegister.registerIcon("GodsMod:WhiteGrass_Bottom");
	    }
	public WhiteGrass(int i, int j)
	{
		super(i, Material.grass);
	    this.setTickRandomly(true);
		setCreativeTab(GodsMod.GodsTab);
	}

		public int quantityDropped(Random random){
		return 1;
		}

		  public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
		    {
		        if (!par1World.isRemote)
		        {
		            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
		            {
		                par1World.setBlock(par2, par3, par4, GodsMod.WhiteDirt.blockID);
		            }
		            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
		            {
		                for (int var6 = 0; var6 < 4; ++var6)
		                {
		                    int var7 = par2 + par5Random.nextInt(3) - 1;
		                    int var8 = par3 + par5Random.nextInt(5) - 3;
		                    int var9 = par4 + par5Random.nextInt(3) - 1;
		                    @SuppressWarnings("unused")
                            int var10 = par1World.getBlockId(var7, var8 + 1, var9);

		                    if (par1World.getBlockId(var7, var8, var9) == GodsMod.WhiteDirt.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
		                    {
		                        par1World.setBlock(var7, var8, var9, GodsMod.WhiteGrass.blockID);
		                    }
		                }
		            }
		        }
		    }
		}
