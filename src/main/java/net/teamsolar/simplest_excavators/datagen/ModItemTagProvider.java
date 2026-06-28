package net.teamsolar.simplest_excavators.datagen;

import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.teamsolar.simplest_excavators.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SimplestExcavators.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        TagAppender<Item> builder = this.tag(ModTags.Items.EXCAVATORS);
        builder.addAll(
                List.of(
                        ModItems.WOODEN_EXCAVATOR.getKey(),
                        ModItems.STONE_EXCAVATOR.getKey(),
                        ModItems.COPPER_EXCAVATOR.getKey(),
                        ModItems.IRON_EXCAVATOR.getKey(),
                        ModItems.DIAMOND_EXCAVATOR.getKey(),
                        ModItems.GOLDEN_EXCAVATOR.getKey(),
                        ModItems.NETHERITE_EXCAVATOR.getKey()
                )
        );
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
        this.tag(ItemTags.MINING_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
