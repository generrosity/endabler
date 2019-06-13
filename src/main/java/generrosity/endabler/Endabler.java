package generrosity.endabler;

import generrosity.endabler.world.BiomeRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import generrosity.endabler.proxy.CommonProxy;
import generrosity.endabler.util.Reference;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptableRemoteVersions="*")
public class Endabler
{
	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	@Instance
	public static Endabler instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	static 
	{
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public static void preInit(FMLInitializationEvent event)
	{
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.init();
		BiomeRegistrar.registerBiomes();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
	}
	
	@EventHandler
	public void startServer(FMLServerStartingEvent event) 
	{
		//event.registerServerCommand(new DebugCommand()); //TODO delete
	}
}