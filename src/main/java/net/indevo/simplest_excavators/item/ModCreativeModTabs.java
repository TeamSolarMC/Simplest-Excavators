package net.indevo.simplest_excavators.item;

import net.indevo.simplest_excavators.SimplestExcavators;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimplestExcavators.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SIMPLEST_EXCAVATORS_TAB = CREATIVE_MODE_TABS.register("simplest_excavators_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHERITE_EXCAVATOR.get()))
                    .title(Component.translatable("creativetab.simplest_excavators_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WOODEN_EXCAVATOR.get());
                        pOutput.accept(ModItems.STONE_EXCAVATOR.get());
                        pOutput.accept(ModItems.IRON_EXCAVATOR.get());
                        pOutput.accept(ModItems.GOLDEN_EXCAVATOR.get());
                        pOutput.accept(ModItems.DIAMOND_EXCAVATOR.get());
                        pOutput.accept(ModItems.NETHERITE_EXCAVATOR.get());
                    }))
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
