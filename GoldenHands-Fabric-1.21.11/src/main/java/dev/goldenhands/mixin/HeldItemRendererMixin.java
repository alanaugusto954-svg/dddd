package dev.goldenhands.mixin;

import dev.goldenhands.GoldenHandsConfig;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {
    @Inject(
        method = "renderFirstPersonItem",
        at = @At("HEAD")
    )
    private void goldenhands$adjustFirstPersonRender(
        AbstractClientPlayerEntity player,
        float tickProgress,
        float pitch,
        Hand hand,
        float swingProgress,
        ItemStack item,
        float equipProgress,
        MatrixStack matrices,
        OrderedRenderCommandQueue queue,
        int light,
        CallbackInfo ci
    ) {
        if (!GoldenHandsConfig.ENABLED) return;

        // Apply before vanilla's own push/render/pop sequence.
        float side = hand == Hand.MAIN_HAND ? 1.0f : -1.0f;
        matrices.translate(
            GoldenHandsConfig.OUTWARD_X * side,
            GoldenHandsConfig.VERTICAL_Y,
            GoldenHandsConfig.DEPTH_Z
        );
        matrices.scale(
            GoldenHandsConfig.SCALE,
            GoldenHandsConfig.SCALE,
            GoldenHandsConfig.SCALE
        );
    }

    @Inject(
        method = "renderFirstPersonItem",
        at = @At("RETURN")
    )
    private void goldenhands$restoreFirstPersonRender(
        AbstractClientPlayerEntity player,
        float tickProgress,
        float pitch,
        Hand hand,
        float swingProgress,
        ItemStack item,
        float equipProgress,
        MatrixStack matrices,
        OrderedRenderCommandQueue queue,
        int light,
        CallbackInfo ci
    ) {
        if (!GoldenHandsConfig.ENABLED) return;

        float side = hand == Hand.MAIN_HAND ? 1.0f : -1.0f;
        matrices.scale(
            1.0f / GoldenHandsConfig.SCALE,
            1.0f / GoldenHandsConfig.SCALE,
            1.0f / GoldenHandsConfig.SCALE
        );
        matrices.translate(
            -GoldenHandsConfig.OUTWARD_X * side,
            -GoldenHandsConfig.VERTICAL_Y,
            -GoldenHandsConfig.DEPTH_Z
        );
    }
}
