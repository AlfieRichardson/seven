package com.alfie.seven.mixin;

import com.alfie.seven.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class EnvyBellMixin {
    @Inject(method = "onBreak",
            at = @At(value = "HEAD"))
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo ci) {
        if (world.getBlockEntity(pos) instanceof BellBlockEntity) {
            PlayerInventory pInv = player.getInventory();
            ItemStack emptyGem = new ItemStack(RegisterItems.EMPTY_GEMSTONE);
            if (pInv.contains(emptyGem)) {
                ItemStack envyGem = new ItemStack(RegisterItems.ENVY_GEMSTONE);
                player.giveItemStack(envyGem);
                pInv.removeStack(pInv.getSlotWithStack(emptyGem), 1);
            }
        }
    }
}
