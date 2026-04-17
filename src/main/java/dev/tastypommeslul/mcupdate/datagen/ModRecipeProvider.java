package dev.tastypommeslul.mcupdate.datagen;

import dev.tastypommeslul.mcupdate.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
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
            }
        };
    }

    @Override
    public String getName() {
        return "McUpdateRecipeProvider";
    }
}
