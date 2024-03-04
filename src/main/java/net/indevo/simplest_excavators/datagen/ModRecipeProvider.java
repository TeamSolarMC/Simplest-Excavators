package net.indevo.simplest_excavators.datagen;

import net.indevo.simplest_excavators.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> p_251297_) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_EXCAVATOR.get())
                .pattern(" B ")
                .pattern(" C ")
                .pattern(" C ")
                .define('B', Items.IRON_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_EXCAVATOR.get())
                .pattern(" B ")
                .pattern(" C ")
                .pattern(" C ")
                .define('B', Items.DIAMOND_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_diamond_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.DIAMOND_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_EXCAVATOR.get())
                .pattern(" B ")
                .pattern(" C ")
                .pattern(" C ")
                .define('B', Items.GOLD_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_gold_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.GOLD_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);


        netheriteSmithing(p_251297_, ModItems.DIAMOND_EXCAVATOR.get(), RecipeCategory.MISC, ModItems.NETHERITE_EXCAVATOR.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_EXCAVATOR.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', Items.STONE_BRICKS)
                .define('C', Items.STICK)
                .unlockedBy("has_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.COBBLESTONE).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOOD_EXCAVATOR.get())
                .pattern(" B ")
                .pattern(" C ")
                .pattern(" C ")
                .define('B', ItemTags.LOGS)
                .define('C', Items.STICK)
                .unlockedBy("has_logs", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemTags.LOGS).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);
    }
}
