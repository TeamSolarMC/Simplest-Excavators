package net.teamsolar.simplest_excavators.datagen;

import net.minecraft.tags.ItemTags;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.teamsolar.simplest_excavators.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SimplestExcavators.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Items.EXCAVATORS)
                .add(
                        ModItems.WOODEN_EXCAVATOR.get(),
                        ModItems.STONE_EXCAVATOR.get(),
                        ModItems.COPPER_EXCAVATOR.get(),
                        ModItems.IRON_EXCAVATOR.get(),
                        ModItems.DIAMOND_EXCAVATOR.get(),
                        ModItems.GOLDEN_EXCAVATOR.get(),
                        ModItems.NETHERITE_EXCAVATOR.get());
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
        this.tag(ItemTags.MINING_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModTags.Items.EXCAVATORS);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
