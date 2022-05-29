package com.alfie.seven.mixin;

import com.alfie.seven.RegisterItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CakeBlock.class)
public abstract class GluttonyCakeMixin {
    @Inject(method = "onUse",
    at = @At(value = "TAIL"))
    private void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable ci) {
        if (!player.canConsume(false)) {
            System.out.println("gluttony");
            PlayerInventory pInv = player.getInventory();
            ItemStack emptyGem = new ItemStack(RegisterItems.EMPTY_GEMSTONE);
            if (pInv.contains(emptyGem)) {
                ItemStack gluttGem = new ItemStack(RegisterItems.GLUTTONY_GEMSTONE);
                player.giveItemStack(gluttGem);
                pInv.removeStack(pInv.getSlotWithStack(emptyGem), 1);
            }
        }
    }
}
