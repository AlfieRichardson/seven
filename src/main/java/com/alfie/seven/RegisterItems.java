package com.alfie.seven;

import com.alfie.seven.tools.GreedPickaxe;
import com.alfie.seven.tools.WrathSword;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    // empty gem
    public static final Item EMPTY_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));

    // SIN gems
    public static final Item PRIDE_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item GLUTTONY_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item LUST_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item ENVY_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item GREED_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item WRATH_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item SLOTH_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));

    // SIN armor
    public static final ArmorMaterial SIN_MATERIAL = new SinArmorMaterial();
    public static final Item PRIDE_HELMET = new ArmorItem(SIN_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item GLUTTONY_CHESTPLATE = new ArmorItem(SIN_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item LUST_LEGGINGS = new ArmorItem(SIN_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final Item ENVY_BOOTS = new ArmorItem(SIN_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(Seven.SEVEN_GROUP));

    // SIN tools
    public static final ToolItem GREED_PICK = new GreedPickaxe(SinToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(Seven.SEVEN_GROUP));
    public static final ToolItem WRATH_SWORD = new WrathSword(SinToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings().group(Seven.SEVEN_GROUP));

    // VIRTUE gems
    public static final Item GRATITUDE_GEMSTONE = new Item(new Item.Settings().group(Seven.SEVEN_GROUP));

    // VIRTUE armor
    public static final ArmorMaterial VIRTUE_MATERIAL = new SinArmorMaterial();

    public static void register() {
        // empty gem
        Registry.register(Registry.ITEM, new Identifier("seven", "empty_gemstone"), EMPTY_GEMSTONE);

        // SIN gems
        Registry.register(Registry.ITEM, new Identifier("seven", "pride_gemstone"), PRIDE_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "gluttony_gemstone"), GLUTTONY_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "lust_gemstone"), LUST_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "envy_gemstone"), ENVY_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "greed_gemstone"), GREED_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "wrath_gemstone"), WRATH_GEMSTONE);
        Registry.register(Registry.ITEM, new Identifier("seven", "sloth_gemstone"), SLOTH_GEMSTONE);

        // SIN armor
        Registry.register(Registry.ITEM, new Identifier("seven", "pride_helmet"), PRIDE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("seven", "gluttony_chestplate"), GLUTTONY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("seven", "lust_leggings"), LUST_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("seven", "envy_boots"), ENVY_BOOTS);

        // SIN tools
        Registry.register(Registry.ITEM, new Identifier("seven", "greed_pick"), GREED_PICK);
        Registry.register(Registry.ITEM, new Identifier("seven", "wrath_sword"), WRATH_SWORD);

        // VIRTUE gems
        Registry.register(Registry.ITEM, new Identifier("seven", "gratitude_gemstone"), GRATITUDE_GEMSTONE);
    }
}
