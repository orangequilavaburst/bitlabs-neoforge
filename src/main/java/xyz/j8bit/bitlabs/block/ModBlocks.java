package xyz.j8bit.bitlabs.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.j8bit.bitlabs.BitlabsMod;
import xyz.j8bit.bitlabs.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BitlabsMod.MOD_ID);

    public static final DeferredBlock<Block> DRAGONITE_ORE = registerBlock("dragonite_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> DEEPSLATE_DRAGONITE_ORE = registerBlock("deepslate_dragonite_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> RAW_DRAGONITE_BLOCK = registerBlock("raw_dragonite_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(DyeColor.ORANGE)));
    public static final DeferredBlock<Block> DRAGONITE_BLOCK = registerBlock("dragonite_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(DyeColor.ORANGE)));

    private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block){
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }

}
