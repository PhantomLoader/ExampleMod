package io.github.phantomloader.example.mixin;

import io.github.phantomloader.example.ExampleMod;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheets.class)
public class SheetsMixin {

    private static final Material CHEST_1 = new Material(Sheets.CHEST_SHEET, new ResourceLocation("example", "entity/chest/chest_1"));
    private static final Material CHEST_2 = new Material(Sheets.CHEST_SHEET, new ResourceLocation("example", "entity/chest/chest_2"));

    @Inject(at = @At("HEAD"), method = "chooseMaterial", cancellable = true)
    private static void chooseMaterial(BlockEntity blockEntity, ChestType type, boolean christmas, CallbackInfoReturnable<Material> callbackInfo) {
        if(blockEntity.getBlockState().is(ExampleMod.CHEST_BLOCK_1.get())) {
            callbackInfo.setReturnValue(CHEST_1);
        } else if(blockEntity.getBlockState().is(ExampleMod.CHEST_BLOCK_2.get())) {
            callbackInfo.setReturnValue(CHEST_2);
        }
    }
}
