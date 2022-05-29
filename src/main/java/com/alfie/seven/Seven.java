package com.alfie.seven;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Seven implements ModInitializer {
	// logger
	public static final Logger LOGGER = LoggerFactory.getLogger("seven");

	// create ITEMGROUP
	public static final ItemGroup SEVEN_GROUP = FabricItemGroupBuilder.build(
			new Identifier("seven", "seven"),
			() -> new ItemStack(RegisterItems.EMPTY_GEMSTONE)
	);

	@Override
	public void onInitialize() {

		// register ITEMS
		RegisterItems.register();

		// register DROPS
		registerDrops();

		// done
		LOGGER.info("SEVEN has loaded.");
	}

	private void registerDrops() {
		LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
			if (new Identifier("minecraft", "chests/simple_dungeon").equals(id)) {
				LootPool poolBuilder = FabricLootPoolBuilder.builder()
						.withEntry(ItemEntry.builder(RegisterItems.EMPTY_GEMSTONE).weight(1).build())
						.withEntry(ItemEntry.builder(Items.AIR).weight(19).build())
						.build();

				supplier.withPool(poolBuilder);
			}
		}));
		LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
			if (new Identifier("minecraft", "entities/wither").equals(id)) {
				LootPool poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootNumberProvider.create(3))
						.withEntry(ItemEntry.builder(RegisterItems.EMPTY_GEMSTONE).weight(1).build())
						.build();

				supplier.withPool(poolBuilder);
			}
		}));
	}

}
