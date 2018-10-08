package fluke.end.world.feature;

import java.util.Random;

import fluke.end.block.ModBlocks;
import fluke.end.world.BiomeRegistrar;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;


//TODO delete class
public class WorldGenReplaceEndSurface extends WorldGenerator
{
	private final IBlockState surfaceBlockState;
	private final IBlockState replacementBlockState;
	private final boolean addEndFoliage;
	private final Random randy;
	private final static IBlockState END_TALL_GRASS = ModBlocks.endTallGrass.getDefaultState();
	private final static IBlockState END_GLOW_PLANT = ModBlocks.endGlowPlant.getDefaultState();

    public WorldGenReplaceEndSurface(IBlockState generate, IBlockState replace, boolean addEndFoliage)
    {
        this.surfaceBlockState = generate;
        this.replacementBlockState = replace;
        this.addEndFoliage = addEndFoliage;
        randy = new Random(800813);
    }
    
    public boolean generate(World world, Random rand, BlockPos pos, Biome biome)
    {
		for(int x=0; x<16; x++)
		{
			for(int z=0; z<16; z++)
			{
				if(world.getBiome(pos.add(x, 0, z)) != biome)
						continue;
				
				BlockPos current = pos.add(x, 70, z);
				
				//find the surface block
				int minY = 52 - randy.nextInt(5);
				for (; current.getY() > minY && world.isAirBlock(current); current = current.down())
		        {
		            ;
		        }
				
				if(world.getBlockState(current) == replacementBlockState)
				{
					world.setBlockState(current, surfaceBlockState, 2);
					if(addEndFoliage)
						genEndPlants(world, current);
						
				}
			}
		}
    	return true;
    }
    
    //faster to put this here rather than its own WorldGenerator since we already know what the surface block location is
    private void genEndPlants(World world, BlockPos pos)
    {
    	int plantRng = randy.nextInt(64);
    	
    	if(plantRng <= 13)
    		world.setBlockState(pos.up(), END_TALL_GRASS, 2);
    	else if(plantRng == 14)
    	{
    		world.setBlockState(pos.up(), END_GLOW_PLANT, 2);
    		
    		if(pos.getX() > 0 && randy.nextBoolean())
    		{
    			if(world.getBlockState(pos.add(-1, 0, 0)) == surfaceBlockState)
    				world.setBlockState(pos.up(), END_GLOW_PLANT, 2);
    		}
    		
    		if(pos.getZ() > 0 && randy.nextBoolean())
    		{
    			if(world.getBlockState(pos.add(0, 0, -1)) == surfaceBlockState)
    				world.setBlockState(pos.up(), END_GLOW_PLANT, 2);
    		}
    	}
    }

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		return generate(worldIn, rand, pos, Biomes.SKY);
	}

}
