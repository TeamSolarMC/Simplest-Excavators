package net.indevo.simplest_excavators.datagen;

import net.indevo.simplest_excavators.SimplestExcavators;
import net.indevo.simplest_excavators.item.ModItems;
import net.indevo.simplest_excavators.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, SimplestExcavators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.EXCAVATORS)
                .add(
                        ModItems.WOOD_EXCAVATOR.get(),
                        ModItems.STONE_EXCAVATOR.get(),
                        ModItems.GOLD_EXCAVATOR.get(),
                        ModItems.IRON_EXCAVATOR.get(),
                        ModItems.DIAMOND_EXCAVATOR.get(),
                        ModItems.NETHERITE_EXCAVATOR.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
