package com.gods.mod;

import net.minecraft.world.biome.BiomeGenBase;

public class WhiteBiome extends BiomeGenBase {

	public WhiteBiome(int par1) {
		super(par1);
	this.setBiomeName("God Biome");
	this.topBlock = (byte) GodsMod.WhiteGrass.blockID;
	this.fillerBlock = (byte) GodsMod.WhiteDirt.blockID;
	this.maxHeight = 0.2F;
	this.minHeight = 0;
	}

}
