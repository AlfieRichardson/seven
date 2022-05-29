package com.alfie.seven;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
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

		// done
		LOGGER.info("SEVEN has loaded.");
	}
}
