package com.alfie.seven.mixin;

import com.alfie.seven.RegisterItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntity.class)
public abstract class WrathVillagerMixin {
    @Inject(method = "onDeath",
            at = @At(value = "HEAD"))
    public void onDeath(DamageSource source, CallbackInfo ci) {
        Entity entity = source.getAttacker();
        if (entity != null
                && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            PlayerInventory pInv = player.getInventory();
            ItemStack emptyGem = new ItemStack(RegisterItems.EMPTY_GEMSTONE);
            if (pInv.contains(emptyGem)) {
                ItemStack wrathGem = new ItemStack(RegisterItems.WRATH_GEMSTONE);
                player.giveItemStack(wrathGem);
                pInv.removeStack(pInv.getSlotWithStack(emptyGem), 1);
            }
        }
    }
}
