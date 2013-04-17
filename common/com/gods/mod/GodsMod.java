package com.gods.mod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = GodsMod.modid, name = "Gods Mod", version = "0.0.1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class GodsMod {

	@Instance("Manitor")
	public static GodsMod Instatnce;

	static int startEntityId = 350;

	public static final String modid = "Gods_GodsMod";

	public static final CreativeTabs GodsTab = new GodTab("The Gods Creative Tab");
	
	private static final String[] blockNames = new String[] {"White Grass", "White Dirt", "Cracked Mossy Stone", "Zeus Block", "Stone Piller", "Atlantic Glass", "Gods Leaves", "Gods Wood", "Gods Sapling"};
	private static final String[] itemNames = new String[] {"Staff", "Trident", "Lightning Bolt"};

	private static final ArrayList<Block> blocks = new ArrayList<Block>();
	private static final ArrayList<Item> items = new ArrayList<Item>();

	public static final Block WhiteGrass = new WhiteGrass(170, 0).setHardness(0.5F).setStepSound(Block.soundGrassFootstep);
	public static final Block WhiteDirt = new GodDirt(171, 0, "WhiteGrass_Bottom").setHardness(0.4F).setStepSound(Block.soundGrassFootstep);
	public static final Block CrackedMossyStone = new CrackedMossy(1002,Material.rock).setHardness(3.0F).setStepSound(Block.soundStoneFootstep);
	public static final Block ZeusBlock = new ZeusBlock(1003, Material.rock).setHardness(10.0F);
	public static final Block StonePiller = new StonePiller(1004, Material.rock).setHardness(6.0F);
	public static final Block AtlanticGlass = new AtlanticGlass(1005, Material.glass).setHardness(1.0F).setLightOpacity(1);
	public static final Block GodsLeaves = new GodsLeaves(1006, 0,"GodsMod:GodsLeaves").setHardness(0.2F);
	public static final Block GodsWood = new GodsWood(1007, 0, Material.wood).setHardness(2.0F);
	public static final Block GodsSapling = new GodsSapling(1008, 1).setHardness(0.0F);
	static {
		blocks.add(WhiteGrass);
		blocks.add(WhiteDirt);
		blocks.add(CrackedMossyStone);
		blocks.add(ZeusBlock);
		blocks.add(StonePiller);
		blocks.add(AtlanticGlass);
		blocks.add(GodsLeaves);
		blocks.add(GodsWood);
		blocks.add(GodsSapling);
	}

	public static final Item Staff = new GodsItem(1004, "GodsMod:Staff").setCreativeTab(GodsTab);
	public static final Item Trident = new GodsItem(1005, "GodsMod:Trident").setCreativeTab(GodsTab);
	public static final Item LightningBolt = new Lightning(1006,"GodsMod:LightningBolt").setCreativeTab(GodsTab);
	static {
		items.add(Staff);
		items.add(Trident);
		items.add(LightningBolt);
	}

	public final BiomeGenBase WhiteBiome = new WhiteBiome(44);

	@Init
	public void load(final FMLInitializationEvent event) {
		
		// Set Block Names
		for(int i = 0; i < blockNames.length; i++) {
			blocks.get(i).setUnlocalizedName(blockNames[i].replaceAll(" ", ""));
		}

		// Block Registry
		for(final Block block : blocks) {
			GameRegistry.registerBlock(block, modid + "_" + block.getUnlocalizedName2());
		}
		GameRegistry.addBiome(this.WhiteBiome);

		// Language registry
		for(int i = 0; i < blockNames.length; i++) {
			LanguageRegistry.addName(blocks.get(i), blockNames[i]);
		}
		for(int i = 0; i < itemNames.length; i++) {
			LanguageRegistry.addName(items.get(i), itemNames[i]);
		}
		
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.The Gods Creative Tab", "en_US", "The Gods Mod");
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.The Gods Creative Tab", "nl_NL", "De Goden Mod");
	}
}
