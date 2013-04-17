package com.gods.mod;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GodsSapling extends BlockFlower {

	@SideOnly(Side.CLIENT)
	private Icon field_Side;
	@SideOnly(Side.CLIENT)
	private Icon field_Top;
	@SideOnly(Side.CLIENT)
	private Icon field_Bottom;

	@Override
	public Icon getBlockTextureFromSideAndMetadata(final int par1,
			final int par2) {
		return par1 == 1 ? this.field_Top : par1 == 0 ? this.field_Bottom
				: par1 == par2 ? this.blockIcon : this.field_Side;
	}

	@Override
	public void registerIcons(final IconRegister par1IconRegister) {
		this.field_Side = par1IconRegister.registerIcon("GodsMod:GodsSapling");
		this.field_Top = par1IconRegister.registerIcon("GodsMod:GodsSapling");
		this.field_Bottom = par1IconRegister
				.registerIcon("GodsMod:GodsSapling");
	}

	protected GodsSapling(final int i, final int j) {
		super(i);
		final float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F,
				0.5F + f);
	}

	@Override
	public void updateTick(final World world, final int i, final int j,
			final int k, final Random random) {
		if (world.isRemote)
			return;
		super.updateTick(world, i, j, k, random);
		if (world.getBlockLightValue(i, j + 1, k) >= 9
				&& random.nextInt(7) == 0)
			this.growTree(world, i, j, k, random);
	}

	public void growTree(final World world, final int i, final int j,
			final int k, final Random random) {
		final int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, 0);
		Object obj = null;
		if (l == 1)
			obj = new WorldGenTaiga2(true);
		else if (l == 2)
			obj = new WorldGenForest(true);
		else {
			obj = new WorldGenGodsTree();
			if (random.nextInt(10) == 0)
				obj = new WorldGenBigTree(false);
		}
		if (!((WorldGenerator) obj).generate(world, random, i, j, k)) {
			world.setBlock(i, j, k, this.blockID, l, 4);
			;
		}
	}

	public int idDropped(final int i, final Random random) {
		return GodsMod.GodsSapling.blockID;
	}

	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer, int par2, float par3, float par4,
			float par5) {
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null) {
			return false;
		}
		if ((equipped.getItem() == Item.dyePowder)
				&& (equipped.getItemDamage() == 15)) // if bone meal
		{
			growTree(world, i, j, k, world.rand);
			equipped.stackSize -= 1;
		}
		return false;
	}
}
