package com.alfie.seven.mixin;

import com.alfie.seven.RegisterItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BannerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public abstract class PrideBannerMixin {
    @Inject(method = "onCraft",
            at = @At(value = "TAIL"))
    private void onCraft (ItemStack stack, World world, PlayerEntity player, CallbackInfo ci) {
        if (stack.getItem() instanceof BannerItem) {
            PlayerInventory pInv = player.getInventory();
            ItemStack emptyGem = new ItemStack(RegisterItems.EMPTY_GEMSTONE);
            if (pInv.contains(emptyGem)) {
                ItemStack prideGem = new ItemStack(RegisterItems.PRIDE_GEMSTONE);
                player.giveItemStack(prideGem);
                pInv.removeStack(pInv.getSlotWithStack(emptyGem), 1);
            }
        }
    }
}
