package dev.tastypommeslul.mcupdate.datagen;

import dev.tastypommeslul.mcupdate.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface ModTagProviders {
    class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

        public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, registryLookupFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {
            valueLookupBuilder(ModTags.Items.REPAIRS_BUNNY_ARMOR)
                    .add(Items.RABBIT_FOOT)
                    .add(Items.RABBIT_HIDE);
        }
    }

    class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
        public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, registryLookupFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider registries) {

        }
    }
}
