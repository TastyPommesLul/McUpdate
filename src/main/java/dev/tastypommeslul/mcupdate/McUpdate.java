package dev.tastypommeslul.mcupdate;

import dev.tastypommeslul.mcupdate.block.ModBlocks;
import dev.tastypommeslul.mcupdate.item.ModArmorMaterials;
import dev.tastypommeslul.mcupdate.item.ModCreativeModeTabs;
import dev.tastypommeslul.mcupdate.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McUpdate implements ModInitializer {
	public static final String MOD_ID = "mcupdate";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		ModCreativeModeTabs.init();
		ModArmorMaterials.init();
	}

	public static Identifier id(String name) {
		return Identifier.fromNamespaceAndPath(MOD_ID, name);
	}
}