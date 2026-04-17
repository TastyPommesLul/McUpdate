package dev.tastypommeslul.mcupdate.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class BunnyBootsItem extends Item {
    public BunnyBootsItem(Properties properties) {
        super(properties);
    }


    @Override
    public void inventoryTick(@NonNull ItemStack itemStack, ServerLevel level, @NonNull Entity owner, @Nullable EquipmentSlot slot) {
        if (!level.isClientSide()) {
            if (owner instanceof Player player) {
                if (slot != null) {
                    if (slot.equals(EquipmentSlot.FEET)) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 1, 0, true, false, false));
                    }
                }
            }
        }
    }
}
