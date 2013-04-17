package com.gods.mod;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class GodsLeaves extends BlockLeavesBase implements IShearable{


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
	    this.field_Side = par1IconRegister.registerIcon("GodsMod:GodsLeaves");
	    this.field_Top = par1IconRegister.registerIcon("GodsMod:GodsLeaves");
	    this.field_Bottom = par1IconRegister.registerIcon("GodsMod:GodsLeaves");
	    }
	
	public GodsLeaves(int par1, int par2, String par2String){
		super(par1, Material.leaves, false);
		this.setTickRandomly(true);
		this.setCreativeTab(GodsMod.GodsTab);
	}
		public int quantityDropped(Random par1Random)
	    {
	        return par1Random.nextInt(20) == 0 ? 1 : 0;
	    }

	public int idDropped(int par1, Random rand, int par3){
		return GodsMod.GodsSapling.blockID;
		
	}
	
	 public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	    {
	        byte b0 = 1;
	        int j1 = b0 + 1;

	        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
	        {
	            for (int k1 = -b0; k1 <= b0; ++k1)
	            {
	                for (int l1 = -b0; l1 <= b0; ++l1)
	                {
	                    for (int i2 = -b0; i2 <= b0; ++i2)
	                    {
	                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

	                        if (Block.blocksList[j2] != null)
	                        {
	                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
	                        }
	                    }
	                }
	            }
	        }
	    }
	
	  @Override
	    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
	    {
	        return true;
	    }

	    @Override
	    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
	    {
	        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
	        return ret;
	    }

	    @Override
	    public void beginLeavesDecay(World world, int x, int y, int z)
	    {
	        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	    }

	    @Override
	    public boolean isLeaves(World world, int x, int y, int z)
	    {
	        return true;
	    }

		
	}

