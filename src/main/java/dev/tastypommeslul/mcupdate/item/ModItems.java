package dev.tastypommeslul.mcupdate.item;

import dev.tastypommeslul.mcupdate.McUpdate;
import dev.tastypommeslul.mcupdate.item.custom.BunnyBootsItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    // Enderite Check list
    /*
        Ore Block
        Scraps
        Ingot
        Armor Pieces (Helmet, Chestplate, Leggings, Boots)
        Tools (Sword, Pickaxe, Axe, Hoe, Shovel [, Hammer])

        Ingot Recipe
        Armor Recipe's (Upgrades from Netherite)
        Tool Recipe's (Upgrades from Netherite)

    */
    public static final Item BUNNY_BOOTS = register("bunny_boots", BunnyBootsItem::new, new Item.Properties().humanoidArmor(ModArmorMaterials.BUNNY_ARMOR, ArmorType.BOOTS));

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, McUpdate.id(name));

        T item = itemFactory.apply(properties.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void init() {}
}

