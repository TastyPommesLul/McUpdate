package dev.tastypommeslul.mcupdate.item;

import dev.tastypommeslul.mcupdate.McUpdate;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> MOD_ARMOR_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), McUpdate.id("mod_armor_tab")
    );
    public static final CreativeModeTab MOD_ARMOR_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.BUNNY_BOOTS))
            .title(Component.literal("Armor"))
            .displayItems((_, output) -> {
                output.accept(ModItems.BUNNY_BOOTS);
            })
            .build();

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOD_ARMOR_TAB_KEY, MOD_ARMOR_TAB);
    }
}
