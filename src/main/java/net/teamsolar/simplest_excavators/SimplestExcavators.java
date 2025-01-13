package net.teamsolar.simplest_excavators;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.EventBusSubscriber;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.teamsolar.simplest_excavators.loot.ModLootModifiers;
import org.slf4j.Logger;

@Mod(SimplestExcavators.MODID)
public class SimplestExcavators
{
    public static final String MODID = "simplest_excavators";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Logger getLogger() {
        return LOGGER;
    }

    public SimplestExcavators(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.WOODEN_EXCAVATOR);
            event.accept(ModItems.STONE_EXCAVATOR);
            event.accept(ModItems.IRON_EXCAVATOR);
            event.accept(ModItems.GOLDEN_EXCAVATOR);
            event.accept(ModItems.DIAMOND_EXCAVATOR);
            event.accept(ModItems.NETHERITE_EXCAVATOR);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EXCAVATOR_SMITHING_TEMPLATE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
