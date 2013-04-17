package com.gods.mod;

import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WhiteBiome extends BiomeGenBase {

	public WhiteBiome(int par1) {
		super(par1);
	this.setBiomeName("God Biome");
	this.topBlock = (byte) GodsMod.WhiteGrass.blockID;
	this.fillerBlock = (byte) GodsMod.WhiteDirt.blockID;
	this.maxHeight = 0.1F;
	this.minHeight = 0;
	
	}
	
	
	

	 public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	    { 
	        return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenGodsTree() : new WorldGenGodsTree());
	    }

}
