package dev.tastypommeslul.mcupdate;

import dev.tastypommeslul.mcupdate.block.ModBlocks;
import dev.tastypommeslul.mcupdate.item.ModArmorMaterials;
import dev.tastypommeslul.mcupdate.item.ModCreativeModeTabs;
import dev.tastypommeslul.mcupdate.item.ModItems;
import dev.tastypommeslul.mcupdate.util.HammerUseEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class McUpdate implements ModInitializer {
	public static final String MOD_ID = "mcupdate";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		ModCreativeModeTabs.init();
		ModArmorMaterials.init();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUseEvent());
	}

	public static Logger logger() {
		return LOGGER;
	}

	public static Identifier id(String name) {
		return Identifier.fromNamespaceAndPath(MOD_ID, name);
	}
}