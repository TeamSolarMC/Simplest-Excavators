package net.teamsolar.simplest_excavators.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.teamsolar.simplest_excavators.item.ModItems;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }


    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(
                this.registries.lookupOrThrow(Registries.ITEM),
                RecipeCategory.MISC,
                ModItems.EXCAVATOR_SMITHING_TEMPLATE.toStack(2)
        )
                .pattern("ABA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .define('B', ModItems.EXCAVATOR_SMITHING_TEMPLATE)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_excavator_template", has(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()))
                .save(output);

        excavatorSmithingRecipe(
                Ingredient.of(Items.WOODEN_SHOVEL),
                Ingredient.of(items.getOrThrow(ItemTags.LOGS)),
                ModItems.WOODEN_EXCAVATOR.get()
        );
        excavatorSmithingRecipe(
                Ingredient.of(Items.STONE_SHOVEL),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_EXCAVATOR.get()
        );
        excavatorSmithingRecipe(
                Ingredient.of(Items.IRON_SHOVEL),
                Ingredient.of(Items.IRON_BLOCK.asItem()),
                ModItems.IRON_EXCAVATOR.get()
        );
        excavatorSmithingRecipe(
                Ingredient.of(Items.GOLDEN_SHOVEL),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_EXCAVATOR.get()
        );
        excavatorSmithingRecipe(
                Ingredient.of(Items.DIAMOND_SHOVEL),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_EXCAVATOR.get()
        );
        excavatorSmithingRecipe(
                Ingredient.of(Items.NETHERITE_SHOVEL),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.NETHERITE_EXCAVATOR.get()
        );
        // Upgrades
        excavatorUpgradeRecipe(
                Ingredient.of(ModItems.WOODEN_EXCAVATOR.get()),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_EXCAVATOR.get()
        );
        // Alternative path: Stone -> Copper -> Iron / Stone -> Iron
        excavatorUpgradeRecipe(
                Ingredient.of(ModItems.STONE_EXCAVATOR.get()),
                Ingredient.of(Items.COPPER_BLOCK),
                ModItems.COPPER_EXCAVATOR.get()
        );
        // *
        excavatorUpgradeRecipe(
                Ingredient.of(ModItems.STONE_EXCAVATOR.get(), ModItems.COPPER_EXCAVATOR.get()),
                Ingredient.of(Items.IRON_BLOCK),
                ModItems.IRON_EXCAVATOR.get()
        );

        // Alternative path: Iron -> Gold -> Diamond / Iron -> Diamond
        excavatorUpgradeRecipe(
                Ingredient.of(ModItems.IRON_EXCAVATOR.get()),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_EXCAVATOR.get()
        );
        // *
        excavatorUpgradeRecipe(
                Ingredient.of(ModItems.GOLDEN_EXCAVATOR.get(), ModItems.IRON_EXCAVATOR.get()),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_EXCAVATOR.get()
        );

        netheriteSmithing(ModItems.DIAMOND_EXCAVATOR.get(), RecipeCategory.MISC, ModItems.NETHERITE_EXCAVATOR.get());

        basicBlastingAndSmeltingRecipe(ModItems.IRON_EXCAVATOR.get(), Items.IRON_NUGGET);
        basicBlastingAndSmeltingRecipe(ModItems.COPPER_EXCAVATOR.get(), Items.COPPER_NUGGET);
        basicBlastingAndSmeltingRecipe(ModItems.GOLDEN_EXCAVATOR.get(), Items.GOLD_NUGGET);
    }

    private String itemNameWithoutNamespace(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    private void excavatorSmithingRecipe(Ingredient base, Ingredient additional, Item outputItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()),
                        base,
                        additional,
                        RecipeCategory.TOOLS,
                        outputItem
                )
                .unlocks("has_excavator_template", has(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()))
                .save(output, itemNameWithoutNamespace(outputItem).concat("_from_shovel"));
    }
    private void excavatorUpgradeRecipe(Ingredient base, Ingredient additional, Item outputItem) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()),
                        base,
                        additional,
                        RecipeCategory.TOOLS,
                        outputItem
                )
                .unlocks("has_excavator_template", has(ModItems.EXCAVATOR_SMITHING_TEMPLATE.get()))
                .save(output, itemNameWithoutNamespace(outputItem).concat("_from_upgrade"));
    }
    private void basicBlastingAndSmeltingRecipe(Item input, Item outputItem) {
        String unqualifiedItemName = itemNameWithoutNamespace(input);
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(input),
                        RecipeCategory.MISC,
                        outputItem,
                        0.1F,
                        100
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_blasting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(input),
                        RecipeCategory.MISC,
                        outputItem,
                        0.1F,
                        200
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_smelting"));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public @NotNull String getName() {
            return "My Recipes";
        }
    }
}
