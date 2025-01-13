package net.teamsolar.simplest_excavators.datagen;

import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.teamsolar.simplest_excavators.SimplestExcavators;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimplestExcavators.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.WOODEN_EXCAVATOR);
        handheldItem(ModItems.STONE_EXCAVATOR);
        handheldItem(ModItems.IRON_EXCAVATOR);
        handheldItem(ModItems.GOLDEN_EXCAVATOR);
        handheldItem(ModItems.DIAMOND_EXCAVATOR);
        handheldItem(ModItems.NETHERITE_EXCAVATOR);

        simpleItem(ModItems.EXCAVATOR_SMITHING_TEMPLATE);
    }

    private <T extends Item> ItemModelBuilder handheldItem(DeferredItem<T> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/handheld")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }

    private <T extends Item>  ItemModelBuilder simpleItem(DeferredItem<T> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }
}
