package xyz.j8bit.bitlabs;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import xyz.j8bit.bitlabs.block.ModBlocks;
import xyz.j8bit.bitlabs.item.ModCreativeTabs;
import xyz.j8bit.bitlabs.item.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BitlabsMod.MOD_ID)
public class BitlabsMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "data/bitlabs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public BitlabsMod(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // deferred registers
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == ModCreativeTabs.BITLABS_TAB.getKey()){
            // blocks go here
            event.accept(ModItems.RAW_DRAGONITE);
            event.accept(ModItems.DRAGONITE_INGOT);

            event.accept(ModItems.BAGUETTE);
            event.accept(ModItems.SLICED_BREAD);

            event.accept(ModBlocks.DRAGONITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_DRAGONITE_ORE);
            event.accept(ModBlocks.DRAGONITE_BLOCK);
            event.accept(ModBlocks.RAW_DRAGONITE_BLOCK);
        }
        else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.DRAGONITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_DRAGONITE_ORE);
            event.accept(ModBlocks.DRAGONITE_BLOCK);
            event.accept(ModBlocks.RAW_DRAGONITE_BLOCK);
        }
        else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_DRAGONITE);
            event.accept(ModItems.DRAGONITE_INGOT);
        }
        else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BAGUETTE);
            event.accept(ModItems.SLICED_BREAD);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            //LOGGER.info("HELLO FROM CLIENT SETUP");
            //LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
