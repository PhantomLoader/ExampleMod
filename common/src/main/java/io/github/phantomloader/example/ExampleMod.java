package io.github.phantomloader.example;

import io.github.phantomloader.example.blocks.ModChestBlock;
import io.github.phantomloader.example.blocks.ModChestBlockEntity;
import io.github.phantomloader.example.blocks.ModStairBlock;
import io.github.phantomloader.library.ModEntryPoint;
import io.github.phantomloader.library.registry.ModRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ExampleMod {

    private static final ModRegistry REGISTRY = ModRegistry.instantiate("example");

    public static final Supplier<Item> TEST_ITEM = REGISTRY.registerItem("test_item");

    public static final Supplier<Block> TEST_BLOCK = REGISTRY.registerBlockAndItem("test_block");

    public static final Supplier<ModStairBlock> TEST_STAIRS = REGISTRY.registerBlockAndItem("test_stairs", () -> new ModStairBlock(TEST_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(TEST_BLOCK.get())));
    public static final Supplier<SlabBlock> TEST_SLAB = REGISTRY.registerBlockVariantAndItem("test_slab", SlabBlock::new, TEST_BLOCK);
    public static final Supplier<WallBlock> TEST_WALL = REGISTRY.registerBlockVariantAndItem("test_wall", WallBlock::new, TEST_BLOCK);

    public static final Supplier<ModChestBlock> CHEST_BLOCK_1 = REGISTRY.registerBlockVariantAndItem("chest_1", ModChestBlock::new, () -> Blocks.CHEST);
    public static final Supplier<ModChestBlock> CHEST_BLOCK_2 = REGISTRY.registerBlockVariantAndItem("chest_2", ModChestBlock::new, CHEST_BLOCK_1);

    public static final Supplier<BlockEntityType<ModChestBlockEntity>> CHEST_BLOCK_ENTITY = REGISTRY.registerBlockEntity("chest", ModChestBlockEntity::new, Set.of(CHEST_BLOCK_1, CHEST_BLOCK_2));

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = REGISTRY.registerCreativeTab("creative_tab", TEST_ITEM, "Example mod", List.of(TEST_ITEM, TEST_BLOCK, TEST_STAIRS, TEST_SLAB, TEST_WALL));

    @ModEntryPoint
    public static void initialize() {
        REGISTRY.register();
    }
}
