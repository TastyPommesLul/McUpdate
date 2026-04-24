package dev.tastypommeslul.mcupdate.datagen;

import dev.tastypommeslul.mcupdate.block.ModBlocks;
import dev.tastypommeslul.mcupdate.item.ModItems;
import dev.tastypommeslul.mcupdate.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public interface ModTagProviders {
    class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

        public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, registryLookupFuture);
        }

        @Override
        protected void addTags(HolderLookup.@NonNull Provider registries) {
            valueLookupBuilder(ModTags.Items.REPAIRS_BUNNY_ARMOR)
                    .add(Items.RABBIT_FOOT)
                    .add(Items.RABBIT_HIDE);

            valueLookupBuilder(ItemTags.PICKAXES)
                    .add(ModItems.WOODEN_HAMMER)
                    .add(ModItems.STONE_HAMMER)
                    .add(ModItems.COPPER_HAMMER)
                    .add(ModItems.GOLDEN_HAMMER)
                    .add(ModItems.IRON_HAMMER)
                    .add(ModItems.DIAMOND_HAMMER)
                    .add(ModItems.NETHERITE_HAMMER);
        }
    }

    class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
        public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, registryLookupFuture);
        }

        @Override
        protected void addTags(HolderLookup.@NonNull Provider registries) {
            valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                    .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL);

            valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.ENDERITE_ORE);

            valueLookupBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                    .add(ModBlocks.ENDERITE_ORE);

        }
    }
}
