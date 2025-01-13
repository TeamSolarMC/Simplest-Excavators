package net.teamsolar.simplest_excavators.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = SimplestExcavators.MODID)
public class ModWanderingTraderEvent {
    @SubscribeEvent
    public static void wanderingVillagerTrade(WandererTradesEvent event) {
        event.getRareTrades().add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get(), 1),
                1, 2, 0.2f
        ));
    }
}