package net.teamsolar.simplest_excavators.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.custom.ExcavatorItem;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = SimplestExcavators.MODID)
public class ModBlockBreakEvent {
    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof ExcavatorItem excavator && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }
            if(!excavator.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(initialBlockPos))) {
                return;
            }

            for (BlockPos pos : ExcavatorItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(!excavator.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    // event.setCanceled(true);
                    continue;
                }
                if(pos.equals(initialBlockPos)) {
                    SimplestExcavators.getLogger().warn("Mined block that was already set to be mined");
                    // event.setCanceled(true);
                    // continue;
                }
                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
}