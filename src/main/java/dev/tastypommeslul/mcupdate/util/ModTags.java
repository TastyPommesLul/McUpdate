package dev.tastypommeslul.mcupdate.util;

import dev.tastypommeslul.mcupdate.McUpdate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface ModTags {
    interface Items {

        TagKey<Item> REPAIRS_BUNNY_ARMOR = create("repairs_bunny_armor");

        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, McUpdate.id(name));
        }
    }
    interface Blocks {
        TagKey<Block> NEEDS_NETHERITE_TOOL = TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace("needs_netherite_tool"));

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, McUpdate.id(name));
        }
    }
}
