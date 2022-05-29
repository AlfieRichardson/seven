package com.alfie.seven.mixin;

import com.alfie.seven.RegisterItems;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin (AnimalEntity.class)
public abstract class BreedingLustMixin {
    @Inject(method = "breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V",
            at = @At(value = "TAIL", target = "Lnet/minecraft/entity/passive/AnimalEntity;breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;)V"))
    private void breed(ServerWorld server, AnimalEntity other, CallbackInfo ci) {
        System.out.println("Make lust gem here");
        ServerPlayerEntity p = other.getLovingPlayer();
        PlayerInventory pInv = p.getInventory();
        ItemStack emptyGem = new ItemStack(RegisterItems.EMPTY_GEMSTONE);
        if (pInv.contains(emptyGem)) {
            ItemStack lustGem = new ItemStack(RegisterItems.LUST_GEMSTONE);
            p.giveItemStack(lustGem);
            pInv.removeStack(pInv.getSlotWithStack(emptyGem), 1);
        }
    }
}
