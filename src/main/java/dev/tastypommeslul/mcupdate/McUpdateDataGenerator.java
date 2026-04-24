package dev.tastypommeslul.mcupdate;

import dev.tastypommeslul.mcupdate.datagen.ModLoottableProvider;
import dev.tastypommeslul.mcupdate.datagen.ModModelProvider;
import dev.tastypommeslul.mcupdate.datagen.ModRecipeProvider;
import dev.tastypommeslul.mcupdate.datagen.ModTagProviders;
import dev.tastypommeslul.mcupdate.datagen.lang.EnglishProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class McUpdateDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLoottableProvider::new);
		pack.addProvider(ModTagProviders.ModItemTagProvider::new);
		pack.addProvider(ModTagProviders.ModBlockTagProvider::new);

		// Languages
		pack.addProvider(EnglishProvider::new);
	}
}
