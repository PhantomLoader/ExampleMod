package io.github.phantomloader.example;

import io.github.phantomloader.library.ModEntryPoint;
import io.github.phantomloader.library.registry.ClientRegistry;

import java.util.Set;

public class ExampleModClient {

	@ModEntryPoint(side = ModEntryPoint.Side.CLIENT)
	public static void initializeClient() {
		ClientRegistry.INSTANCE.addItemsToCreativeTab("functional_blocks", Set.of(ExampleMod.CHEST_BLOCK_1, ExampleMod.CHEST_BLOCK_2));
	}
}
