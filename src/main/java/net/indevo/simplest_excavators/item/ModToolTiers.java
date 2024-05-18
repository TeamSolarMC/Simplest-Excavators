package net.indevo.simplest_excavators.item;

import net.indevo.simplest_excavators.SimplestExcavators;
import net.indevo.simplest_excavators.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier WOOD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 88, 1.0F, 1.5F, 15,
                    ModTags.Blocks.NEEDS_WOODEN_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "planks"), List.of(Tiers.WOOD), List.of());

    public static final Tier STONE = TierSortingRegistry.registerTier(
            new ForgeTier(1, 196, 2.0F, 1.5F, 5,
                    ModTags.Blocks.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "stone"), List.of(Tiers.STONE), List.of());

    public static final Tier IRON = TierSortingRegistry.registerTier(
            new ForgeTier(2, 375, 4.0F, 1.5F, 14,
                    ModTags.Blocks.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "iron_ingot"), List.of(Tiers.IRON), List.of());

    public static final Tier GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 48, 8.0F, 1.5F, 22,
                    ModTags.Blocks.NEEDS_GOLDEN_TOOL, () -> Ingredient.of(Items.GOLD_INGOT)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "gold_ingot"), List.of(Tiers.GOLD), List.of());

    public static final Tier DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2341, 6.0F, 1.5F, 10,
                    ModTags.Blocks.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.DIAMOND)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "diamond"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier NETHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 3046, 7.0F, 1.5F, 15,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT)),
            new ResourceLocation(SimplestExcavators.MOD_ID, "netherite_ingot"), List.of(Tiers.NETHERITE), List.of());

}
