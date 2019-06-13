package generrosity.endabler.world;

import generrosity.endabler.world.biomes.BiomeEndJungle;
import generrosity.endabler.world.biomes.BiomeEndVolcano;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeRegistrar 
{
	
	public static final Biome END_JUNGLE = new BiomeEndJungle();
	public static final Biome END_VOLCANO = new BiomeEndVolcano();
	
	public static void registerBiomes()
	{
		System.out.println("*************************************** End doesn't register biomes");
	//	initBiome(END_JUNGLE, "stygian_growth", Type.END);
	//	initBiome(END_VOLCANO, "acidic_plains", Type.END);
	}
	
	private static void initBiome(Biome biome, String name, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
	}
}
