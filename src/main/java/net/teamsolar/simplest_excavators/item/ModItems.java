package net.teamsolar.simplest_excavators.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.custom.ExcavatorItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SimplestExcavators.MODID);

    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;

    public static final DeferredItem<ExcavatorItem> WOODEN_EXCAVATOR = ITEMS.registerItem(
        "wooden_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.WOOD,
            new Item.Properties(),
            2.5f,
            -3.2f,
            177
        )
    );
    public static final DeferredItem<ExcavatorItem> STONE_EXCAVATOR = ITEMS.registerItem(
        "stone_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.STONE,
            new Item.Properties(),
            2.5f,
            -3.2f,
            393
        )
    );
    public static final DeferredItem<ExcavatorItem> COPPER_EXCAVATOR = ITEMS.registerItem(
        "copper_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.COPPER,
            new Item.Properties(),
            2.5f,
            0.8F - 4.0F,
            570
        )
    );
    public static final DeferredItem<ExcavatorItem> IRON_EXCAVATOR = ITEMS.registerItem(
        "iron_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.IRON,
            new Item.Properties(),
            2.5f,
            -3.2f,
            750
        )
    );
    public static final DeferredItem<ExcavatorItem> GOLDEN_EXCAVATOR = ITEMS.registerItem(
        "golden_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.GOLD,
            new Item.Properties(),
            2.5f,
            -3.2f,
            96
        )
    );
    public static final DeferredItem<ExcavatorItem> DIAMOND_EXCAVATOR = ITEMS.registerItem(
        "diamond_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.DIAMOND,
            new Item.Properties(),
            2.5f,
            -3.2f,
            4683
        )
    );
    public static final DeferredItem<ExcavatorItem> NETHERITE_EXCAVATOR = ITEMS.registerItem(
        "netherite_excavator", ExcavatorItem::new,
        () -> ExcavatorItem.excavatorProperties(
            ToolMaterial.NETHERITE,
            new Item.Properties().fireResistant(),
            2.5f,
            -3.2f,
            6093
        )
    );

    public static final DeferredItem<SmithingTemplateItem> EXCAVATOR_SMITHING_TEMPLATE = ITEMS.registerItem("excavator_upgrade_smithing_template",
        (properties) -> new SmithingTemplateItem(
            Component.translatable("item.simplest_excavators.excavator_upgrade_smithing_template.applies_to").withStyle(DESCRIPTION_FORMAT), // DESCRIPTION_FORMAT
            Component.translatable("item.simplest_excavators.excavator_upgrade_smithing_template.ingredients").withStyle(DESCRIPTION_FORMAT), // DESCRIPTION_FORMAT
            // Component.translatable("item.simplest_hammers.hammer_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            // Upgrade descriptions were removed in 1.21.10
            Component.translatable("item.simplest_excavators.excavator_upgrade_smithing_template.base_slot_description"), // No formatting
            Component.translatable("item.simplest_excavators.excavator_upgrade_smithing_template.additions_slot_description"), // No formatting
            // Base slot empty icons
            List.of(
                // Identifier.withDefaultNamespace("item/empty_slot_shovel"),
                // 1.21.10: Slot is now called container/slot/shovel
                // ?
                Identifier.withDefaultNamespace("container/slot/shovel"),
                Identifier.fromNamespaceAndPath(SimplestExcavators.MODID, "container/slot/empty_slot_excavator")
            ),
            // Additional slot empty icons
            List.of(
                Identifier.fromNamespaceAndPath(SimplestExcavators.MODID, "container/slot/empty_slot_block")
            ),
            properties
        ),
        () -> new Item.Properties().rarity(Rarity.UNCOMMON)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}