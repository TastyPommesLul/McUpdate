package dev.tastypommeslul.mcupdate.datagen.lang;

import dev.tastypommeslul.mcupdate.item.ModItems;
import dev.tastypommeslul.mcupdate.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EnglishProvider extends FabricLanguageProvider {
    public EnglishProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BUNNY_BOOTS, "Bunny Boots");
        translationBuilder.add(ModTags.Items.REPAIRS_BUNNY_ARMOR, "Repair Bunny Armor");
    }
}
