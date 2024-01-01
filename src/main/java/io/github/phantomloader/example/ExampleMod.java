package io.github.phantomloader.example;

import io.github.phantomloader.example.blocks.ModChestBlock;
import io.github.phantomloader.example.blocks.ModChestBlockEntity;
import io.github.phantomloader.library.ModEntryPoint;
import io.github.phantomloader.library.registry.ModRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import java.util.function.Supplier;

public class ExampleMod {

	private static final ModRegistry REGISTRY = ModRegistry.instantiate("example");

	public static final Supplier<Item> TEST_ITEM = REGISTRY.registerItem("test_item");

	public static final Supplier<Block> TEST_BLOCK = REGISTRY.registerBlockAndItem("test_block");

	public static final Supplier<ModChestBlock> CHEST_BLOCK_1 = REGISTRY.registerBlockVariantAndItem("chest_1", ModChestBlock::new, () -> Blocks.CHEST);
	public static final Supplier<ModChestBlock> CHEST_BLOCK_2 = REGISTRY.registerBlockVariantAndItem("chest_2", ModChestBlock::new, CHEST_BLOCK_1);

	public static final Supplier<BlockEntityType<ModChestBlockEntity>> CHEST_BLOCK_ENTITY = REGISTRY.registerBlockEntity("chest", ModChestBlockEntity::new, Set.of(CHEST_BLOCK_1, CHEST_BLOCK_2));

	public static final Supplier<CreativeModeTab> CREATIVE_TAB = REGISTRY.registerCreativeTab("creative_tab", TEST_ITEM, "Example mod", Set.of(TEST_ITEM, TEST_BLOCK));

	@ModEntryPoint
	public static void initialize() {
		REGISTRY.register();
	}
}
