package dev.tastypommeslul.mcupdate.datagen.lang;

import dev.tastypommeslul.mcupdate.item.ModItems;
import dev.tastypommeslul.mcupdate.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class EnglishProvider extends FabricLanguageProvider {
    public EnglishProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BUNNY_BOOTS, "Bunny Boots");
        translationBuilder.add(ModTags.Items.REPAIRS_BUNNY_ARMOR, "Repair Bunny Armor");

        translationBuilder.add(ModItems.WOODEN_HAMMER, "Wooden Hammer");
        translationBuilder.add(ModItems.STONE_HAMMER, "Stone Hammer");
        translationBuilder.add(ModItems.COPPER_HAMMER, "Copper Hammer");
        translationBuilder.add(ModItems.GOLDEN_HAMMER, "Golden Hammer");
        translationBuilder.add(ModItems.IRON_HAMMER, "Iron Hammer");
        translationBuilder.add(ModItems.DIAMOND_HAMMER, "Diamond Hammer");
        translationBuilder.add(ModItems.NETHERITE_HAMMER, "Netherite Hammer");
    }
}
