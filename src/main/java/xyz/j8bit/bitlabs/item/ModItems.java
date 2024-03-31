package xyz.j8bit.bitlabs.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xyz.j8bit.bitlabs.BitlabsMod;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BitlabsMod.MOD_ID);

    // minerals
    public static final DeferredItem<Item> RAW_DRAGONITE = ITEMS.register("raw_dragonite", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRAGONITE_INGOT = ITEMS.register("dragonite_ingot", () -> new Item(new Item.Properties()));

    // food
    public static final DeferredItem<Item> SLICED_BREAD = ITEMS.register("sliced_bread", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));
    public static final DeferredItem<Item> BAGUETTE = ITEMS.register("baguette", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationMod(1.0F).build())));

}
