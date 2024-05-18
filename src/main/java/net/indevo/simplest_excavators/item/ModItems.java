package net.indevo.simplest_excavators.item;

import net.indevo.simplest_excavators.SimplestExcavators;
import net.indevo.simplest_excavators.item.custom.ExcavatorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SimplestExcavators.MOD_ID);

    public static final RegistryObject<Item> WOODEN_EXCAVATOR = ITEMS.register("wooden_excavator",
            () -> new ExcavatorItem(ModToolTiers.WOOD, 1.5f, -3.4F, new Item.Properties().durability(88)));
    public static final RegistryObject<Item> STONE_EXCAVATOR = ITEMS.register("stone_excavator",
            () -> new ExcavatorItem(ModToolTiers.STONE, 1.5f, -3.4F, new Item.Properties().durability(196)));
    public static final RegistryObject<Item> IRON_EXCAVATOR = ITEMS.register("iron_excavator",
            () -> new ExcavatorItem(ModToolTiers.IRON, 1.5f, -3.4F, new Item.Properties().durability(375)));
    public static final RegistryObject<Item> GOLDEN_EXCAVATOR = ITEMS.register("golden_excavator",
            () -> new ExcavatorItem(ModToolTiers.GOLD, 1.5f, -3.4F, new Item.Properties().durability(48)));
    public static final RegistryObject<Item> DIAMOND_EXCAVATOR = ITEMS.register("diamond_excavator",
            () -> new ExcavatorItem(ModToolTiers.DIAMOND, 1.5f, -3.4F, new Item.Properties().durability(2341)));
    public static final RegistryObject<Item> NETHERITE_EXCAVATOR = ITEMS.register("netherite_excavator",
            () -> new ExcavatorItem(ModToolTiers.NETHERITE, 1.5f, -3.4F, new Item.Properties().durability(3046)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
