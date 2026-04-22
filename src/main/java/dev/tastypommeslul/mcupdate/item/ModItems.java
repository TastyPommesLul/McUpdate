package dev.tastypommeslul.mcupdate.item;

import dev.tastypommeslul.mcupdate.McUpdate;
import dev.tastypommeslul.mcupdate.item.custom.BunnyBootsItem;
import dev.tastypommeslul.mcupdate.item.custom.HammerItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    // Enderite Check list
    /*
        Ore Block
        Scraps
        Ingot
        Armor Pieces (Helmet, Chestplate, Leggings, Boots)
        Tools (Sword, Pickaxe, Axe, Hoe, Shovel, Hammer)

        Ingot Recipe
        Armor Recipe's (Upgrades from Netherite)
        Tool Recipe's (Upgrades from Netherite)

    */
    public static final Item BUNNY_BOOTS = register("bunny_boots", BunnyBootsItem::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BUNNY_ARMOR, ArmorType.BOOTS));
    public static final HammerItem WOODEN_HAMMER = register("wooden_hammer",
            props -> new HammerItem(ToolMaterial.WOOD, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem STONE_HAMMER = register("stone_hammer",
            props -> new HammerItem(ToolMaterial.STONE, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem GOLDEN_HAMMER = register("golden_hammer",
            props -> new HammerItem(ToolMaterial.GOLD, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem IRON_HAMMER = register("iron_hammer",
            props -> new HammerItem(ToolMaterial.IRON, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem COPPER_HAMMER = register("copper_hammer",
            props -> new HammerItem(ToolMaterial.COPPER, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem DIAMOND_HAMMER = register("diamond_hammer",
            props -> new HammerItem(ToolMaterial.DIAMOND, 1f, -2.8f, props), new Item.Properties());
    public static final HammerItem NETHERITE_HAMMER = register("netherite_hammer",
            props -> new HammerItem(ToolMaterial.NETHERITE, 1f, -2.8f, props), new Item.Properties());

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, McUpdate.id(name));

        T item = itemFactory.apply(properties.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void init() {
        McUpdate.logger().info("Registering Mod Items for " + McUpdate.MOD_ID);

    }
}

