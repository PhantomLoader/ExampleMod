package io.github.phantomloader.example.events;

import io.github.phantomloader.example.ExampleMod;
import io.github.phantomloader.library.events.ClientEventHandler;
import io.github.phantomloader.library.events.RegisterBlockEntityRenderersEvent;
import io.github.phantomloader.library.utils.CreativeTabsUtils;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModClientEvents implements ClientEventHandler {

	@Override
	public void addItemsToCreativeTab(ResourceKey<CreativeModeTab> resourceKey, Consumer<Supplier<? extends ItemLike>> event) {
		if(resourceKey.equals(CreativeTabsUtils.FUNCTIONAL_BLOCKS)) {
			event.accept(ExampleMod.CHEST_BLOCK_1);
			event.accept(ExampleMod.CHEST_BLOCK_2);
		}
	}

	@Override
	public void registerBlockEntityRenderers(RegisterBlockEntityRenderersEvent event) {
		event.register(ExampleMod.CHEST_BLOCK_ENTITY.get(), ChestRenderer::new);
		event.registerItemRenderer(ExampleMod.CHEST_BLOCK_1);
		event.registerItemRenderer(ExampleMod.CHEST_BLOCK_2);
	}
}
