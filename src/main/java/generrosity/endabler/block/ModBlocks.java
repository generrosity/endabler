package generrosity.endabler.block;

import generrosity.endabler.block.fluid.ModBlockFluidClassic;
import generrosity.endabler.block.fluid.ModFluids;
import generrosity.endabler.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModBlocks 
{
	@GameRegistry.ObjectHolder(BlockEndLog.REG_NAME)
    public static BlockEndLog endLog;
	
	@GameRegistry.ObjectHolder(BlockEndPlanks.REG_NAME)
    public static BlockEndPlanks endPlanks;
	
	@GameRegistry.ObjectHolder(BlockEndLeaves.REG_NAME)
    public static BlockEndLeaves endLeaves;
	
	@GameRegistry.ObjectHolder(BlockEndGrass.REG_NAME)
    public static BlockEndGrass endGrass;
	
	@GameRegistry.ObjectHolder(BlockEndTallGrass.REG_NAME)
    public static BlockEndTallGrass endTallGrass;
	
	@GameRegistry.ObjectHolder(BlockEndGlowPlant.REG_NAME)
    public static BlockEndGlowPlant endGlowPlant;
	
	@GameRegistry.ObjectHolder(BlockEndCanopySapling.REG_NAME)
    public static BlockEndCanopySapling endCanopySapling;
	
	@GameRegistry.ObjectHolder(BlockEndVine.REG_NAME)
    public static BlockEndVine endVine;
	
	@GameRegistry.ObjectHolder(BlockEnderObsidian.REG_NAME)
    public static BlockEnderObsidian endObsidian;
	
	@GameRegistry.ObjectHolder(BlockEndMagma.REG_NAME)
    public static BlockEndMagma endMagma;
	
	@GameRegistry.ObjectHolder(BlockEndCactus.REG_NAME)
    public static BlockEndCactus endCactus;
	
	@GameRegistry.ObjectHolder("endacid")
    public static ModBlockFluidClassic endAcid;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		ModFluids.registerFluids();
		IForgeRegistry<Block> reggy = event.getRegistry();
		reggy.register(new BlockEndLog());
		reggy.register(new BlockEndPlanks());
		reggy.register(new BlockEndLeaves());
		reggy.register(new BlockEndGrass());
		reggy.register(new BlockEndTallGrass());
		reggy.register(new BlockEndGlowPlant());
		reggy.register(new BlockEndCanopySapling());
		reggy.register(new BlockEndVine());
		reggy.register(new BlockEnderObsidian());
		reggy.register(new BlockEndMagma());
		reggy.register(new BlockEndCactus());
		reggy.register(new ModBlockFluidClassic(ModFluids.ACID, Material.WATER).setRegistryName("endacid").setUnlocalizedName("endabler:endacid"));// new MaterialLiquid(MapColor.PURPLE)).setRegistryName("endacid").setUnlocalizedName("endabler:endacid"));
	}
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		IForgeRegistry<Item> reggy = event.getRegistry();
		reggy.register(new ItemBlock(ModBlocks.endLog).setRegistryName(ModBlocks.endLog.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endPlanks).setRegistryName(ModBlocks.endPlanks.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endLeaves).setRegistryName(ModBlocks.endLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endGrass).setRegistryName(ModBlocks.endGrass.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endTallGrass).setRegistryName(ModBlocks.endTallGrass.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endGlowPlant).setRegistryName(ModBlocks.endGlowPlant.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endCanopySapling).setRegistryName(ModBlocks.endCanopySapling.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endVine).setRegistryName(ModBlocks.endVine.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endObsidian).setRegistryName(ModBlocks.endObsidian.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endMagma).setRegistryName(ModBlocks.endMagma.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endCactus).setRegistryName(ModBlocks.endCactus.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.endAcid).setRegistryName("endacid"));
		
		OreDictionary.registerOre("logWood", endLog);
		OreDictionary.registerOre("plankWood", endPlanks);
		OreDictionary.registerOre("treeLeaves", endLeaves);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
		endLog.initModel();
		endPlanks.initModel();
		endLeaves.initModel();
		endGrass.initModel();
		endTallGrass.initModel();
		endGlowPlant.initModel();
		endCanopySapling.initModel();
		endVine.initModel();
		endObsidian.initModel();
		endMagma.initModel();
		endCactus.initModel();
		endAcid.initModel();
    }
}
	
