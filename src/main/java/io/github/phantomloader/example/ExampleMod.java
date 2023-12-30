package io.github.phantomloader.example;

import io.github.phantomloader.library.ModEntryPoint;
import io.github.phantomloader.library.registry.ModRegistry;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ExampleMod {

	private static final ModRegistry REGISTRY = ModRegistry.instantiate("example");

	public static final Supplier<Item> TEST_ITEM = REGISTRY.registerItem("test_item");

	@ModEntryPoint
	public static void initialize() {
		REGISTRY.register();
	}
}
