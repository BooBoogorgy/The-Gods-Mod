package com.gods.mod;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = GodsMod.modid, name = "Gods Mod", version = "0.0.1 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class GodsMod 
{
    public static final String modid = "Gods_GodsMod";
    
    public static CreativeTabs GodsTab = new GodTab("The Gods Creative Tab");
    
   
  
    public static Block WhiteGrass = new WhiteGrass(1000, 0).setUnlocalizedName("WhiteGrass").setHardness(2.0F).setStepSound(Block.soundGrassFootstep);
	public static Block WhiteDirt = new GodDirt(1001, 0, "WhiteGrass_Bottom").setUnlocalizedName("WhiteDirt").setHardness(2.0F).setStepSound(Block.soundGrassFootstep);
    public static Block CrackedMossyStone = new CrackedMossy(1002, Material.rock).setUnlocalizedName("CrackedMossyStone").setHardness(10.0F).setStepSound(Block.soundStoneFootstep);
    public static Block ZeusBlock = new ZeusBlock(1003, Material.rock).setUnlocalizedName("ZeusBlock").setHardness(10.0F);
    public static Block StonePiller = new StonePiller(1004, Material.rock).setUnlocalizedName("StonePiller").setHardness(10.0F);
    
   
    public static Item Staff = new GodsItem(1004, "GodsMod:Staff").setUnlocalizedName("Staff").setCreativeTab(GodsTab);
	public static Item Trident = new GodsItem(1005, "GodsMod:Trident").setUnlocalizedName("Trident").setCreativeTab(GodsTab);
	public static Item LightningBolt = new Lightning(1006, "GodsMod:LightningBolt").setUnlocalizedName("LightningBolt").setCreativeTab(GodsTab);
	
	
	
	
	

    
    @Init
    public void load(FMLInitializationEvent event) 
    {
		//Game Registry
		GameRegistry.registerBlock(CrackedMossyStone);	
		GameRegistry.registerBlock(WhiteGrass);	
		GameRegistry.registerBlock(ZeusBlock);	
		GameRegistry.registerBlock(StonePiller);	
		GameRegistry.registerBlock(WhiteDirt);	

		
	
        
        // Language registry
		LanguageRegistry.addName(CrackedMossyStone, "Cracked Mossy Stone");
		LanguageRegistry.addName(Staff, "Staff");
		LanguageRegistry.addName(StonePiller, "Stone Piller");
		LanguageRegistry.addName(Trident, "Trident");
		LanguageRegistry.addName(ZeusBlock, "Zeus Block");
		LanguageRegistry.addName(WhiteGrass, "White Grass");
		LanguageRegistry.addName(WhiteDirt, "White Dirt");
		LanguageRegistry.addName(LightningBolt, "Lightning Bolt");
		LanguageRegistry.instance().addStringLocalization("itemGroup.The Gods Creative Tab", "en_US", "The Gods Mod");
		LanguageRegistry.instance().addStringLocalization("itemGroup.The Gods Creative Tab", "nl_NL", "De Goden Mod");
    }
}
