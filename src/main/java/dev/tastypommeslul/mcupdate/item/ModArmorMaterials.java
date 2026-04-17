package dev.tastypommeslul.mcupdate.item;

import dev.tastypommeslul.mcupdate.McUpdate;
import dev.tastypommeslul.mcupdate.util.ModTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.*;

public class ModArmorMaterials {

    public static final ResourceKey<EquipmentAsset> BUNNY_ARMOR_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, McUpdate.id("bunny"));
    public static final ArmorMaterial BUNNY_ARMOR = new ArmorMaterial(
            15,
            ArmorMaterials.makeDefense(1, 4, 5, 1, 4),
            1,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0f,
            0f,
            ModTags.Items.REPAIRS_BUNNY_ARMOR,
            BUNNY_ARMOR_KEY
    );

    public static void init() {}
}
