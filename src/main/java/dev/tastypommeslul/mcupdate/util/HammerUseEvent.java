package dev.tastypommeslul.mcupdate.util;

import dev.tastypommeslul.mcupdate.item.custom.HammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HammerUseEvent implements PlayerBlockBreakEvents.Before {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @Override
    public boolean beforeBlockBreak(@NonNull Level level, @NonNull Player player, @NonNull BlockPos pos,
                                    @NonNull BlockState state, @Nullable BlockEntity blockEntity) {

        return handleBlockBreak(player, pos, state, level, true);
    }

    public boolean handleBlockBreak(Player player, BlockPos pos, BlockState state, Level level, boolean shouldAccountForDurability) {
        ItemStack item = player.getMainHandItem();
        if (item.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer && state.tags().toList().contains(BlockTags.MINEABLE_WITH_PICKAXE)) {
            if (HARVESTED_BLOCKS.contains(pos)) return true;
            for (BlockPos bPos : HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                if (pos == bPos || !hammer.isCorrectToolForDrops(item, level.getBlockState(bPos))) continue;

                HARVESTED_BLOCKS.add(bPos);
                if (shouldAccountForDurability) {

                    if (item.get(DataComponents.DAMAGE) == (item.getMaxDamage() - 1)) {
                        player.sendOverlayMessage(Component.literal("Item About to Break! Saved at 1 Durability."));
                        break;
                    } else {
                        serverPlayer.gameMode.destroyBlock(bPos);
                    }
                } else {
                    serverPlayer.gameMode.destroyBlock(bPos);
                }
                HARVESTED_BLOCKS.remove(bPos);
            }
        }
        return false;
    }
}