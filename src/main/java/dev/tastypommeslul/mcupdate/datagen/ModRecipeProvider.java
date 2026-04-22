package dev.tastypommeslul.mcupdate.datagen;

import dev.tastypommeslul.mcupdate.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.COMBAT, ModItems.BUNNY_BOOTS)
                        .pattern("H H")
                        .pattern("F F")
                        .define('F', Items.RABBIT_FOOT)
                        .define('H', Items.RABBIT_HIDE)
                        .unlockedBy(getHasName(Items.RABBIT_FOOT), has(Items.RABBIT_FOOT))
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
                hammer(ModItems.WOODEN_HAMMER, ItemTags.PLANKS);
                hammer(ModItems.STONE_HAMMER, ItemTags.STONE_TOOL_MATERIALS);
                hammer(ModItems.COPPER_HAMMER, Items.COPPER_INGOT, Items.COPPER_BLOCK);
                hammer(ModItems.GOLDEN_HAMMER, Items.GOLD_INGOT, Items.GOLD_BLOCK);
                hammer(ModItems.IRON_HAMMER, Items.IRON_INGOT, Items.IRON_BLOCK);
                hammer(ModItems.DIAMOND_HAMMER, Items.DIAMOND, Items.DIAMOND_BLOCK);

                netheriteSmithing(ModItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER);
            }

            public void hammer(Item result, Item material, Item block) {
                shaped(RecipeCategory.TOOLS, result)
                        .pattern("BMB")
                        .pattern("BSB")
                        .pattern(" S ")
                        .define('M', material)
                        .define('B', block)
                        .define('S', Items.STICK)
                        .unlockedBy("has_stick", has(material))
                        .save(output);
            }
            public void hammer(Item result, TagKey<Item> material) {
                shaped(RecipeCategory.TOOLS, result)
                        .pattern("BMB")
                        .pattern("BSB")
                        .pattern(" S ")
                        .define('M', material)
                        .define('B', material)
                        .define('S', Items.STICK)
                        .unlockedBy("has_stick", has(material))
                        .save(output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "McUpdateRecipeProvider";
    }
}
