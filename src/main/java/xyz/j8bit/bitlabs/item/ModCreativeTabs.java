package xyz.j8bit.bitlabs.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.j8bit.bitlabs.BitlabsMod;
import xyz.j8bit.bitlabs.block.ModBlocks;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BitlabsMod.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITLABS_TAB = CREATIVE_MODE_TABS.register("bitlabs_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.bitlabs")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModBlocks.DRAGONITE_BLOCK.asItem().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.DRAGONITE_BLOCK.asItem().getDefaultInstance()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

}
