package com.gods.mod;


import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;


public class WorldGenGodsTree extends WorldGenerator {
public WorldGenGodsTree() {
}
public boolean generate(World world, Random random, int i, int j, int k) {
  int l = random.nextInt(1) + 4;
  boolean flag = true;
  if (j < 1 || j + l + 1 > 256) {
   return false;
  }
  for (int i1 = j; i1 <= j + 1 + l; i1++) {
   byte byte0 = 1;
   if (i1 == j) {
        byte0 = 0;
   }
   if (i1 >= (j + 1 + l) - 2) {
        byte0 = 2;
   }
   for (int i2 = i - byte0; i2 <= i + byte0 && flag; i2++) {
        for (int l2 = k - byte0; l2 <= k + byte0 && flag; l2++) {
         if (i1 >= 0 && i1 < 256) {
          int j3 = world.getBlockId(i2, i1, l2);
          if (j3 != 0 && j3 != GodsMod.GodsLeaves.blockID) {
           flag = false;
          }
         } else {
          flag = false;
         }
        }
   }
  }
  if (!flag) {
   return false;
  }
  int j1 = world.getBlockId(i, j - 1, k);
  if (j1 != GodsMod.WhiteGrass.blockID && j1 != Block.dirt.blockID
        && j1 != Block.grass.blockID || j >= 256 - l - 1)
  // White Grass, dirt, grass = the block that the tree can spawn on
  {
   return false;
  }
  world.setBlock(i, j - 1, k, GodsMod.WhiteDirt.blockID);// White Dirt = block created after its grown
                          // under the tree
  for (int k1 = (j - 3) + l; k1 <= j + l; k1++) {
   int j2 = k1 - (j + l);
   int i3 = 1 - j2 / 2;
   for (int k3 = i - i3; k3 <= i + i3; k3++) {
        int l3 = k3 - i;
        for (int i4 = k - i3; i4 <= k + i3; i4++) {
         int j4 = i4 - k;
         if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random
           .nextInt(2) != 0 && j2 != 0)
           && !Block.opaqueCubeLookup[world.getBlockId(k3, k1,
                 i4)]) {
          setBlockAndMetadata(world, k3, k1, i4,
                GodsMod.GodsLeaves.blockID, 0);
         }
        }
   }
  }
  for (int l1 = 0; l1 < l; l1++) {
   int k2 = world.getBlockId(i, j + l1, k);
   if (k2 == 0 || k2 ==GodsMod.GodsLeaves.blockID) {
        setBlockAndMetadata(world, i, j + l1, k,
          GodsMod.GodsWood.blockID, 0);
   }
  }
  return true;
}
}