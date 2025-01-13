package net.teamsolar.simplest_excavators.item;

import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.custom.ExcavatorItem;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SimplestExcavators.MODID);

    public static final DeferredItem<ExcavatorItem> WOODEN_EXCAVATOR = ITEMS.register("wooden_excavator",
            () -> new ExcavatorItem(Tiers.WOOD, new Item.Properties().durability(177).attributes(ExcavatorItem.createAttributes(Tiers.WOOD, 2.5f, -3.2f))));
    public static final DeferredItem<ExcavatorItem> STONE_EXCAVATOR = ITEMS.register("stone_excavator",
            () -> new ExcavatorItem(Tiers.STONE, new Item.Properties().durability(393).attributes(ExcavatorItem.createAttributes(Tiers.STONE, 2.5f, -3.2f))));
    public static final DeferredItem<ExcavatorItem> IRON_EXCAVATOR = ITEMS.register("iron_excavator",
            () -> new ExcavatorItem(Tiers.IRON, new Item.Properties().durability(750).attributes(ExcavatorItem.createAttributes(Tiers.IRON, 2.5f, -3.2f))));
    public static final DeferredItem<ExcavatorItem> GOLDEN_EXCAVATOR = ITEMS.register("golden_excavator",
            () -> new ExcavatorItem(Tiers.GOLD, new Item.Properties().durability(96).attributes(ExcavatorItem.createAttributes(Tiers.GOLD, 2.5f, -3.2f))));
    public static final DeferredItem<ExcavatorItem> DIAMOND_EXCAVATOR = ITEMS.register("diamond_excavator",
            () -> new ExcavatorItem(Tiers.DIAMOND, new Item.Properties().durability(4683).attributes(ExcavatorItem.createAttributes(Tiers.DIAMOND, 2.5f, -3.2f))));
    public static final DeferredItem<ExcavatorItem> NETHERITE_EXCAVATOR = ITEMS.register("netherite_excavator",
            () -> new ExcavatorItem(Tiers.NETHERITE, new Item.Properties().durability(6093).attributes(ExcavatorItem.createAttributes(Tiers.NETHERITE, 2.5f, -3.2f)).fireResistant()));
    public static final DeferredItem<SmithingTemplateItem> EXCAVATOR_SMITHING_TEMPLATE = ITEMS.register("excavator_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.simplest_excavators.excavator_smithing_template.applies_to").withStyle(ChatFormatting.BLUE), // DESCRIPTION_FORMAT
                    Component.translatable("item.simplest_excavators.excavator_smithing_template.ingredients").withStyle(ChatFormatting.BLUE), // DESCRIPTION_FORMAT
                    Component.translatable("item.simplest_excavators.excavator_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY), // TITLE_FORMAT
                    Component.translatable("item.simplest_excavators.excavator_smithing_template.base_slot_description"), // No formatting
                    Component.translatable("item.simplest_excavators.excavator_smithing_template.additions_slot_description"), // No formatting
                    // Base slot empty icons
                    List.of(
                            ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                            ResourceLocation.fromNamespaceAndPath(SimplestExcavators.MODID, "item/empty_slot_excavator")
                    ),
                    List.of(
                            ResourceLocation.fromNamespaceAndPath(SimplestExcavators.MODID, "item/empty_slot_block")
                    )
                    // Additional slot empty icons
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}